
package net.kibotu.dragnslay.general.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.assets.loader.ShaderAssetLoader;
import net.kibotu.dragnslay.general.assets.loader.StillModelAssetLoader;
import net.kibotu.logger.Logger;

import static net.kibotu.dragnslay.general.Constants.*;

// https://github.com/libgdx/libgdx/blob/new3dapi/tests/gdx-tests/src/com/badlogic/gdx/tests/AssetManagerTest.java
public enum Assets {

    INSTANCE;
    private static final String TAG = Assets.class.getSimpleName();
    public static AssetManager manager;
    private static Assets instance;

    static {
        manager = new AssetManager();
        manager.setLoader( StillModel.class, new StillModelAssetLoader( new InternalFileHandleResolver() ) );
        manager.setLoader( ShaderProgram.class, new ShaderAssetLoader( new InternalFileHandleResolver() ) );
    }

    public static void loadModels () {
        Logger.v( TAG, "load model assets" );
//        manager.load( MODEL_BLA, StillModel.class );
    }

    /**
     * Loads all required shader, compiles them and sets active shader.
     */
    public static void loadShaderAssets () {
        Logger.v( TAG, "load shader assets" );
        manager.load( SHADER_LIBGDX_DEFAULT, ShaderProgram.class );
        manager.load( SHADER_PHONG, ShaderProgram.class );
    }

    public static void loadSprites () {
        Logger.v( TAG, "load sprites assets" );
        manager.load( TEXTURE_WHITE, Texture.class );
    }

    /**
     * Re-Allocates assets.
     */
    public static void create () {
        Logger.v( TAG, "allocate assets" );
        loadShaderAssets();
        loadModels();
        loadSprites();
    }

    /**
     * Clears all assets related buffers.
     */
    public static void clear () {
        Logger.v( TAG, "unload all assets" );
        unload();
    }

    private static void unload () {
        Logger.v( TAG, "unload assets" );
        manager.unload( TEXTURE_WHITE );
        manager.unload( SHADER_LIBGDX_DEFAULT );
        manager.unload( SHADER_PHONG );
    }

    public static void loadSplashScreen () {
        Logger.v( TAG, "allocate splash screen assets" );
    }

    public static void unloadSplashScreen () {
        Logger.v( TAG, "unload splash screen assets" );
    }

    public static void loadLoadingScreen () {
        Logger.v( TAG, "allocate loading screen assets" );
    }

    public static void unloadLoadingScreen () {
        Logger.v( TAG, "unload loading screen assets" );
    }

    public static void dispose () {
        Logger.v( TAG, "dispose assets" );
        Assets.manager.clear();
        ShaderProgram.clearAllShaderPrograms( Gdx.app );
        Texture.clearAllTextures( Gdx.app );
    }
}
