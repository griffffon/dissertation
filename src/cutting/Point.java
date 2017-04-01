package cutting;

public class Point {
	public double X;
	public double Y;
	
	public Point() {
		this.X = 0;
		this.Y = 0;
	}
	
	public Point(double initX, double initY) {
		this.X = initX;
		this.Y = initY;
	}
	
	public double getX() {
		return this.X;
	}
	
	public double getY() {
		return this.Y;
	}
	
	public void setX(double newX) {
		this.X = newX;
	}
	
	public void setY(double newY) {
		this.Y = newY;
	}
}
