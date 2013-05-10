package net.kibotu.dragnslay.general.screens;

import com.badlogic.gdx.Screen;
import net.kibotu.dragnslay.general.DragnSlayGame;
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
    }

    @Override
    public void render ( final float delta ) {
    }

    @Override
    public void resize ( final int width, final int height ) {
        Logger.v( TAG, "resize" );
    }

    @Override
    public void show () {
        Logger.v( TAG, "show" );

        // TODO load saved stuff
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
    }
}
