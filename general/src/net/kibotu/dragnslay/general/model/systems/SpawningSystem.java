package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import net.kibotu.dragnslay.general.model.EntityBuilder;
import net.kibotu.dragnslay.general.model.components.AffiliationComponent;
import net.kibotu.dragnslay.general.model.components.SpawningComponent;
import net.kibotu.dragnslay.general.model.components.states.SpaceShipIdleComponent;

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
        final long currentTime = System.currentTimeMillis();
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            sC = spawnCmp.get( e );
            if ( sC.currentSpawns >= sC.maxSpawnAmount ) break;  // TODO rethink current spawn amount source
            sC.delta += currentTime - sC.startTime;
            sC.startTime = currentTime;
            long amount = sC.delta / sC.interval;
            if ( amount > 0 ) {
                sC.delta -= amount * sC.interval;
                for ( int j = 0; j < amount; ++ j ) {
                    Entity newEntity = EntityBuilder.createSpaceship();
                    newEntity.addComponent( new AffiliationComponent( e ) );
                    newEntity.addComponent( new SpaceShipIdleComponent( 4, 2 ) );
                    EntityBuilder.world.addEntity( newEntity );
                    sC.currentSpawns++;
                    sC.spawns.add( newEntity );
                }
            }
        }
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
