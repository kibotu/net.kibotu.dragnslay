package net.kibotu.dragnslay.general.graphics.primitives;

import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

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
}