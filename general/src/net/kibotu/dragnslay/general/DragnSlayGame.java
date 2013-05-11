package net.kibotu.dragnslay.general;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.GLESOrthographicCamera;
import net.kibotu.dragnslay.general.screens.SplashScreen;
import net.kibotu.logger.Logger;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class DragnSlayGame extends Game {

    private static final String TAG = DragnSlayGame.class.getSimpleName();
    /**
     * Spritebatch for displaying sprites.
     * Note: There can be only one sprite batch at a time.
     */
    public static SpriteBatch batch;
    public static ShaderProgram libgdx;
    public static ShaderProgram phong;
    public static GLESOrthographicCamera orthographicCamera;

    public DragnSlayGame () {
        super();
    }

    @Override
    public void create () {
        Logger.v( TAG, "create" );
        orthographicCamera = new GLESOrthographicCamera();
        setScreen( new SplashScreen( this ) );
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
        super.resume();
        Logger.v( TAG, "resume" );

        // re-allocate stuff
        Assets.create();

        // do fancy loading screen
        // might be null now
        libgdx = Assets.manager.get( Constants.SHADER_LIBGDX_DEFAULT, ShaderProgram.class );
        batch = new SpriteBatch( 1000, libgdx );
    }

    @Override
    public void resize ( int width, int height ) {
        super.resize( width, height );
        Logger.v( TAG, "resize" );
        DragnSlayGame.orthographicCamera.setToOrtho( false, width, height );
    }

    @Override
    public void dispose () {
        super.dispose();
        Logger.v( TAG, "dispose" );
        Assets.dispose();
    }
}
