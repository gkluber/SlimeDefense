package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public enum EventPriority {
    HIGHEST(0),
    HIGH(1),
    NORMAL(2),
    LOW(3),
    LOWEST(4);

    private int priority;

    private EventPriority(int id)
    {
        this.priority = id;
    }

    public int getPriority()
    {
        return priority;
    }
}
