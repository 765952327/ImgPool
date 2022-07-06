package cn.welsione.file.img;

import cn.welsione.file.IFile;
import cn.welsione.file.Size;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Winstone
 * @date 2022/7/4 - 15:21
 */
public interface Image extends IFile<BufferedImage>{
	Logger logger = LoggerFactory.getLogger(Image.class);

	default BufferedImage resize(BufferedImage originalImage, Size size, String type) {
		BufferedImage resizeImg = null;
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Thumbnails.of(originalImage)
					.size(size.getWidth(), size.getHeight())
					.outputFormat(type)
					.outputQuality(1)
					.toOutputStream(outputStream);
			byte[] data = outputStream.toByteArray();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
			resizeImg = ImageIO.read(inputStream);
		} catch (IOException e) {
			logger.error("重设文件大小错误：{}", e.getMessage(), e);
		}
		return resizeImg;
	}
}
