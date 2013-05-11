package net.kibotu.dragnslay.general;

import net.kibotu.logger.Logger;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
final public class Constants {

    /**
     * Logger stuff
     */

    public static final String APP_TAG = "DNS";
    public static final Logger.Level LOGGING_LEVEL = Logger.Level.VERBOSE;

    /**
     * FILE PATHS
     */

    public static final String DATA_PATH = "data/";
    public static final String GRAPHICS_PATH = DATA_PATH + "Graphics/";
    public static final String SHADER_PATH = GRAPHICS_PATH + "Shader/";
    public static final String ATLASES_PATH = GRAPHICS_PATH + "Atlases/";
    public static final String MODELS_PATH = GRAPHICS_PATH + "Models/";

    /**
     * Flurry
     */

    public static final String FLURRY_API_KEY = "";

    /**
     * SHADER see {@link net.kibotu.dragnslay.general.assets.loader.ShaderAssetLoader}
     */

    public static final String SHADER_LIBGDX_DEFAULT = SHADER_PATH + "Libgdx_DefaultShader";
    public static final String SHADER_PHONG = SHADER_PATH + "Phong";

    /**
     * Meshes
     */

    public static final String MODEL_BLA = MODELS_PATH + "bla.obj";

    /**
     * Textures
     */

    public static final String TEXTURE_SPLASH_SCREEN = ATLASES_PATH + "splashscreen.png";
    public static final String TEXTURE_LOADING_SCREEN = ATLASES_PATH + "loadingscreen.png";


    private Constants () {
    }
}
