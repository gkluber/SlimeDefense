package me.gkluber.slimedef.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import net.dermetfan.gdx.physics.box2d.PositionController;

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
    private MapProperties props;
    private TiledMapTileLayer mainLayer;

    private int widthTiles, heightTiles, tileWidth, tileHeight, width, height;

    public Level(String str)
    {
        map = new TmxMapLoader().load(str);
        props = map.getProperties();

        //dimensions in tile units
        widthTiles = props.get("width", Integer.class);
        heightTiles = props.get("height", Integer.class);
        //dimensions of each tile
        tileWidth = props.get("tilewidth", Integer.class);
        tileHeight = props.get("tileheight", Integer.class);

        width = widthTiles * tileWidth;
        height = heightTiles * tileHeight;
        mainLayer = (TiledMapTileLayer) map.getLayers().get(0);
    }

    public Level(Path path)
    {
        this(path.toString());
    }

    public TiledMap getTiledMap()
    {
        return map;
    }

    public int getWidthTiles()
    {
        return widthTiles;
    }

    public int getHeightTiles()
    {
        return heightTiles;
    }

    public int getTileWidth()
    {
        return tileWidth;
    }

    public int getTileHeight()
    {
        return tileHeight;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void dispose()
    {
        map.dispose();
    }

    public TiledMapTileLayer.Cell getCell(int x, int y)
    {
        return this.mainLayer.getCell(x,y);
    }
}
