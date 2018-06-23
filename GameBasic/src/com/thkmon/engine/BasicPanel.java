package com.thkmon.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.util.LogUtil;

public class BasicPanel extends JPanel {
	
	public void paint(Graphics g) {
		// LogUtil.debug("BasicPanel paint");
		
		int formWidth = BasicConst.BasicForm.getWidth();
		int formHeight = BasicConst.BasicForm.getHeight();
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 0, formWidth, formHeight);
		g2d.setColor(ColorConst.BLACK);
		g2d.dispose();
	}
}
