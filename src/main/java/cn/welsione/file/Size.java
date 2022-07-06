package cn.welsione.file;

/**
 * @author Winstone
 * @date 2022/7/4 - 15:18
 */
public class Size{
	public static Size SMALL = new Size(100, 100);
	public static Size MIDDLE = new Size(250, 250);
	public static Size LARGE = new Size(500, 500);

	private int width;
	private int height;

	public Size() {
	}

	public Size(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
