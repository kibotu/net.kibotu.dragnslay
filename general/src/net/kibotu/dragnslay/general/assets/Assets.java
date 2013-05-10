
package net.kibotu.dragnslay.general.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import net.kibotu.dragnslay.general.assets.loader.ShaderLoader;
import net.kibotu.dragnslay.general.assets.loader.StillModelLoader;

import java.util.HashMap;

import static net.kibotu.dragnslay.general.Constants.*;

public final class Assets {

    public static AssetManager manager;
    public static HashMap<String, ShaderProgram> activeShader;
    private static Assets instance;

    private Assets () {
        activeShader = new HashMap<>( 2 );
        manager = new AssetManager();
        manager.setLoader( StillModel.class, new StillModelLoader( new InternalFileHandleResolver() ) );
    }

    public synchronized static Assets instance () {
        if ( instance == null ) {
            instance = new Assets();
        }
        return instance;
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
        loadShaderAssets();
        loadModels();
        loadSprites();
        manager.finishLoading();
    }

    /**
     * Clears all assets related buffers.
     */
    public static void clear () {
        unload();
        Assets.manager.clear();
        ShaderProgram.clearAllShaderPrograms( Gdx.app );
        Texture.clearAllTextures( Gdx.app );
    }

    private static void unload () {
        manager.unload( TEXTURE_WHITE );
//        manager.unload( MODEL_BLA );
    }
}
