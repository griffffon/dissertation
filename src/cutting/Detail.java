package cutting;

import java.util.ArrayList;

public class Detail {
	public int ID;
    public String Name;
    public int Count;
    public int Demand;
    public int Demand2;
    public double Alpha;
    public ArrayList<Point> Points;
    public Point PolarPoint;
    public Border Borders;
    
    public Detail() {
        this.Points = new ArrayList<Point>();
        this.PolarPoint = new Point();
        this.Borders = new Border();
        this.Alpha = 0;
    }
    
    public Detail(Detail template) {
    	this.Name = template.Name;
    	this.Count = template.Count;
    	this.Demand = template.Demand;
    	this.Demand2 = template.Demand2;
    	this.ID = template.ID;
    	this.Alpha = template.Alpha;
    	this.PolarPoint = new Point(template.PolarPoint.X, template.PolarPoint.Y);
    	this.Points = new ArrayList<Point>();
        for (int i = 0; i < Count; i++) {
            Points.add(new Point(template.Points.get(i).X, template.Points.get(i).Y));
        }
        this.Borders = new Border();
        getBorders();
    }
    
    public void getBorders() {
        getPolarPoint();
        int minXnum = getMinXNum();
        int maxXnum = getMaxXNum();
        int minYnum = getMinYNum();
        int maxYnum = getMaxYNum();
        getTopAndBottomBorders(minXnum, maxXnum);
        getLeftAndRightBorders(minYnum, maxYnum);
    }
    
    public Point getPolarPoint() {
        return new Point(((getMaxX() + getMinX()) / 2), ((getMaxY() + getMinY()) / 2));
    }
    
    public double getMinX() {
        double min = Points.get(0).X;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).X < min) {
                min = Points.get(i).X;
            }
        }
        return min;
    }

    public double getMaxX() {
        double max = Points.get(0).X;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).X >= max) {
                max = Points.get(i).X;
            }
        }
        return max;
    }

    public double getMinY() {
        double min = Points.get(0).Y;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).Y < min) {
                min = Points.get(i).Y;
            }
        }
        return min;
    }

    public double getMaxY() {
        double max = Points.get(0).Y;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).Y >= max) {
                max = Points.get(i).Y;
            }
        }
        return max;
    }

    public int getMinXNum() {
        double min = Points.get(0).X;
        int n = 0;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).X < min) {
                min = Points.get(i).X;
                n = i;
            }
        }
        return n;
    }

    public int getMaxXNum()
    {
        double max = Points.get(0).X;
        int n = 0;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).X >= max) {
                max = Points.get(i).X;
                n = i;
            }
        }
        return n;
    }

    public int getMinYNum() {
        double min = Points.get(0).Y;
        int n = 0;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).Y < min) {
                min = Points.get(i).Y;
                n = i;
            }
        }
        return n;
    }

    public int getMaxYNum() {
        double max = Points.get(0).Y;
        int n = 0;
        for (int i = 1; i < Points.size(); i++) {
            if (Points.get(i).Y >= max) {
                max = Points.get(i).Y;
                n = i;
            }
        }
        return n;
    }

    private void getTopAndBottomBorders(int numInfPointX, int numExtPointX) {
        int numBottom1 = 0, numTop1 = 0;
        
        if (numInfPointX > numExtPointX) {
            Borders.numTop = numInfPointX - numExtPointX + 1;

            for (int j = 0; j < Borders.numTop; j++) {
                Borders.top.add(new Point(Points.get(numExtPointX + j).X, Points.get(numExtPointX + j).Y));
            }

            numBottom1 = Count - numInfPointX;

            for (int j = 0; j < numBottom1; j++) {
                Borders.bottom.add(new Point(Points.get(numInfPointX + j).X, Points.get(numInfPointX + j).Y));
            }

            for (int j = 0; j < numExtPointX; j++) {
                Borders.bottom.add(new Point(Points.get(j).X, Points.get(j).Y));
            }

            Borders.numBottom = numBottom1 + numExtPointX;
        } else {
            numTop1 = Count - numExtPointX;

            for (int j = 0; j < numTop1; j++) {
                Borders.top.add(new Point(Points.get(numExtPointX + j).X, Points.get(numExtPointX + j).Y));
            }

            for (int j = 0; j < numInfPointX; j++) {
                Borders.top.add(new Point(Points.get(j).X, Points.get(j).Y));
            }

            Borders.numTop = numTop1 + numInfPointX;
            Borders.numBottom = numExtPointX - numInfPointX + 1;

            for (int j = 0; j < Borders.numBottom; j++) {
                Borders.bottom.add(new Point(Points.get(numInfPointX + j).X, Points.get(numInfPointX + j).Y));
            }
        }
    }

    private void getLeftAndRightBorders(int numInfPointY, int numExtPointY) {
        int numLeft1 = 0, numRight1 = 0;
        
        if (numInfPointY > numExtPointY) {
            Borders.numLeft = numInfPointY - numExtPointY + 1;

            for (int j = 0; j < Borders.numLeft; j++) {
                Borders.left.add(new Point(Points.get(numExtPointY + j).X, Points.get(numExtPointY + j).Y));
            }

            numRight1 = Count - numInfPointY;

            for (int j = 0; j < numRight1; j++) {
                Borders.right.add(new Point(Points.get(numInfPointY + j).X, Points.get(numInfPointY + j).Y));
            }

            for (int j = 0; j < numExtPointY; j++) {
                Borders.right.add(new Point(Points.get(j + 1).X, Points.get(j + 1).Y));
            }

            Borders.numRight = numRight1 + numExtPointY;
        } else {
            numLeft1 = Count - numExtPointY;

            for (int j = 0; j < numLeft1; j++) {
                Borders.left.add(new Point(Points.get(numExtPointY + j).X, Points.get(numExtPointY + j).Y));
            }

            for (int j = 0; j < numInfPointY; j++) {
                Borders.left.add(new Point(Points.get(j + 1).X, Points.get(j + 1).Y));
            }

            //Borders.numRight += numInfPointY;
            Borders.numLeft = numExtPointY - numInfPointY + 1;

            for (int j = 0; j < Borders.numLeft; j++) {
                Borders.right.add(new Point(Points.get(numInfPointY + j).X, Points.get(numInfPointY + j).Y));
            }

            Borders.numRight = Borders.right.size();
        }
    }
}