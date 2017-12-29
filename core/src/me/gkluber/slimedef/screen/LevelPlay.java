package me.gkluber.slimedef.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import me.gkluber.slimedef.SlimeDef;
import me.gkluber.slimedef.level.Level;
import me.gkluber.slimedef.system.EntitySystem;
import me.gkluber.slimedef.system.ParticleSystem;

/**
 * Created by gklub on 12/27/2017.
 */

public class LevelPlay implements Screen {

    private SlimeDef main;

    private EntitySystem esys;
    private ParticleSystem psys;

    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Level lvl;

    private float time = 0f;

    public LevelPlay(SlimeDef main, String level)
    {
        this.main = main;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        lvl = new Level(level);
        renderer = new OrthogonalTiledMapRenderer(lvl.getTiledMap());
    }

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
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        renderer.render();
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
