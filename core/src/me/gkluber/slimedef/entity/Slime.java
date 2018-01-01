package me.gkluber.slimedef.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.gkluber.slimedef.level.Level;
import me.gkluber.slimedef.level.TileType;
import me.gkluber.slimedef.util.Animation;
import me.gkluber.slimedef.util.ColorUtil;

/**
 * Created by gklub on 12/27/2017.
 */

public class Slime extends Damageable {
    private Color color;
    private Action last;
    private Level lvl;
    private List<Action> possibilities;
    private Random rand;
    private static final Action[] possibleActions = new Action[]{
        Action.MOVE_UP, Action.MOVE_LEFT, Action.MOVE_DOWN, Action.MOVE_RIGHT, Action.PAUSE
    };

    public Slime(Level lvl, Vector2 pos, double health)
    {
        super(pos, health);
        //90% alpha
        color = ColorUtil.drawColor().sub(0,0,0,0.1f);
        last = null;
        this.lvl = lvl;
        possibilities = new ArrayList<Action>(5);
        rand = new Random();
    }

    public boolean damage(double hp)
    {
        health -= hp;
        return health > 0;
    }

    public void draw()
    {

    }

    public void move(Vector2 target)
    {

    }

    public void destroy()
    {

    }

    public void playAnimation(Animation an)
    {

    }

    public boolean act(Action a)
    {

        return false;
    }

    public void update()
    {
        possibilities.clear();
        if(last==null)
        {
            TiledMapTileLayer.Cell[] neighbors = lvl.getCellNeighbors((int)pos.x, (int)pos.y);
            for(Action a : possibleActions)
                if(a!=Action.PAUSE && neighbors[a.getId()] != null && neighbors[a.getId()].getTile().getId()!= TileType.UNWALKABLE.getId())
                    possibilities.add(a);
        }
        else
        {
            TiledMapTileLayer.Cell[] neighbors = lvl.getCellNeighbors((int)pos.x, (int)pos.y);
            Action anti = Action.getAntipodal(last);
            neighbors[anti.getId()] = null;
            for(Action a : possibleActions)
                if(a!=Action.PAUSE && neighbors[a.getId()] != null && neighbors[a.getId()].getTile().getId()!= TileType.UNWALKABLE.getId())
                    possibilities.add(a);
        }

        int rand = this.rand.nextInt(possibilities.size());
        act(possibilities.get(rand));
    }
}
