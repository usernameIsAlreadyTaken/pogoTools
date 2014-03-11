package org.pogo.util;

import java.io.*;

public class FileOperater {
	/**
	 * 创建目录
	 * 
	 * @param folderPath
	 *            如 c:/abc
	 * @return boolean
	 */
	public void newFolder(String folderPath) {
		File myFilePath = new File(folderPath);
		if (!myFilePath.exists()) {
			myFilePath.mkdir();
		}
	}

	/**
	 * 创建文件
	 * 
	 * @param fileName文件路径�?��??称
	 *            如c:/test.txt
	 * @param fileContent文件内容
	 * @throws IOException
	 */
	public void newFile(String fileName, String fileContent) throws IOException {
		File myFilePath = new File(fileName);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		String strContent = fileContent;
		myFile.println(strContent);
		resultFile.close();
	}

	/**
	 * 删除文件
	 * 
	 * @param fileName文件路径�?��??称
	 *            如c:/test.txt
	 */
	public void delFile(String fileName) {
		File myDelFile = new File(fileName);
		myDelFile.delete();
	}

	/**
	 * 删除文件夹
	 * 
	 * @param filePathAndName
	 *            文件夹路径�?��??称 如c:/fqf
	 */
	public void delFolder(String folderPath) {
		delAllFile(folderPath); // 删除完里�?�所有内容
		File myFilePath = new File(folderPath);
		myFilePath.delete(); // 删除空文件夹
	}

	/**
	 * 删除文件夹里�?�的所有文件
	 * 
	 * @param folderPath
	 *            文件夹路径 如 c:/abc
	 */
	public void delAllFile(String folderPath) {
		File file = new File(folderPath);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (folderPath.endsWith(File.separator)) {
				temp = new File(folderPath + tempList[i]);
			} else {
				temp = new File(folderPath + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(folderPath + "/" + tempList[i]);// 先删除文件夹里�?�的文件
				delFolder(folderPath + "/" + tempList[i]);// �?删除空文件夹
			}
		}
	}

	/**
	 * �?制�?�个文件
	 * 
	 * @param oldPath
	 *            原文件路径 如：C:/test.txt
	 * @param newPath
	 *            �?制�?�路径 如：D:/test.txt
	 * @throws Exception
	 */
	public void copyFile(String oldPath, String newPath) throws Exception {
		int byteRead = 0;
		File oldfile = new File(oldPath);
		if (oldfile.exists()) { // 文件存在时
			InputStream inStream = new FileInputStream(oldPath); // 读入原文件
			FileOutputStream fs = new FileOutputStream(newPath);
			byte[] buffer = new byte[1024];
			while ((byteRead = inStream.read(buffer)) != -1) {
				fs.write(buffer, 0, byteRead);
			}
			fs.flush();
			fs.close();
			inStream.close();
		}
	}

	/**
	 * �?制整个文件夹内容
	 * 
	 * @param oldPath
	 *            原文件路径 如：c:/abc
	 * @param newPath
	 *            �?制�?�路径 如：d:/abc/dd
	 * @throws Exception
	 */
	public void copyFolder(String oldPath, String newPath) throws Exception {
		(new File(newPath)).mkdirs(); // 如果文件夹�?存在 则建立新文件夹
		File oFile = new File(oldPath);
		String[] file = oFile.list();
		File temp = null;
		for (int i = 0; i < file.length; i++) {
			if (oldPath.endsWith(File.separator)) {
				temp = new File(oldPath + file[i]);
			} else {
				temp = new File(oldPath + File.separator + file[i]);
			}
			if (temp.isFile()) {
				FileInputStream input = new FileInputStream(temp);
				FileOutputStream output = new FileOutputStream(newPath + "/"
						+ (temp.getName()).toString());
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			}
			if (temp.isDirectory()) {// 如果是�?文件夹
				copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
			}
		}

	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            如：c:/freezq.txt
	 * @param newPath
	 *            如：d:/freezq.txt
	 * @throws Exception
	 */
	public void moveFile(String oldPath, String newPath) throws Exception {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动文件夹到指定目录
	 * 
	 * @param oldPath
	 *            如：c:/abc
	 * @param newPath
	 *            如：d:/abc
	 * @throws Exception
	 */
	public void moveFolder(String oldPath, String newPath) throws Exception {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}

}
