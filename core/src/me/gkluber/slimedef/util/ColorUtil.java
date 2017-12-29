package me.gkluber.slimedef.util;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

/**
 * Created by gklub on 12/28/2017.
 */

public class ColorUtil {
    private static Random r = new Random();

    public static Color drawColor()
    {
        switch(r.nextInt(11))
        {
            case 0:
                return Color.LIGHT_GRAY;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.BROWN;
            case 3:
                return Color.CYAN;
            case 4:
                return Color.FOREST;
            case 5:
                return Color.GOLD;
            case 6:
                return Color.RED;
            case 7:
                return Color.OLIVE;
            case 8:
                return Color.LIME;
            case 9:
                return Color.YELLOW;
            case 10:
                return Color.PINK;
        }
        return null;
    }
}
