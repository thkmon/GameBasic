package com.thkmon.engine;

import java.awt.event.KeyEvent;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.KeyConst;
import com.thkmon.util.LogUtil;

public class KeyEngine {
	
//	@Override
//	public void run() {
//		
//		while (true) {
//			try {
//				if (KeyConst.onKeyDown) {
//					// UnitConst.playerY = UnitConst.playerY + 40;
//					BasicConst.mapTopMargin = BasicConst.mapTopMargin - 40; 
//					
//				} else if (KeyConst.onKeyUp) {
//					// UnitConst.playerY = UnitConst.playerY - 40;
//					BasicConst.mapTopMargin = BasicConst.mapTopMargin + 40;
//				}
//				
//				if (KeyConst.onKeyRight) {
//					// UnitConst.playerX = UnitConst.playerX + 40;
//					BasicConst.mapLeftMargin = BasicConst.mapLeftMargin - 40;
//					
//				} else if (KeyConst.onKeyLeft) {
//					// UnitConst.playerX = UnitConst.playerX - 40;
//					BasicConst.mapLeftMargin = BasicConst.mapLeftMargin + 40;
//				}
//				
//				Thread.sleep(10);
//			
//			} catch (Exception e) {
//				LogUtil.debug(e);
//			}
//		}
//	}
//	
	public void onKeyPressed(KeyEvent e) {
		
		if (KeyConst.readyToKeyInput == false) {
			return;
		}
		
		try {
			KeyConst.readyToKeyInput = false;
			
			int keyCode = e.getKeyCode();
			// LogUtil.debug("BasicForm keyPressed keyCode : " + keyCode);
			
			if (keyCode == KeyConst.UP || keyCode == KeyConst.W) {
				BasicConst.mapTopMargin = BasicConst.mapTopMargin + 40;
			}
			
			if (keyCode == KeyConst.DOWN || keyCode == KeyConst.S) {
				BasicConst.mapTopMargin = BasicConst.mapTopMargin - 40;
			}
			
			if (keyCode == KeyConst.LEFT || keyCode == KeyConst.A) {
				BasicConst.mapLeftMargin = BasicConst.mapLeftMargin + 40;
			}
			
			if (keyCode == KeyConst.RIGHT || keyCode == KeyConst.D) {
				BasicConst.mapLeftMargin = BasicConst.mapLeftMargin - 40;
			}
			
			if (keyCode == KeyConst.ENTER || keyCode == KeyConst.SPACE || keyCode == KeyConst.Z) {
	//			KeyConst.onKeyEnter = true;
			}
			
			if (keyCode == KeyConst.ESC || keyCode == KeyConst.X) {
	//			KeyConst.onKeyCancel = true;
			}
			
			BasicConst.gameEngine.printMap(null);
			
		} catch (Exception e1) {
			LogUtil.debug(e1);
		}
		
		KeyConst.readyToKeyInput = true;
	}
}
