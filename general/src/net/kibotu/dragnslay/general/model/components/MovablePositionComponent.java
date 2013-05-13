package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector3;
import org.jetbrains.annotations.NotNull;

/**
 * POD for old old position, used for interpolated movement
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class MovablePositionComponent extends Component {

    public Vector3 oldPosition;
    public float startTime;
    public float currentTime;

    public MovablePositionComponent ( @NotNull final Vector3 position ) {
        this.oldPosition = new Vector3( position );
        startTime = 0;
        currentTime = 0;


    }
}
