package net.kibotu.dragnslay.general.screens;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.DragnSlay;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.scene.MeshNode;
import net.kibotu.dragnslay.general.graphics.scene.RootNode;
import net.kibotu.logger.Logger;
import org.jetbrains.annotations.NotNull;

import static net.kibotu.dragnslay.general.DragnSlay.*;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class GameScreen implements Screen {

    private static final String TAG = GameScreen.class.getSimpleName();
    private final World world = new World();
    private DragnSlay gameContext;
    private RootNode scene;

    public GameScreen ( @NotNull final DragnSlay gameContext ) {
        this.gameContext = gameContext;
        Logger.v( TAG, "construct" );

        // set default gl state
        initGL();



        scene = new RootNode();
        MeshNode razor = new MeshNode( Assets.manager.get( Constants.MODEL_RAZOR, StillModel.class ), Assets.manager.get( Constants.TEXTURE_RAZOR, Texture.class ) );
        scene.addChild( razor );
    }

    private void initGL () {
        Gdx.graphics.getGL20().glEnable( GL20.GL_BLEND );
        Gdx.graphics.getGL20().glEnable( GL20.GL_DITHER );
        Gdx.graphics.getGL20().glEnable( GL20.GL_DEPTH_TEST );
        Gdx.graphics.getGL20().glDisable( GL20.GL_CULL_FACE );   // important! required for spritebatch
        Gdx.graphics.getGL20().glEnable( GL20.GL_TEXTURE_2D );
    }

    /**
     * Main Loop
     *
     * @param delta - dt in milliseconds
     */
    @Override
    public void render ( final float delta ) {
        phong.begin();

        // camera
        perspectiveCamera.clearScreen();
        perspectiveCamera.update();
        perspectiveCamera.apply( phong );

        // light
        light.apply( phong );

        // scene
        scene.render( phong );

        phong.end();
    }

    @Override
    public void resize ( final int width, final int height ) {
        Logger.v( TAG, "resize" );
    }

    @Override
    public void show () {
        Logger.v( TAG, "show" );
        phong = Assets.manager.get( Constants.SHADER_PHONG, ShaderProgram.class );
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
    }

    @Override
    public void dispose () {
        // gets called only manually
        Logger.v( TAG, "dispose" );
    }
}
