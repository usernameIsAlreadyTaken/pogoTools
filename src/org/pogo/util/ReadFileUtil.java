package org.pogo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class ReadFileUtil {
	/**
	 * 以字节为�?��?读�?�文件，常用于读二进制文件，如图片�?声音�?影�?等文件。
	 */
	public static void readFileByBytes(String fileName) {
		File file = new File(fileName);
		InputStream in = null;
		try {
			System.out.println("以字节为�?��?读�?�文件内容，一次读一个字节：");
			// 一次读一个字节
			in = new FileInputStream(file);
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {
				System.out.write(tempbyte);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		try {
			System.out.println("以字节为�?��?读�?�文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempbytes = new byte[100];
			int byteread = 0;
			in = new FileInputStream(fileName);
			ReadFileUtil.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while ((byteread = in.read(tempbytes)) != -1) {
				System.out.write(tempbytes, 0, byteread);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 以字符为�?��?读�?�文件，常用于读文本，数字等类型的文件
	 */
	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("以字符为�?��?读�?�文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个�?�行。
				// 但如果这两个字符分开显示时，会�?�两次行。
				// 因此，�?蔽掉\r，或者�?蔽\n。�?�则，将会多出很多空行。
				if (((char) tempchar) != '\r') {
					System.out.print((char) tempchar);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("以字符为�?��?读�?�文件内容，一次读多个字节：");
			// 一次读多个字符
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// 读入多个字符到字符数组中，charread为一次读�?�字符数
			while ((charread = reader.read(tempchars)) != -1) {
				// �?�样�?蔽掉\r�?显示
				if ((charread == tempchars.length)
						&& (tempchars[tempchars.length - 1] != '\r')) {
					System.out.print(tempchars);
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == '\r') {
							continue;
						} else {
							System.out.print(tempchars[i]);
						}
					}
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 以行为�?��?读�?�文件，常用于读�?��?�行的格�?化文件
	 */
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为�?��?读�?�文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结�?�
			while ((tempString = reader.readLine()) != null) {
				// 显示行�?�
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * �?机读�?�文件内容
	 */
	public static void readFileByRandomAccess(String fileName) {
		RandomAccessFile randomFile = null;
		try {
			System.out.println("�?机读�?�一段文件内容：");
			// 打开一个�?机访问文件�?，按�?�读方�?
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始�?置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始�?置移到beginIndex�?置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容�?足10个字节，则读剩下的字节。
			// 将一次读�?�的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 显示输入�?中还剩的字节数
	 */
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当�?字节输入�?中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName = "C:/temp/newTemp.txt";
		ReadFileUtil.readFileByBytes(fileName);
		ReadFileUtil.readFileByChars(fileName);
		ReadFileUtil.readFileByLines(fileName);
		ReadFileUtil.readFileByRandomAccess(fileName);
	}
}
