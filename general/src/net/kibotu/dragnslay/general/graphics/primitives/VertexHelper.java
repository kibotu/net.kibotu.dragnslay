package net.kibotu.dragnslay.general.graphics.primitives;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.materials.Material;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.g3d.model.still.StillSubMesh;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
class VertexHelper {

    public final float[] finalVerts;
    public final short[] finalIndices;
    private int vi = 0;
    private int ii = 0;

    public VertexHelper ( int maxVertices, int maxIndices ) {
        finalVerts = new float[maxVertices * ( 3 + 3 + 2 )];
        finalIndices = new short[maxIndices];
    }

    public static VertexAttributes getVertexAttributes () {
        return new VertexAttributes(
                new VertexAttribute( VertexAttributes.Usage.Position, 3, ShaderProgram.POSITION_ATTRIBUTE ),
                new VertexAttribute( VertexAttributes.Usage.Normal, 3, ShaderProgram.NORMAL_ATTRIBUTE ),
                new VertexAttribute( VertexAttributes.Usage.TextureCoordinates, 2, ShaderProgram.TEXCOORD_ATTRIBUTE + "0" ) );
    }

    public static void rotateZ ( float angle, Vector3 v ) {
        float cosRY = ( float ) Math.cos( angle );
        float sinRY = ( float ) Math.sin( angle );
        float x = v.x;
        v.x = ( v.x * cosRY ) - ( v.y * sinRY );
        v.y = ( x * sinRY ) + ( v.y * cosRY );
    }

    public static void rotateY ( float angle, Vector3 v ) {
        float cosRY = ( float ) Math.cos( angle );
        float sinRY = ( float ) Math.sin( angle );
        float x = v.x;
        v.x = ( v.x * cosRY ) + ( v.z * sinRY );
        v.z = ( x * - sinRY ) + ( v.z * cosRY );
    }

    public void addVertex ( final float pX, final float pY, final float pZ, final float nX, final float nY, final float nZ, final float u, final float v ) {
        finalVerts[vi++] = pX;
        finalVerts[vi++] = pY;
        finalVerts[vi++] = pZ;
        finalVerts[vi++] = nX;
        finalVerts[vi++] = nY;
        finalVerts[vi++] = nZ;
        finalVerts[vi++] = u;
        finalVerts[vi++] = v;
    }

    public void addFace ( int p0, int p1, int p2 ) {
        finalIndices[ii++] = ( short ) p0;
        finalIndices[ii++] = ( short ) p1;
        finalIndices[ii++] = ( short ) p2;

    }

    public void addQuad ( int upperLeft, int upperRight, int lowerRight, int lowerLeft ) {
        addFace( upperLeft, lowerRight, upperRight );
        addFace( upperLeft, lowerLeft, lowerRight );
    }

    public StillModel getModel ( String tag ) {
        // actual mesh
        Mesh mesh = new Mesh( true, finalVerts.length, finalIndices.length, VertexHelper.getVertexAttributes() );
        mesh.setVertices( finalVerts );
        mesh.setIndices( finalIndices );

        // add mesh to model
        StillModel model = new StillModel( new StillSubMesh( tag, mesh, GL10.GL_TRIANGLES ) );
        model.setMaterial( new Material( tag ) );
        return model;
    }
}