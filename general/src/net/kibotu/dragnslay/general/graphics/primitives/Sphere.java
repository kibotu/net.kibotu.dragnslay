package net.kibotu.dragnslay.general.graphics.primitives;

import com.badlogic.gdx.math.Vector3;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class Sphere extends APrimitive {

    /**
     * Sphere stacks from pole to pole.
     */
    private int stacks;
    /**
     * Sphere slices around the equator.
     */
    private int slices;
    private float radius;

    public Sphere ( float radius, int stacks, int slices ) {
        this.radius = radius;
        this.stacks = stacks;
        this.slices = slices;
        buildMesh( ( stacks + 1 ) * ( slices + 1 ), stacks * slices * 2 * 3 ); // 2 because we build quads; 3 because we have 3 indices per face
    }

    public Sphere () {
        this( 1, 16, 16 );
    }

    protected void create ( @NotNull final VertexHelper helper ) {

        int r, c;

        Vector3 n = new Vector3();
        Vector3 pos = new Vector3();
        Vector3 posFull = new Vector3();

        // vertices
        // vertices
        for ( r = 0; r <= slices; r++ ) {
            float v = ( float ) r / ( float ) slices; // [0,1]
            float theta1 = v * ( float ) Math.PI; // [0,PI]

            n.set( 0, 1, 0 );
            VertexHelper.rotateZ( theta1, n );

            for ( c = 0; c <= stacks; c++ ) {
                float u = ( float ) c / ( float ) stacks; // [0,1]
                float theta2 = u * ( float ) ( Math.PI * 2f ); // [0,2PI]
                pos.set( n );
                VertexHelper.rotateY( theta2, pos );

                posFull.set( pos );
                posFull.scl( radius );

                helper.addVertex( posFull.x, posFull.y, posFull.z, pos.x, pos.y, pos.z, u, v );
            }
        }

        // faces
        int colLength = stacks + 1;

        for ( r = 0; r < slices; r++ ) {
            int offset = r * colLength;

            for ( c = 0; c < stacks; c++ ) {
                int ul = offset + c;
                int ur = offset + c + 1;
                int br = offset + c + 1 + colLength;
                int bl = offset + c + 0 + colLength;

                helper.addQuad( ul, ur, br, bl );
            }
        }
    }
}
