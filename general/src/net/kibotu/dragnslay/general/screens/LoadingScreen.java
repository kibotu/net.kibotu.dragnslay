package net.kibotu.dragnslay.general.screens;

import com.badlogic.gdx.Screen;
import net.kibotu.logger.Logger;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LoadingScreen implements Screen {

    private static final String TAG = LoadingScreen.class.getSimpleName();

    public LoadingScreen () {
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
