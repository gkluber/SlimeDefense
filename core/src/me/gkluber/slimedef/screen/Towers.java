package me.gkluber.slimedef.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by gklub on 1/25/2018.
 *
 * GUI that appears at the bottom of the screen
 */

public class Towers {
    private Stage stage;
    private Skin skin;
    private Window window;

    public Towers()
    {
        stage = new Stage(new ScreenViewport());
        skin = new Skin();

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        skin.add("default", new BitmapFont());

        //button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        window = new Window("Towers",skin);
        window.setPosition(0,0);
        window.setFillParent(true);

        final TextButton button = new TextButton("Click me!", skin);
        window.add(button);


        window.add(new Image(skin.newDrawable("white", Color.RED))).size(64);

        stage.addActor(window);
        button.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Clicked! Is checked: " + button.isChecked());
                button.setText("Good job!");
            }
        });
    }

    public void render(float delta)
    {
        stage.act(delta);
        stage.draw();
    }

    public void resize(int width, int height)
    {
        stage.getViewport().update(width, height, true);
    }

    public void dispose()
    {
        stage.dispose();
        skin.dispose();
    }
}
