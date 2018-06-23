package com.thkmon.engine;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.KeyConst;
import com.thkmon.constant.UnitConst;
import com.thkmon.util.LogUtil;

public class KeyEngine extends Thread {
	
	@Override
	public void run() {
		
		while (true) {
			try {
				if (KeyConst.onKeyDown) {
					// UnitConst.playerY = UnitConst.playerY + 2;
					BasicConst.mapTopMargin = BasicConst.mapTopMargin - 2; 
					
				} else if (KeyConst.onKeyUp) {
					// UnitConst.playerY = UnitConst.playerY - 2;
					BasicConst.mapTopMargin = BasicConst.mapTopMargin + 2;
				}
				
				if (KeyConst.onKeyRight) {
					// UnitConst.playerX = UnitConst.playerX + 2;
					BasicConst.mapLeftMargin = BasicConst.mapLeftMargin - 2;
					
				} else if (KeyConst.onKeyLeft) {
					// UnitConst.playerX = UnitConst.playerX - 2;
					BasicConst.mapLeftMargin = BasicConst.mapLeftMargin + 2;
				}
				
				Thread.sleep(10);
			
			} catch (Exception e) {
				LogUtil.debug(e);
			}
		}
	}
}
