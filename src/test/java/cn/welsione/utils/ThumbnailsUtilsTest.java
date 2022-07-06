package cn.welsione.utils;


import cn.welsione.file.img.AdjustableImage;

/**
 * @author Winstone
 * @date 2022/7/4 - 12:01
 */
class ThumbnailsUtilsTest{
	public static void main(String[] args) throws Exception {
		AdjustableImage image = new AdjustableImage("/Users/weigaolei/Downloads/文件管理.png");
		image.resize(0.1f);
		image.write("/Users/weigaolei/Downloads/文件管理4.png");
	}
}