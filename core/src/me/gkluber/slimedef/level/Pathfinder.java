package me.gkluber.slimedef.level;

import com.badlogic.gdx.math.Vector2;

import java.nio.file.*;
import java.util.*;
import java.io.*;

import me.gkluber.slimedef.entity.Action;

/**
 * Created by gklub on 12/27/2017.
 */

public class Pathfinder {
    private byte[][] paths;

    public Pathfinder(String str)
    {
        parse(str);
    }

    public Pathfinder(Path path)
    {

    }

    private void parse(String str)
    {

    }

    private void parse(byte[] bytes)
    {

    }

    public Action getAction(int x, int y)
    {
        return Action.getAction(paths[x][y]);
    }

    public Vector2 getActionVector(int x, int y)
    {
        return getAction(x,y).toVector();
    }

}
