package net.kibotu.dragnslay.general.model.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import net.kibotu.dragnslay.general.model.components.DisplayComponent;
import net.kibotu.dragnslay.general.model.components.TransformationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class ModelRendererSystem extends EntitySystem {

    public static final String u_ModelView = "u_ModelView";
    @Mapper
    ComponentMapper<TransformationComponent> transformationCmp;
    @Mapper
    ComponentMapper<DisplayComponent> displayCmp;

    private ModelBatch modelBatch;

    public ModelRendererSystem(@NotNull final ModelBatch modelBatch) {
        super(Aspect.getAspectForAll(TransformationComponent.class, DisplayComponent.class));
        this.modelBatch = modelBatch;
    }

    @Override
    protected void processEntities(final ImmutableBag<Entity> entities) {
        Entity e;
        TransformationComponent tC;
        DisplayComponent dC;
        for (int i = 0; i < entities.size(); ++i) {
            e = entities.get(i);
            dC = displayCmp.get(e);
            if (!dC.isVisible) break;
            tC = transformationCmp.get(e);
            dC.program.setUniformMatrix(u_ModelView, tC.combinedTransformation);
            modelBatch.render(dC.model, lights);
        }
    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }
}
