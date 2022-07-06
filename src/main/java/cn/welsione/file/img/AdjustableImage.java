package cn.welsione.file.img;

import cn.welsione.file.Resizeable;
import cn.welsione.file.Retypeable;
import cn.welsione.file.Saveable;
import cn.welsione.file.Size;
import cn.welsione.utils.ImageUtil;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Winstone
 * @date 2022/7/4 - 15:18
 */
@Slf4j
public class AdjustableImage implements Resizeable, Retypeable, Saveable, Image{
	private final File info;
	private Size size;
	private BufferedImage image;
	private String type;

	public AdjustableImage(Size size, BufferedImage image, File info) {
		this.size = size;
		this.image = image;
		this.info = info;
	}

	public AdjustableImage(String path) {
		File file = new File(path);
		BufferedImage read = read(file);
		this.size = new Size(read.getWidth(), read.getHeight());
		this.image = read;
		this.info = file;
	}

	public String getOriginalType() {
		return ImageUtil.suffix(this.info);
	}

	public String getType() {
		boolean blank = this.type == null || "".equals(this.type);
		return blank ? getOriginalType() : this.type;
	}

	public String getName() {
		return info.getName();
	}

	@Override
	public BufferedImage read(InputStream input) {
		try {
			this.image = ImageIO.read(input);
		} catch (IOException e) {
			log.error("读取图片失败：{}", e.getMessage(), e);
		}
		return this.image;
	}

	@Override
	public void write(OutputStream output) {
		try {
			boolean hChanged = this.image.getHeight() != this.size.getHeight();
			boolean wChanged = this.image.getWidth() != this.size.getWidth();
			BufferedImage resizeImage;
			if (hChanged || wChanged) {
				resizeImage = resize(this.image, this.size, this.getType());
			} else {
				resizeImage = this.image;
			}
			ImageIO.write(resizeImage, getType(), output);
		} catch (IOException e) {
			log.error("输出图片失败：{}", e.getMessage(), e);
		}
	}

	@Override
	public void resize(Size size) {
		this.size = size;
	}

	@Override
	public void resize(float multiple) {
		int width = (int) (this.size.getWidth() * multiple);
		int height = (int) (this.size.getHeight() * multiple);
		this.size = new Size(width, height);
	}

	@Override
	public void retype(String type) {
		this.type = type;
	}

	@Override
	public void save() {

	}
}
