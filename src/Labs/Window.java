package Labs;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Window extends JFrame implements ActionListener, MenuListener {
    private Drawing draw = new Drawing();

    public Window(String Title,int x,int y){
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();

        // creation of menus
        JMenuBar m = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuAbout = new JMenu("About");
        JMenuItem new0 = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        menuFile.add(new0);
        menuFile.add(open);
        menuFile.add(save);
        menuFile.add(quit);
        m.add(menuFile);
        m.add(menuAbout);
        setJMenuBar(m);
        // menu actions
        menuAbout.addMenuListener(this);
        // menuItem actions
        new0.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);

        // creations of JButtons
        JButton ellipse = new JButton("Ellipse");
        JButton circle = new JButton("Circle");
        JButton rectangle = new JButton("Rectangle");
        JButton square = new JButton("Square");

        JButton black = new JButton("black");
        black.setBackground(Color.black);
        black.setForeground(Color.white);
        JButton red = new JButton("red");
        red.setBackground(Color.red);
        JButton green = new JButton("green");
        green.setBackground(Color.green);
        JButton blue = new JButton("blue");
        blue.setBackground(Color.blue);
        blue.setForeground(Color.white);
        JButton yellow = new JButton("yellow");
        yellow.setBackground(Color.yellow);
        JButton pink = new JButton("pink");
        pink.setBackground(Color.pink);
        JButton magenta = new JButton("magenta");
        magenta.setBackground(Color.magenta);
        JButton orange = new JButton("orange");
        orange.setBackground(Color.orange);

        // organisation of southPanel
        JPanel southPanel = new JPanel();
        JPanel color = new JPanel();
        JPanel shape = new JPanel();

        southPanel.setLayout(new GridLayout(1,2));
        color.setLayout(new GridLayout(2,4));
        shape.setLayout(new GridLayout(2,2));
        southPanel.add(color);
        southPanel.add(shape);

        color.add(black);
        color.add(red);
        color.add(green);
        color.add(blue);
        color.add(yellow);
        color.add(pink);
        color.add(magenta);
        color.add(orange);

        shape.add(ellipse);
        shape.add(circle);
        shape.add(rectangle);
        shape.add(square);

        contentPanel.add(draw,"Center");
        contentPanel.add(southPanel,"South");

        // interaction
        ellipse.addActionListener(this);
        circle.addActionListener(this);
        rectangle.addActionListener(this);
        square.addActionListener(this);

        black.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        yellow.addActionListener(this);
        pink.addActionListener(this);
        magenta.addActionListener(this);
        orange.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Ellipse":
                Drawing.setNameFigure("Ellipse");
                break;
            case "Circle":
                Drawing.setNameFigure("Circle");
                break;
            case "Rectangle":
                Drawing.setNameFigure("Rectangle");
                break;
            case "Square":
                Drawing.setNameFigure("Square");
                break;
            case "black":
                Drawing.setColor(Color.black);
                break;
            case "red":
                Drawing.setColor(Color.red);
                break;
            case "green":
                Drawing.setColor(Color.green);
                break;
            case "blue":
                Drawing.setColor(Color.blue);
                break;
            case "yellow":
                Drawing.setColor(Color.yellow);
                break;
            case "pink":
                Drawing.setColor(Color.pink);
                break;
            case "magenta":
                Drawing.setColor(Color.magenta);
                break;
            case "orange":
                Drawing.setColor(Color.orange);
                break;

            case "New":
                getContentPane().repaint();
                draw.getList().clear();
                getContentPane().add(draw,"Center");
                break;
            case "Open":
                JFileChooser fileChoose = new JFileChooser();
                int r = fileChoose.showOpenDialog(getParent());
                if (r == JFileChooser.APPROVE_OPTION) {
                    File file = fileChoose.getSelectedFile();
                    try {
                        FileInputStream fileIS = new FileInputStream(file);
                        InputStream IS = new BufferedInputStream(fileIS);
                        Image image = ImageIO.read(IS);
                        if (image == null){
                            System.out.println("the file is not an image");
                        }
                        else{
                            JLabel label = new JLabel(new ImageIcon(image));
                            getContentPane().add(label,"Center");
                            pack();
                            setVisible(true);
                            getContentPane().add(draw,"Center");
                        }
                    }
                    catch (FileNotFoundException ex) {
                        System.out.println("error in fileInputStream");
                    } catch (IOException ioException) {
                        System.out.println("error reading file");
                    }
                }
                else {
                    System.out.println("error opening file");
                }
                break;
            case "Save":
                JFileChooser file = new JFileChooser();
                int s = file.showSaveDialog(getParent());
                if (s == JFileChooser.APPROVE_OPTION){
                    try{
                        FileOutputStream fileOS = new FileOutputStream(file.getSelectedFile());
                        ObjectOutputStream object = new ObjectOutputStream(fileOS);
                        object.writeInt(draw.getList().size());
                        for (Figure f : draw.getList()){
                            object.writeObject(f);
                        }
                        object.close();
                        /*int w = getContentPane().getWidth();
                        int h = getContentPane().getHeight();
                        BufferedImage bi = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
                        ImageIO.write(bi, "jpg", fileOS);*/
                        System.out.println("file save");
                    }
                    catch (Exception exc){
                        System.out.println("Error creating file");
                    }
                }
                else {
                    System.out.println("Error saving file");
                }
                break;
            case "Quit":
                System.exit(0);
                break;
        }
    }

    @Override
    public void menuSelected(MenuEvent e) {
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog(info, "Authors: Audrey Bourguignon", "information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void menuDeselected(MenuEvent e) {}

    @Override
    public void menuCanceled(MenuEvent e) {}

}
