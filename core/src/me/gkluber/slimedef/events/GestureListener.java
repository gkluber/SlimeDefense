package me.gkluber.slimedef.events;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/29/2017.
 */

public class GestureListener implements GestureDetector.GestureListener {
    private EventHandler parent;

    public GestureListener(EventHandler parent)
    {
        this.parent = parent;
    }

    public boolean fling(float vx, float vy, int button)
    {
        parent.fire(new FlingEvent(new Vector2(vx,vy)));
        return true;
    }

    public boolean longPress(float x, float y)
    {
        parent.fire(new LongPressEvent(new Vector2(x,y)));
        return true;
    }

    public boolean pan(float x, float y, float dx, float dy)
    {
        //get whether pan is on the map or the UI

        //if pan is not on UI, then fire FlingEvent
        parent.fire(new PanEvent(new Vector2(x,y), new Vector2(dx,dy)));
        return true;
    }

    public boolean panStop(float x, float y, int pointer, int button)
    {
        //set camera velocity to 0?
        return true;
    }

    public boolean pinch(Vector2 initP1, Vector2 initP2, Vector2 p1, Vector2 p2)
    {
        //unused
        return false;
    }

    public void pinchStop()
    {
        //unused
    }

    public boolean tap(float x, float y, int count, int button)
    {
        parent.fire(new TapEvent(new Vector2(x,y)));
        return true;
    }

    public boolean touchDown(float x, float y, int pointer, int button)
    {
        //unused
        return false;
    }

    public boolean zoom(float initd, float d)
    {
        //unused
        return false;
    }
}
