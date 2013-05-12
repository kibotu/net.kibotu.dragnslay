package net.kibotu.dragnslay.general.model.systems.input;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import net.kibotu.dragnslay.general.model.components.CameraComponent;
import net.kibotu.logger.Logger;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class CameraInputSystem extends AGestureListenerSystem {

    private static final String TAG = CameraInputSystem.class.getSimpleName();
    @Mapper
    ComponentMapper<CameraComponent> cameraCmp;
    private float velocityX;
    private float velocityY;
    private float scale;
    private boolean flinging;

    public CameraInputSystem () {
        super( Aspect.getAspectForAll( CameraComponent.class ) );
        ( ( InputMultiplexer ) Gdx.input.getInputProcessor() ).addProcessor( new GestureDetector( this ) );
        velocityX = 0;
        velocityY = 0;
        scale = 1;
        flinging = false;
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {

        if ( ! flinging ) return;

        Entity e;
        CameraComponent cC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            cC = cameraCmp.get( e );


//            velocityX *= 0.95f;
//            velocityY *= 0.95f;
//            camera.translate( - velocityX * Gdx.graphics.getDeltaTime(), velocityY * Gdx.graphics.getDeltaTime() );
//            if ( Math.abs( velocityX ) < 0.01f ) velocityX = 0;
//            if ( Math.abs( velocityY ) < 0.01f ) velocityY = 0;
        }
    }

    @Override
    public boolean pan ( float x, float y, float deltaX, float deltaY ) {
        Logger.v( TAG, "pan gesture" );
//        camera.position.add(-deltaX * camera.zoom, deltaY * camera.zoom, 0);
        return true;
    }

    @Override
    public boolean fling ( float velocityX, float velocityY, int button ) {
        Logger.v( TAG, "fling gesture" );
//        flinging = true;
//        this.velocityX = camera.zoom * velocityX * 0.5f;
//        this.velocityY = camera.zoom * velocityY * 0.5f;
        return true;
    }

    @Override
    public boolean zoom ( float initialDistance, float distance ) {
        Logger.v( TAG, "zoom gesture" );
//        float z = this.scale * (initialDistance / distance);
//        if (z > WorldConstants.MAX_ZOOM_LEVEL) z = WorldConstants.MAX_ZOOM_LEVEL;
//        if (z < WorldConstants.MIN_ZOOM_LEVEL) z = WorldConstants.MIN_ZOOM_LEVEL;
//        camera.zoom = z;
        return true;
    }

    @Override
    public boolean touchDown ( float x, float y, int pointer, int button ) {
        Logger.v( TAG, "touchDown gesture" );
//
//        flinging = false;
//        scale = camera.zoom;
        return false;
    }
}
