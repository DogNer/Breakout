import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Main extends GraphicsProgram {
    public GRect rocket;
    public GRect brick1;
    public GRect brick2;
    public GRect brick3;
    public GRect brick4;
    public GRect brick5;
    public GRect brick6;
    public GRect brick7;
    public GRect brick8;
    public GRect brick9;
    public GRect brick10;
    public GRect brick11;
    public GRect brick12;
    public GRect brick13;
    public GRect brick14;
    public GRect brick15;
    public GRect brick16;
    public GRect brick17;
    public GRect brick18;
    public GRect brick19;
    public GRect brick20;
    public GRect brick21;
    public GRect brick22;
    public GRect brick23;
    public GRect brick24;
    public GRect brick25;
    public GRect brick26;
    public GRect brick27;
    public GRect brick28;
    public GRect brick29;
    public GRect brick30;

    public GRect brick31;
    public GRect brick32;
    public GRect brick33;
    public GRect brick34;
    public GRect brick35;
    public GRect brick36;
    public GRect brick37;
    public GRect brick38;
    public GRect brick39;
    public GRect brick40;
    public GRect brick41;
    public GRect brick42;
    public GRect brick43;
    public GRect brick44;
    public GRect brick45;
    public GRect brick46;
    public GRect brick47;
    public GRect brick48;
    public GRect brick49;
    public GRect brick50;
    public GOval ball;

    public void run() {
        this.setSize(710, 1000);
        wallPaper();
        rocket();
        setBricks();
        setBall();
    }

    public void wallPaper() {
        GRect wallpaper = new GRect(0, 0, 710, 1000);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#efe6d6"));
        add(wallpaper);
    }

    public void rocket() {
        rocket = new GRect(0, 0, 80, 7);
        rocket.setFilled(true);
        rocket.setColor(Color.decode("#666235"));
        add(rocket, 310, 950);
    }

    public void setBricks() {
        brick1 = new GRect(0, 0, 60, 10);
        brick1.setFilled(true);
        brick1.setColor(Color.decode("#020201"));
        add(brick1, 10, 100);

        brick2 = new GRect(0, 0, 60, 10);
        brick2.setFilled(true);
        brick2.setColor(Color.decode("#020201"));
        add(brick2, 80, 100);

        brick3 = new GRect(0, 0, 60, 10);
        brick3.setFilled(true);
        brick3.setColor(Color.decode("#020201"));
        add(brick3, 150, 100);

        brick4 = new GRect(0, 0, 60, 10);
        brick4.setFilled(true);
        brick4.setColor(Color.decode("#020201"));
        add(brick4, 220, 100);

        brick5 = new GRect(0, 0, 60, 10);
        brick5.setFilled(true);
        brick5.setColor(Color.decode("#020201"));
        add(brick5, 290, 100);

        brick6 = new GRect(0, 0, 60, 10);
        brick6.setFilled(true);
        brick6.setColor(Color.decode("#020201"));
        add(brick6, 360, 100);

        brick7 = new GRect(0, 0, 60, 10);
        brick7.setFilled(true);
        brick7.setColor(Color.decode("#020201"));
        add(brick7, 430, 100);

        brick8 = new GRect(0, 0, 60, 10);
        brick8.setFilled(true);
        brick8.setColor(Color.decode("#020201"));
        add(brick8, 500, 100);

        brick9 = new GRect(0, 0, 60, 10);
        brick9.setFilled(true);
        brick9.setColor(Color.decode("#020201"));
        add(brick9, 570, 100);

        brick10 = new GRect(0, 0, 60, 10);
        brick10.setFilled(true);
        brick10.setColor(Color.decode("#020201"));
        add(brick10, 640, 100);

        brick11 = new GRect(0, 0, 60, 10);
        brick11.setFilled(true);
        brick11.setColor(Color.decode("#6f859b"));
        add(brick11, 10, 115);

        brick12 = new GRect(0, 0, 60, 10);
        brick12.setFilled(true);
        brick12.setColor(Color.decode("#6f859b"));
        add(brick12, 80, 115);

        brick13 = new GRect(0, 0, 60, 10);
        brick13.setFilled(true);
        brick13.setColor(Color.decode("#6f859b"));
        add(brick13, 150, 115);

        brick14 = new GRect(0, 0, 60, 10);
        brick14.setFilled(true);
        brick14.setColor(Color.decode("#6f859b"));
        add(brick14, 220, 115);

        brick15 = new GRect(0, 0, 60, 10);
        brick15.setFilled(true);
        brick15.setColor(Color.decode("#6f859b"));
        add(brick15, 290, 115);

        brick16 = new GRect(0, 0, 60, 10);
        brick16.setFilled(true);
        brick16.setColor(Color.decode("#6f859b"));
        add(brick16, 360, 115);

        brick17 = new GRect(0, 0, 60, 10);
        brick17.setFilled(true);
        brick17.setColor(Color.decode("#6f859b"));
        add(brick17, 430, 115);

        brick18 = new GRect(0, 0, 60, 10);
        brick18.setFilled(true);
        brick18.setColor(Color.decode("#6f859b"));
        add(brick18, 500, 115);

        brick19 = new GRect(0, 0, 60, 10);
        brick19.setFilled(true);
        brick19.setColor(Color.decode("#6f859b"));
        add(brick19, 570, 115);

        brick20 = new GRect(0, 0, 60, 10);
        brick20.setFilled(true);
        brick20.setColor(Color.decode("#6f859b"));
        add(brick20, 640, 115);

        brick21 = new GRect(0, 0, 60, 10);
        brick21.setFilled(true);
        brick21.setColor(Color.decode("#7c8f78"));
        add(brick21, 10, 130);

        brick22 = new GRect(0, 0, 60, 10);
        brick22.setFilled(true);
        brick22.setColor(Color.decode("#7c8f78"));
        add(brick22, 80, 130);

        brick23 = new GRect(0, 0, 60, 10);
        brick23.setFilled(true);
        brick23.setColor(Color.decode("#7c8f78"));
        add(brick23, 150, 130);

        brick24 = new GRect(0, 0, 60, 10);
        brick24.setFilled(true);
        brick24.setColor(Color.decode("#7c8f78"));
        add(brick24, 220, 130);

        brick25 = new GRect(0, 0, 60, 10);
        brick25.setFilled(true);
        brick25.setColor(Color.decode("#7c8f78"));
        add(brick25, 290, 130);

        brick26 = new GRect(0, 0, 60, 10);
        brick26.setFilled(true);
        brick26.setColor(Color.decode("#7c8f78"));
        add(brick26, 360, 130);

        brick27 = new GRect(0, 0, 60, 10);
        brick27.setFilled(true);
        brick27.setColor(Color.decode("#7c8f78"));
        add(brick27, 430, 130);

        brick28 = new GRect(0, 0, 60, 10);
        brick28.setFilled(true);
        brick28.setColor(Color.decode("#7c8f78"));
        add(brick28, 500, 130);

        brick29 = new GRect(0, 0, 60, 10);
        brick29.setFilled(true);
        brick29.setColor(Color.decode("#7c8f78"));
        add(brick29, 570, 130);

        brick30 = new GRect(0, 0, 60, 10);
        brick30.setFilled(true);
        brick30.setColor(Color.decode("#7c8f78"));
        add(brick30, 640, 130);

        brick31 = new GRect(0, 0, 60, 10);
        brick31.setFilled(true);
        brick31.setColor(Color.decode("#a98c6a"));
        add(brick31, 10, 145);

        brick32 = new GRect(0, 0, 60, 10);
        brick32.setFilled(true);
        brick32.setColor(Color.decode("#a98c6a"));
        add(brick32, 80, 145);

        brick33 = new GRect(0, 0, 60, 10);
        brick33.setFilled(true);
        brick33.setColor(Color.decode("#a98c6a"));
        add(brick33, 150, 145);

        brick34 = new GRect(0, 0, 60, 10);
        brick34.setFilled(true);
        brick34.setColor(Color.decode("#a98c6a"));
        add(brick34, 220, 145);

        brick35 = new GRect(0, 0, 60, 10);
        brick35.setFilled(true);
        brick35.setColor(Color.decode("#a98c6a"));
        add(brick35, 290, 145);

        brick36 = new GRect(0, 0, 60, 10);
        brick36.setFilled(true);
        brick36.setColor(Color.decode("#a98c6a"));
        add(brick36, 360, 145);

        brick37 = new GRect(0, 0, 60, 10);
        brick37.setFilled(true);
        brick37.setColor(Color.decode("#a98c6a"));
        add(brick37, 430, 145);

        brick38 = new GRect(0, 0, 60, 10);
        brick38.setFilled(true);
        brick38.setColor(Color.decode("#a98c6a"));
        add(brick38, 500, 145);

        brick39 = new GRect(0, 0, 60, 10);
        brick39.setFilled(true);
        brick39.setColor(Color.decode("#a98c6a"));
        add(brick39, 570, 145);

        brick40 = new GRect(0, 0, 60, 10);
        brick40.setFilled(true);
        brick40.setColor(Color.decode("#a98c6a"));
        add(brick40, 640, 145);

        brick41 = new GRect(0, 0, 60, 10);
        brick41.setFilled(true);
        brick41.setColor(Color.decode("#f5f8eb"));
        add(brick41, 10, 160);

        brick42 = new GRect(0, 0, 60, 10);
        brick42.setFilled(true);
        brick42.setColor(Color.decode("#f5f8eb"));
        add(brick42, 80, 160);

        brick43 = new GRect(0, 0, 60, 10);
        brick43.setFilled(true);
        brick43.setColor(Color.decode("#f5f8eb"));
        add(brick43, 150, 160);

        brick44 = new GRect(0, 0, 60, 10);
        brick44.setFilled(true);
        brick44.setColor(Color.decode("#f5f8eb"));
        add(brick44, 220, 160);

        brick45 = new GRect(0, 0, 60, 10);
        brick45.setFilled(true);
        brick45.setColor(Color.decode("#f5f8eb"));
        add(brick45, 290, 160);

        brick46 = new GRect(0, 0, 60, 10);
        brick46.setFilled(true);
        brick46.setColor(Color.decode("#f5f8eb"));
        add(brick46, 360, 160);

        brick47 = new GRect(0, 0, 60, 10);
        brick47.setFilled(true);
        brick47.setColor(Color.decode("#f5f8eb"));
        add(brick47, 430, 160);

        brick48 = new GRect(0, 0, 60, 10);
        brick48.setFilled(true);
        brick48.setColor(Color.decode("#f5f8eb"));
        add(brick48, 500, 160);

        brick49 = new GRect(0, 0, 60, 10);
        brick49.setFilled(true);
        brick49.setColor(Color.decode("#f5f8eb"));
        add(brick49, 570, 160);

        brick50 = new GRect(0, 0, 60, 10);
        brick50.setFilled(true);
        brick50.setColor(Color.decode("#f5f8eb"));
        add(brick50, 640, 160);
    }

    public void setBall() {
        ball = new GOval(0,0, 16,16);
        ball.setFilled(true);
        ball.setColor(Color.decode("#9C4A1A"));
        add(ball, 342, 934);
        //
        /
    }
}