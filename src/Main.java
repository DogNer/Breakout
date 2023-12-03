/**
 * Розробити гру Breakout
 *
 * File: Laba
 * Autors: Ноженко Артур, Мущенко Дана
 */

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
    public int points = 0;
    public GLabel pointsLabel;

    public void run() {
        loadWindow();
        IODialog dialog = new IODialog();
        dialog.println("Вітаємо Вас у грі \"Breakout\"! \n " +
                "Правила гри: \n " +
                "Вам потрібно збити всі цеглинки, щоб перемогти. " +
                "У вас є три житті, якщо Вам не вдалось це зробити за три спроби - Ви програли." +
                "\nУправління: " +
                "\n В головному меню оберіть рівень, натиснувши два рази на кнопку рівня." +
                "\n Натисніть на м'ячик, щоб розпочати гру." +
                "\n Затисніть кнопку на ракетці і рухайте мишкою, щоб керувати ракеткою" +
                "\n Натисніть esc, щоб поставити гру на паузу" +
                "\n Розробники: Мущенко Дана та Ноженко Артур");


    }

    /**
     * запускає стартове меню
     */
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


    /**
     * запускає перший рівень
     */
    public void gameUploadMain(){
        this.setSize(710 + 16, 700 + 60);
        FirstLVL f = new FirstLVL(this);
        int cntL = f.lifes;
        int pointsL = f.points;
        f.rocket = rocket();
        f.ball = setBall(26);
        f.wallpaper = wallPaper();
        f.pointsLabel = addPoints1(f, pointsL);
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

    /**
     * запускає другий рівень
     */
    public void gameUploadMain2(){
        this.setSize(710 + 16, 700 + 60);

        SecondLVL f = new SecondLVL(this);
        int cntL = f.lifes;
        int pointsL = f.points;
        f.rocket = rocket();
        f.ball = setBall(18);
        f.wallpaper = wallPaper();
        f.pointsLabel = addPoints2(f, pointsL);
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

    /**
     * запускає третій  рівень
     */
    public void gameUploadMain3(){
        this.setSize(710 + 16, 700 + 60);
        ThirdLVL f = new ThirdLVL(this);
        int cntL = f.lifes;
        int pointsL = f.points;
        f.rocket = rocket();
        f.ball = setBall(16);
        f.wallpaper = wallPaper();
        f.pointsLabel = addPoints3(f, pointsL);
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

    /**
     * додає життя для першого рівня
     * @param f об'єкт класу FirstLVL
     * @param cnt кількість життів
     */
    private void addLives(FirstLVL f, int cnt){
        heart1 = new GImage("heart.png", 10, 10);
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

    /**
     * додає життя для другого рівня
     * @param f об'єкт класу SecondLVL
     * @param cnt кількість життів
     */
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

    /**
     * додає життя для третього рівня
     * @param f об'єкт класу ThirdLVL
     * @param cnt кількість життів
     */
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

    /**
     * додає фон
     * @return об’єкт фону
     */
    public GRect wallPaper() {
        wallpaper = new GRect(0, 0, 710, 700);
        wallpaper.setFilled(true);
        wallpaper.setColor(Color.decode("#efe6d6"));
        return wallpaper;
    }


    /**
     * додає ракетку на екран
     * @return об'єкт ракетки
     */
    public GRect rocket() {
        rocket = new GRect(310, 600, 100, 20);
        rocket.setFilled(true);
        rocket.setColor(Color.decode("#666235"));
        return rocket;
    }

    private RandomGenerator rgen = RandomGenerator.getDefault();


    /**
     * розміщує м’яч на екран
     * @param r значення діаметра
     * @return об’єкт м’яча
     */
    public GOval setBall(int r) {
        GOval ball1 = new GOval(rgen.nextInt(50, this.getWidth() - 50), rgen.nextInt(300,500), r,r);
        ball1.setFilled(true);
        ball1.setColor(Color.decode("#9C4A1A"));
        return ball1;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }


    /**
     * рухає ракетку по екрану
     * @param mouseEvent the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (mouseEvent.getX() >= 0 && mouseEvent.getX() <= getWidth() - rocket.getWidth())
            rocket.setLocation(mouseEvent.getX(), rocket.getY());
    }


    /**
     * додає лічильник очок для першого рівня
     * @param f об'єкт класу FirstLVL
     * @param points кількість очок
     * @return об’єкт з написом кількості очок
     */
    public GLabel addPoints1(FirstLVL f, int points) {
        String pointsText = "" + points;
        GLabel pointsLabel = new GLabel(pointsText, 670, 30);
        pointsLabel.setFont("Arial-40");
        pointsLabel.setColor(Color.RED);
        return pointsLabel;
    }

    /**
     * додає лічильник очок для другого рівня
     * @param f об'єкт класу SecondLVL
     * @param points кількість очок
     * @return Повертаємо об’єкт з написом кількості очок
     */
    public GLabel addPoints2(SecondLVL f, int points) {
        String pointsText = "" + points;
        GLabel pointsLabel = new GLabel(pointsText, 670, 30);
        pointsLabel.setFont("Arial-40");
        pointsLabel.setColor(Color.RED);
        return pointsLabel;
    }

    /**
     * додає лічильник очок для третього рівня
     * @param f об'єкт класу ThirdLVL
     * @param points кількість очок
     * @return об’єкт з написом кількості очок
     */
    public GLabel addPoints3(ThirdLVL f, int points) {
        String pointsText = "" + points;
        GLabel pointsLabel = new GLabel(pointsText, 665, 30);
        pointsLabel.setFont("Arial-40");
        pointsLabel.setColor(Color.RED);
        return pointsLabel;
    }
}
class Member extends GraphicsProgram{
    public GRect ob;
    public int index;
}