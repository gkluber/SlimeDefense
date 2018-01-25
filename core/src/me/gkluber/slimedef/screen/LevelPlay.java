package me.gkluber.slimedef.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import me.gkluber.slimedef.SlimeDef;
import me.gkluber.slimedef.events.EListener;
import me.gkluber.slimedef.events.FlingEvent;
import me.gkluber.slimedef.events.InteractEvent;
import me.gkluber.slimedef.events.KeyPressEvent;
import me.gkluber.slimedef.events.KeyReleaseEvent;
import me.gkluber.slimedef.events.LongPressEvent;
import me.gkluber.slimedef.events.MouseMoveEvent;
import me.gkluber.slimedef.events.PanEvent;
import me.gkluber.slimedef.events.ScrollEvent;
import me.gkluber.slimedef.events.TapEvent;
import me.gkluber.slimedef.level.Level;
import me.gkluber.slimedef.system.EntitySystem;
import me.gkluber.slimedef.system.ParticleSystem;

/**
 * Created by gklub on 12/27/2017.
 */

public class LevelPlay implements Screen, EListener {
    private SlimeDef main;

    private EntitySystem esys;
    private ParticleSystem psys;

    private Towers towers;

    private OrthogonalTiledMapRenderer renderer;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private Level lvl;

    private float time = 0f;
    private Vector3 cameraVelocity;

    private int squareX, squareY;

    public LevelPlay(SlimeDef main, String level) {
        this.main = main;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth()*2.5f, Gdx.graphics.getHeight()*2.5f);
        cameraVelocity = new Vector3();
        //towers = new Towers();

        lvl = new Level(level);
        renderer = new OrthogonalTiledMapRenderer(lvl.getTiledMap());
        shapeRenderer = new ShapeRenderer();
        squareX = squareY = -1;
    }

    //called on resource release--last method to be called
    @Override
    public void dispose() {
        lvl.dispose();
    }

    //called when the screen is no longer in use--after pause
    @Override
    public void hide() {
        dispose();
    }

    //called when screen is paused
    @Override
    public void pause() {

    }

    @Override
    public void render(float delta) {
        time+=delta;
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //towers.render(delta);

        //apply velocity to camera
        camera.position.add(delta*cameraVelocity.x, delta*cameraVelocity.y, delta*cameraVelocity.z);
        cameraVelocity.scl(0.95f);
        //if velocity norm is small, minimize drift
        if(cameraVelocity.dot(cameraVelocity)<100)
            cameraVelocity.set(0,0,0);

        camera.position.x = MathUtils.clamp(camera.position.x, camera.viewportWidth/2, lvl.getWidth() - camera.viewportWidth/2);
        camera.position.y =  MathUtils.clamp(camera.position.y, camera.viewportHeight/2, lvl.getHeight() -camera.viewportHeight/2);
        camera.update();

        SpriteBatch batch = main.getBatch();
        batch.setProjectionMatrix(camera.combined);

        //batch.begin();

        //batch.draw


        renderer.setView(camera);
        renderer.render();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(1f,1f,1f,0.5f));

        if(squareX!=-1&&squareY!=-1)
            shapeRenderer.rect(squareX*lvl.getTileWidth(), squareY*lvl.getTileHeight(), lvl.getTileWidth(), lvl.getTileHeight());
        shapeRenderer.end();

    }

    //counterpart of pause
    @Override
    public void resume() {

    }

    @Override
    public void resize(int w, int h) {

    }

    //first method to be called
    @Override
    public void show()
    {

    }

    //Events

    @Override
    public void onKeyPress(KeyPressEvent e)
    {

    }

    @Override
    public void onKeyRelease(KeyReleaseEvent e)
    {

    }

    @Override
    public void onInteract(InteractEvent e)
    {

    }

    @Override
    public void onFling(FlingEvent e)
    {
        cameraVelocity.set(-e.getVelocity().x, e.getVelocity().y, 0);
    }

    @Override
    public void onLongPress(LongPressEvent e)
    {

    }

    @Override
    public void onPan(PanEvent e)
    {
        e.getDelta().set(-1*e.getDelta().x, e.getDelta().y);
        camera.translate(e.getDelta());
    }

    @Override
    public void onTap(TapEvent e)
    {
        double mapPosX = this.camera.position.x+2.5f*e.getX()-camera.viewportWidth/2;
        double mapPosY = this.camera.position.y-2.5f*e.getY()+camera.viewportHeight/2;
        int cellPosX =  (int) mapPosX/lvl.getTileWidth();
        int cellPosY = (int) mapPosY/lvl.getTileHeight();
        System.out.println("screen: "+e.getX()+" "+e.getY());
        System.out.println("map: "+mapPosX+" "+mapPosY);
        System.out.println("cell: "+cellPosX+ " "+cellPosY);

        squareX = cellPosX;
        squareY = cellPosY;

    }

    @Override
    public void onScroll(ScrollEvent e)
    {
        camera.translate(0, e.getAmount());
    }

    @Override
    public void onMouseMove(MouseMoveEvent e)
    {

    }
}
