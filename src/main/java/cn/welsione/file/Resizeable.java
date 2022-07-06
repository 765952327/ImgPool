package cn.welsione.file;

/**
 * 可以重设大小
 * @author Winstone
 * @date 2022/7/4 - 15:26
 */
public interface Resizeable{
	void resize(Size size);

	void resize(float multiple);

	default void resize(int multiple){
		resize((float) multiple);
	}

	default void resize(int width, int height){
		Size size = new Size(width,height);
		resize(size);
	}
}
