package net.kibotu.dragnslay.general.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
final public class Utils {

    private Utils () {
    }

    /**
     * Rotates a vector around an origin.
     *
     * @param v        The vector to rotate.
     * @param o        The origin.
     * @param angleDeg The angle, in degrees.
     *
     * @author Obli from Badlogic forum (libGDX)
     */
    public static void rotate ( Vector3 v, Vector3 o, float angleDeg ) {
        float cos = MathUtils.cosDeg( angleDeg );
        float sin = MathUtils.sinDeg( angleDeg );
        float x = v.x;
        float y = v.y;
        v.x = cos * ( x - o.x ) - sin * ( y - o.y ) + o.x;
        v.y = sin * ( x - o.x ) + cos * ( y - o.y ) + o.y;
    }

    public static void rotateAroundVector ( Vector3 v, Vector3 o, float radius, float time, float circulationTerm ) {
        v.x = o.x + ( - radius * MathUtils.cos( phi( time, circulationTerm ) ) );
        v.y = o.y + ( radius * MathUtils.sin( phi( time, circulationTerm ) ) );
    }

    private static float phi ( float t, float tu ) {
        return ( float ) ( ( tu == 0 ) ? 2 * Math.PI * t : 2 * Math.PI * t / tu );
    }
}
