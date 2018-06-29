package com.thkmon.constant;

import java.awt.image.BufferedImage;

import com.thkmon.engine.BasicForm;
import com.thkmon.engine.BasicPanel;
import com.thkmon.engine.GameEngine;
import com.thkmon.engine.KeyEngine;
import com.thkmon.util.ImgUtil;

public class BasicConst {
	
	public static BasicForm BasicForm = null;
	public static BasicPanel basicPanel = null;
	public static BufferedImage surface1 = ImgUtil.loadImage("data/img/800x600.png");
	
	public static int currentWidth = 0;
	public static int currentHieght = 0;
	
	public static final int FORM_WIDTH = 800;
	public static final int FORM_HEIGHT = 600;
	
	public static int mapLeftMargin = 0;
	public static int mapTopMargin = 0;
	
	public static int mapAxisX = 0;
	public static int mapAxisY = 0;
	
	public static GameEngine gameEngine = null;
	public static KeyEngine keyEngine = null;
}