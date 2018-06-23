package com.thkmon.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImgUtil {
	
	public static BufferedImage loadImage(String filePath) {
		
		BufferedImage img = null;
		
		try {
			File imgFile = new File(filePath);
			if (!imgFile.exists()) {
				LogUtil.debug("ImgUtil readImage : imgFile not exists : " + imgFile.getAbsolutePath());
				return null;
			}
			
			img = ImageIO.read(imgFile);
		
		} catch (Exception e) {
			LogUtil.debug(e);
		}
		
		return img;
	}
	
	
//	public static BufferedImage resizeImage(BufferedImage image, int width, int height) {
//		int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
//		BufferedImage resizedImage = new BufferedImage(width, height, type);
//		Graphics2D g = resizedImage.createGraphics();
//		g.setComposite(AlphaComposite.Src);
//
//		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//		g.drawImage(image, 0, 0, width, height, null);
//		g.dispose();
//
//		return resizedImage;
//	}
}
