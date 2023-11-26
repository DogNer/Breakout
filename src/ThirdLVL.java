import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class ThirdLVL extends GraphicsProgram implements MouseListener {
    GRect wallpaper;
    public GOval ball = null;
    public static int DELAY = 10;
    boolean menu = false;
    public GRect rocket;
    private int cnt = 0;
    public int lifes = 3;
    public GImage heart1 = null, heart2 = null, heart3 = null;
    public int speedX = 5, speedY = -5;
    private Main main;

    public boolean buttonPressed = false;

    public ThirdLVL(Main main) {
        this.main = main;
    }

    public void gameUpload(){
        main.add(wallpaper);
        Member brick = new Member();
        for (int j = 1; j <= 7; ++j) {
            for (int i = 0; i < 10; ++i) {
                brick.ob = new GRect(10 + 70 * i, 100 + 15 * j, 60, 10);
                brick.index = i + 10 * (j - 1);
                brick.ob.setFilled(true);
                switch (j) {
                    case 1:
                        brick.ob.setFillColor(Color.decode("#020201"));
                        break;
                    case 2:
                        brick.ob.setFillColor(Color.decode("#6f859b"));
                        break;
                    case 3:
                        brick.ob.setFillColor(Color.decode("#7c8f78"));
                        break;
                    case 4:
                        brick.ob.setFillColor(Color.decode("#a98c6a"));
                        break;
                    case 5:
                        brick.ob.setFillColor(Color.decode("#f5f8eb"));
                        break;
                    case 6:
                        brick.ob.setFillColor(Color.decode("#817474"));
                        break;
                    case 7:
                        brick.ob.setFillColor(Color.decode("#71713b"));
                        break;
                }

                main.add(brick.ob);
                cnt++;
            }
        }
        if (heart1 != null)
            main.add(heart1);
        if (heart2 != null)
            main.add(heart2);
        if (heart3 != null)
            main.add(heart3);
        //addLives();
        //rocket();
        main.add(rocket);
        //setBall();
        main.add(ball);
    }

    public void movementOfBall(){

        Timer T = new Timer();
        TimerTask g = new TimerTask(){
            @Override
            public void run(){
                if (ball.getY() <= rocket.getY()) {
                    //top
                    if (main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart3) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1));
                        if(cntIsZero()) T.cancel();
                    } else if (main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1)!= rocket
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart3) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1));
                        if(cntIsZero()) T.cancel();
                    } else if (main.getElementAt(ball.getX(), ball.getY() - 1) != null
                            && main.getElementAt(ball.getX(), ball.getY() - 1) != rocket
                            && main.getElementAt(ball.getX(), ball.getY() - 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX(), ball.getY() - 1) != heart1
                            && main.getElementAt(ball.getX(), ball.getY() - 1) != heart2
                            && main.getElementAt(ball.getX(), ball.getY() - 1) != heart3) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX(), ball.getY() - 1));
                        if(cntIsZero()) T.cancel();
                    }

                    //bottom
                    if (main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart3){
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                        if(cntIsZero()) T.cancel();
                    }
                    else if (main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart3) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1));
                        if(cntIsZero()) T.cancel();
                    }else if (main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != null
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != rocket
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart1
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart2
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart3) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1));
                        if(cntIsZero()) T.cancel();
                    }

                    //left
                    if (main.getElementAt(ball.getX() - 1, ball.getY()) != null
                            && main.getElementAt(ball.getX() - 1, ball.getY()) != rocket
                            && main.getElementAt(ball.getX() - 1, ball.getY()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() - 1, ball.getY()) != heart1
                            && main.getElementAt(ball.getX() - 1, ball.getY()) != heart2
                            && main.getElementAt(ball.getX() - 1, ball.getY()) != heart3){
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() - 1, ball.getY()));
                        if(cntIsZero()) T.cancel();
                    }
                    else if (main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart1
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart2
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                        if(cntIsZero()) T.cancel();
                    }else if (main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != null
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != rocket
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart1
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart2
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart3) {
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()));
                        if(cntIsZero()) T.cancel();
                    }

                    //right
                    if (main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart3){
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()));
                        if(cntIsZero()) T.cancel();
                    }
                    else if (main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket
                            &&  main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            &&  main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart1
                            &&  main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart2
                            &&  main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                        if(cntIsZero()) T.cancel();
                    }else if (main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart3) {
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()));
                        if(cntIsZero()) T.cancel();
                    }
                }

                if (ball.getX() + ball.getWidth() + speedX <= main.getWidth() || ball.getX() - ball.getWidth() + speedX >= 0)
                    moveBall(speedX, speedY);
                if (ball.getX() + ball.getWidth() + speedX >= main.getWidth() || ball.getX() + speedX <= 0)
                    speedX *= -1;

                if (ball.getY() >= 0 && ball.getY() + speedY + ball.getHeight() <= main.getHeight())
                    moveBall(speedX, speedY);
                if (ball.getY() + speedY <= 0) {
                    speedY *= -1;
                }
                if (ball.getY() + speedY + ball.getHeight() >= main.getHeight()) {
                    lifes--;
                    if (lifes == 2){
                        deleteLifes(heart3);
                        T.cancel();
                        buttonPressed = false;
                    }
                    else if (lifes == 1){
                        deleteLifes(heart2);
                        T.cancel();
                        buttonPressed = false;
                    }
                    else if(lifes == 0){
                        main.removeAll();
                        T.cancel();
                    }

                }

                if (isRocket(ball, speedX, speedY) || (main.getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1) != null
                        && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1) != null
                        && inCircle(ball, main.getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1))
                        && inCircle(ball, main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1)))) {
                    speedY *= -1;
                }

            }
        };
        T.scheduleAtFixedRate(g, 0, 30);
    }
    public void addLives(){
        heart1 = new GImage("heart.png");
        heart2 = new GImage("heart.png");
        heart3 = new GImage("heart.png");
        heart1.scale(0.1);
        heart2.scale(0.1);
        heart3.scale(0.1);
        main.add(heart1, 10, 10);
        main.add(heart2, 20 + heart1.getWidth(), 10);
        main.add(heart3, 30 + heart1.getWidth() * 2, 10);
    }

    public void wallPaper() {
        wallpaper = new GRect(0, 0, 710, 700);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#efe6d6"));
        main.add(wallpaper);
    }

    public GRect getRocket() {
        return rocket;
    }

    public void setRocket(GRect rocket) {
        this.rocket = rocket;
    }

    public void setBall() {
        ball = new GOval(0,0, 30,30);
        ball.setFilled(true);
        ball.setColor(Color.decode("#9C4A1A"));
        main.add(ball, 325, 300);
    }

    public void moveBall(int speedX, int speedY) {
        ball.move(speedX, speedY);
    }

    private boolean isRocket(GObject im, int speedX, int speedY){
        //bottom
        if (main.getElementAt(im.getX() + im.getWidth() / 2 + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;
        if (main.getElementAt(im.getX() + im.getWidth() + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;
        if (main.getElementAt(im.getX() + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;

        return false;
    }

    private boolean inCircle(GOval balls, GObject getOb){
        double ballX = balls.getX() - 8, ballY = balls.getY() - 8;
        if (getOb != null && getOb != wallpaper && getOb != heart1 && getOb != heart2 && getOb != heart3)
            return Math.pow(ballX - getOb.getX(), 2) + Math.pow(ballY - getOb.getY(), 2) <= 64;
        return false;
    }

    private void stopGameBad(){
        main.removeAll();
    }

    private boolean cntIsZero(){
        cnt--;
        if (cnt <= 0){
            main.removeAll();
            IODialog dialog = new IODialog();
            dialog.println("Вітаю! Ви пройшли третій рівень");
        }
        return cnt <= 0;
    }

    private void deleteLifes(GImage life){
        main.remove(life);
        rocket.setLocation(310, 600);
        ball.setLocation(342, 300);
        //rocket();
        speedX = 5;
        speedY = -5;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        /*while (ball.getX() <= getWidth()) {
            moveBall();
            pause(DELAY);
        }*/
    }

    public void movementOfRocke(MouseEvent mouseEvent){
        if (mouseEvent.getX() >= 0 && mouseEvent.getX() <= main.getWidth() - this.rocket.getWidth())
            this.rocket.setLocation(mouseEvent.getX(), this.rocket.getY());
    }
}



