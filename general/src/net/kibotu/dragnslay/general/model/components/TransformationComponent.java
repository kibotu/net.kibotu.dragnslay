package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

/**
 * POD for transformation state of an entity
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class TransformationComponent extends Component {

    public Matrix4 combinedTransformation;
    public Vector3 position;
    public Vector3 scaling;
    public Quaternion rotation;
    public boolean combinedTransformationIsDirty;

    public TransformationComponent () {
        combinedTransformation = new Matrix4();
        position = new Vector3();
        scaling = new Vector3( 1, 1, 1 );
        rotation = new Quaternion();
        combinedTransformationIsDirty = true;
    }
}
