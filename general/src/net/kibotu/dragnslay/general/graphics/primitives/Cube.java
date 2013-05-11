package net.kibotu.dragnslay.general.graphics.primitives;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.model.SubMesh;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.g3d.model.still.StillSubMesh;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.FloatArray;

import java.util.ArrayList;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class Cube {

    private static final String TAG = Cube.class.getSimpleName();

    private StillModel model;

    public Cube () {
        model = new StillModel();
    }

    public void build () {

        final FloatArray verts;
        final FloatArray norms;
        final FloatArray uvs;

        verts = new FloatArray( 300 );
        norms = new FloatArray( 300 );
        uvs = new FloatArray( 200 );





//
//        ArrayList<VertexAttribute> attributes = new ArrayList<>();
//        attributes.add(new VertexAttribute( VertexAttributes.Usage.Position, 3, ShaderProgram.POSITION_ATTRIBUTE));
//        attributes.add(new VertexAttribute( VertexAttributes.Usage.Normal, 3, ShaderProgram.NORMAL_ATTRIBUTE));
//        attributes.add(new VertexAttribute( VertexAttributes.Usage.TextureCoordinates, 2, ShaderProgram.TEXCOORD_ATTRIBUTE + "0"));
//
//        mesh = new Mesh(true, numFaces * 3, numIndices, attributes.toArray(new VertexAttribute[attributes.size()]));
//        mesh.setVertices(finalVerts);
//        if (numIndices > 0) mesh.setIndices(finalIndices);
//
//




        VertexAttributes vertexAttributes = new VertexAttributes();
        Mesh mesh = new Mesh( true, 24, 12, vertexAttributes);

        StillSubMesh [] stillSubMesh = new StillSubMesh[1];
        model = new StillModel(stillSubMesh) ;
    }

//    protected void setupInternal(@NotNull ProcessingState state) {
//        if (mesh != null) return;
//        this.mesh = new Mesh(24, 12);
//
//        final float c = 1f;
//        Color4 emissive = material.getEmission();
//
//        mesh.addVertex(c, -c, -c, 0, -c, 0, emissive.r, emissive.g, emissive.b, emissive.a, 0, 0);
//        mesh.addVertex(c, -c, c, 0, -c, 0, emissive.r, emissive.g, emissive.b, emissive.a, c, 0);
//        mesh.addVertex(-c, -c, c, 0, -c, 0, emissive.r, emissive.g, emissive.b, emissive.a, c, c);
//        mesh.addVertex(-c, -c, -c, 0, -c, 0, emissive.r, emissive.g, emissive.b, emissive.a, 0, c);
//        mesh.addVertex(c, c, -c, 0, c, 0, emissive.r, emissive.g, emissive.b, emissive.a, 0, 0);
//        mesh.addVertex(-c, c, -c, 0, c, 0, emissive.r, emissive.g, emissive.b, emissive.a, c, 0);
//        mesh.addVertex(-c, c, c, 0, c, 0, emissive.r, emissive.g, emissive.b, emissive.a, c, c);
//        mesh.addVertex(c, c, c, 0, c, 0, emissive.r, emissive.g, emissive.b, emissive.a, 0, c);
//        mesh.addVertex(c, -c, -c, c, 0, 0, emissive.r, emissive.g, emissive.b, emissive.a, 0, 0);
//        mesh.addVertex(c, c, -c, c, 0, 0, emissive.r, emissive.g, emissive.b, emissive.a, c, 0);
//        mesh.addVertex(c, c, c, c, 0, 0, emissive.r, emissive.g, emissive.b, emissive.a, c, c);
//        mesh.addVertex(c, -c, c, c, 0, 0, emissive.r, emissive.g, emissive.b, emissive.a, 0, c);
//        mesh.addVertex(c, -c, c, -0, -0, c, emissive.r, emissive.g, emissive.b, emissive.a, 0, 0);
//        mesh.addVertex(c, c, c, -0, -0, c, emissive.r, emissive.g, emissive.b, emissive.a, c, 0);
//        mesh.addVertex(-c, c, c, -0, -0, c, emissive.r, emissive.g, emissive.b, emissive.a, c, c);
//        mesh.addVertex(-c, -c, c, -0, -0, c, emissive.r, emissive.g, emissive.b, emissive.a, 0, c);
//        mesh.addVertex(-c, -c, c, -c, -0, -0, emissive.r, emissive.g, emissive.b, emissive.a, 0, 0);
//        mesh.addVertex(-c, c, c, -c, -0, -0, emissive.r, emissive.g, emissive.b, emissive.a, c, 0);
//        mesh.addVertex(-c, c, -c, -c, -0, -0, emissive.r, emissive.g, emissive.b, emissive.a, c, c);
//        mesh.addVertex(-c, -c, -c, -c, -0, -0, emissive.r, emissive.g, emissive.b, emissive.a, 0, c);
//        mesh.addVertex(c, c, -c, 0, 0, -c, emissive.r, emissive.g, emissive.b, emissive.a, 0, 0);
//        mesh.addVertex(c, -c, -c, 0, 0, -c, emissive.r, emissive.g, emissive.b, emissive.a, c, 0);
//        mesh.addVertex(-c, -c, -c, 0, 0, -c, emissive.r, emissive.g, emissive.b, emissive.a, c, c);
//        mesh.addVertex(-c, c, -c, 0, 0, -c, emissive.r, emissive.g, emissive.b, emissive.a, 0, c);
//
//        mesh.faces.add(0, 1, 2);
//        mesh.faces.add(0, 2, 3);
//        mesh.faces.add(4, 5, 6);
//        mesh.faces.add(4, 6, 7);
//        mesh.faces.add(8, 9, 10);
//        mesh.faces.add(8, 10, 11);
//        mesh.faces.add(12, 13, 14);
//        mesh.faces.add(12, 14, 15);
//        mesh.faces.add(16, 17, 18);
//        mesh.faces.add(16, 18, 19);
//        mesh.faces.add(20, 21, 22);
//        mesh.faces.add(20, 22, 23);
//    }

}
