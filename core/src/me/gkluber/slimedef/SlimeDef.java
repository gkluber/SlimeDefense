package me.gkluber.slimedef;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.*;

import me.gkluber.slimedef.events.*;
import me.gkluber.slimedef.screen.*;

public class SlimeDef extends Game implements EListener {
	private OrthographicCamera camera;
	private Texture img;
	private Sprite sprite;
	private SpriteBatch batch;

	private Main mainMenu;
	private Settings settingsMenu;
	private LevelSelect selectMenu;
	private LevelPlay playScreen;
	private LevelSummary endScreen;

	private EventHandler eventHandler;

	private Vector2 interactPos;


	
	@Override
	public void create () {
		switch(Gdx.app.getType())
		{
			case Android:

				break;
			case Desktop:

				break;
			case WebGL:

				break;
		}

		interactPos = new Vector2();
		eventHandler = new EventHandler();
		eventHandler.registerListener(this);

		float w = Gdx.graphics.getWidth(), h = Gdx.graphics.getHeight();
		//camera = new OrthographicCamera(1, h/w);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		camera.update();

		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("badlogic.jpg"));
		img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		TextureRegion region = new TextureRegion(img, 0, 0, 256, 256);

		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f*sprite.getHeight()/sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);

		this.setScreen(new LevelPlay(this, "sewers.tmx"));
	}

	//main loop
	@Override
	public void render () {
		super.render();
		/*Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		sprite.draw(batch);*/

		switch(Gdx.app.getType())
		{
			case Android:
				//gets where the user touched
				if(Gdx.input.justTouched())
				{
					System.out.println("touched");
					interactPos.set(Gdx.input.getX(),Gdx.input.getY());
					eventHandler.fire(new InteractEvent(interactPos));
				}

				break;
			case Desktop:
				if(Gdx.input.justTouched())
				{
					System.out.println("clicked");
					interactPos.set(Gdx.input.getX(),Gdx.input.getY());
					eventHandler.fire(new InteractEvent(interactPos));
				}
				break;
			case WebGL:
				if(Gdx.input.justTouched())
				{
					System.out.println("clicked");
					interactPos.set(Gdx.input.getX(),Gdx.input.getY());
					eventHandler.fire(new InteractEvent(interactPos));
				}
				break;
		}


		//batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	//Listener functions
	public void onKeyPress(KeyPressEvent e)
	{

	}

	public void onKeyRelease(KeyReleaseEvent e)
	{

	}

	public void onInteract(InteractEvent e)
	{
		System.out.println("Interacted! x: "+e.getX()+" "+e.getY());
	}
}
