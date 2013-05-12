package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import net.kibotu.dragnslay.general.model.components.DisplayComponent;
import net.kibotu.dragnslay.general.model.components.SelectableComponent;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;
import net.kibotu.logger.Logger;

import static net.kibotu.dragnslay.general.DragnSlay.perspectiveCamera;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class ObjectInputSystem extends AGestureListenerSystem {

    private static final String TAG = ObjectInputSystem.class.getSimpleName();
    @Mapper
    ComponentMapper<TransformationComponent> transformationCmp;
    @Mapper
    ComponentMapper<DisplayComponent> displayCmp;
    @Mapper
    ComponentMapper<SelectableComponent> selectableCmp;
    private Vector3 unprojected;
    private boolean isTapped;
    private Ray ray;

    public ObjectInputSystem () {
        super( Aspect.getAspectForAll( TransformationComponent.class, DisplayComponent.class, SelectableComponent.class ) );
        isTapped = false;
        unprojected = new Vector3();
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        if ( ! isTapped ) return;
        isTapped = false;
        Entity e;
        TransformationComponent tC;
        DisplayComponent dC;
        SelectableComponent sC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            dC = displayCmp.get( e );
            tC = transformationCmp.get( e );
            sC = selectableCmp.get( e );

            // get aabb
            BoundingBox aabb = sC.aabb;

            // TODO compute only when dirty
            dC.model.getBoundingBox( aabb );

            // TODO transform only when dirty
            aabb.mul( tC.combinedTransformation );

            // check intersection
            Logger.v( TAG, "intersects: " + Intersector.intersectRayBoundsFast( ray, aabb ) );

            // TODO do somethhing fancy when clicked
        }
    }

    @Override
    public boolean tap ( float x, float y, int count, int button ) {
        isTapped = true;

        // TODO unproject
//        perspectiveCamera.unproject( unprojected.set( x, y, 0 ) );
        ray = perspectiveCamera.getPickRay( x, y, 0f, 0f, ( float ) Gdx.graphics.getWidth(), ( float ) Gdx.graphics.getHeight() );
        return true;
    }
}
