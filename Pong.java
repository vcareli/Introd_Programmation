import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JPanel {

    // --- Constantes ---
    static final int W = 600, H = 400, BALL = 15;
    static final int PW = 15, PH = 80, AIH = 60, SPEED = 5;

    // --- État du jeu via records mutables simulés avec des tableaux ---
    int ballX = W/2, ballY = H/2;
    int velX = 3, velY = 3;
    int p1Y = 150, p2Y = 150;
    int score1 = 0, score2 = 0;
    boolean up, down;

    public Pong() {
        setPreferredSize(new Dimension(W, H));
        setBackground(Color.BLACK);
        setFocusable(true);

        // KeyListener en lambda (Java 21 : adapter anonyme simplifié)
        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP   -> up   = true;
                    case KeyEvent.VK_DOWN -> down = true;
                }
            }
            @Override public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP   -> up   = false;
                    case KeyEvent.VK_DOWN -> down = false;
                }
            }
        });

        // Timer avec lambda au lieu d'implémenter ActionListener
        new Timer(10, e -> update()).start();
    }

    void update() {
        // Joueur 1
        if (up   && p1Y > 0)        p1Y -= SPEED;
        if (down && p1Y < H - PH)   p1Y += SPEED;

        // IA (joueur 2)
        if (velX > 0) {
            if (p2Y + AIH/2 < ballY && p2Y < H - AIH) p2Y += 3;
            else if (p2Y + AIH/2 > ballY && p2Y > 0)  p2Y -= 3;
        }

        // Déplacement balle
        ballX += velX;
        ballY += velY;

        // Rebond haut/bas
        if (ballY <= 0 || ballY >= H - BALL) velY = -velY;

        // Collision raquette 1
        if (ballX <= 35 && ballX >= 20 && ballY >= p1Y - BALL && ballY <= p1Y + PH) {
            if (velX < 0) velX = -velX;
            velX++;
        }

        // Collision raquette 2
        if (ballX >= 550 && ballX <= 565 && ballY >= p2Y - BALL && ballY <= p2Y + AIH) {
            if (velX > 0) velX = -velX;
            velX--;
        }

        // Points & reset
        if (ballX < 0)      { score2++; reset(); }
        if (ballX > W)      { score1++; reset(); }

        repaint();
    }

    void reset() {
        ballX = W/2 - BALL/2;
        ballY = H/2 - BALL/2;
        velX  = Math.random() > 0.5 ? 3 : -3;
        velY  = Math.random() > 0.5 ? 3 : -3;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(20,  p1Y, PW, PH);           // Raquette 1
        g.fillRect(565, p2Y, PW, AIH);           // Raquette 2
        g.fillOval(ballX, ballY, BALL, BALL);    // Balle

        g.setColor(Color.GRAY);
        for (int i = 0; i < H; i += 20)
            g.fillRect(300, i, 2, 10);           // Ligne centrale

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(String.valueOf(score1), 220, 50);
        g.drawString(String.valueOf(score2), 360, 50);
    }

    public static void main(String[] args) {
        var frame = new JFrame("Pong");
        frame.add(new Pong());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
