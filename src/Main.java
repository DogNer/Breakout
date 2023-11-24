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
    private int cnt = 0;
    private int lifes = 3;
    private GImage heart1, heart2, heart3;

    public void run() {
        this.setSize(710 + 14, 700 + 60);
        //wallPaper();
        Member brick = new Member();
        for (int j = 1; j <= 2; ++j) {
            for (int i = 0; i < 5; ++i) {
                brick.ob = new GRect(10 + 140 * i, 100 + 15 * j, 130, 10);
                brick.index = i + 10 * (j - 1);
                brick.ob.setFilled(true);
                brick.ob.setFillColor(Color.black);
                add(brick.ob);
                cnt++;
            }
        }
        addLives();
        rocket();
        setBall();
        addMouseListeners();
        addKeyListeners();
    }

    private void addLives(){
        heart1 = new GImage("heart.png");
        heart2 = new GImage("heart.png");
        heart3 = new GImage("heart.png");
        heart1.scale(0.1);
        heart2.scale(0.1);
        heart3.scale(0.1);
        add(heart1, 10, 10);
        add(heart2, 20 + heart1.getWidth(), 10);
        add(heart3, 30 + heart1.getWidth() * 2, 10);
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

    private boolean inCircle(GOval balls, GObject getOb){
        double ballX = balls.getX() - 8, ballY = balls.getY() - 8;
        return Math.pow(ballX - getOb.getX(), 2) + Math.pow(ballY - getOb.getY(), 2) <= 64;
    }

    private void stopGameBad(){
        removeAll();
    }

    private boolean cntIsZero(){
        cnt--;
        if (cnt <= 0){
            removeAll();
        }
        return cnt <= 0;
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
                        if(cntIsZero()) T.cancel();
                    } else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != null &&
                            getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1)!= rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1));
                        if(cntIsZero()) T.cancel();
                    } else if (getElementAt(ball.getX(), ball.getY() - 1) != null &&
                            getElementAt(ball.getX(), ball.getY() - 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX(), ball.getY() - 1));
                        if(cntIsZero()) T.cancel();
                    }

                    //bottom
                    if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                     && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket){
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                        if(cntIsZero()) T.cancel();
                    }
                    else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != null
                            && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1));
                        if(cntIsZero()) T.cancel();
                    }else if (getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != null
                            && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != rocket) {
                        speedY *= -1;
                        remove(getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1));
                        if(cntIsZero()) T.cancel();
                    }

                    //left
                    if (getElementAt(ball.getX() - 1, ball.getY()) != null
                            && getElementAt(ball.getX() - 1, ball.getY()) != rocket){
                        speedX *= -1;
                        remove(getElementAt(ball.getX() - 1, ball.getY()));
                        if(cntIsZero()) T.cancel();
                    }
                    else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                            && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                        if(cntIsZero()) T.cancel();
                    }else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != null
                            && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()));
                        if(cntIsZero()) T.cancel();
                    }

                    //right
                    if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != null
                            && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != rocket){
                        speedX *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()));
                        if(cntIsZero()) T.cancel();
                    }
                    else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                            && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                        if(cntIsZero()) T.cancel();
                    }else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != null
                            && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != rocket) {
                        speedX *= -1;
                        remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()));
                        if(cntIsZero()) T.cancel();
                    }
                }

                if (getElementAt(ball.getX() - 1, ball.getY() - 1) == rocket && inCircle(ball, getElementAt(ball.getX() - 1, ball.getY() - 1))){
                    speedY *= -1;
                    remove(getElementAt(ball.getX(), ball.getY()));
                    if(cntIsZero()) T.cancel();
                }
                if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() - 1) == rocket && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() - 1))){
                    speedY *= -1;
                    remove(getElementAt(ball.getX(), ball.getY()));
                    if(cntIsZero()) T.cancel();
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
                if (ball.getY() + speedY + ball.getHeight() >= getHeight()) {
                    lifes--;
                    if (lifes == 2) {
                        T.cancel();
                        remove(heart3);
                        remove(rocket);
                        remove(ball);
                        rocket();
                        setBall();
                        speedX = 5;
                        speedY = -5;
                    }
                    else if (lifes == 1) {
                        T.cancel();
                        remove(heart2);
                        remove(rocket);
                        remove(ball);
                        rocket();
                        setBall();
                        speedX = 5;
                        speedY = -5;
                    }
                    else if (lifes == 0){
                        T.cancel();
                        remove(heart1);
                        remove(rocket);
                        remove(ball);
                        rocket();
                        setBall();
                        speedX = 5;
                        speedY = -5;
                    }
                    if(lifes <= 0) T.cancel();

                }

                if (isRocket(ball)) {
                    speedY *= -1;
                }

            }
        };
        T.scheduleAtFixedRate(Birthday, 0, 50);
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