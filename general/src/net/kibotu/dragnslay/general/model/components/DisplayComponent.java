package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.materials.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

/**
 * POD for mesh, visibility and used shader
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class DisplayComponent extends Component {

    public static final String u_texture01 = "u_texture01";
    public StillModel model;
    public boolean isVisible;
    public ShaderProgram program;

    public DisplayComponent ( final StillModel model, final Texture texture, final ShaderProgram program ) {
        this.model = model;
        isVisible = true;
        this.program = program;
        texture.setFilter( Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Nearest );
        model.getSubMeshes()[0].material.addAttribute( new TextureAttribute( texture, 0, u_texture01 ) );
    }
}
