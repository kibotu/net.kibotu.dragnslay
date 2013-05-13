package net.kibotu.dragnslay.general.model;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.flurry.org.apache.avro.reflect.Nullable;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.primitives.Cube;
import net.kibotu.dragnslay.general.graphics.primitives.Sphere;
import net.kibotu.dragnslay.general.model.components.*;
import net.kibotu.logger.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
final public class EntityBuilder {

    private static final String TAG = EntityBuilder.class.getSimpleName();
    @Nullable
    public static World world;

    private EntityBuilder () {
    }

    public static void init ( @NotNull final World world ) {
        EntityBuilder.world = world;
    }

    public static Entity createPlanet () {
        Entity entity = world.createEntity();
        Logger.v( TAG, "create planet " + entity.getUuid() );
        entity.addComponent( new TransformationComponent() );
        Sphere sphere = new Sphere();
        entity.addComponent( new DisplayComponent( sphere.model,
                Assets.manager.get( Constants.TEXTURE_EARTH, Texture.class ),
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ) ) );
        entity.addComponent( new SelectableComponent() );
        entity.addComponent( new SpawningComponent( 1, 15, ( int ) (15/(360f/15f)*1000f) ) );
        return entity;
    }

    public static Entity createSpaceship () {
        Entity entity = world.createEntity();
        Logger.v( TAG, "create spaceship " + entity.getUuid() );
        TransformationComponent tC = new TransformationComponent();
        tC.scaling.scl( 0.10f );
        entity.addComponent( tC );
        entity.addComponent( new DisplayComponent(
                Assets.manager.get( Constants.MODEL_RAZOR, StillModel.class ),
                Assets.manager.get( Constants.TEXTURE_RAZOR, Texture.class ),
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ) ) );
        return entity;
    }

    public static Entity createPlaceholder () {
        Entity entity = world.createEntity();
        Logger.v( TAG, "create placeholder " + entity.getUuid() );
        entity.addComponent( new TransformationComponent() );
        Cube cube = new Cube();
        entity.addComponent( new DisplayComponent( cube.model,
                Assets.manager.get( Constants.TEXTURE_CRATE, Texture.class ),
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ) ) );
        return entity;
    }

    public static Entity createCamera ( final PerspectiveCamera camera ) {
        Entity entity = world.createEntity();
        Logger.v( TAG, "create camera " + entity.getUuid() );
        camera.position.set( 0, 0, 15 );
        camera.direction.set( 0, 0, - 1 );
        camera.near = 0.1f;
        camera.far = 100f;
        entity.addComponent( new CameraComponent( camera,
                Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class ),
                Color.BLACK ) );
        return entity;
    }
}
