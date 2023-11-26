import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import org.graalvm.polyglot.Context;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartMenu extends GraphicsProgram implements MouseListener {

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
        main.add(l);

    }
    public void drawButton(Main main, double x, double y) {
        GLabel l = new GLabel("dfg", x, y);
        main.add(l);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("dfgdsfg");
    }
}
