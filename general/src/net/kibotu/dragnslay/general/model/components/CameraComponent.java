package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import org.jetbrains.annotations.NotNull;

/**
 * POD for camera
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class CameraComponent extends Component {

    public PerspectiveCamera camera;
    public ShaderProgram program;
    public Color bgColor;

    public CameraComponent ( @NotNull final PerspectiveCamera camera, @NotNull final ShaderProgram program, @NotNull final Color bgColor ) {
        this.camera = camera;
        this.program = program;
        this.bgColor = bgColor;
    }
}
