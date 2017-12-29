package me.gkluber.slimedef.events;

import com.badlogic.gdx.Gdx;

/**
 * Created by gklub on 12/27/2017.
 */

public class KeyPressEvent implements Event{

    private int id;

    public KeyPressEvent(int keyId)
    {
        id = keyId;
    }

    public int getKeyId()
    {
        return id;
    }

    public String getEventName()
    {
        return "Key Press Event";
    }

    public int getId()
    {
        return 1;
    }
}
