package cutting;

import java.util.ArrayList;

public class Border {
	public int numTop, numBottom, numLeft, numRight;
    public ArrayList<Point> top;
    public ArrayList<Point> bottom;
    public ArrayList<Point> left;
    public ArrayList<Point> right;
    
    public Border() {
    	this.numTop = 0;
    	this.numBottom = 0;
    	this.numLeft = 0;
    	this.numRight = 0;
    	
    	this.top = new ArrayList<Point>();
    	this.bottom = new ArrayList<Point>();
    	this.left = new ArrayList<Point>();
    	this.right = new ArrayList<Point>();
    }
    
    public Border(int initNumTop, int initNumBottom, int initNumLeft, int initNumRight, 
    		ArrayList<Point> initTop, ArrayList<Point> initBottom, ArrayList<Point> initLeft, ArrayList<Point> initRight) {
    	this.numTop = initNumTop;
    	this.numBottom = initNumBottom;
    	this.numLeft = initNumLeft;
    	this.numRight = initNumRight;
    	
    	this.top = initTop;
    	this.bottom = initBottom;
    	this.left = initLeft;
    	this.right = initRight;
    }
}
