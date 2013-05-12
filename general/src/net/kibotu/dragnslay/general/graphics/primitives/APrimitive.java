package net.kibotu.dragnslay.general.graphics.primitives;

import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public abstract class APrimitive {

    protected final String TAG;
    public StillModel model;

    public APrimitive ( int maxVertices, int maxIndices ) {
        this();
        buildMesh( maxVertices, maxIndices );
    }

    public APrimitive () {
        TAG = this.getClass().getSimpleName();
    }

    protected void buildMesh ( int maxVertices, int maxIndices ) {
        VertexHelper helper = new VertexHelper( maxVertices, maxIndices );
        create( helper );
        model = helper.getModel( TAG );
    }

    protected abstract void create ( @NotNull final VertexHelper helper );
}
