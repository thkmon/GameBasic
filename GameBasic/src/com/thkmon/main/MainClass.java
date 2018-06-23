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
			
			// �ϴ� ��ü ������� ����ٰ�, ���ϴ� ������� �����Ѵ�. �ʱ� ��ũ�� �ٱ��� �̹��� �׷����� �ʴ� ���� ����.
			BasicConst.BasicForm.setBounds(0, 0, BasicConst.FORM_WIDTH, BasicConst.FORM_HEIGHT);
			BasicConst.BasicForm.setBackground(ColorConst.BLACK);
			BasicConst.BasicForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// �ϴ� ��ü ������� ����ٰ�, ���ϴ� ������� �����Ѵ�. �ʱ� ��ũ�� �ٱ��� �̹��� �׷����� �ʴ� ���� ����.
			BasicConst.BasicForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			// BasicConst.BasicForm.setUndecorated(true);

			BasicConst.BasicForm.setVisible(true);
			
			// �ϴ� ��ü ������� ����ٰ�, ���ϴ� ������� �����Ѵ�. �ʱ� ��ũ�� �ٱ��� �̹��� �׷����� �ʴ� ���� ����. 
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