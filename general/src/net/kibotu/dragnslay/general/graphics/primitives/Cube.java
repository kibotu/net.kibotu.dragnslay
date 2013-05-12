package net.kibotu.dragnslay.general.graphics.primitives;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.materials.Material;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.g3d.model.still.StillSubMesh;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class Cube {

    private static final String TAG = Cube.class.getSimpleName();
    public StillModel model;

    public Cube () {
        create();
    }

    private void create () {

        int maxVertices = 24;
        int faces = 12;
        int maxIndices = faces * 3;

        VertexHelper helper = new VertexHelper( maxVertices, maxIndices );
        float c = 1f;

        // build interleaved vertices
        helper.addVertex( c, - c, - c, 0, - c, 0, 0, 0 );
        helper.addVertex( c, - c, c, 0, - c, 0, c, 0 );
        helper.addVertex( - c, - c, c, 0, - c, 0, c, c );
        helper.addVertex( - c, - c, - c, 0, - c, 0, 0, c );
        helper.addVertex( c, c, - c, 0, c, 0, 0, 0 );
        helper.addVertex( - c, c, - c, 0, c, 0, c, 0 );
        helper.addVertex( - c, c, c, 0, c, 0, c, c );
        helper.addVertex( c, c, c, 0, c, 0, 0, c );
        helper.addVertex( c, - c, - c, c, 0, 0, 0, 0 );
        helper.addVertex( c, c, - c, c, 0, 0, c, 0 );
        helper.addVertex( c, c, c, c, 0, 0, c, c );
        helper.addVertex( c, - c, c, c, 0, 0, 0, c );
        helper.addVertex( c, - c, c, - 0, - 0, c, 0, 0 );
        helper.addVertex( c, c, c, - 0, - 0, c, c, 0 );
        helper.addVertex( - c, c, c, - 0, - 0, c, c, c );
        helper.addVertex( - c, - c, c, - 0, - 0, c, 0, c );
        helper.addVertex( - c, - c, c, - c, - 0, - 0, 0, 0 );
        helper.addVertex( - c, c, c, - c, - 0, - 0, c, 0 );
        helper.addVertex( - c, c, - c, - c, - 0, - 0, c, c );
        helper.addVertex( - c, - c, - c, - c, - 0, - 0, 0, c );
        helper.addVertex( c, c, - c, 0, 0, - c, 0, 0 );
        helper.addVertex( c, - c, - c, 0, 0, - c, c, 0 );
        helper.addVertex( - c, - c, - c, 0, 0, - c, c, c );
        helper.addVertex( - c, c, - c, 0, 0, - c, 0, c );

        // build indices
        helper.addFace( 0, 1, 2 );
        helper.addFace( 0, 2, 3 );
        helper.addFace( 4, 5, 6 );
        helper.addFace( 4, 6, 7 );
        helper.addFace( 8, 9, 10 );
        helper.addFace( 8, 10, 11 );
        helper.addFace( 12, 13, 14 );
        helper.addFace( 12, 14, 15 );
        helper.addFace( 16, 17, 18 );
        helper.addFace( 16, 18, 19 );
        helper.addFace( 20, 21, 22 );
        helper.addFace( 20, 22, 23 );

        // actual mesh
        Mesh mesh = new Mesh( true, maxVertices, maxIndices, VertexHelper.getVertexAttributes() );
        mesh.setVertices( helper.finalVerts );
        mesh.setIndices( helper.finalIndices );

        // add mesh to model
        model = new StillModel( new StillSubMesh( TAG, mesh, GL10.GL_TRIANGLES ) );
        model.setMaterial( new Material( TAG ) );
    }
}
