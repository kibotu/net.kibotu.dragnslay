package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * POD for the axis-aligned bounding box, used for selectable
 * entities (collision detection)
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SelectableComponent extends Component {

    public BoundingBox aabb;

    public SelectableComponent () {
        aabb = new BoundingBox();
    }
}
