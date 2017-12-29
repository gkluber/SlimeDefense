package me.gkluber.slimedef.util;

import me.gkluber.slimedef.system.EntitySystem;

/**
 * Created by gklub on 12/28/2017.
 */

public class AnimationPlayer extends Thread{

    public AnimationPlayer()
    {
        super(new AnimationRunnable());
    }
}
class AnimationRunnable implements Runnable
{

    public AnimationRunnable()
    {

    }

    @Override
    public void run()
    {
        while(EntitySystem.animating)
        {

        }
    }
}