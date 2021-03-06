package me.gkluber.slimedef.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

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

    /*
    Custom MapProperties:
    startingPosX
    startingPosY
    configFile (contains info about waves and rewards and etc.)
     */

    private TiledMap map;
    private MapProperties props;
    private TiledMapTileLayer mainLayer;

    private int widthTiles, heightTiles, tileWidth, tileHeight, width, height, startingPosX, startingPosY;

    private Vector2 startingPos;

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

        Integer objPosX = props.get("startingPosX", Integer.class);
        startingPosX = objPosX==null?0:objPosX;

        Integer objPosY = props.get("startingPosY", Integer.class);
        startingPosY = objPosY==null?0:objPosY;

        startingPos = new Vector2(startingPosX, startingPosY);

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

    public Vector2 getStartingPos(){ return startingPos; }

    public TiledMapTileLayer.Cell getCell(int x, int y)
    {
        return x < widthTiles && y < heightTiles ? this.mainLayer.getCell(x,y) : null;
    }

    /*public boolean isTileOccupied(int x, int y)
    {
        return this.mainLayer.getCell(x,y).getTile().getId()>1;
    }

    //code for when the tower occupies the tile
    public boolean occupyTile(int x, int y)
    {
        if(isTileOccupied(x,y))
            return false;
        //this.mainLayer.getCell(x,y).setTile();
        //this.mainLayer.set
        return true;
    }*/

    //may return null values
    //each index corresponds to Action enum id
    public TiledMapTileLayer.Cell[] getCellNeighbors(int x, int y)
    {
        return new TiledMapTileLayer.Cell[]{
                getCell(x, y + 1),
                getCell(x - 1, y ),
                getCell(x, y - 1),
                getCell(x + 1, y)
        };
    }
}
