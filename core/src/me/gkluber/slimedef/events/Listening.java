package me.gkluber.slimedef.events;

/**
 * Created by gklub on 12/27/2017.
 */

public @interface Listening {
    EventPriority priority() default EventPriority.NORMAL;
}
