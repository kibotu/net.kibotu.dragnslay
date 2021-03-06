package net.kibotu.dragnslay.general.model;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.primitives.Sphere;
import net.kibotu.dragnslay.general.model.components.CameraComponent;
import net.kibotu.dragnslay.general.model.components.DisplayComponent;
import net.kibotu.dragnslay.general.model.components.SelectableComponent;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
final public class EntityBuilder {

    private static World world;

    private EntityBuilder () {
    }

    public static void init ( @NotNull final World world ) {
        EntityBuilder.world = world;
    }

    public static Entity createPlanet () {
        Entity entity = world.createEntity();
        entity.addComponent( new TransformationComponent() );
        Sphere sphere = new Sphere();
        entity.addComponent( new DisplayComponent( sphere.model,
                Assets.manager.get( Constants.TEXTURE_EARTH, Texture.class ),
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ) ) );
        entity.addComponent( new SelectableComponent() );
        return entity;
    }

    public static Entity createSpaceship () {
        Entity entity = world.createEntity();
        entity.addComponent( new TransformationComponent() );
        entity.addComponent( new DisplayComponent(
                Assets.manager.get( Constants.MODEL_RAZOR, StillModel.class ),
                Assets.manager.get( Constants.TEXTURE_RAZOR, Texture.class ),
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ) ) );
        return entity;
    }

    public static Entity createCamera ( final PerspectiveCamera camera ) {
        Entity entity = world.createEntity();
        camera.position.set( 0, 0, 7 );
        camera.direction.set( 0, 0, - 1 );
        camera.near = 0.1f;
        camera.far = 1000f;
        entity.addComponent( new CameraComponent( camera,
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ),
                Color.DARK_GRAY ) );
        return entity;
    }
}
