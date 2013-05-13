package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;
import com.artemis.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * POD for spawning
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpawningComponent extends Component {

    public int spawnAmount;
    public int maxSpawnAmount;
    public int currentSpawns;
    public int interval;
    public long startTime;
    public long delta;
    public Array<Entity> spawns;

    /**
     * @param spawnAmount amount units that will be spawn
     * @param interval    in milliseconds
     */
    public SpawningComponent ( final int spawnAmount, final int maxSpawnAmount, final int interval ) {
        this.spawnAmount = spawnAmount;
        this.maxSpawnAmount = maxSpawnAmount;
        this.interval = interval;
        currentSpawns = 0;
        startTime = System.currentTimeMillis();
        delta = 0;
        spawns = new Array<>( maxSpawnAmount );
    }
}
