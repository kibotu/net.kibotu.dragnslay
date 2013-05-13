package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.Matrix4;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class TransformationSystem extends EntitySystem {

    private static final String TAG = TransformationSystem.class.getSimpleName();
    @Mapper
    ComponentMapper<TransformationComponent> transformationCmp;
    private Matrix4 scaleMat;
    private Matrix4 transMat;
    private Matrix4 rotMat;

    public TransformationSystem () {
        super( Aspect.getAspectForAll( TransformationComponent.class ) );
        scaleMat = new Matrix4();
        transMat = new Matrix4();
        rotMat = new Matrix4();
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        Entity e;
        TransformationComponent tC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            tC = transformationCmp.get( e );
//            if ( ! tC.combinedTransformationIsDirty ) break;
            // M = S * R * T
            scaleMat.setToScaling( tC.scaling );
            transMat.setTranslation( tC.position );
            tC.combinedTransformation.setToTranslationAndScaling( tC.position.x, tC.position.y, tC.position.z, tC.scaling.x, tC.scaling.y, tC.scaling.z);
            rotMat.set( tC.rotation.nor() );
//            tC.combinedTransformation.set( rotMat.mul( scaleMat.mul( transMat ) ) );
            tC.combinedTransformation.mul( rotMat );
            tC.combinedTransformationIsDirty = false;
        }
    }

    @Override
    protected boolean checkProcessing () {
        return true;
    }
}
