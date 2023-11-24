import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends GraphicsProgram {
    GRect wallpaper;
    public GOval ball = null;
    public static int DELAY = 10;
    boolean menu = false;
    public GRect rocket;

    public void run() {
        this.setSize(710 + 14, 700 + 60);
        //wallPaper();
        Member brick = new Member();
        for (int j = 1; j <= 5; ++j) {
            for (int i = 0; i < 10; ++i) {
                brick.ob = new GRect(10 + 70 * i, 100 + 15 * j, 60, 10);
                brick.index = i + 10 * (j - 1);
                brick.ob.setFilled(true);
                brick.ob.setFillColor(Color.black);
                add(brick.ob);
            }
        }
        rocket();
        setBall();
        addMouseListeners();
        addKeyListeners();
    }

    public void wallPaper() {
        wallpaper = new GRect(0, 0, 710, 700);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#efe6d6"));
        add(wallpaper);
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
        add(ball, 342, 600-17);
    }

    public void moveBall(int speedX, int speedY) {
        ball.move(speedX, speedY);
    }

//    public void mouseDragged(MouseEvent e) {
//        rocket.move(getM, 0);
//    }


    private boolean isRocket(GObject im){
        //bottom
        if (getElementAt(im.getX() + im.getWidth() / 2, im.getY() + im.getHeight() + 1) == rocket)
            return true;
        else if (getElementAt(im.getX() + im.getWidth(), im.getY() + im.getHeight() + 1) == rocket)
            return true;
        else if (getElementAt(im.getX(), im.getY() + im.getHeight() + 1) == rocket)
            return true;
        return false;
    }

    private boolean inCircle(GObject balls, GObject getOb){
        double ballX = balls.getX() - 8, ballY = balls.getY() - 8;
        return Math.pow(ballX - getOb.getX(), 2) + Math.pow(ballY - getOb.getY(), 2) <= 64;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        /*while (ball.getX() <= getWidth()) {
            moveBall();
            pause(DELAY);
        }*/


        Timer T = new Timer();
        TimerTask Birthday = new TimerTask(){
            int speedX = 5, speedY = -5;
            @Override
            public void run(){
                if (ball.getY() <= rocket.getY()) {
                    //top
                    if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != null &&
                            getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1));
                    } else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != null &&
                            getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1)!= rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1));
                    } else if (getElementAt(ball.getX(), ball.getY() - 1) != null &&
                            getElementAt(ball.getX(), ball.getY() - 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX(), ball.getY() - 1));
                    }

                    //bottom
                    if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                     && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket){
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                    }
                    else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != null
                            && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1));
                    }else if (getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != null
                            && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1));
                    }

                    //left
                    if (getElementAt(ball.getX() - 1, ball.getY()) != null
                            && getElementAt(ball.getX() - 1, ball.getY()) != rocket){
                        speedX *= -1;
                        remove(getElementAt(ball.getX() - 1, ball.getY()));
                    }
                    else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                            && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                    }else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != null
                            && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()));
                    }

                    //right
                    if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != null
                            && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != rocket){
                        speedX *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()));
                    }
                    else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                            && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                    }else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != null
                            && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()));
                    }
                }

                if (ball.getX() + ball.getWidth() + speedX <= getWidth() || ball.getX() - ball.getWidth() + speedX >= 0)
                    moveBall(speedX, speedY);
                if (ball.getX() + ball.getWidth() + speedX >= getWidth() || ball.getX() + speedX <= 0)
                    speedX *= -1;

                if (ball.getY() >= 0 && ball.getY() + speedY + ball.getHeight() <= getHeight())
                    moveBall(speedX, speedY);
                if (ball.getY() + speedY <= 0) {
                    speedY *= -1;
                }
                if (ball.getY() + speedY + ball.getHeight() >= getHeight())
                    T.cancel();

                if (isRocket(ball)) {
                    speedY *= -1;
                }

            }
        };
        T.scheduleAtFixedRate(Birthday, 0, 200);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int speed = 50;
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            if (rocket.getX() - speed >= 0)
                rocket.setLocation(rocket.getX() - speed, rocket.getY());
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (rocket.getX() + rocket.getWidth() + speed <= getWidth()) {
                rocket.setLocation(rocket.getX() + speed, rocket.getY());
            }
        }
    }
}

class Member extends GraphicsProgram{
    public GRect ob;
    public int index;
}