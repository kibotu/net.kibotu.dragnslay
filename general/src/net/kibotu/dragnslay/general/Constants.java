package net.kibotu.dragnslay.general;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
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
    public static final Logger.Level LOGGING_LEVEL = Logger.Level.NO_LOGGING;

    /**
     * Screens
     */

    public static final long SPLASH_SCREEN_DISPLAY_TIME = 750;

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

    static {
        // disable default materials forcing shader attributes
        ShaderProgram.pedantic = false;
    }

    public static final String SHADER_LIBGDX_DEFAULT = SHADER_PATH + "Libgdx_DefaultShader";
    public static final String SHADER_PHONG = SHADER_PATH + "Phong";

    /**
     * Meshes
     */

    public static final String MODEL_RAZOR = MODELS_PATH + "razor.obj";

    /**
     * Textures
     */

    public static final String TEXTURE_SPLASH_SCREEN = ATLASES_PATH + "splashscreen.png";
    public static final String TEXTURE_LOADING_SCREEN = ATLASES_PATH + "loadingscreen.png";
    public static final String TEXTURE_RAZOR = ATLASES_PATH + "razor.png";
    public static final String TEXTURE_CRATE = ATLASES_PATH + "crate.png";
    public static final String TEXTURE_EARTH = ATLASES_PATH + "earth.png";

    private Constants () {
    }
}
