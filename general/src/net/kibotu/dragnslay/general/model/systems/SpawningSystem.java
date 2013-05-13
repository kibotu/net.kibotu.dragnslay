package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import net.kibotu.dragnslay.general.model.EntityBuilder;
import net.kibotu.dragnslay.general.model.components.SpawningComponent;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpawningSystem extends EntitySystem {

    private static final String TAG = SpawningSystem.class.getSimpleName();
    @Mapper
    ComponentMapper<SpawningComponent> spawnCmp;

    public SpawningSystem () {
        super( Aspect.getAspectForAll( SpawningComponent.class ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        Entity e;
        SpawningComponent sC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            sC = spawnCmp.get( e );
            sC.delta += System.currentTimeMillis() - sC.startTime;
            sC.startTime = System.currentTimeMillis();
            long amount = sC.delta / sC.interval;
            if ( amount > 0 ) {
                sC.delta -= amount * sC.interval;
                for ( int j = 0; j < amount; ++ j ) {
                    Entity newEntity = EntityBuilder.createSpaceship();
                    TransformationComponent tC = newEntity.getComponent( TransformationComponent.class );
                    tC.position.set( 2, 0, 0 );
                    EntityBuilder.world.addEntity( newEntity );
                }
            }
        }
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
