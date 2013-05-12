package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import net.kibotu.dragnslay.general.model.components.DisplayComponent;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class StillModelRenderSystem extends EntitySystem {

    public static final String u_ModelView = "u_ModelView";
    @Mapper
    ComponentMapper<TransformationComponent> transformationCmp;
    @Mapper
    ComponentMapper<DisplayComponent> displayCmp;

    public StillModelRenderSystem () {
        super( Aspect.getAspectForAll( TransformationComponent.class, DisplayComponent.class ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        Entity e;
        TransformationComponent tC;
        DisplayComponent dC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            dC = displayCmp.get( e );
            if ( ! dC.isVisible ) return;
            tC = transformationCmp.get( e );
            dC.program.setUniformMatrix( u_ModelView, tC.combinedTransformation );
            dC.model.render( dC.program );
        }
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
