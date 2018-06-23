package com.thkmon.util;

import java.awt.image.BufferedImage;

import com.thkmon.constant.MapConst;

import data.MapInfo;
import data.StringList;
import data.Tile;
import data.TileBox;

public class MapUtil {
	
	public static TileBox makeBasicBox() {
		TileBox tileBox = new TileBox();
		
		addToTileBox(tileBox, MapConst.blockTileImg, "B");
		addToTileBox(tileBox, MapConst.spaceTileImg, "S");
		
		tileBox.put("X_TILE", MapConst.xTile);
		
		return tileBox;
	}
	
	
	private static void addToTileBox(TileBox tileBox, BufferedImage tileImg, String prefix) {
		int tileImgWidth = tileImg.getWidth();
		int remain = tileImgWidth % 40;
		int tileCount = (tileImgWidth - remain) / 40;
		
		for (int idx=0; idx<tileCount; idx++) {
			BufferedImage tileImage = ImgUtil.loadImage("data/img/40x40.png");
			for (int x=0; x<40; x++) {
				for (int y=0; y<40; y++) {
					int leftMargin = idx * 40;
					tileImage.setRGB(x, y, tileImg.getRGB(leftMargin + x, y));
				}
			}
			
			String tileName = prefix + idx;
			Tile tileObj = new Tile(tileImage);
			tileBox.put(tileName, tileObj);
		}
	}
	
	
	public static Tile getTile(String tileName) {
		Tile tileObj = MapConst.tileBox.get(tileName);
		if (tileObj == null) {
//			LogUtil.debug("MapUtil getTile : tile is null. tileName == [" + tileName + "]");
			return null;
		}
		
		return tileObj;
	}
	
	
	public static MapInfo loadMap(String mapFilePath) {
		StringList testMapContent = TextUtil.readTextFile(mapFilePath);
		MapInfo testMapInfo = new MapInfo(testMapContent);
		return testMapInfo;
	}
	
	
	public static boolean moveMapLeft() {
		
		
		
		return true;
	}
}