package net.kibotu.dragnslay.general.model.systems.input;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import net.kibotu.dragnslay.general.model.components.CameraComponent;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class CameraInputSystem extends AGestureListenerSystem {

    private static final String TAG = CameraInputSystem.class.getSimpleName();
    @Mapper
    ComponentMapper<CameraComponent> cameraCmp;

    public CameraInputSystem () {
        super( Aspect.getAspectForAll( CameraComponent.class ) );
        ( ( InputMultiplexer ) Gdx.input.getInputProcessor() ).addProcessor( new GestureDetector( this ) );
    }

    @Override
    protected void processEntities ( final ImmutableBag<Entity> entities ) {
        Entity e;
        CameraComponent cC;
        for ( int i = 0; i < entities.size(); ++ i ) {
            e = entities.get( i );
            cC = cameraCmp.get( e );
        }
    }
}
