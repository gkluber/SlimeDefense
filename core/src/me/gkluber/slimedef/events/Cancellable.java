package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public interface Cancellable {
    public void setCanceled(boolean canceled);
    public boolean isCanceled();
}
