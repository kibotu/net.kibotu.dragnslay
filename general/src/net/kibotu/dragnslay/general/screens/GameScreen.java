package net.kibotu.dragnslay.general.screens;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.collision.BoundingBox;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.DragnSlay;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.scene.MeshNode;
import net.kibotu.dragnslay.general.graphics.scene.RootNode;
import net.kibotu.dragnslay.general.model.EntityBuilder;
import net.kibotu.dragnslay.general.model.systems.ObjectInputSystem;
import net.kibotu.dragnslay.general.model.systems.StillModelRenderSystem;
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
    private MeshNode razor;
    private World world;
    private DragnSlay gameContext;
    private RootNode scene;
    private BoundingBox razorBox;

    public GameScreen ( @NotNull final DragnSlay gameContext ) {
        this.gameContext = gameContext;
        Logger.v( TAG, "construct" );

        // set default gl state
        initGL();

        ObjectInputSystem objectInputSystem = new ObjectInputSystem();

        // input
        InputMultiplexer multiplexer = new InputMultiplexer();
//        multiplexer.addProcessor(new GestureDetector(hudInputSystem));
        multiplexer.addProcessor( new GestureDetector( objectInputSystem ) );
        Gdx.input.setInputProcessor( multiplexer );

        // create world
        world = new World();

        // init entity builder
        EntityBuilder.init( world );

        // add systems
//        world.setSystem(hudInputSystem);
        world.setSystem( objectInputSystem );
        world.setSystem( new StillModelRenderSystem() );
        world.initialize();

        // assemble world
        createEntities();
    }

    private void createEntities () {
        world.addEntity( EntityBuilder.createSpaceship() );
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

        world.setDelta( delta );
        world.process();

//        razor.getRotation().setEulerAngles( Gdx.input.getPitch(), Gdx.input.getRoll(), Gdx.input.getAzimuth() );

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
