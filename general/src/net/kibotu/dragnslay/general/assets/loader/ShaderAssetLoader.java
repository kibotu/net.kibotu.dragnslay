package net.kibotu.dragnslay.general.assets.loader;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class ShaderAssetLoader extends SynchronousAssetLoader<ShaderProgram, AssetLoaderParameters<ShaderProgram>> {

    private static final String VERTEX_SHADER_EXTENSION = ".vsh";
    private static final String FRAGMENT_SHADER_EXTENSION = ".fsh";

    public ShaderAssetLoader ( final FileHandleResolver resolver ) {
        super( resolver );
    }

    @Override
    public ShaderProgram load ( final AssetManager assetManager, final String fileName, final AssetLoaderParameters<ShaderProgram> parameter ) {
        final ShaderProgram shader = new ShaderProgram( resolve( fileName + VERTEX_SHADER_EXTENSION ), resolve( fileName + FRAGMENT_SHADER_EXTENSION ) );
        if ( shader.isCompiled() == false ) {
            throw new IllegalStateException( shader.getLog() );
        }
        return shader;
    }

    @Override
    public Array<AssetDescriptor> getDependencies ( final String fileName, final AssetLoaderParameters<ShaderProgram> parameter ) {
        return null;
    }
}
