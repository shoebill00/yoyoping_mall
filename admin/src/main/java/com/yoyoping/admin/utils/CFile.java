package com.yoyoping.admin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CFile {

	public static boolean deleteFile(String path) {
		boolean flag = false;
		try {
			File f = new File(path);
			if (f.exists() && f.isFile()) {
				flag = f.delete();
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static boolean deleteDir(File dir) {
		try {
			if (dir == null || !dir.exists() || !dir.isDirectory()) {
				// System.out.println(dir.getAbsolutePath() + " null");
				return false; // 检查参数
			}
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					file.delete(); // 删除所有文件
				} else if (file.isDirectory()) {
					deleteDir(file); // 递规的方式删除文件夹
				}
			}
			return dir.delete();// 删除目录本身
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteDir(String dir) {
		return deleteDir(new File(dir));
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static boolean copyFile(String oldPath, String newPath) {
		InputStream inStream = null;
		FileOutputStream fs = null;
		try {
			// int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				inStream = new FileInputStream(oldPath); // 读入原文件
				fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024];
				// int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					// bytesum += byteread; //字节数 文件大小
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				//inStream.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
					inStream = null;
				}
				if (fs != null) {
					fs.close();
					fs = null;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public static String getExtension(File f) {
		return (f != null) ? getExtension(f.getName()) : "";
	}

	public static String getExtension(String filename) {
		return getExtension(filename, "");
	}

	public static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i);
			}
		}
		return defExt;
	}

	public static String getExtensionWithoutDot(File f) {
		return (f != null) ? getExtensionWithoutDot(f.getName()) : "";
	}

	//获取扩展名(没有点)
	public static String getExtensionWithoutDot(String filename) {
		return getExtensionWithoutDot(filename, "");
	}

	public static String getExtensionWithoutDot(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}

	public static String getFileName(String filename, boolean withExtension) {
		if (filename == null || filename.isEmpty())
			return "";
		filename = filename.replace("\\", "/");
		Pattern p = withExtension ? Pattern.compile(".+/(.+)$") : Pattern
				.compile(".+/(.+)\\.\\w+$");
		Matcher m = p.matcher(filename);
		boolean result = m.find();
		if (!result)
			return "";
		return m.group(1);
	}

	public static String getFileName(String filename) {
		return getFileName(filename, true);
	}

	public static String trimExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');
			if ((i > -1) && (i < (filename.length()))) {
				return filename.substring(0, i);
			}
		}
		return filename;
	}

	public static String getPathFromId(long id) {
		return getPathFromId(id + "");
	}

	public static String getPathFromId(String strPhotoId) {
		int tLen = strPhotoId.length();
		/*
		 * for (int i = 0; i < 6 - tLen; i++) { strPhotoId = "0" + strPhotoId; }
		 * tLen = strPhotoId.length(); return strPhotoId.substring(tLen - 6,
		 * tLen - 4) + "/" + strPhotoId.substring(tLen - 4, tLen - 2);
		 */
		for (int i = 0; i < 4 - tLen; i++) {
			strPhotoId = "0" + strPhotoId;
		}
		tLen = strPhotoId.length();
		return strPhotoId.substring(tLen - 4, tLen - 2);
	}

	/*
	 * public static String getFileNameByPath(String filePath, String def) { if
	 * ((filePath != null) && (filePath.length() > 0)) { int i =
	 * filePath.lastIndexOf('/');
	 * 
	 * if ((i > -1) && (i < (filePath.length() - 1))) { return
	 * filePath.substring(i + 1); } } return def; }
	 * 
	 * public static String getFileNameByPath(String filePath) { return
	 * getFileNameByPath(filePath, ""); }
	 */
}
