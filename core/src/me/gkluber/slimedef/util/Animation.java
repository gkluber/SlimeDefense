package me.gkluber.slimedef.util;

/**
 * Created by gklub on 12/28/2017.
 *
 * Stores information about the current state of the animation
 */
public class Animation
{
    private AnimationType type;
    private int frame;
    private int cycleLength;

    public Animation(AnimationType type, int cycleLength)
    {
        this.type = type;
        this.cycleLength = cycleLength;
        frame = cycleLength;
    }

    public void tick()
    {
        ++frame;
    }

    //checked after ticking
    public boolean isDone()
    {
        return frame == cycleLength;
    }

    public void reset()
    {
        frame = 0;
    }

    public AnimationType getType()
    {
        return type;
    }

    public int getFrame()
    {
        return frame;
    }

    public int getCycleLength()
    {
        return cycleLength;
    }
}
