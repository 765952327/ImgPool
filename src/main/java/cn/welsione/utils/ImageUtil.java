package cn.welsione.utils;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@Slf4j
public class ImageUtil extends FileUtil{
	/**
	 * byte[]数组转BufferedImage图片流
	 */
	private static BufferedImage bytesToBufferedImage(byte[] ImageByte) {
		ByteArrayInputStream in = new ByteArrayInputStream(ImageByte);
		BufferedImage image = null;
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			log.error("错误信息: ", e);
		}
		return image;
	}
}

