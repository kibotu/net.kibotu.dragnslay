package net.kibotu.dragnslay.general.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.DragnSlayGame;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.logger.Logger;
import org.jetbrains.annotations.NotNull;

import static net.kibotu.dragnslay.general.DragnSlayGame.*;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SplashScreen implements Screen {

    private static final String TAG = SplashScreen.class.getSimpleName();
    private static final long TIME_TO_WAIT = 3000; // 3 seconds
    private DragnSlayGame gameContext;
    private long startTime;
    private Sprite bgSprite;

    public SplashScreen ( @NotNull final DragnSlayGame gameContext ) {
        this.gameContext = gameContext;
        Logger.v( TAG, "construct" );
        startTime = System.currentTimeMillis();

        // load default shader + splash screen texture
        Assets.loadSplashScreen();

        // set
        libgdx = Assets.manager.get( Constants.SHADER_LIBGDX_DEFAULT, ShaderProgram.class );
        batch = new SpriteBatch( 1000, libgdx );

        bgSprite = new Sprite( Assets.manager.get( Constants.TEXTURE_SPLASH_SCREEN, Texture.class ) );
        bgSprite.rotate90( true );
        bgSprite.setBounds( 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
    }

    @Override
    public void render ( final float delta ) {
        DragnSlayGame.orthographicCamera.clearScreen();

        batch.setProjectionMatrix( orthographicCamera.combined );
        batch.begin();
        bgSprite.draw( batch );
        batch.end();

        // switching screens
        if ( System.currentTimeMillis() - startTime > TIME_TO_WAIT ) {
            Logger.v( TAG, "Splash time exceeded" );
            gameContext.setScreen( new LoadingScreen( gameContext ) );
            dispose();
        }
    }

    @Override
    public void resize ( final int width, final int height ) {
        Logger.v( TAG, "resize" );
    }

    @Override
    public void show () {
        Logger.v( TAG, "show" );
    }

    @Override
    public void hide () {
        Logger.v( TAG, "hide" );

        // TODO dispose screen related stuff
    }

    @Override
    public void pause () {
        Logger.v( TAG, "pause" );
    }

    @Override
    public void resume () {
        Logger.v( TAG, "resume" );

        // TODO re-allocate screen related stuff
    }

    @Override
    public void dispose () {
        // gets called only manually
        Logger.v( TAG, "dispose" );
        Assets.unloadSplashScreen();
    }
}
