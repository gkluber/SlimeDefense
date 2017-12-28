package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public class KeyPressEvent {

    private int id;

    public KeyPressEvent(int keyId)
    {
        id = keyId;
    }

    public int getKeyId()
    {
        return id;
    }
}
