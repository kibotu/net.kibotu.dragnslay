package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class TransformationComponent extends Component {

    public Matrix4 combinedTransformation;
    public Vector3 position;
    public Vector3 scalling;
    public Quaternion rotation;

    public TransformationComponent () {
        combinedTransformation = new Matrix4();
        position = new Vector3();
        scalling = new Vector3( 1, 1, 1 );
        rotation = new Quaternion();
    }
}
