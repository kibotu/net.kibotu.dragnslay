package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import net.kibotu.dragnslay.general.model.components.SpawningComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpawningSystem extends EntitySystem {

    public SpawningSystem ( final Aspect aspect ) {
        super( Aspect.getAspectForAll( SpawningComponent.class ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
