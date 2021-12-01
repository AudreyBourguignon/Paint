package Labs;

import java.awt.*;

public class Square extends Rectangle{
    private int cote;

    public Square(Point point,int cote, Color c) {
        super(point, cote, cote, c);
        this.p = point;
        this.c = c;
    }

    @Override
    public void setBoundingBox(int l, int w) {
        super.setBoundingBox(l, w);
        if (l>w){this.cote = l;}
        else{this.cote = w;}
        this.length = cote;
        this.width = cote;
    }
}
