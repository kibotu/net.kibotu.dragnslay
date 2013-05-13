package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.artemis.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * POD for parent entity
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class AffiliationComponent extends Component {

    public Entity entity;

    public AffiliationComponent ( @NotNull final Entity entity ) {
        this.entity = entity;
    }
}
