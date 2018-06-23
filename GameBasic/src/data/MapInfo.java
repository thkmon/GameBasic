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
			
			// ��(#)���� �����ϸ� �ּ����� �Ǵ��Ѵ�.
			if (oneLine.startsWith("#")) {
				continue;
			}
			
			// ������(/)�� �־�߸� �Ѵ�.
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
			
			
			// ��ī��Ʈ ����
			this.maxRowCount++;
			
			// �� ī��Ʈ ����
			if (colCount > this.maxColCount) {
				this.maxColCount = colCount;
			}
			
			LogUtil.debug("MapInfo constructor : maxRowCount == [" + this.maxRowCount + "]");
			LogUtil.debug("MapInfo constructor : maxColCount == [" + this.maxColCount + "]");
		}
	}
}
