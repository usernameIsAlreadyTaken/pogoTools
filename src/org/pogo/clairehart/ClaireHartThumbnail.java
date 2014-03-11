package org.pogo.clairehart;

import java.io.File;

import org.pogo.info.Base;
import org.pogo.util.FileOperater;

public class ClaireHartThumbnail {

	static String episodeName = "E099_C030-2";
	static String thumbnailLevel = "Voodoo";
	static String level1 = "Storeroom";
	static String level2 = "SouthernHome";
	static Integer ofbif = 109554698;
	static Integer ofbic = 109554699;
	static Integer ofbpf = 71997;
	static Integer ofbpc = 71996;

	static FileOperater fo = new FileOperater();
	static String episodesPath = Base.chPath
			+ "hauntedhog-server\\src\\main\\webapp\\episodes\\icons\\";
	static String productsPath = Base.chPath
			+ "hauntedhog-server\\src\\main\\webapp\\products\\";
	static String scenesPath = Base.chPath
			+ "hauntedhog-server\\src\\main\\webapp\\scenes\\icons\\";
	static String locationPath = Base.claireHartPath + "Locations\\";

	public static void main(String[] args) {
		if (copyThumbnail() & copyLevel1() & copyLevel2()) {
			doScript(parseEpisodeNumber(episodeName).toString(), episodeName,
					ofbif.toString(), ofbic.toString(), ofbpf.toString(),
					ofbpc.toString(), thumbnailLevel, level1, level2);
		} else {
			System.err.println("not add files!");
		}
	}

	public static void doScript(String episodesNumber, String episodeName,
			String ofbif, String ofbic, String ofbpf, String ofbpc,
			String thumbnailLevel, String level1, String level2) {
		try {
			Thread.sleep(1000);
			Runtime.getRuntime().exec(
					"cmd /k start _ch_thumbnail" + " " + " " + episodesNumber
							+ " " + episodeName + " " + ofbif + " " + ofbic
							+ " " + ofbpf + " " + ofbpc + " " 
							+ thumbnailLevel + "_Thumbnail"
							+ " " + level1 + "_Thumbnail"
							+ " " + level2 + "_Thumbnail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Boolean copyLevel2() {
		File file;
		String filePath;
		filePath = locationPath + level2 + "\\" + level2 + "_Thumbnail"
				+ ".png";
		file = new File(filePath);
		if (file.exists()) {
			try {
				fo.copyFile(filePath, scenesPath + level2 + "_Thumbnail"
						+ ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		System.err.println("can't find the file at " + filePath);
		filePath = locationPath + level2 + "\\" + level2 + "_Thumbnail"
				+ ".jpg";
		file = new File(filePath);
		if (file.exists()) {
			try {
				fo.copyFile(filePath, scenesPath + level2 + "_Thumbnail"
						+ ".jpg");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		System.err.println("can't find the file at " + filePath);
		return false;
	}

	public static Boolean copyLevel1() {
		File file;
		String filePath;
		filePath = locationPath + level1 + "\\" + level1 + "_Thumbnail"
				+ ".png";
		file = new File(filePath);
		if (file.exists()) {
			try {
				fo.copyFile(filePath, scenesPath + level1 + "_Thumbnail"
						+ ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		System.err.println("can't find the file at " + filePath);
		filePath = locationPath + level1 + "\\" + level1 + "_Thumbnail"
				+ ".jpg";
		file = new File(filePath);
		if (file.exists()) {
			try {
				fo.copyFile(filePath, scenesPath + level1 + "_Thumbnail"
						+ ".jpg");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		System.err.println("can't find the file at " + filePath);
		return false;
	}

	public static Boolean copyThumbnail() {
		Integer episodeNumber = parseEpisodeNumber(episodeName);
		File file;
		String filePath;
		filePath = locationPath + thumbnailLevel + "\\" + thumbnailLevel
				+ "_Thumbnail" + ".png";
		file = new File(filePath);
		if (file.exists()) {
			try {
				fo.copyFile(filePath, episodesPath + episodeName + ".png");
				fo.copyFile(filePath, productsPath + "HauntedHog_episode_"
						+ episodeNumber + ".png");
				fo.copyFile(filePath, productsPath + "HauntedHog_episode_"
						+ episodeNumber + "_preview" + ".png");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbif
						+ ".png");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbic
						+ ".png");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbpf
						+ ".png");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbpc
						+ ".png");
				fo.copyFile(filePath, scenesPath + thumbnailLevel
						+ "_Thumbnail" + ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		System.err.println("can't find the file at " + filePath);
		filePath = locationPath + thumbnailLevel + "\\" + thumbnailLevel
				+ "_Thumbnail" + ".jpg";
		file = new File(filePath);
		if (file.exists()) {
			try {
				fo.copyFile(filePath, episodesPath + episodeName + ".jpg");
				fo.copyFile(filePath, productsPath + "HauntedHog_episode_"
						+ episodeNumber + ".jpg");
				fo.copyFile(filePath, productsPath + "HauntedHog_episode_"
						+ episodeNumber + "_preview" + ".jpg");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbif
						+ ".jpg");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbic
						+ ".jpg");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbpf
						+ ".jpg");
				fo.copyFile(filePath, productsPath + "OFB-GENI_" + ofbpc
						+ ".jpg");
				fo.copyFile(filePath, scenesPath + thumbnailLevel
						+ "_Thumbnail" + ".jpg");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		System.err.println("can't find the file at " + filePath);
		return false;
	}

	public static Integer parseEpisodeNumber(String episodeName) {
		String temp[] = episodeName.split("_");
		String numStr = temp[0].substring(1);
		Integer episodeNum = Integer.parseInt(numStr);
		return episodeNum;
	}

}
