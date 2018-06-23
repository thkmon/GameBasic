package com.thkmon.engine;

import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.thkmon.constant.BasicConst;
import com.thkmon.constant.KeyConst;
import com.thkmon.util.LogUtil;

public class BasicForm extends JFrame {
	
	private static Toolkit toolKit = Toolkit.getDefaultToolkit();
	
	public BasicForm() {
		
		
		// 리사이즈
		this.addComponentListener(new ComponentAdapter() {
	        public void componentResized(ComponentEvent e) {
	        	
	        	int formWidth = BasicConst.BasicForm.getWidth();
	        	int formHeight = BasicConst.BasicForm.getHeight();
	        	boolean widthIsShort = (formWidth * 6) < (formHeight * 8);
	        	
	        	if (widthIsShort) {
	        		BasicConst.currentWidth = formWidth - 50;
	        		BasicConst.currentHieght = (int) Math.round((double) BasicConst.currentWidth / 8 * 6);
		        	
	        	} else {
	        		BasicConst.currentHieght = formHeight - 50;
		        	BasicConst.currentWidth = (int) Math.round((double) BasicConst.currentHieght / 6 * 8);
	        	}
	        	
	        	
	        	LogUtil.debug("BasicForm componentResized : " + BasicConst.currentWidth + " x " + BasicConst.currentHieght);
	        }
	    });

		
		// 키입력
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
				// LogUtil.debug("BasicForm keyReleased keyCode : " + keyCode);
				
				if (keyCode == KeyConst.UP || keyCode == KeyConst.W) {
					KeyConst.onKeyUp = false;
				}
				
				if (keyCode == KeyConst.DOWN || keyCode == KeyConst.S) {
					KeyConst.onKeyDown = false;
				}
				
				if (keyCode == KeyConst.DOWN || keyCode == KeyConst.S) {
					KeyConst.onKeyDown = false;
				}
				
				if (keyCode == KeyConst.LEFT || keyCode == KeyConst.A) {
					KeyConst.onKeyLeft = false;
				}
				
				if (keyCode == KeyConst.RIGHT || keyCode == KeyConst.D) {
					KeyConst.onKeyRight = false;
				}
				
				if (keyCode == KeyConst.ENTER || keyCode == KeyConst.SPACE || keyCode == KeyConst.Z) {
					KeyConst.onKeyEnter = false;
				}
				
				if (keyCode == KeyConst.ESC || keyCode == KeyConst.X) {
					KeyConst.onKeyCancel = false;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();
				// LogUtil.debug("BasicForm keyPressed keyCode : " + keyCode);
				
				if (keyCode == KeyConst.UP || keyCode == KeyConst.W) {
					KeyConst.onKeyUp = true;
				}
				
				if (keyCode == KeyConst.DOWN || keyCode == KeyConst.S) {
					KeyConst.onKeyDown = true;
				}
				
				if (keyCode == KeyConst.DOWN || keyCode == KeyConst.S) {
					KeyConst.onKeyDown = true;
				}
				
				if (keyCode == KeyConst.LEFT || keyCode == KeyConst.A) {
					KeyConst.onKeyLeft = true;
				}
				
				if (keyCode == KeyConst.RIGHT || keyCode == KeyConst.D) {
					KeyConst.onKeyRight = true;
				}
				
				if (keyCode == KeyConst.ENTER || keyCode == KeyConst.SPACE || keyCode == KeyConst.Z) {
					KeyConst.onKeyEnter = true;
				}
				
				if (keyCode == KeyConst.ESC || keyCode == KeyConst.X) {
					KeyConst.onKeyCancel = true;
				}
			}
		});
	}
}