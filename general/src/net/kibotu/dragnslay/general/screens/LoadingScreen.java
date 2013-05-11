package net.kibotu.dragnslay.general.screens;

import com.badlogic.gdx.Screen;
import net.kibotu.dragnslay.general.DragnSlayGame;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.logger.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LoadingScreen implements Screen {

    private static final String TAG = LoadingScreen.class.getSimpleName();
    private DragnSlayGame gameContext;

    public LoadingScreen ( @NotNull final DragnSlayGame gameContext ) {
        this.gameContext = gameContext;
        Logger.v( TAG, "construct" );

        Assets.loadLoadingScreen();
    }

    @Override
    public void render ( final float delta ) {

        Logger.v( TAG, String.format( "Current progress %f", Assets.manager.getProgress() ) );
        if ( Assets.manager.update() ) {
            Logger.v( TAG, "Finished loading basic assets." );
            gameContext.setScreen( new GameScreen( gameContext ) );
            // this screen is preserved (not disposed) at the moment
        }
    }

    @Override
    public void resize ( final int width, final int height ) {
        Logger.v( TAG, "resize" );
    }

    @Override
    public void show () {
        Logger.v( TAG, "show" );

        // load game assets
        Assets.create();
    }

    @Override
    public void hide () {
        Logger.v( TAG, "hide" );

        // unload loading screen
        Assets.unloadLoadingScreen();
    }

    @Override
    public void pause () {
        Logger.v( TAG, "pause" );
    }

    @Override
    public void resume () {
        Logger.v( TAG, "resume" );

        // load loading screen
        Assets.loadLoadingScreen();
    }

    @Override
    public void dispose () {
        // gets called only manually
        Logger.v( TAG, "dispose" );

        // unload loading screen
        Assets.unloadLoadingScreen();
    }
}
