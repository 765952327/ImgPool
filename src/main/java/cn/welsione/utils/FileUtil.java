package cn.welsione.utils;

import java.io.File;

/**
 * @author Winstone
 * @date 2022/7/4 - 15:33
 */
public class FileUtil{

	public static String suffix(File file) {
		String name = file.getName();
		int index = name.lastIndexOf(".");
		return name.substring(index + 1, name.length());
	}
}
