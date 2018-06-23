package com.thkmon.engine;

import java.awt.image.BufferedImage;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.constant.MapConst;
import com.thkmon.util.LogUtil;
import com.thkmon.util.MapUtil;

import data.MapInfo;
import data.Tile;
import data.TileBox;

public class GameEngine extends Thread {

	@Override
	public void run() {
		try {
			BufferedImage backSurface = null;
			
			while (true) {
				try {
					if (BasicConst.frontSurfaceIs1) {
						backSurface = BasicConst.surface2;
					} else {
						backSurface = BasicConst.surface1;
					}
					
					for (int x=0; x<800; x++) {
						for (int y=0; y<600; y++) {
							backSurface.setRGB(x, y, ColorConst.BLUE_RGB);
						}
					}
					
					printMap(backSurface, MapConst.testMap, 0, 0);
					
					// 그래픽 처리
					BasicConst.frontSurfaceIs1 = !BasicConst.frontSurfaceIs1;
					Thread.sleep(1);
				
				} catch (Exception e) {
					LogUtil.debug(e);
				}
			}
		
		} catch (Exception e) {
			LogUtil.debug(e);
		}
	}
	
	
	/**
	 * 맵을 1판으로 출력한다. axisX == 0, axisY == 0 일 경우 좌측 최상단을 출력한다.
	 * 
	 * @param backSurface
	 * @param mapInfo
	 * @param axisX
	 * @param axisY
	 */
	private void printMap(BufferedImage backSurface, MapInfo mapInfo, int axisX, int axisY) {
		
		for (int col=0; col<20; col++) {
			for (int row=0; row<15; row++) {
				int positionX = axisX + col;
				int positionY = axisY + row;
				
				String oneTileName = mapInfo.getTileName(positionX, positionY);
				printTile(backSurface, oneTileName, col, row);
			}
		}
	}
	
	
	/**
	 * 타일 1개를 출력한다. (from 이름)
	 * 
	 * @param backSurface
	 * @param tileName
	 * @param positionX
	 * @param positionY
	 * @return
	 */
	private boolean printTile(BufferedImage backSurface, String tileName, int positionX, int positionY) {
		return printTile(backSurface, MapUtil.getTile(tileName), positionX, positionY);
	}
	
	
	/**
	 * 타일 1개를 출력한다. (from 타일 객체)
	 * 
	 * @param backSurface
	 * @param tile
	 * @param positionX
	 * @param positionY
	 * @return
	 */
	private boolean printTile(BufferedImage backSurface, Tile tile, int positionX, int positionY) {
		
		if (tile == null) {
			LogUtil.debug("[" + positionX + "][" + positionY + "] is null");
			tile = MapConst.xTile;
		}
		
		// positionX == 0 ~ 19
		if (positionX < 0) {
			positionX = 0;
		}
		
		if (positionX > 19) {
			positionX = 19;
		}
		
		// positionY == 0 ~ 14
		if (positionY < 0) {
			positionY = 0;
		}
		
		if (positionY > 14) {
			positionY = 14;
		}
		
		int targetX = positionX * 40;
		int targetY = positionY * 40;
		
		BufferedImage tileImg = tile.getTileImage();
		for (int x=0; x<40; x++) {
			for (int y=0; y<40; y++) {
				backSurface.setRGB(targetX + x, targetY + y, tileImg.getRGB(x, y));
			}
		}
		
		return true;
	}
}