package me.gkluber.slimedef.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/**
 * Created by gklub on 12/27/2017.
 */

public class EventHandler {

    private List<EListener> listeners;

    public EventHandler()
    {
        Gdx.input.setInputProcessor(new GestureDetector(new GestureListener(this)));
        listeners = new ArrayList<EListener>(30);
    }

    public EventHandler(int size)
    {
        listeners = new ArrayList<EListener>(size);
    }

    public void registerListener(EListener l)
    {
        listeners.add(l);
    }

    //TODO: make this more efficient
    public void fire(Event e)
    {
        for(int i=0; i<listeners.size(); i++)
        {
            if(e instanceof KeyPressEvent)
                listeners.get(i).onKeyPress((KeyPressEvent) e);
            else if(e instanceof KeyReleaseEvent)
                listeners.get(i).onKeyRelease((KeyReleaseEvent) e);
            else if(e instanceof InteractEvent)
                listeners.get(i).onInteract((InteractEvent) e);
        }
        /*Map<Object[], Integer> calls = new HashMap<Object[], Integer>(30);

        for(int i=0; i<listeners.size(); i++)
        {
            EListener l = listeners.get(i);
            Object[] objs = getMethod(e, l);

            if(objs==null)
                continue;

            Method m = (Method) objs[0];
            int priority = ((EventPriority) objs[1]).getPriority();

            //key index 0 = EListener Object, key index 1 = Method object
            System.out.println("putting "+l.getClass().getName()+", "+m.getName());
            calls.put(new Object[]{l,m}, priority);
        }

        Map.Entry<Object[], Integer>[] ens = calls.entrySet().toArray(new Map.Entry[calls.size()]);

        sort(ens, 0, ens.length - 1);

        System.out.println("sorted size "+ens.length);

        //iterates from highest (numerically smallest) priority to lowest priority
        for(Map.Entry<Object[], Integer> en : ens)
        {
            Object[] objs = en.getKey();
            EListener l = (EListener) objs[0];
            Method m = (Method) objs[1];

            //tries to call the listener for the event
            try
            {
                System.out.println("invoking "+l.getClass().getName());
                m.invoke(l, e);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }*/
    }

    //@returns Method Object at index 0, int priority at index 1
    private Object[] getMethod(Event e, EListener l)
    {
        Class<? extends EListener> c = l.getClass();

        for(Method m : c.getMethods())
        {
            System.out.println("found "+m.getName());

            Listening annotation = m.getAnnotation(Listening.class);
            if(annotation==null) {
                System.out.println("Annotation not found");
                for(Annotation a : m.getAnnotations())
                {
                    System.out.println("did find "+ a.getClass().getName());
                }
                continue;
            }
            Class<?>[] types = m.getParameterTypes();
            if(types.length!=1 || !(types[0].getClass().isAssignableFrom(Event.class)))
                throw new InvalidParameterException(m.getName() + " was declared with @Listening incorrectly");


            //assumes event class names are unique
            if(!(types[0].getName().equals(e.getClass().getName()))) {
                System.out.println(""+l.getClass().getName()+" uses different event");
                continue;
            }

            //each class should only have one method for each event
            return new Object[]{
                    m,
                    annotation.priority()
            };
        }
        return null;
    }


    /*
    Adapted from https://www.geeksforgeeks.org/quick-sort/
     */
    private void sort(Map.Entry<?, Integer>[] ens, int low, int high)
    {
        if(low < high)
        {
            int q = partition(ens, low, high);

            sort(ens, low, q - 1);
            sort(ens, low, q + 1);
        }
    }

    private int partition(Map.Entry<?, Integer>[] ens, int low, int high)
    {
        Map.Entry<?, Integer> pivot = ens[high];
        int i = low - 1;

        for(int j=low; j<= high - 1; j++)
        {
            Map.Entry<?, Integer> en = ens[j];
            if(en.getValue() <= pivot.getValue())
            {
                i++;
                Map.Entry<?, Integer> temp = ens[i];
                ens[i] = ens[j];
                ens[j] = temp;
            }
        }
        Map.Entry<?, Integer> temp = ens[i + 1];
        ens[i + 1] = ens[high];
        ens[high] = temp;

        return i + 1;
    }
}
