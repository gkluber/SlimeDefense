package me.gkluber.slimedef.events;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by gklub on 12/30/2017.
 */

public class ScrollEvent implements Event {
    private int amount;

    public ScrollEvent(int amount)
    {
        this.amount = amount;
    }

    public int getId()
    {
        return 8;
    }

    public int getAmount()
    {
        return amount;
    }

    public String getEventName()
    {
        return "Scroll Event";
    }
}
