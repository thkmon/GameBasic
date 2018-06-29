package com.thkmon.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.constant.MapConst;
import com.thkmon.engine.BasicForm;
import com.thkmon.engine.BasicPanel;
import com.thkmon.engine.GameEngine;
import com.thkmon.engine.KeyEngine;
import com.thkmon.util.LogUtil;

public class MainClass {

	public static void main(String[] args) {
		new MainClass().showForm();
	}
	
	public void showForm() {
		
		try {
			// load classes
			new MapConst();
			BasicConst.gameEngine = new GameEngine();
			BasicConst.keyEngine = new KeyEngine();
			
			// 일단 전체 사이즈로 띄웠다가, 원하는 사이즈로 변경한다. 초기 폼크기 바깥에 이미지 그려지지 않는 현상 때문.
			// Dimension desktop = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			// int desktopWidth = desktop.width;
			// int desktopHeight = desktop.height;

			BasicConst.BasicForm = new BasicForm();
			BasicConst.BasicForm.setLayout(new BorderLayout());
			
			BasicConst.BasicForm.setBounds(0, 0, BasicConst.FORM_WIDTH, BasicConst.FORM_HEIGHT);
			BasicConst.BasicForm.setBackground(ColorConst.BLACK);
			BasicConst.BasicForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			BasicConst.basicPanel = new BasicPanel();
			BasicConst.BasicForm.add(BasicConst.basicPanel);
			
			BasicConst.BasicForm.setVisible(true);
			
		} catch (Exception e) {
			LogUtil.debug(e);
		}
	}
}