package Labs;

import java.awt.*;

public class Ellipse extends Figure{
    protected Point point;
    protected int semiAxisX = 0;
    protected int semiAxisY = 0;
    protected Color c;

    public Ellipse (Point p,int px, int py, Color c){
        super(c,new Point(px,py));
        this.point = p;
        this.semiAxisX = px;
        this.semiAxisY = py;
        this.c = c;
    }

    public int getPerimeter(){return (int) (2*Math.PI*Math.sqrt((Math.pow(semiAxisX,2) + Math.pow(semiAxisY,2))/2));}
    public int getSurface(){return (int) (Math.PI*semiAxisX*semiAxisY);}

    public int setSemiAxisX(int axisX){return this.semiAxisX;}
    public int setSemiAxisY(int axisY){return this.semiAxisY;}

    public void setBoundingBox(int l, int w){
        this.semiAxisY = w;
        this.semiAxisX = l;
    }

    public void draw(Graphics g){
        int x = point.getX();
        int y = point.getY();
        g.setColor(c);
        g.drawOval(x,y,semiAxisX,semiAxisY);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxisX=" + semiAxisX +
                ", semiAxisY=" + semiAxisY +
                ", c=" + c +
                '}';
    }
}
