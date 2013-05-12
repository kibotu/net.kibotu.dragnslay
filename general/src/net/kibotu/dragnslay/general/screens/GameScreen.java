package net.kibotu.dragnslay.general.screens;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.DragnSlay;
import net.kibotu.dragnslay.general.assets.Assets;
import net.kibotu.dragnslay.general.graphics.primitives.Cube;
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
public class GameScreen implements Screen, GestureDetector.GestureListener {

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

//        Logger.v( TAG, "compassAvail: " + Gdx.input.isPeripheralAvailable( Input.Peripheral.Compass ) );

        Gdx.input.setInputProcessor( new GestureDetector( this ) );

        world = new World();

//        world.setSystem(hudInputSystem);
//        world.setSystem(objectInputSystem);
//        world.setSystem(mapInputSystem);
//        world.setSystem(new AnimationSystem());
//        world.setSystem(new BackgroundRenderingSystem(batch, camera));
//        world.setSystem(new StaticImageRenderingSystem(batch, camera));
//        world.setSystem(new AnimationRenderingSystem(batch, camera));
        world.initialize();

        createEntities();
    }

    private void createEntities () {
        scene = new RootNode();
//        razor = new MeshNode( Assets.manager.get( Constants.MODEL_RAZOR, StillModel.class ), Assets.manager.get( Constants.TEXTURE_RAZOR, Texture.class ) );

        Cube cube = new Cube();
        razor = new MeshNode( cube.model, Assets.manager.get( Constants.TEXTURE_CRATE, Texture.class ) );

        scene.addChild( razor );
        razorBox = new BoundingBox();
        razor.model.getBoundingBox( razorBox );
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

        razor.getRotation().setEulerAngles( Gdx.input.getPitch(), Gdx.input.getRoll(), Gdx.input.getAzimuth() );

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

    @Override
    public boolean touchDown ( final float x, final float y, final int pointer, final int button ) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean tap ( final float x, final float y, final int count, final int button ) {
        Ray ray = perspectiveCamera.getPickRay( x, y, 0f, 0f, ( float ) Gdx.graphics.getWidth(), ( float ) Gdx.graphics.getHeight() );
        Logger.v( TAG, "intersects: " + Intersector.intersectRayBoundsFast( ray, razorBox ) );
        return false;
    }

    @Override
    public boolean longPress ( final float x, final float y ) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean fling ( final float velocityX, final float velocityY, final int button ) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean pan ( final float x, final float y, final float deltaX, final float deltaY ) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean zoom ( final float initialDistance, final float distance ) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean pinch ( final Vector2 initialPointer1, final Vector2 initialPointer2, final Vector2 pointer1, final Vector2 pointer2 ) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
