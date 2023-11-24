import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends GraphicsProgram {

    public GOval ball = null;
    public static int DELAY = 10;
    boolean menu = false;
    public GRect rocket;

    public void run() {
        this.setSize(710 + 14, 700 + 60);
        wallPaper();
        Member brick = new Member();
        for (int j = 1; j <= 5; ++j) {
            for (int i = 0; i < 10; ++i) {
                brick.ob = new GRect(10 + 70 * i, 100 + 15 * j, 60, 10);
                brick.index = i + 10 * (j - 1);
                add(brick.ob);
            }
        }
        rocket();
        setBall();
    }

    public void wallPaper() {
        GRect wallpaper = new GRect(0, 0, 710, 700);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#efe6d6"));
        add(wallpaper);
        addMouseListeners();
        addKeyListeners();
    }

    public void rocket() {
        rocket = new GRect(0, 0, 80, 7);
        rocket.setFilled(true);
        rocket.setColor(Color.decode("#666235"));
        add(rocket, 310, 600);
    }

    public void setBall() {
        ball = new GOval(0,0, 16,16);
        ball.setFilled(true);
        ball.setColor(Color.decode("#9C4A1A"));
        add(ball, 342, 934);
    }

    public void moveBall(int speedX, int speedY) {
        ball.move(speedX, speedY);
    }

//    public void mouseDragged(MouseEvent e) {
//        rocket.move(getM, 0);
//    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        /*while (ball.getX() <= getWidth()) {
            moveBall();
            pause(DELAY);
        }*/


        Timer T = new Timer();
        TimerTask Birthday = new TimerTask(){
            int i = 1, j = 1;
            int speedX = 5, speedY = -5;
            @Override
            public void run(){
                if (ball.getX() + ball.getWidth() + speedX <= getWidth()) {
                    moveBall(speedX, speedY);
                }
                if (ball.getX() + ball.getWidth() + speedX >= getWidth())
                    speedX *= -1;
                if (ball.getX() - ball.getWidth() + speedX >= 0 ){
                    moveBall(speedX, speedY);
                }
                if (ball.getX() - ball.getWidth() + speedX <= 0)
                    speedX *= -1;
                if (ball.getY() >= 0 && ball.getY() + speedY + ball.getHeight() <= getHeight())
                    moveBall(speedX, speedY);
                if (ball.getY() <= 0) {
                    speedY *= -1;
                }
                if (ball.getY() + speedY + ball.getHeight() >= getHeight())
                    T.cancel();
            }
        };
        T.scheduleAtFixedRate(Birthday, 0, 50);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int speed = 30;
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            if (rocket.getX() - 30 >= 0)
                rocket.setLocation(rocket.getX() - speed, rocket.getY());
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (rocket.getX() + rocket.getWidth() + 30 <= getWidth()) {
                rocket.setLocation(rocket.getX() + speed, rocket.getY());
            }
        }
    }
}

class Member extends GraphicsProgram{
    public GRect ob;
    public int index;
}