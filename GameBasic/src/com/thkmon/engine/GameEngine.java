package com.thkmon.engine;

import java.awt.image.BufferedImage;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.constant.MapConst;
import com.thkmon.constant.UnitConst;
import com.thkmon.util.LogUtil;
import com.thkmon.util.MapUtil;

import data.MapInfo;
import data.Tile;

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
					
					if (BasicConst.mapLeftMargin >= 40) {
						int ramain = BasicConst.mapLeftMargin % 40;
						int tileCount = (BasicConst.mapLeftMargin - ramain) / 40;
						
						BasicConst.mapAxisX = BasicConst.mapAxisX - tileCount;
						BasicConst.mapLeftMargin = ramain;
						
					} else if (BasicConst.mapLeftMargin <= -40) {
						int ramain = (BasicConst.mapLeftMargin * -1) % 40;
						int tileCount = ((BasicConst.mapLeftMargin * -1) - ramain) / 40;
						
						BasicConst.mapAxisX = BasicConst.mapAxisX + tileCount;
						BasicConst.mapLeftMargin = -ramain;
					}
					
					if (BasicConst.mapTopMargin >= 40) {
						int ramain = BasicConst.mapTopMargin % 40;
						int tileCount = (BasicConst.mapTopMargin - ramain) / 40;
						
						BasicConst.mapAxisY = BasicConst.mapAxisY - tileCount;
						BasicConst.mapTopMargin = ramain;
					
					} else if (BasicConst.mapTopMargin <= -40) {
						int ramain = (BasicConst.mapTopMargin * -1) % 40;
						int tileCount = ((BasicConst.mapTopMargin * -1) - ramain) / 40;
						
						BasicConst.mapAxisY = BasicConst.mapAxisY + tileCount;
						BasicConst.mapTopMargin = -ramain;
					}
					
					printMap(backSurface, MapConst.testMap, BasicConst.mapAxisX, BasicConst.mapAxisY, BasicConst.mapLeftMargin, BasicConst.mapTopMargin);
					
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
	 * @param screenLeftMargin
	 * @param screenTopMargin
	 */
	private void printMap(BufferedImage backSurface, MapInfo mapInfo, int axisX, int axisY, int screenLeftMargin, int screenTopMargin) {
		
		int beginCol = 0;
		int endCol = 19;
		
		int beginRow = 0;
		int endRow = 14;
		
		if (screenLeftMargin > 0) {
			beginCol = beginCol - 1;
			
		} else if (screenLeftMargin < 0) {
			endCol = endCol + 1;
		}
		
		if (screenTopMargin > 0) {
			beginRow = beginRow - 1;
			
		} else if (screenTopMargin < 0) {
			endRow = endRow + 1;
		}
		
		for (int col=beginCol; col<=endCol; col++) {
			for (int row=beginRow; row<=endRow; row++) {
				int positionX = axisX + col;
				int positionY = axisY + row;
				
				String oneTileName = mapInfo.getTileName(positionX, positionY);
				printTile(backSurface, oneTileName, col, row, screenLeftMargin, screenTopMargin);
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
	 * @param screenLeftMargin
	 * @param screenTopMargin
	 * @return
	 */
	private boolean printTile(BufferedImage backSurface, String tileName, int positionX, int positionY, int screenLeftMargin, int screenTopMargin) {
		return printTile(backSurface, MapUtil.getTile(tileName), positionX, positionY, screenLeftMargin, screenTopMargin);
	}
	
	
	/**
	 * 타일 1개를 출력한다. (from 타일 객체)
	 * 
	 * @param backSurface
	 * @param tile
	 * @param positionX
	 * @param positionY
	 * @param screenLeftMargin
	 * @param screenTopMargin
	 * @return
	 */
	private boolean printTile(BufferedImage backSurface, Tile tile, int positionX, int positionY, int screenLeftMargin, int screenTopMargin) {
		
		if (tile == null) {
//			LogUtil.debug("[" + positionX + "][" + positionY + "] is null");
			tile = MapConst.xTile;
		}
		
		if (screenLeftMargin == 0) {
			// positionX == 0 ~ 19
			if (positionX < 0) {
				positionX = 0;
			}
			
			if (positionX > 19) {
				positionX = 19;
			}
		}
		
		if (screenTopMargin == 0) {
			// positionY == 0 ~ 14
			if (positionY < 0) {
				positionY = 0;
			}
			
			if (positionY > 14) {
				positionY = 14;
			}
		}
		
		int targetX = positionX * 40;
		int targetY = positionY * 40;
		
		BufferedImage tileImg = tile.getTileImage();
		for (int x=0; x<40; x++) {
			for (int y=0; y<40; y++) {
				int px = targetX + x + screenLeftMargin;
				int py = targetY + y + screenTopMargin;
				
				if (px < 0 || px >= 800) {
					continue;
				}
				
				if (py < 0 || py >= 600) {
					continue;
				}
				
				backSurface.setRGB(px, py, tileImg.getRGB(x, y));
			}
		}
		
		return true;
	}
}