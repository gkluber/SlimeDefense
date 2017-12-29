package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public interface EListener {
    public void onKeyPress(KeyPressEvent e);
    public void onKeyRelease(KeyReleaseEvent e);
    public void onInteract(InteractEvent e);
    public void onFling(FlingEvent e);
    public void onLongPress(LongPressEvent e);
    public void onPan(PanEvent e);
    public void onTap(TapEvent e);
}
