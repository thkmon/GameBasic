package data;

import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage tileImage = null;

	// ������
	public Tile(BufferedImage tileImage) {
		this.tileImage = tileImage;
	}
	
	public BufferedImage getTileImage() {
		return tileImage;
	}
}
