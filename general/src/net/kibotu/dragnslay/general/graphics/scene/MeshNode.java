package net.kibotu.dragnslay.general.graphics.scene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.materials.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.sun.istack.internal.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class MeshNode extends RootNode {

    static {
        // disable default materials forcing shader attributes
        ShaderProgram.pedantic = false;
    }

    public static final String TAG = MeshNode.class.getSimpleName();
    public static final String u_ModelView = "u_ModelView";
    public static final String u_texture01 = "u_texture01";
    public StillModel model;

    public MeshNode ( @NotNull StillModel model, final Texture texture ) {
        super();
        this.model = model;
        texture.setFilter( Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Nearest );
        model.getSubMeshes()[0].material.addAttribute( new TextureAttribute( texture, 0, u_texture01 ) );
    }

    @Override
    public void render ( @NotNull ShaderProgram program ) {
        super.render( program );
        if ( ! isVisible() ) return;
        program.setUniformMatrix( u_ModelView, getCombinedTransoformation() );
        model.render( program );
    }
}

