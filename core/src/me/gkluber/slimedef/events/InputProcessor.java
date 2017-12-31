package me.gkluber.slimedef.events;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/30/2017.
 */

public class InputProcessor extends GestureDetector {
    private GestureListener listen;
    private EventHandler parent;

    public InputProcessor(EventHandler parent, GestureListener listen)
    {
        super(listen);
        this.parent = parent;
        this.listen = listen;
    }

    public InputProcessor(EventHandler parent, float halfTapSquareSize, float tapCountInterval, float longPressDuration, float maxFlingDelay, GestureListener listen)
    {
        super(halfTapSquareSize, tapCountInterval, longPressDuration, maxFlingDelay, listen);
        this.parent = parent;
        this.listen = listen;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        parent.fire(new KeyPressEvent(keycode));
        return true;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        parent.fire(new KeyReleaseEvent(keycode));
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        parent.fire(new MouseMoveEvent(new Vector2(screenX, screenY)));
        return true;
    }

    //never called on mobile
    @Override
    public boolean scrolled(int amount)
    {
        parent.fire(new ScrollEvent(amount));
        return true;
    }

}
