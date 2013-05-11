package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;

/**
 * Background coordinates in Game World
 */

public class BackgroundPosition extends Component {

    public int x;
    public int y;

    public BackgroundPosition ( int x, int y ) {
        this.x = x;
        this.y = y;
    }
}
