package section4;

public class Rectangle extends Shape {

	int width, height;
	
	public Rectangle(int w, int h) {
		super("Rectangle");
		width = w;
		height = h;
	}
	
	public double computeArea() {
		return (double)width*height;
	}
	
	public double computePerimeter() {
		return 2.0*(width*height);
	}
		
	public String toString() {
		return "Rectangle: width is "+width+", height is "+height;
	}
	
	
}
