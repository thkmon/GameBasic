package com.thkmon.constant;

import java.awt.image.BufferedImage;

import com.thkmon.engine.BasicForm;
import com.thkmon.engine.BasicPanel;
import com.thkmon.util.ImgUtil;

public class BasicConst {
	
	public static BasicForm BasicForm = null;
	public static BasicPanel basicPanel = null;
	public static BufferedImage surface1 = ImgUtil.loadImage("data/img/800x600.png");
	public static BufferedImage surface2 = ImgUtil.loadImage("data/img/800x600.png");
	public static boolean frontSurfaceIs1 = true;
	
	public static int currentWidth = 0;
	public static int currentHieght = 0;
	
	public static int animaTime = 0;
	
	public static final int FORM_WIDTH = 800;
	public static final int FORM_HEIGHT = 600;
}