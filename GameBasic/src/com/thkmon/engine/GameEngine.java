package com.thkmon.engine;

import java.awt.image.BufferedImage;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.constant.UnitConst;
import com.thkmon.util.ImgUtil;
import com.thkmon.util.LogUtil;

public class GameEngine extends Thread {

	@Override
	public void run() {
		
		BufferedImage blueScreenImg = ImgUtil.loadImage("data/img/blue_screen.png");
		BufferedImage basicCellImg = ImgUtil.loadImage("data/img/basic_cell.png");
		
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
				
				for (int x=0; x<40; x++) {
					for (int y=0; y<40; y++) {
						backSurface.setRGB(UnitConst.playerX + x, UnitConst.playerY + y, basicCellImg.getRGB(x, y));
					}
				}
				
				// 그래픽 처리
				BasicConst.frontSurfaceIs1 = !BasicConst.frontSurfaceIs1;
				Thread.sleep(1);
			
			} catch (Exception e) {
				LogUtil.debug(e);
			}
		}
	}
}
