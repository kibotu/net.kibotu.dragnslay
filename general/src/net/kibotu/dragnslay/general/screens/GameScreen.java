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
public class GameScreen implements Screen {

    private static final String TAG = GameScreen.class.getSimpleName();
    private DragnSlayGame gameContext;

    public GameScreen ( @NotNull final DragnSlayGame gameContext ) {
        this.gameContext = gameContext;
        Logger.v( TAG, "construct" );
    }

    @Override
    public void render ( final float delta ) {
        Logger.v( TAG, "construct" );
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
    }

    @Override
    public void pause () {
        Logger.v( TAG, "pause" );
    }

    @Override
    public void resume () {
        Logger.v( TAG, "resume" );
    }

    @Override
    public void dispose () {
        Logger.v( TAG, "dispose" );
    }
}
