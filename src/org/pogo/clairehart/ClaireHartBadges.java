package org.pogo.clairehart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.pogo.info.Base;

public class ClaireHartBadges {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static String episodeID = "099_C030-2"; // without E 
	public static String badgeName = "The Skeleton Key"; // without Badge
	public static String episodeName = "The Masked Man"; 
	public static int maxNumber;
	public static String[] fileCategoryPatch = new String[] { "lg", "lg-d",
			"sm", "sm-d" };
	public static String localPatch = Base.mainPath
			+ "webapps\\pogo\\htdocs\\images\\badges\\";
	public static String webPatch = Base.claireHartPath + "Badges\\#";

	public static void main(String[] args) throws IOException {
		maxNumber = maxNum();
		copy();
		printInfo();
		doScript(maxNumber + ".jpg", localPatch, Base.mainPath
				+ "java\\props\\badge\\");
	}

	public static void printInfo() {
		String temp[] = episodeID.split("_");
		int episode = Integer.parseInt(temp[0]);
		System.out.println(" *********** " + "HauntedHogEP" + episode
				+ " ********** ");
		System.out.println("HauntedHogEP" + episode + ".description="
				+ badgeName + " Badge");
		System.out.println("HauntedHogEP" + episode + ".description.short="
				+ badgeName);
		System.out.println("HauntedHogEP" + episode + ".info="
				+ "Complete the Episode \"" + episodeName
				+ "\" to earn this badge.");
		System.out.println("HauntedHogEP" + episode + ".game=hauntedhog");
		System.out.println("HauntedHogEP" + episode + ".id=" + maxNumber);
		System.out.println("HauntedHogEP" + episode + ".category=game");
		System.out
				.println("HauntedHogEP" + episode + ".order=" + (episode - 1));
	}

	public static void doScript(String fileName, String filePath, String defPath) {
		try {
			Thread.sleep(100);
			Runtime.getRuntime().exec(
					"cmd /k start _ch_badge" + " " + fileName + " " + filePath
							+ " " + defPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * get the current the max img number
	 */
	public static int maxNum() {
		int maxNumber = 0;
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

	/**
	 * copy the different files to different patch
	 * 
	 * @throws IOException
	 */
	public static void copy() throws IOException {
		String serverBadgePath = webPatch + episodeID + "\\";
		copyFile(serverBadgePath + "lg.jpg", localPatch + "lg\\" + maxNumber
				+ ".jpg");
		copyFile(serverBadgePath + "lg-d.jpg", localPatch + "lg-d\\"
				+ maxNumber + ".jpg");
		copyFile(serverBadgePath + "sm.jpg", localPatch + "sm\\" + maxNumber
				+ ".jpg");
		copyFile(serverBadgePath + "sm-d.jpg", localPatch + "sm-d\\"
				+ maxNumber + ".jpg");
	}

	public static void copyFile(String file1, String file2) throws IOException {
		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
		int temp;
		while ((temp = fis.read()) != -1) {
			fos.write(temp);
		}
		fis.close();
		fos.close();
	}
}
