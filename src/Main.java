import acm.graphics.*;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.random.RandomGenerator;

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

    public void run() {
        //gameUpload();
        loadWindow();
        IODialog dialog = new IODialog();
        dialog.println("Вітаємо Вас у грі \"Breakout\"! \n " +
                "Правила гри: \n " +
                "Вам потрібно збити всі цеглинки, щоб перемогти. " +
                "У вас є три житті, якщо Вам не вдалось це зробити за три спроби - Ви програли." +
                "\nУправління: " +
                "\n В головному меню оберіть рівень, натиснувши два рази на кнопку рівня." +
                "\n Натисніть на м'ячик, щоб розпочати гру." +
                "\n Затисніть кнопку на ракетці і рухайте мишкою, щоб керувати ракеткою");


    }

    public void loadWindow(){
        this.setSize(500, 500);
        StartMenu inter = new StartMenu(this);
        int size = 26;
        inter.wallpaper();
        inter.drawButtonLVL(this);
        inter.drawText(this, "Welcome", size, getWidth() / 2 - size - inter.getObText("Welcome").getWidth() / 2, 100);
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

        inter.button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAll();
                IODialog dialog = new IODialog();
                dialog.println("Дякуємо за гру");
            }
        });
    }

    public void gameUploadMain(){
        this.setSize(710 + 16, 700 + 60);
        FirstLVL f = new FirstLVL(this);
        int cntL = f.lifes;
        f.rocket = rocket();
        f.ball = setBall(26);
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
        this.setSize(710 + 16, 700 + 60);

        SecondLVL f = new SecondLVL(this);
        int cntL = f.lifes;
        f.rocket = rocket();
        f.ball = setBall(26);
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
        this.setSize(710 + 16, 700 + 60);
        ThirdLVL f = new ThirdLVL(this);
        int cntL = f.lifes;
        f.rocket = rocket();
        f.ball = setBall(16);
        f.wallpaper = wallPaper();
        addLives3(f, cntL);
        if (cntL == 3)
            f.gameUpload();
        f.wallpaper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!f.buttonPressed) {
                    f.movementOfBall();
                    f.genBomb();
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
        rocket = new GRect(310, 600, 100, 20);
        rocket.setFilled(true);
        rocket.setColor(Color.decode("#666235"));
        return rocket;
    }

    private RandomGenerator rgen = RandomGenerator.getDefault();
    public GOval setBall(int r) {
        GOval ball1 = new GOval(rgen.nextInt(50, this.getWidth() - 50), rgen.nextInt(300,500), r,r);
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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

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