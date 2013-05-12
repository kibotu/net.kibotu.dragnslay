package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector3;
import org.jetbrains.annotations.NotNull;


/**
 * This component stores the current position for the given entity for movable objects.
 * These are Game World coordinates.
 */
public class MovablePosition extends Component {

    public Vector3 oldPosition;
    public float startTime;
    public float currentTime;

    public MovableTransformation ( @NotNull final Vector3 position ) {
        this.oldPosition = new Vector3( position );
        startTime = 0;
        currentTime = 0;
    }
}
