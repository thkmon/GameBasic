package com.thkmon.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.engine.BasicForm;
import com.thkmon.engine.BasicPanel;
import com.thkmon.engine.GameEngine;
import com.thkmon.engine.GraphicEngine;
import com.thkmon.engine.KeyEngine;
import com.thkmon.util.LogUtil;

public class MainClass {

	public static void main(String[] args) {
		new MainClass().showForm();
	}
	
	public void showForm() {
		
		try {
			// Dimension desktop = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			// int desktopWidth = desktop.width;
			// int desktopHeight = desktop.height;

			BasicConst.BasicForm = new BasicForm();
			BasicConst.BasicForm.setLayout(new BorderLayout());
			
			BasicConst.basicPanel = new BasicPanel();
			BasicConst.BasicForm.add(BasicConst.basicPanel);
			// BasicConst.BasicForm.pack();
			
			// 일단 전체 사이즈로 띄웠다가, 원하는 사이즈로 변경한다. 초기 폼크기 바깥에 이미지 그려지지 않는 현상 때문.
			BasicConst.BasicForm.setBounds(0, 0, BasicConst.FORM_WIDTH, BasicConst.FORM_HEIGHT);
			BasicConst.BasicForm.setBackground(ColorConst.BLACK);
			BasicConst.BasicForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// 일단 전체 사이즈로 띄웠다가, 원하는 사이즈로 변경한다. 초기 폼크기 바깥에 이미지 그려지지 않는 현상 때문.
			BasicConst.BasicForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			// BasicConst.BasicForm.setUndecorated(true);

			BasicConst.BasicForm.setVisible(true);
			
			// 일단 전체 사이즈로 띄웠다가, 원하는 사이즈로 변경한다. 초기 폼크기 바깥에 이미지 그려지지 않는 현상 때문. 
			Thread.sleep(200);
			//BasicConst.BasicForm.setBounds(0, 0, BasicConst.FORM_WIDTH + 50, BasicConst.FORM_HEIGHT + 50);
			
			new GraphicEngine().start();
			new GameEngine().start();
			new KeyEngine().start();
			
		} catch (Exception e) {
			LogUtil.debug(e);
		}
	}
}