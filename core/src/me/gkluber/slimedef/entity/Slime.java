package me.gkluber.slimedef.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.gkluber.slimedef.level.Level;
import me.gkluber.slimedef.level.TileType;
import me.gkluber.slimedef.util.Animation;
import me.gkluber.slimedef.util.AnimationType;
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
    private Animation moveAnimation;
    private Animation damageAnimation;
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
        moveAnimation = new Animation(AnimationType.MOVING, 60);
        damageAnimation = new Animation(AnimationType.DAMAGED, 20);
    }

    public boolean damage(double hp)
    {
        health -= hp;
        playAnimation(damageAnimation);
        return health > 0;
    }

    public void draw(ShapeRenderer renderer)
    {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        if(!moveAnimation.isDone())
        {
            pos.y += moveAnimation.getFrame()>30?-1:1;
            moveAnimation.tick();
        }
        if(damageAnimation.isDone())
        {
            color.add(Color.RED);
        }
        renderer.circle(pos.x, pos.y, (float)Math.sqrt(getHealth()));
        renderer.end();
    }


    public void move(Vector2 target)
    {

    }

    public void destroy()
    {

    }

    public void playAnimation(Animation an)
    {
        an.reset();
    }

    public boolean act(Action a)
    {
        if(a==Action.PAUSE)
            return true; //change nothing

        playAnimation(moveAnimation);

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
            TiledMapTileLayer.Cell[] neighbors = lvl.getCellNeighbors((int)pos.x/lvl.getTileWidth(), (int)pos.y/lvl.getTileHeight());
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
