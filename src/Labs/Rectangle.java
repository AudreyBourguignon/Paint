package Labs;

import java.awt.*;

public class Rectangle extends Figure{
    protected Point point;
    protected int width;
    protected int length;
    protected Color c;

    public Rectangle (Point p,int px, int py, Color c){
        super(c,new Point(px,py));
        this.point = p;
        this.length = px;
        this.width = py;
        this.c = c;
    }

    public int getPerimeter(){return 2*length + 2*width;}
    public int getSurface(){return length*width;}

    public int setLength(int l){return this.length;}
    public int setWidth(int w){return this.width;}

    public void setBoundingBox(int l, int w){
        this.width = w;
        this.length = l;
    }

    public void draw(Graphics g){
        int x = point.getX();
        int y = point.getY();
        g.setColor(c);
        g.drawRect(x,y,length,width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", c=" + c +
                '}';
    }
}
