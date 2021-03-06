package net.kibotu.dragnslay.general;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.Light;
import net.kibotu.dragnslay.general.graphics.camera.GLESOrthographicCamera;
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
        light = new Light( Light.Type.u_DirectionalLight, 0, 0, - 10, 0, 0, 1 );
    }

    private void initCameras () {
        // orthographic camera for sprite batch
        orthographicCamera = new GLESOrthographicCamera();
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
        Gdx.graphics.getGL20().glViewport( 0, 0, width, height );
        orthographicCamera.setToOrtho( false, width, height );
    }

    @Override
    public void dispose () {
        super.dispose();
        Logger.v( TAG, "dispose" );
        Assets.dispose();
    }
}
