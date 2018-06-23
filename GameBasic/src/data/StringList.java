package data;

import java.util.ArrayList;

public class StringList extends ArrayList<String> {
	
	public String toString() {
		if (this.size() == 0) {
			return "StringList size is 0";
		}
		
		StringBuffer contentBuffer = new StringBuffer();
		int contentCount = this.size();
		int lastIndex = contentCount - 1;
		for (int i=0; i<contentCount; i++) {
			contentBuffer.append(i + " : " + this.get(i));
			if (i < lastIndex) {
				contentBuffer.append("\n");
			}
		}
		
		return contentBuffer.toString();
	}
}
