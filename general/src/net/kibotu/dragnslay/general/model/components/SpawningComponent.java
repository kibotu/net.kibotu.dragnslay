package net.kibotu.dragnslay.general.model.components;

import com.artemis.Component;

/**
 * POD for spawning
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class SpawningComponent extends Component {

    public int spawns;
    public int maxSpawnAmount;
    public int currentSpawns;
    public int interval;
    public long startTime;
    public long delta;

    /**
     * @param spawns   amount units that will be spawn
     * @param interval in milliseconds
     */
    public SpawningComponent ( final int spawns, final int maxSpawnAmount, final int interval ) {
        this.spawns = spawns;
        this.maxSpawnAmount = maxSpawnAmount;
        this.interval = interval;
        startTime = System.currentTimeMillis();
        delta = 0;
    }
}
