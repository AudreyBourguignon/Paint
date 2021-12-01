package Labs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.MouseListener;

public class Drawing extends JPanel implements MouseListener {
    private int x;
    private int y;
    private Point p;
    private static Color color;
    private ArrayList<Figure> list;
    private static String nameFigure;

    public Drawing() {
        list = new ArrayList<Figure>();
        color = Color.black;
        nameFigure = "Rectangle";
        this.setBackground(Color.white);
        this.addMouseListener(this);
    }

    public static void setColor(Color c){color = c;}
    public static void setNameFigure(String name){nameFigure = name;}
    public ArrayList<Figure> getList(){return list;}

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        for(Figure f : list){
            f.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        int originX = e.getX();
        int originY = e.getY();
        p = new Point(originX,originY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        switch (nameFigure) {
            case "Ellipse":
                list.add(new Ellipse(p,x-p.getX(), y-p.getY(), color));
                break;
            case "Circle":
                Figure circle = new Circle(p,0, color);
                circle.setBoundingBox(x-p.getX(), y-p.getY());
                list.add(circle);
                break;
            case "Rectangle":
                list.add(new Rectangle(p,x -p.getX(), y-p.getY(), color));
                break;
            case "Square":
                Figure square = new Square(p,0, color);
                square.setBoundingBox(x-p.getX(), y-p.getY());
                list.add(square);
                break;
        }
        paintComponents(getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
