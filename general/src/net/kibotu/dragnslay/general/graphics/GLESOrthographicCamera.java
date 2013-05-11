package net.kibotu.dragnslay.general.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class GLESOrthographicCamera extends OrthographicCamera {

    private Color background;

    public GLESOrthographicCamera () {
        background = Color.DARK_GRAY;
    }

    public void clearScreen () {
        Gdx.graphics.getGL20().glClearColor( background.r, background.g, background.b, background.a );
        Gdx.graphics.getGL20().glClear( GL20.GL_DEPTH_BUFFER_BIT | GL20.GL_COLOR_BUFFER_BIT | GL20.GL_STENCIL_BUFFER_BIT );
    }
}
