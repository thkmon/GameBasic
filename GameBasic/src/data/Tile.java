package data;

import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage tileImage = null;

	// »ý¼ºÀÚ
	public Tile(BufferedImage tileImage) {
		this.tileImage = tileImage;
	}
	
	public BufferedImage getTileImage() {
		return tileImage;
	}
}
