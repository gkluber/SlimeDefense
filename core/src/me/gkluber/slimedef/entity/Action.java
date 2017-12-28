package me.gkluber.slimedef.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/27/2017.
 */

public enum Action {
    MOVE_UP(0),
    MOVE_LEFT(1),
    MOVE_DOWN(2),
    MOVE_RIGHT(3),
    PAUSE(4),
    FIRE(5),
    RELOAD(6);

    private int id;
    public static final Vector2 UP = new Vector2(0,-1);
    public static final Vector2 LEFT = new Vector2(-1,0);
    public static final Vector2 DOWN = new Vector2(0,1);
    public static final Vector2 RIGHT = new Vector2(1,0);

    private Action(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public boolean isMove()
    {
        return id < 4;
    }

    public Vector2 toVector()
    {
        if(!isMove())
            return new Vector2(0,0);
        switch(id)
        {
            case 0:
                return Action.UP;
            case 1:
                return Action.LEFT;
            case 2:
                return Action.DOWN;
            case 3:
                return Action.RIGHT;
        }
        return null;
    }

    public static Action getAction(int id)
    {
        return Action.values()[id];
    }

}
