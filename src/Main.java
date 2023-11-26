import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends GraphicsProgram implements MouseListener{
    GRect wallpaper;
    public GOval ball = null;
    public static int DELAY = 10;
    boolean menu = false;
    public GRect rocket;
    private int cnt = 0;
    private int lifes = 3;
    private GImage heart1, heart2, heart3;
    public int speedX = 5, speedY = -5;

    public void run() {
        //gameUpload();
        loadWindow();


    }

    private void loadWindow(){
        this.setSize(500, 500);
        StartMenu inter = new StartMenu(this);
        int size = 26;
        inter.drawText(this, "Welcome", size, getWidth() / 2 - size - inter.getObText("Welcome").getWidth() / 2, 100);
        inter.drawButtonLVL(this);
        inter.button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAll();
                gameUploadMain();
            }
        });

        inter.button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAll();
                gameUploadMain2();
            }
        });

        inter.button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAll();
                gameUploadMain3();
            }
        });
    }

    public void gameUploadMain(){
        this.setSize(710 + 14, 700 + 60);
        /*wallPaper();
        Member brick = new Member();
        for (int j = 1; j <= 2; ++j) {
            for (int i = 0; i < 5; ++i) {
                brick.ob = new GRect(10 + 140 * i, 100 + 25 * j, 130, 20);
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
        addMouseListeners(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Timer T = new Timer();
                TimerTask Birthday = new TimerTask(){
                    @Override
                    public void run(){
                        if (ball.getY() <= rocket.getY()) {
                            //top
                            if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            } else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1)!= rocket
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            } else if (getElementAt(ball.getX(), ball.getY() - 1) != null
                                    && getElementAt(ball.getX(), ball.getY() - 1) != rocket
                                    && getElementAt(ball.getX(), ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX(), ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            }

                            //bottom
                            if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart3){
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }

                            //left
                            if (getElementAt(ball.getX() - 1, ball.getY()) != null
                                    && getElementAt(ball.getX() - 1, ball.getY()) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart3){
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY()));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()));
                                if(cntIsZero()) T.cancel();
                            }

                            //right
                            if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart3){
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart1
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart2
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()));
                                if(cntIsZero()) T.cancel();
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
                        if (ball.getY() + speedY + ball.getHeight() >= getHeight()) {
                            lifes--;
                            if (lifes == 2) {
                                T.cancel();
                                deleteLifes(heart3);
                            }
                            else if (lifes == 1) {
                                T.cancel();
                                deleteLifes(heart2);
                            }
                            else if (lifes == 0){
                                T.cancel();
                                deleteLifes(heart1);
                            }
                            if(lifes <= 0){
                                T.cancel();
                            }

                        }

                        if (isRocket(ball, speedX, speedY) || (getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1) != null
                                && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1) != null
                                && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1))
                                && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1)))) {
                            speedY *= -1;
                        }

                    }
                };
                T.scheduleAtFixedRate(Birthday, 0, 30);
            }
        });
        addKeyListeners();*/
        FirstLVL f = new FirstLVL(this);
        int cntL = f.lifes;
        f.rocket = rocket();
        f.ball = setBall();
        f.wallpaper = wallPaper();
        addLives(f, cntL);
        if (cntL == 3)
            f.gameUpload();
        f.wallpaper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!f.buttonPressed) {
                    f.movementOfBall();
                    f.buttonPressed = true;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
               f.movementOfRocke(e);
            }
        });
    }

    public void gameUploadMain2(){
        this.setSize(710 + 14, 700 + 60);
        /*wallPaper();
        Member brick = new Member();
        for (int j = 1; j <= 2; ++j) {
            for (int i = 0; i < 5; ++i) {
                brick.ob = new GRect(10 + 140 * i, 100 + 25 * j, 130, 20);
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
        addMouseListeners(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Timer T = new Timer();
                TimerTask Birthday = new TimerTask(){
                    @Override
                    public void run(){
                        if (ball.getY() <= rocket.getY()) {
                            //top
                            if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            } else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1)!= rocket
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            } else if (getElementAt(ball.getX(), ball.getY() - 1) != null
                                    && getElementAt(ball.getX(), ball.getY() - 1) != rocket
                                    && getElementAt(ball.getX(), ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX(), ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            }

                            //bottom
                            if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart3){
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }

                            //left
                            if (getElementAt(ball.getX() - 1, ball.getY()) != null
                                    && getElementAt(ball.getX() - 1, ball.getY()) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart3){
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY()));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()));
                                if(cntIsZero()) T.cancel();
                            }

                            //right
                            if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart3){
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart1
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart2
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()));
                                if(cntIsZero()) T.cancel();
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
                        if (ball.getY() + speedY + ball.getHeight() >= getHeight()) {
                            lifes--;
                            if (lifes == 2) {
                                T.cancel();
                                deleteLifes(heart3);
                            }
                            else if (lifes == 1) {
                                T.cancel();
                                deleteLifes(heart2);
                            }
                            else if (lifes == 0){
                                T.cancel();
                                deleteLifes(heart1);
                            }
                            if(lifes <= 0){
                                T.cancel();
                            }

                        }

                        if (isRocket(ball, speedX, speedY) || (getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1) != null
                                && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1) != null
                                && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1))
                                && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1)))) {
                            speedY *= -1;
                        }

                    }
                };
                T.scheduleAtFixedRate(Birthday, 0, 30);
            }
        });
        addKeyListeners();*/
        SecondLVL f = new SecondLVL(this);
        int cntL = f.lifes;
        f.rocket = rocket();
        f.ball = setBall();
        f.wallpaper = wallPaper();
        addLives2(f, cntL);
        if (cntL == 3)
            f.gameUpload();
        f.wallpaper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!f.buttonPressed) {
                    f.movementOfBall();
                    f.buttonPressed = true;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                f.movementOfRocke(e);
            }
        });
    }

    public void gameUploadMain3(){
        this.setSize(710 + 14, 700 + 60);
        /*wallPaper();
        Member brick = new Member();
        for (int j = 1; j <= 2; ++j) {
            for (int i = 0; i < 5; ++i) {
                brick.ob = new GRect(10 + 140 * i, 100 + 25 * j, 130, 20);
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
        addMouseListeners(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Timer T = new Timer();
                TimerTask Birthday = new TimerTask(){
                    @Override
                    public void run(){
                        if (ball.getY() <= rocket.getY()) {
                            //top
                            if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            } else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1)!= rocket
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            } else if (getElementAt(ball.getX(), ball.getY() - 1) != null
                                    && getElementAt(ball.getX(), ball.getY() - 1) != rocket
                                    && getElementAt(ball.getX(), ball.getY() - 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart1
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart2
                                    && getElementAt(ball.getX(), ball.getY() - 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX(), ball.getY() - 1));
                                if(cntIsZero()) T.cancel();
                            }

                            //bottom
                            if (getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart3){
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != null
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != rocket
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart1
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart2
                                    && getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1) != heart3) {
                                speedY *= -1;
                                remove(getElementAt(ball.getX(), ball.getY() + ball.getHeight() + 1));
                                if(cntIsZero()) T.cancel();
                            }

                            //left
                            if (getElementAt(ball.getX() - 1, ball.getY()) != null
                                    && getElementAt(ball.getX() - 1, ball.getY()) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY()) != heart3){
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY()));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != rocket
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart1
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart2
                                    && getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight()));
                                if(cntIsZero()) T.cancel();
                            }

                            //right
                            if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()) != heart3){
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY()));
                                if(cntIsZero()) T.cancel();
                            }
                            else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart1
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart2
                                    &&  getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                                if(cntIsZero()) T.cancel();
                            }else if (getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != rocket
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != wallpaper
                                    && heart1 != null && heart2 != null && heart3 != null
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart1
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart2
                                    && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()) != heart3) {
                                speedX *= -1;
                                remove(getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight()));
                                if(cntIsZero()) T.cancel();
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
                        if (ball.getY() + speedY + ball.getHeight() >= getHeight()) {
                            lifes--;
                            if (lifes == 2) {
                                T.cancel();
                                deleteLifes(heart3);
                            }
                            else if (lifes == 1) {
                                T.cancel();
                                deleteLifes(heart2);
                            }
                            else if (lifes == 0){
                                T.cancel();
                                deleteLifes(heart1);
                            }
                            if(lifes <= 0){
                                T.cancel();
                            }

                        }

                        if (isRocket(ball, speedX, speedY) || (getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1) != null
                                && getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1) != null
                                && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1))
                                && inCircle(ball, getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1)))) {
                            speedY *= -1;
                        }

                    }
                };
                T.scheduleAtFixedRate(Birthday, 0, 30);
            }
        });
        addKeyListeners();*/
        ThirdLVL f = new ThirdLVL(this);
        int cntL = f.lifes;
        f.rocket = rocket();
        f.ball = setBall();
        f.wallpaper = wallPaper();
        addLives3(f, cntL);
        if (cntL == 3)
            f.gameUpload();
        f.wallpaper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!f.buttonPressed) {
                    f.movementOfBall();
                    f.buttonPressed = true;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                f.movementOfRocke(e);
            }
        });
    }

    private void addLives(FirstLVL f, int cnt){
        heart1 = new GImage("heart.png", 10, 10);
        System.out.println(heart1.getWidth());
        heart2 = new GImage("heart.png");
        heart3 = new GImage("heart.png");
        heart1.scale(0.1);
        heart2.scale(0.1);
        heart3.scale(0.1);
        heart2.setLocation(20 + heart1.getWidth(), 10);
        heart3.setLocation(30 + heart1.getWidth() * 2, 10);
        if (cnt == 3) {
            f.heart1 = heart1;
            f.heart2 = heart2;
            f.heart3 = heart3;
        }
    }

    private void addLives2(SecondLVL f, int cnt){
        heart1 = new GImage("heart.png", 10, 10);
        System.out.println(heart1.getWidth());
        heart2 = new GImage("heart.png");
        heart3 = new GImage("heart.png");
        heart1.scale(0.1);
        heart2.scale(0.1);
        heart3.scale(0.1);
        heart2.setLocation(20 + heart1.getWidth(), 10);
        heart3.setLocation(30 + heart1.getWidth() * 2, 10);
        if (cnt == 3) {
            f.heart1 = heart1;
            f.heart2 = heart2;
            f.heart3 = heart3;
        }
    }

    private void addLives3(ThirdLVL f, int cnt){
        heart1 = new GImage("heart.png", 10, 10);
        System.out.println(heart1.getWidth());
        heart2 = new GImage("heart.png");
        heart3 = new GImage("heart.png");
        heart1.scale(0.1);
        heart2.scale(0.1);
        heart3.scale(0.1);
        heart2.setLocation(20 + heart1.getWidth(), 10);
        heart3.setLocation(30 + heart1.getWidth() * 2, 10);
        if (cnt == 3) {
            f.heart1 = heart1;
            f.heart2 = heart2;
            f.heart3 = heart3;
        }
    }

    public GRect wallPaper() {
        wallpaper = new GRect(0, 0, 710, 700);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#efe6d6"));
        return wallpaper;
    }

    public GRect rocket() {
        rocket = new GRect(310, 600, 80, 7);
        rocket.setFilled(true);
        rocket.setColor(Color.decode("#666235"));
        return rocket;
    }

    public GOval setBall() {
        GOval ball1 = new GOval(342, 300, 30,30);
        ball1.setFilled(true);
        ball1.setColor(Color.decode("#9C4A1A"));
        return ball1;
    }

    public void moveBall(int speedX, int speedY) {
        ball.move(speedX, speedY);
    }

    private boolean isRocket(GObject im, int speedX, int speedY){
        //bottom
        if (getElementAt(im.getX() + im.getWidth() / 2 + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;
        if (getElementAt(im.getX() + im.getWidth() + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;
        if (getElementAt(im.getX() + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
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
        removeAll();
    }

    private boolean cntIsZero(){
        cnt--;
        if (cnt <= 0){
            removeAll();
        }
        return cnt <= 0;
    }

    private void deleteLifes(GImage life){
        remove(life);
        remove(rocket);
        remove(ball);
        rocket();
        setBall();
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

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (mouseEvent.getX() >= 0 && mouseEvent.getX() <= getWidth() - rocket.getWidth())
            rocket.setLocation(mouseEvent.getX(), rocket.getY());
    }
}

class Member extends GraphicsProgram{
    public GRect ob;
    public int index;
}