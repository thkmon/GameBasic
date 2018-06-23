package data;

import com.thkmon.util.LogUtil;

public class MapInfo {

	private StringList mapContent = null;
	private String[][] mapArray = new String[1000][1000];
	private int maxColCount = 0;
	private int maxRowCount = 0;
	
	
	public String toString() {
		if (mapContent == null || mapContent.size() == 0) {
			return super.toString();
		}
		
		return mapContent.toString();
	}
	
	
	public String getTileName(int rowPosition, int colPosition) {
		if (rowPosition < 0 || rowPosition > 1000) {
			return "";
		}
		
		if (colPosition < 0 || colPosition > 1000) {
			return "";
		}
		
		return mapArray[rowPosition][colPosition];
	}
	
	
	public MapInfo(StringList mapContent) {
		this.mapContent = mapContent;
		
		if (mapContent == null || mapContent.size() == 0) {
			return;
		}
		
		String oneLine = null;
		int lineCount = mapContent.size();
		for (int row=0; row<lineCount; row++) {
			oneLine = mapContent.get(row);
			if (oneLine == null || oneLine.length() == 0) {
				continue;
			}
			
			oneLine = oneLine.trim();
			
			// 샵(#)으로 시작하면 주석으로 판단한다.
			if (oneLine.startsWith("#")) {
				continue;
			}
			
			// 슬래시(/)가 있어야만 한다.
			if (oneLine.indexOf("/") < 0) {
				continue;
			}
			
			String[] oneLineArray = oneLine.split("/");
			if (oneLineArray.length == 0) {
				continue;
			}
			
			int colCount = oneLineArray.length;
			for (int col=0; col<colCount; col++) {
				mapArray[col][row] = oneLineArray[col];
				LogUtil.debug("MapInfo constructor mapArray[" + col + "][" + row + "] == [" + mapArray[col][row] + "]");
			}
			
			
			// 행카운트 갱신
			this.maxRowCount++;
			
			// 열 카운트 갱신
			if (colCount > this.maxColCount) {
				this.maxColCount = colCount;
			}
			
			LogUtil.debug("MapInfo constructor : maxRowCount == [" + this.maxRowCount + "]");
			LogUtil.debug("MapInfo constructor : maxColCount == [" + this.maxColCount + "]");
		}
	}
}
