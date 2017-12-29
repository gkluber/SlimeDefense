package me.gkluber.slimedef.entity;

import com.badlogic.gdx.math.Vector2;

import java.util.HashSet;
import java.util.Set;

import me.gkluber.slimedef.util.Animation;

/**
 * Created by gklub on 12/27/2017.
 */

public abstract class Entity {

    protected Vector2 pos;
    protected Set<Animation> animations;
    protected Thread animationPlayer;

    public Entity(Vector2 pos)
    {
        this.pos = pos;
        animations = new HashSet<Animation>();
        animationPlayer = new Thread(new Runnable() {
            @Override
            public void run() {
                //asynchronously update animations
            }
        });
    }

    public Vector2 getPosition()
    {
        return pos;
    }

    public abstract void playAnimation(Animation an);

    protected void startAnimation(Animation an)
    {
        animations.add(an);
    }

    protected void stopAnimation(Animation an)
    {
        animations.remove(an);
    }

    public Set<Animation> getAnimations()
    {
        return animations;
    }

    public abstract void draw();
    public abstract void move(Vector2 target);
    public abstract void destroy();
    public abstract boolean act(Action a); //returns false if cannot act
}
