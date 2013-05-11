package net.kibotu.dragnslay.general;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.GLESOrthographicCamera;
import net.kibotu.dragnslay.general.graphics.GLESPerspectiveCamera;
import net.kibotu.dragnslay.general.graphics.Light;
import net.kibotu.dragnslay.general.screens.LoadingScreen;
import net.kibotu.dragnslay.general.screens.SplashScreen;
import net.kibotu.logger.Logger;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class DragnSlay extends Game {

    private static final String TAG = DragnSlay.class.getSimpleName();
    /**
     * Spritebatch for displaying sprites.
     * Note: There can be only one sprite batch at a time.
     */
    public static SpriteBatch batch;
    public static ShaderProgram libgdx;
    public static ShaderProgram phong;
    public static GLESOrthographicCamera orthographicCamera;
    public static GLESPerspectiveCamera perspectiveCamera;
    public static Light light;
    public static LoadingScreen loadingScreen;

    public DragnSlay () {
        super();
    }

    @Override
    public void create () {
        Logger.v( TAG, "create" );
        initCameras();
        initLights();
        setScreen( new SplashScreen( this ) );
    }

    private void initLights () {
        light = new Light( Light.Type.u_DirectionalLight, 0, 0, - 35, 0, 0, 1 );
    }

    private void initCameras () {

        // orthographic camera for sprite batch
        orthographicCamera = new GLESOrthographicCamera();
        orthographicCamera.setBackground( Color.DARK_GRAY );

        // camera
        perspectiveCamera = new GLESPerspectiveCamera( 67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        perspectiveCamera.position.set( 0, 0, 35 );
        perspectiveCamera.direction.set( 0, 0, - 1 );
        perspectiveCamera.near = 0.5f;
        perspectiveCamera.far = 1000f;
        perspectiveCamera.setBackground( Color.DARK_GRAY );
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void pause () {
        super.pause();
        Logger.v( TAG, "pause" );

        // dispose stuff
        Assets.clear();
        batch.dispose();
    }

    @Override
    public void resume () {
        Logger.v( TAG, "resume" );
        // TODO rework me with loading screen and dry
        Assets.resume();
        libgdx = Assets.manager.get( Constants.SHADER_LIBGDX_DEFAULT, ShaderProgram.class );
        batch = new SpriteBatch( 1000, libgdx );
        super.resume();
    }

    @Override
    public void resize ( int width, int height ) {
        super.resize( width, height );
        Logger.v( TAG, "resize" );
        DragnSlay.orthographicCamera.setToOrtho( false, width, height );
    }

    @Override
    public void dispose () {
        super.dispose();
        Logger.v( TAG, "dispose" );
        Assets.dispose();
    }
}
