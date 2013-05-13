package net.kibotu.dragnslay.general.model.components.states;

import com.artemis.Component;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpaceShipIdleComponent extends Component {

    public float delta;
    public float circulationTerm;
    public float radius;

    public SpaceShipIdleComponent ( final float circulationTerm, final float radius ) {
        this.delta = 0;
        this.circulationTerm = circulationTerm;
        this.radius = radius;
    }
}
