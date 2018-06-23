package com.thkmon.constant;

import java.awt.image.BufferedImage;

import com.thkmon.util.ImgUtil;
import com.thkmon.util.MapUtil;

import data.MapInfo;
import data.Tile;

public class MapConst {

	public static MapInfo testMap = null;
	
	public static BufferedImage blockTileImg = null;
	public static BufferedImage spaceTileImg = null;
	
	public static Tile xTile = null;
	
	public MapConst() {
		testMap = MapUtil.loadMap("data/map/test_map.txt");
		
		blockTileImg = ImgUtil.loadImage("data/img/block_tile.png");
		spaceTileImg = ImgUtil.loadImage("data/img/space_tile.png");
		
		xTile = new Tile(ImgUtil.loadImage("data/img/x_tile.png"));
	}
}