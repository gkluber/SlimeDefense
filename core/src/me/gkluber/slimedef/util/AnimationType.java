package me.gkluber.slimedef.util;

/**
 * Created by gklub on 12/28/2017.
 */

public enum AnimationType {
    IDLE(0),
    MOVING(1),
    DAMAGED(2),
    SEEKING(3), //used when the tower targets a specific slime
    FIRING(4);

    private int id;

    private AnimationType(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
}