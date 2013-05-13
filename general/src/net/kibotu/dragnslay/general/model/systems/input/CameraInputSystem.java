package net.kibotu.dragnslay.general.model.systems.input;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.input.GestureDetector;
import net.kibotu.logger.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class CameraInputSystem extends AGestureListenerSystem {

    private static final String TAG = CameraInputSystem.class.getSimpleName();
    private float velocityX;
    private float velocityY;
    private boolean flinging;
    private PerspectiveCamera camera;
    private float zoomSpeed;
    private float minFovy;
    private float maxFovy;
    private float maxZoomOut;
    private float maxZoomIn;
    private float panSpeed;

    public CameraInputSystem ( @NotNull final PerspectiveCamera camera ) {
        super( Aspect.getEmpty() );
        ( ( InputMultiplexer ) Gdx.input.getInputProcessor() ).addProcessor( new GestureDetector( this ) );
        this.camera = camera;
        velocityX = 0;
        velocityY = 0;
        zoomSpeed = 30;
        minFovy = 67;
        maxFovy = 100;
        panSpeed = 100;
        maxZoomOut = 30;
        maxZoomIn = 3;
        flinging = false;
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
    }

    @Override
    public boolean pan ( float x, float y, float deltaX, float deltaY ) {
        Logger.v( TAG, "pan gesture " + ( ( - deltaX / x ) * Gdx.graphics.getDeltaTime() ) + " " + ( ( deltaY / y ) * Gdx.graphics.getDeltaTime() ) );
        camera.translate( ( - deltaX / x ) * Gdx.graphics.getDeltaTime() * panSpeed, ( deltaY / y ) * Gdx.graphics.getDeltaTime() * panSpeed, 0 );
        return true;
    }

    @Override
    public boolean fling ( float velocityX, float velocityY, int button ) {
        Logger.v( TAG, "fling gesture" );
        flinging = true;
        return true;
    }

    @Override
    public boolean zoom ( float initialDistance, float distance ) {
        Logger.v( TAG, "zoom gesture  " + ( 1 - distance / initialDistance ) );
        return zoomDepth( initialDistance, distance );
    }

    public boolean zoomDepth ( float initialDistance, float distance ) {
        camera.translate( 0, 0, ( zoomSpeed * Gdx.graphics.getDeltaTime() ) * ( 1 - distance / initialDistance ) );
        if ( camera.position.z < maxZoomIn ) {
            camera.position.z = maxZoomIn;
        } else if ( camera.position.z > maxZoomOut ) {
            camera.position.z = maxZoomOut;
        }
        return zoomFovy( initialDistance, distance );
    }

    /**
     * see http://badlogicgames.com/forum/viewtopic.php?f=11&t=5509&p=26355&hilit=zoom+perspective#p26355
     */
    public boolean zoomFovy ( float initialDistance, float distance ) {
        float ratio = 1 - distance / initialDistance;
        camera.fieldOfView += ( zoomSpeed * Gdx.graphics.getDeltaTime() ) * Math.signum( ratio );
        if ( camera.fieldOfView < minFovy ) {
            camera.fieldOfView = minFovy;
        } else if ( camera.fieldOfView > maxFovy ) {
            camera.fieldOfView = maxFovy;
        }
        return true;
    }

    @Override
    public boolean touchDown ( float x, float y, int pointer, int button ) {
        Logger.v( TAG, "touchDown gesture" );
        return false;
    }
}
