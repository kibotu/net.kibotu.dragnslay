package net.kibotu.dragnslay.general;

import com.badlogic.gdx.Game;
import net.kibotu.logger.Logger;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class DragnSlayGame extends Game {

    private static final String TAG = DragnSlayGame.class.getSimpleName();

    public DragnSlayGame () {
        super();
        Logger.v( TAG, "construct" );
    }

    @Override
    public void create () {
        Logger.v( TAG, "create" );
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void pause () {
        super.pause();
        Logger.v( TAG, "pause" );
    }

    @Override
    public void resume () {
        super.resume();
        Logger.v( TAG, "resume" );
    }

    @Override
    public void resize ( int width, int height ) {
        super.resize( width, height );
        Logger.v( TAG, "resize" );
    }

    @Override
    public void dispose () {
        super.dispose();
        Logger.v( TAG, "dispose" );
    }
}
