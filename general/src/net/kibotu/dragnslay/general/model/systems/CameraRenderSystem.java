package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import net.kibotu.dragnslay.general.model.components.CameraComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class CameraRenderSystem extends EntitySystem {

    public static final String u_ProjectionWorldView = "u_ProjectionWorldView";
    @Mapper
    ComponentMapper<CameraComponent> cameraCmp;

    public CameraRenderSystem () {
        super( Aspect.getAspectForAll( CameraComponent.class ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        Entity e;
        CameraComponent cC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            cC = cameraCmp.get( e );

            // cls
            Gdx.graphics.getGL20().glClearColor( cC.bgColor.r, cC.bgColor.g, cC.bgColor.b, cC.bgColor.a );
            Gdx.graphics.getGL20().glClear( GL20.GL_DEPTH_BUFFER_BIT | GL20.GL_COLOR_BUFFER_BIT | GL20.GL_STENCIL_BUFFER_BIT );

            // update camera
            cC.camera.update();

            // send transformation matrix to shader
            cC.program.setUniformMatrix( u_ProjectionWorldView, cC.camera.combined );
        }
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
