package net.kibotu.dragnslay.android;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.SurfaceView;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import net.kibotu.dragnslay.general.Constants;
import net.kibotu.dragnslay.general.DragnSlayGame;
import net.kibotu.logger.Logger;
import net.kibotu.logger.android.GdxLogger;

public class DragnSlayMainActivity extends AndroidApplication {

    private static final String TAG = DragnSlayMainActivity.class.getSimpleName();

    public DragnSlayMainActivity () {
        super();
        Logger.v( TAG, "construct" );
    }

    @Override
    public void onCreate ( final Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // init logger
        Logger.init( new GdxLogger(), Constants.APP_TAG, Constants.LOGGING_LEVEL );
        Logger.v( TAG, "onCreate" );

        // app cfg
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = true;
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        cfg.r = 8;
        cfg.g = 8;
        cfg.b = 8;
        cfg.a = 8;
        initialize( new DragnSlayGame(), cfg );

        if ( graphics.getView() instanceof SurfaceView ) {
            final SurfaceView glView = ( SurfaceView ) graphics.getView();
            glView.getHolder().setFormat( PixelFormat.RGBA_8888 );
        }
    }

    @Override
    protected void onRestart () {
        super.onRestart();
        Logger.v( TAG, "onRestart" );
    }

    @Override
    protected void onStart () {
        super.onStart();
        Logger.v( TAG, "onStart" );
    }

    @Override
    protected void onPause () {
        super.onPause();
        Logger.v( TAG, "onPause" );
    }

    @Override
    protected void onResume () {
        super.onResume();
        Logger.v( TAG, "onResume" );
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Logger.v( TAG, "onDestroy" );
    }
}