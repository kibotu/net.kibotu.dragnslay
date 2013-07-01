package net.kibotu.dragnslay.general.model.systems.spaceship;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import net.kibotu.dragnslay.general.model.components.states.SpaceShipMoveComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpaceShipMoveSystem extends EntitySystem {

    public SpaceShipMoveSystem () {
        super( Aspect.getAspectForAll( SpaceShipMoveComponent.class ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {


    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
