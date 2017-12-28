package me.gkluber.slimedef.level;

/**
 * Created by gklub on 12/27/2017.
 */

public enum TileType {
    UNWALKABLE(0),
    WALKABLE(1),
    BUILDABLE(2);

    private int id;

    private TileType(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
}
