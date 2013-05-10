
package net.kibotu.dragnslay.general.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.assets.loader.ShaderLoader;
import net.kibotu.dragnslay.general.assets.loader.StillModelLoader;
import net.kibotu.logger.Logger;

import java.util.HashMap;

import static net.kibotu.dragnslay.general.Constants.*;

public enum Assets {

    INSTANCE;
    private static final String TAG = Assets.class.getSimpleName();
    public static AssetManager manager;
    public static HashMap<String, ShaderProgram> activeShader;
    private static Assets instance;

    static {
        activeShader = new HashMap<>( 2 );
        manager = new AssetManager();
        manager.setLoader( StillModel.class, new StillModelLoader( new InternalFileHandleResolver() ) );
    }

    public static void loadModels () {
//        manager.load( MODEL_BLA, StillModel.class );
    }

    /**
     * Loads all required shader, compiles them and sets active shader.
     */
    public static void loadShaderAssets () {
        activeShader.put( SHADER_LIBGDX_DEFAULT, ShaderLoader.loadAndCreateShader( SHADER_Libgdx_DefaultShader_vsh, SHADER_Libgdx_DefaultShader_fsh ) );
        activeShader.put( SHADER_PHONG, ShaderLoader.loadAndCreateShader( SHADER_Phong_vsh, SHADER_Phong_fsh ) );
    }

    public static void loadSprites () {
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
        Logger.v( TAG, "dispose assets" );
        unload();
        Assets.manager.clear();
        ShaderProgram.clearAllShaderPrograms( Gdx.app );
        Texture.clearAllTextures( Gdx.app );
    }

    private static void unload () {
        manager.unload( TEXTURE_WHITE );
//        manager.unload( MODEL_BLA );
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
}
