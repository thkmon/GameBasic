package com.thkmon.engine;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.thkmon.constant.BasicConst;
import com.thkmon.util.LogUtil;

public class BasicPanel extends JPanel {
	
	public void paint(Graphics g) {
		LogUtil.debug("BasicPanel paint");
		super.paint(g);
		
		BasicConst.gameEngine.printMap(g);
	}
}
