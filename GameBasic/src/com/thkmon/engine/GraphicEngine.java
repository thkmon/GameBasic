package com.thkmon.engine;

import java.awt.Graphics2D;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.util.LogUtil;

public class GraphicEngine extends Thread {

//	@Override
//	public void run() {
//
//		try {
//			Graphics2D g2d = (Graphics2D) BasicConst.basicPanel.getGraphics();
//			
//			while (true) {
//				// LogUtil.debug("GraphicEngine draw");
//				
//				BasicConst.animaTime++;
//				if (BasicConst.animaTime == 60) {
//					BasicConst.animaTime = 0;
//				}
//				
//				// 화면이 가로 사이즈 중앙에 오도록 처리.
//				int formWidth = BasicConst.BasicForm.getWidth() - 20;
//				int margin = formWidth - BasicConst.currentWidth;
//				int remain = margin % 2;
//				int leftMargin = (margin - remain) / 2;
//				if (leftMargin < 0) {
//					leftMargin = 0;
//				}
////				
//				if (BasicConst.frontSurfaceIs1) {
//					g2d.drawImage(BasicConst.surface1, leftMargin, 0, BasicConst.currentWidth, BasicConst.currentHieght, ColorConst.BLACK, null);
//				} else {
//					g2d.drawImage(BasicConst.surface2, leftMargin, 0, BasicConst.currentWidth, BasicConst.currentHieght, ColorConst.BLACK, null);
//				}
//				
//				// draw 60 times per 1 second.
//				Thread.sleep(16);
//			}
//			
//		} catch (Exception e) {
//			LogUtil.debug(e);
//		}
//	}
}
