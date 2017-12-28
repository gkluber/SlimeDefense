package me.gkluber.slimedef.screen;

import com.badlogic.gdx.Screen;

/**
 * Created by gklub on 12/27/2017.
 */

public class Main implements Screen {

    //called on resource release--last method to be called
    @Override
    public void dispose()
    {

    }

    //called when the screen is no longer in use--after pause
    @Override
    public void hide()
    {
        dispose();
    }

    //called when screen is paused
    @Override
    public void pause()
    {

    }

    @Override
    public void render(float delta)
    {

    }

    //counterpart of pause
    @Override
    public void resume()
    {

    }

    @Override
    public void resize(int w, int h)
    {

    }

    //first method to be called
    @Override
    public void show()
    {

    }
}
