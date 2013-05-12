package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SelectableComponent extends Component {

    /**
     * axis-aligned bounding box
     */
    public BoundingBox aabb;

    public SelectableComponent () {
        aabb = new BoundingBox();
    }
}
