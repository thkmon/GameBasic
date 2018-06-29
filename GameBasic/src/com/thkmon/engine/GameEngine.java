package com.thkmon.engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.constant.MapConst;
import com.thkmon.util.LogUtil;
import com.thkmon.util.MapUtil;

import data.MapInfo;
import data.Tile;

public class GameEngine extends Thread {

	public void printMap(Graphics g) {
		
		if (g == null) {
			g = BasicConst.basicPanel.getGraphics();
		}
		
		try {
			for (int x=0; x<800; x++) {
				for (int y=0; y<600; y++) {
					BasicConst.surface1.setRGB(x, y, ColorConst.BLUE_RGB);
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
			
			printMap(BasicConst.surface1, MapConst.testMap, BasicConst.mapAxisX, BasicConst.mapAxisY, BasicConst.mapLeftMargin, BasicConst.mapTopMargin);
		
		} catch (Exception e) {
			LogUtil.debug(e);
		}
		
		
		try {
        	int formWidth = BasicConst.BasicForm.getWidth();
        	int formHeight = BasicConst.BasicForm.getHeight();
        	boolean widthIsShort = (formWidth * 6) < (formHeight * 8);
        	
        	if (widthIsShort) {
        		BasicConst.currentWidth = formWidth - 50;
        		BasicConst.currentHieght = (int) Math.round((double) BasicConst.currentWidth / 8 * 6);
	        	
        	} else {
        		BasicConst.currentHieght = formHeight - 50;
	        	BasicConst.currentWidth = (int) Math.round((double) BasicConst.currentHieght / 6 * 8);
        	}
        	
		} catch (Exception e1) {
			LogUtil.debug(e1);
		}
		
		
		try {
			// 화면이 가로 사이즈 중앙에 오도록 처리.
			int formWidth = BasicConst.BasicForm.getWidth() - 20;
			int margin = formWidth - BasicConst.currentWidth;
			int remain = margin % 2;
			int leftMargin = (margin - remain) / 2;
			if (leftMargin < 0) {
				leftMargin = 0;
			}
			
			g.fillRect(0, 0, 2000, 2000);
			g.setColor(ColorConst.BLACK);
			g.drawImage(BasicConst.surface1, leftMargin, 0, BasicConst.currentWidth, BasicConst.currentHieght, ColorConst.BLACK, null);
			g.dispose();
			
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