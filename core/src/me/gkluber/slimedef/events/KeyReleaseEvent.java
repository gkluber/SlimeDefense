package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public class KeyReleaseEvent {

    private int id;

    public KeyReleaseEvent(int keyId)
    {
        id = keyId;
    }

    public int getKeyId()
    {
        return id;
    }
}
