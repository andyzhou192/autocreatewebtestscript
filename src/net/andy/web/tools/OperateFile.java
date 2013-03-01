package net.andy.web.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OperateFile {
	
	/**
	 * �����ļ���
	 * 
	 * @param path
	 *            Ŀ¼
	 */
	public static void createDir(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	/**
	 * �������ļ�
	 * 
	 * @param path
	 *            Ŀ¼
	 * @param filename
	 *            �ļ���
	 * @throws IOException
	 */
	public static File createFile(String path, String filename) {
		if (path != null && path != "") {
			path = path.replace("\\", "/").replace(".", "/");
		}
		createDir(path);
		File file = new File(path + "/" + filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	/**
	 * ��ȡ�ı��ļ�.
	 * 
	 */
	public static String readTxtFile( File filename ) {
		BufferedReader bufread;
		String read;
		String readStr = "";
		FileReader fileread;
		try {
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {
					readStr = readStr + read + "\r\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return readStr;
	}

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	// createFile("D:/com/taobao/andy/test", "test.java");
	//
	// }

}
