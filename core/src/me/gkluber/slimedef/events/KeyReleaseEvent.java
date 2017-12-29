package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public class KeyReleaseEvent implements Event{

    private int id;

    public KeyReleaseEvent(int keyId)
    {
        id = keyId;
    }

    public int getKeyId()
    {
        return id;
    }

    public String getEventName()
    {
        return "Key Release Event";
    }

    public int getId()
    {
        return 2;
    }
}
