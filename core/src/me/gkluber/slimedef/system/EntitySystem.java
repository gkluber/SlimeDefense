package me.gkluber.slimedef.system;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
        entityCap = 30;
        entities = new Entity[entityCap];
    }

    public EntitySystem(int entityCap)
    {
        this.entityCap = entityCap;
        entities = new Entity[entityCap];
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
