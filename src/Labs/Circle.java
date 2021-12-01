package Labs;

import java.awt.*;

public class Circle extends Ellipse{
    private int rayon;

    public Circle (Point point,int rayon, Color c){
        super(point,rayon,rayon,c);
        this.p = point;
        this.c = c;
    }

    @Override
    public void setBoundingBox(int l, int w) {
        super.setBoundingBox(l, w);
        if (l>w){this.rayon = l;}
        else{this.rayon = w;}
        this.semiAxisX = rayon;
        this.semiAxisY = rayon;
    }
}
