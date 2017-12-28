package me.gkluber.slimedef.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.gkluber.slimedef.SlimeDef;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 2560/4;
		config.width = 1440/4;
		config.useGL30 = true;
		config.title = "Slime Defense";

		new LwjglApplication(new SlimeDef(), config);
	}
}
