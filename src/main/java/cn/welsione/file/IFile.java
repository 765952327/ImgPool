package cn.welsione.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 定义文件的行为
 *
 * @author Winstone
 * @date 2022/7/5 - 14:20
 */
public interface IFile<T>{
	Logger logger = LoggerFactory.getLogger(IFile.class);

	T read(InputStream input);

	void write(OutputStream output);

	default T read(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			return read(file);
		}
		throw new IllegalArgumentException(path + "is not file");
	}

	default T read(File file) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		}
		return read(inputStream);
	}

	default void write(File file) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		}
		write(outputStream);
	}

	default void write(String path) {
		File file = new File(path);
		write(file);
	}
}
