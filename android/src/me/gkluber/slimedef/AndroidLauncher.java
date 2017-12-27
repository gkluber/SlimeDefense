package me.gkluber.slimedef;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.surfaceview.FixedResolutionStrategy;

import me.gkluber.slimedef.SlimeDef;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		//configuration options
		config.useAccelerometer = false;
		config.useCompass = false;
		config.useGyroscope = false;
		config.disableAudio = false;
		config.hideStatusBar = true;
		config.useImmersiveMode = true;
		config.useRotationVectorSensor = false;
		config.useWakelock = true;

		initialize(new SlimeDef(), config);
	}
}
