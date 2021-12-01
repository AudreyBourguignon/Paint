package Labs;

public class Point {
    private int X;
    private int Y;

    public int getX(){return X;}
    public int getY(){return Y;}

    @Override
    public String toString() {
        return "(" + X + "," + Y + ')';
    }

    public Point(){
        this.X = 0;
        this.Y = 0;
    }

    public Point(int a, int b){
        this.X = a;
        this.Y = b;
    }

}
