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
     * SHADER
     */
    public static final String SHADER_LIBGDX_DEFAULT = "LIBGDX_DEFAULT_SHADER";
    public static final String SHADER_PHONG = "PHONG_SHADER";
    public static final String SHADER_Libgdx_DefaultShader_vsh = SHADER_PATH + "Libgdx_DefaultShader.vsh";
    public static final String SHADER_Libgdx_DefaultShader_fsh = SHADER_PATH + "Libgdx_DefaultShader.fsh";
    public static final String SHADER_Phong_vsh = SHADER_PATH + "Phong.vsh";
    public static final String SHADER_Phong_fsh = SHADER_PATH + "Phong.fsh";

    /**
     * Meshes
     */

    public static final String MODEL_BLA = MODELS_PATH + "bla.obj";

    /**
     * Textures
     */

    public static final String TEXTURE_WHITE = ATLASES_PATH + "white.png";


    private Constants () {
    }
}
