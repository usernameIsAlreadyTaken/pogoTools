package org.pogo.hogs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.pogo.info.Base;

public class PrintMaxNumber {

	public static void main(String[] args) {
		Integer maxNumber = PrintMaxNumber.GetMaxNum();
		System.out.println(maxNumber);
	}

	public static String[] fileCategoryPatch = new String[] { "lg", "lg-d",
			"sm", "sm-d" };
	public static String localPatch = Base.mainPath
			+ "webapps\\pogo\\htdocs\\images\\badges\\";

	public static Integer GetMaxNum() {
		Integer maxNumber = 0;
		for (int n = 0; n < fileCategoryPatch.length; n++) {
			File file = new File(localPatch + fileCategoryPatch[n]);
			String[] fileList = file.list();
			String region = "(\\.swf)|(\\.jpg)|(\\.png)";
			Pattern numPattern = Pattern.compile("\\d*");
			List<Integer> fileNameList = new ArrayList<Integer>();
			for (int i = 0; i < fileList.length; i++) {
				String fileName = fileList[i].replaceAll(region, "");
				if (numPattern.matcher(fileName).matches()) {
					fileNameList.add(Integer.parseInt(fileName));
				}
			}

			for (int i = 0; i < fileNameList.size(); i++) {
				if (maxNumber < fileNameList.get(i))
					maxNumber = fileNameList.get(i);
			}
		}
		return ++maxNumber;
	}
}
