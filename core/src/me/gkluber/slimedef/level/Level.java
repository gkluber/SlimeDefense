package me.gkluber.slimedef.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.nio.file.Path;

/**
 * Created by gklub on 12/27/2017.
 */

public class Level {
    //TiledMap object
    //TiledMapTileSets must have ids that are disjoint
    //TiledMapTileSet holds tiles
    //StaticTiledMapTile for map underneath -> AnimatedTileMapTile for above?

    private TiledMap map;

    public Level(String str)
    {
        map = new TmxMapLoader().load(str);
    }

    public Level(Path path)
    {
        this(path.toString());
    }

    public TiledMap getTiledMap()
    {
        return map;
    }
}
