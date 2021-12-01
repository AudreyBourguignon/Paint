package Labs;

import java.awt.*;

public abstract class Figure {
    protected Color c;
    protected Point p;

    public Figure(Color c,Point p) {
        this.c = c;
        this.p = p;
    }

    public Color getC(){return c;}
    public Point getP(){return p;}

    public abstract int getPerimeter();
    public abstract int getSurface();

    public abstract void setBoundingBox(int l, int w);

    public abstract void draw(Graphics g);

    @Override
    public String toString() {
        return "Figure{" +
                "c=" + c +
                ", p=" + p +
                /*
                ", width=" + width +
                ", length=" + length +
                ", semiAxisX=" + semiAxisX +
                ", semiAxisY=" + semiAxisY +
                 */
                '}';
    }

}
