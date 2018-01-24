package me.gkluber.slimedef.system;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Map;
import java.util.Set;

import me.gkluber.slimedef.entity.Damageable;
import me.gkluber.slimedef.entity.Entity;
import me.gkluber.slimedef.util.Animation;

/**
 * Created by gklub on 12/27/2017.
 */

public class EntitySystem {
    private int entityCap;
    private Entity[] entities;
    private int emptyIndex = 0;

    public EntitySystem()
    {
        entityCap = 500;
        entities = new Entity[entityCap];
    }

    public EntitySystem(int entityCap)
    {
        this.entityCap = entityCap;
        entities = new Entity[entityCap];
    }

    public boolean registerEntity(Entity e)
    {
        if(isCapped()) //attempt to recycle old entities
        {
            return recycle(e);
        }
        return true; //todo
    }

    public boolean recycle(Entity e)
    {
        for(Entity en : entities)
        {
            if(e instanceof Damageable && en instanceof Damageable)
            {
                //respawn entity and move location
                Damageable target = (Damageable) en;
                Damageable subject = (Damageable) e;
                target.setHealth(subject.getHealth());
                target.setPosition(subject.getPosition());
            }
        }
        return true; //todo

    }

    private int nextIndex()
    {
        return emptyIndex++;
    }

    private boolean isCapped()
    {
        return emptyIndex>=entityCap;
    }

    public void drawEntities(ShapeRenderer renderer)
    {
        for(Entity e : entities)
            e.draw(renderer);
    }

    public void update(float delta)
    {

    }

    //returns the index of the newly created entity
    public int spawnSlime(Vector2 pos)
    {
        //entities[emptyIndex];
        return 0; // todo
    }

    public void deleteEntity(int id)
    {

    }

}
