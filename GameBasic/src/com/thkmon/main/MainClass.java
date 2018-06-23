package com.thkmon.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.ColorConst;
import com.thkmon.constant.MapConst;
import com.thkmon.engine.BasicForm;
import com.thkmon.engine.BasicPanel;
import com.thkmon.engine.GameEngine;
import com.thkmon.engine.GraphicEngine;
import com.thkmon.engine.KeyEngine;
import com.thkmon.util.LogUtil;
import com.thkmon.util.MapUtil;

public class MainClass {

	public static void main(String[] args) {
		new MainClass().showForm();
	}
	
	public void showForm() {
		
		try {
			// load classes
			MapConst mapConst = new MapConst();
			MapUtil mapUtil = new MapUtil();
			
			// �ϴ� ��ü ������� ����ٰ�, ���ϴ� ������� �����Ѵ�. �ʱ� ��ũ�� �ٱ��� �̹��� �׷����� �ʴ� ���� ����.
			// Dimension desktop = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			// int desktopWidth = desktop.width;
			// int desktopHeight = desktop.height;

			BasicConst.BasicForm = new BasicForm();
			BasicConst.BasicForm.setLayout(new BorderLayout());
			
			Thread.sleep(10);
			
			BasicConst.basicPanel = new BasicPanel();
			BasicConst.BasicForm.add(BasicConst.basicPanel);
			// BasicConst.BasicForm.pack();
			
			BasicConst.BasicForm.setBounds(0, 0, BasicConst.FORM_WIDTH, BasicConst.FORM_HEIGHT);
			BasicConst.BasicForm.setBackground(ColorConst.BLACK);
			BasicConst.BasicForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// �ִ�ȭ (�ϴ� �ִ�ȭ�ߴٰ� �ٽ� ũ�⺹��. �ʱ� ��ũ�� �ٱ��� �̹��� �׷����� �ʴ� ���� ����)
			BasicConst.BasicForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			// BasicConst.BasicForm.setUndecorated(true);

			BasicConst.BasicForm.setVisible(true);
			
			// ũ�⺹�� (�ϴ� �ִ�ȭ�ߴٰ� �ٽ� ũ�⺹��. �ʱ� ��ũ�� �ٱ��� �̹��� �׷����� �ʴ� ���� ����)
			new GraphicEngine().start();
			
			Thread.sleep(10);
			
			BasicConst.BasicForm.setExtendedState(JFrame.NORMAL);
			
			new GameEngine().start();
			new KeyEngine().start();
			
		} catch (Exception e) {
			LogUtil.debug(e);
		}
	}
}