/**
 * Розробити гру Breakout
 *
 * File: Laba
 * Autors: Ноженко Артур, Мущенко Дана
 */

import acm.graphics.*;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class FirstLVL extends GraphicsProgram implements MouseListener, KeyListener {
    GRect wallpaper;
    public GOval ball = null;
    public static int DELAY = 10;
    boolean menu = false;
    public GRect rocket;
    private int cnt = 0;
    public int lifes = 3;
    public GImage heart1 = null, heart2 = null, heart3 = null;
    public int speedX = 3, speedY = -4;
    private Main main;
    private Clip clip;
    private boolean soundLoaded;
    private Clip clipBack;
    private final String pathToClip = "/Users/danam/Videos/hit.wav";
    private final String pathToClipLostLife = "/Users/danam/Videos/lostlife.wav";
    private final String pathToClipWin = "/Users/danam/Videos/winSound.wav";
    private final String pathToClipBackMusic = "/Users/danam/Videos/backSounds.wav";
    private boolean soundLoadedBack;

    public boolean buttonPressed = false;
    private static final int NUMBEROFBRICKS = 1;
    private static final int DISTANCEBETWEENBRICKS = 1;

    private TimerTask tmp = null;
    public boolean stopKey = true;
    public int points = 0;
    public GLabel pointsLabel;
    public String pointsText = "";

    public FirstLVL(Main main) {
        this.main = main;
    }

    /**
     * метод, який додає цеглинки, ракетку, м’яч, житті
     */
    public void gameUpload(){
        addSoundBackSound(pathToClipBackMusic);
        main.add(wallpaper);
        main.add(pointsLabel);
        Member brick = new Member();
        for (int j = 1; j <= 5; ++j) {
            for (int i = 0; i < 5; ++i) {
                brick.ob = new GRect(10 + 140 * i, 100 + 15 * j, 130, 10);
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
        main.add(rocket);
        main.add(ball);

    }


    /**
     * метод, що дозволяє ставити гру на паузу
     */
    public void movementOfBall() {
        tmp = timerMove();
        main.addKeyListeners(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE ->{
                        if(tmp != null) {
                            tmp.cancel();
                            tmp = null;
                            long clipTimePos = clipBack.getMicrosecondPosition();
                            clipBack.stop();

                            IODialog dialog = new IODialog();
                            String res = dialog.readLine("Гра на паузі." + '\n' + "Хочете вийти в головне меню? 1 - Так, 0 - Ні");

                            if (res.equalsIgnoreCase("yes") || res.equalsIgnoreCase("1")
                                    || res.equalsIgnoreCase("так")) {
                                speedX = 3;
                                speedY = -4;
                                main.removeAll();
                                main.loadWindow();
                                buttonPressed = false;
                            } else {
                                clipBack.setMicrosecondPosition(clipTimePos);
                                clipBack.start();
                                buttonPressed = false;
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * метод, що описує логіку гри і дозволяє ставити гру на паузу
     * @return значення таймеру
     */
    private TimerTask timerMove(){
        Timer T = new Timer();
        TimerTask g = new TimerTask() {
            @Override
            public void run() {
                if (ball.getY() <= rocket.getY()) {
                    //top
                    if (main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != heart3
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1) != pointsLabel) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() - 1));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();

                    }

                    //bottom
                    else if (main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != heart3
                            && main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1) != pointsLabel) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight() + 1));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();

                    }

                    //left
                    else if (main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != null
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != rocket
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart1
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart2
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != heart3
                            && main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2) != pointsLabel) {
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() - 1, ball.getY() + ball.getHeight() / 2));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();

                    }

                    //right
                    else if (main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != heart3
                            && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2) != pointsLabel) {
                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() / 2));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();

                    }

                    else if (main.getElementAt(ball.getX(), ball.getY()) != null
                            && main.getElementAt(ball.getX(), ball.getY()) != rocket
                            && main.getElementAt(ball.getX(), ball.getY()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX(), ball.getY()) != heart1
                            && main.getElementAt(ball.getX(), ball.getY()) != heart2
                            && main.getElementAt(ball.getX(), ball.getY()) != heart3
                            && main.getElementAt(ball.getX(), ball.getY()) != pointsLabel) {

                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX(), ball.getY()));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();

                    }
                    else if (main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != heart3
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()) != pointsLabel) {

                        speedX *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth(), ball.getY()));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();

                    }
                    else if (main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != rocket
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != heart1
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != heart2
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != heart3
                            && main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()) != pointsLabel) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight()));
                        cnt--;
                        points += 1;
                        changePoints();

                        if (cntIsZero()) T.cancel();
                    }
                    else if (main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != null
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != rocket
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != wallpaper
                            && heart1 != null && heart2 != null && heart3 != null
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != heart1
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != heart2
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != heart3
                            && main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()) != pointsLabel) {
                        speedY *= -1;
                        main.remove(main.getElementAt(ball.getX(), ball.getY() + ball.getHeight()));
                        cnt--;
                        points += 1;
                        changePoints();
                        if (cntIsZero()) T.cancel();
                    }
                }

                if (ball.getX() + ball.getWidth() + speedX <= main.getWidth() || ball.getX() - ball.getWidth() + speedX >= 0)
                    moveBall(speedX, speedY);
                if (ball.getX() + ball.getWidth() + speedX >= main.getWidth() || ball.getX() + speedX <= 0) {
                    addSound(pathToClip);
                    speedX *= -1;
                }
                if (ball.getY() >= 0 && ball.getY() + speedY + ball.getHeight() <= main.getHeight())
                    moveBall(speedX, speedY);
                if (ball.getY() + speedY <= 0) {
                    addSound(pathToClip);
                    speedY *= -1;
                }
                if (ball.getY() + speedY + ball.getHeight() >= main.getHeight()) {
                    lifes--;
                    if (tmp != null) {
                        tmp.cancel();
                        tmp = null;
                    }
                    if (lifes == 2) {
                        deleteLifes(heart3);
                        T.cancel();
                        buttonPressed = false;
                    } else if (lifes == 1) {
                        deleteLifes(heart2);
                        T.cancel();
                        buttonPressed = false;
                    } else if (lifes == 0) {
                        T.cancel();
                        windowIfLost();
                    }
                }

                if (isRocket(ball, speedX, speedY) || (main.getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1) != null
                        && main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1) != null
                        && inCircle(ball, main.getElementAt(ball.getX() + ball.getWidth() - 1, ball.getY() + ball.getHeight() + 1))
                        && inCircle(ball, main.getElementAt(ball.getX() + ball.getWidth() + 1, ball.getY() + ball.getHeight() + 1)))) {
                    addSound(pathToClip);
                    speedY *= -1;
                }
            }
        };
        T.scheduleAtFixedRate(g, 0, 30);

        return g;
    }

    /**
     * метод, що рухає м’яч
     * @param speedX  значення швидкості по Х
     * @param speedY  значення швидкості по У
     */
    public void moveBall(int speedX, int speedY) {
        ball.move(speedX, speedY);
    }


    /**
     * метод, що перевіряє зіткнення м’яча та ракетки
     * @param im значення м’яча
     * @param speedX координати м’яча по х
     * @param speedY координати м’яча по у
     * @return чи м'яч стикається з ракеткою
     */
    private boolean isRocket(GObject im, int speedX, int speedY) {
        //bottom
        if (main.getElementAt(im.getX() + im.getWidth() / 2 + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;
        if (main.getElementAt(im.getX() + im.getWidth() + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;
        if (main.getElementAt(im.getX() + speedX, im.getY() + im.getHeight() + 1 + speedY) == rocket)
            return true;

        return false;
    }


    /**
     * метод, що перевіряє зіткнення м’яча з якимось об’єктом
     * @param balls значення м’яча
     * @param getOb значення об’єкта
     * @return чи м'яч стикається з об’єктом
     */
    private boolean inCircle(GOval balls, GObject getOb){
        double ballX = balls.getX() - 8, ballY = balls.getY() - 8;
        if (getOb != null && getOb != wallpaper && getOb != heart1 && getOb != heart2 && getOb != heart3)
            return Math.pow(ballX - getOb.getX(), 2) + Math.pow(ballY - getOb.getY(), 2) <= 64;
        return false;
    }

    /**
     * метод, що виводить діалогове вікно при перемозі
     */
    private void windowIfWin() {
        IODialog dialog = new IODialog();
        dialog.println("Вітаю! Ви пройшли перший рівень");
        main.removeAll();
        main.loadWindow();
    }

    /**
     * метод, що виводить діалогове вікно при поразці
     */
    private void windowIfLost() {
        clipBack.stop();
        addSound(pathToClipLostLife);
        IODialog dialog = new IODialog();
        dialog.println("На жаль, ви програли.");
        main.removeAll();
        main.loadWindow();
    }

    /**
     * метод, що перевіряє, чи залишились ще цеглинки
     * @return чи залишились цеглинки
     */
    private boolean cntIsZero() {
        if (cnt <= 0){
            tmp.cancel();
            addSound(pathToClip);
            addSound(pathToClipWin);
            clipBack.stop();
            windowIfWin();
        }
        else addSound(pathToClip);
        return cnt <= 0;
    }

    /**
     * метод, що видаляє життя, коли ми його втратили
     * @param life зображення життя
     */
    private void deleteLifes(GImage life) {
        addSound(pathToClipLostLife);
        main.remove(life);
        rocket.setLocation(310, 600);
        ball.setLocation(342, 300);
        //rocket();
        speedX = 3;
        speedY = -4;
    }

    /**
     * метод, що додає звукові ефекти
     * @param path шлях до файлу з музикою
     */
    private void addSound(String path) {
        try {
            File file = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            soundLoaded = true;
        }
        catch (UnsupportedAudioFileException e) {
            soundLoaded = false;
            e.printStackTrace();
        }
        catch (IOException e) {
            soundLoaded = false;
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            soundLoaded = false;
            e.printStackTrace();
        }

        clip.start();
    }


    /**
     * метод, що додає музику на задній план
     * @param path шлях до файлу з музикою
     */
    private void addSoundBackSound(String path) {
        try {
            File file = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            clipBack = AudioSystem.getClip();
            clipBack.open(audioIn);
            soundLoadedBack = true;
        }
        catch (UnsupportedAudioFileException e) {
            soundLoadedBack = false;
            e.printStackTrace();
        }
        catch (IOException e) {
            soundLoadedBack = false;
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            soundLoadedBack = false;
            e.printStackTrace();
        }

        clipBack.start();
    }


    /**
     * метод, що не дозволяє ракетці виходити за межі вікна
     * @param mouseEvent
     */
    public void movementOfRocke(MouseEvent mouseEvent){
        if (mouseEvent.getX() >= 0 && mouseEvent.getX() <= main.getWidth() - this.rocket.getWidth())
            this.rocket.setLocation(mouseEvent.getX(), this.rocket.getY());
    }

    /**
     * лічильник збитих цеглинок
     */
    public void changePoints() {
        main.remove(pointsLabel);
        pointsText = "" + points;
        pointsLabel = new GLabel(pointsText, 665, 30);
        pointsLabel.setFont("Arial-40");
        pointsLabel.setColor(Color.RED);
        main.add(pointsLabel);
    }


}


