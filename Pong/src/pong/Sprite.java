package pong;

import java.awt.*;

//object to help implement for other classes
public class Sprite {
	protected int x;
	//displace x coords
	protected int y;
	//y coords
	protected int width;
	//width of the object
	protected int height;
	//height of the object
	protected Image image;
	//image object
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public int Height() {
		return height;
	}
	public int Width() {
		return width;
	}
	public Image getImage() {
		return image;
	}
	public Rectangle getRect() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	} //acts as a collision box for the sprite
	
	public void getDimensions() {
		height = image.getHeight(null);
		width = image.getWidth(null);
	}
	
	
}
