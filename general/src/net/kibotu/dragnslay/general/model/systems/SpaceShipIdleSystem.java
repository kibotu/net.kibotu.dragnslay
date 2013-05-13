package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import net.kibotu.dragnslay.general.model.components.AffiliationComponent;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;
import net.kibotu.dragnslay.general.model.components.states.SpaceShipIdleComponent;
import net.kibotu.dragnslay.general.utils.Utils;

/**
 * lets a spaceship idle around a planet
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpaceShipIdleSystem extends EntitySystem {

    private static final String TAG = SpaceShipIdleSystem.class.getSimpleName();
    @Mapper
    ComponentMapper<SpaceShipIdleComponent> idleCmp;
    @Mapper
    ComponentMapper<TransformationComponent> transformationCmp;
    @Mapper
    ComponentMapper<AffiliationComponent> affiliationCmp;

    public SpaceShipIdleSystem () {
        super( Aspect.getAspectForAll( SpaceShipIdleComponent.class, AffiliationComponent.class ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        Entity e;
        SpaceShipIdleComponent iC;
        AffiliationComponent aC;
        TransformationComponent tC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            iC = idleCmp.get( e );
            aC = affiliationCmp.get( e );
            tC = transformationCmp.get( e );
            TransformationComponent parent = aC.entity.getComponent( TransformationComponent.class );
            Utils.rotateAroundVector( tC.position, parent.position, iC.radius, iC.delta += e.getWorld().getDelta(), iC.circulationTerm );
        }
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
