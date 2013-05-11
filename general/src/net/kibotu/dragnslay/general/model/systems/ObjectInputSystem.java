package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.utils.ImmutableBag;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class ObjectInputSystem extends AGestureListenerSystem {

    public ObjectInputSystem ( final Aspect aspect ) {
        super( aspect );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
    }
}
