package net.kibotu.dragnslay.general.screens.helper;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LoadingBar extends Actor {

    Animation animation;
    TextureRegion reg;
    float stateTime;

    public LoadingBar ( Animation animation ) {
        this.animation = animation;
        reg = animation.getKeyFrame( 0 );
    }

    @Override
    public void act ( float delta ) {
        stateTime += delta;
        reg = animation.getKeyFrame( stateTime );
    }

    @Override
    public void draw ( SpriteBatch batch, float parentAlpha ) {
        batch.draw( reg, getX(), getY() );
    }
}