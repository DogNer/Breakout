import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartMenu extends GraphicsProgram implements MouseListener {
    GRect button1, button2, button3, button4, wallpaper;
    public Main main;
    public StartMenu(Main main) {
        main.addMouseListeners();
    }

    public GLabel getObText(String text){
        GLabel l = new GLabel(text);
        return l;
    }

    public void drawText(Main main, String text, int size, double x, double y){
        GLabel l = new GLabel(text, x, y);
        l.setFont("Arial-" + size);
        l.setColor(Color.decode("#4D0C02"));
        main.add(l);

    }

    private GRect genRectangle(double rectangleWidth, Main main, int i){
        if (i == 4) {
            GRect tmp = new GRect(main.getWidth() / 2 - rectangleWidth / 2, 350, rectangleWidth, 50);
            tmp.setFilled(true);
            tmp.setColor(Color.decode("#B54213"));
            return tmp;
        }
        else {
            GRect tmp = new GRect((main.getWidth() - rectangleWidth * 3) * i / 4 + rectangleWidth * (i - 1), 200, rectangleWidth, 50);
            tmp.setFilled(true);
            tmp.setColor(Color.decode("#F8A86A"));
            return tmp;
        }
    }

    public void drawButtonLVL(Main main){
        double rectangleWidth = 100;

        button1 = genRectangle(rectangleWidth, main, 1);
        button2 = genRectangle(rectangleWidth, main, 2);
        button3 = genRectangle(rectangleWidth, main, 3);
        button4 = genRectangle(rectangleWidth, main, 4);

        main.add(wallpaper);
        main.add(button1);
        main.add(button2);
        main.add(button3);
        main.add(button4);
        drawText(main, "LVL 1", 26, (main.getWidth() - rectangleWidth * 3) / 4 + getObText("LVL 1").getWidth() / 2, 225 + getObText("LVL 1").getHeight() / 2);
        drawText(main, "LVL 2", 26, (main.getWidth() - rectangleWidth * 3) * 2 / 4 + getObText("LVL 1").getWidth() / 2 + rectangleWidth, 225 + getObText("LVL 1").getHeight() / 2);
        drawText(main, "LVL 3", 26, (main.getWidth() - rectangleWidth * 3) * 3 / 4 + getObText("LVL 1").getWidth() / 2 + rectangleWidth * 2, 225 + getObText("LVL 1").getHeight() / 2);
        drawText(main, "EXIT", 26, main.getWidth() / 2 - rectangleWidth / 4 - 3, 385);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("dfgdsfg");
    }

    public void wallpaper() {
        wallpaper = new GRect(0, 0, 500, 500);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#FEF4DB"));
        add(wallpaper);
    }
}
