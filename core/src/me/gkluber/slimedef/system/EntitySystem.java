package me.gkluber.slimedef.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import me.gkluber.slimedef.entity.Entity;
import me.gkluber.slimedef.util.Animation;

/**
 * Created by gklub on 12/27/2017.
 */

public class EntitySystem {
    private Map<Class<? extends Entity>, List<Animation>> animationLookup;

    public static boolean animating = false;

}
