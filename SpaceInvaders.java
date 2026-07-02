import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Space Invaders
 * Compile : javac SpaceInvaders.java
 * Exécute : java SpaceInvaders
 */
public class SpaceInvaders extends JPanel implements ActionListener, KeyListener {

    // ── Constantes ──────────────────────────────────────────────────────────
    static final int W = 800, H = 600;
    static final int PLAYER_SPEED = 5;
    static final int BULLET_SPEED = 10;
    static final int ENEMY_ROWS = 4, ENEMY_COLS = 11;
    static final int ENEMY_W = 36, ENEMY_H = 24;
    static final int ENEMY_GAP_X = 14, ENEMY_GAP_Y = 16;
    static final int ENEMY_STEP_DOWN = 16;
    static final int ENEMY_MOVE_INTERVAL = 40; // ticks entre chaque mouvement ennemi
    static final Color BG      = new Color(5, 5, 20);
    static final Color PLAYER_COLOR  = new Color(80, 220, 120);
    static final Color BULLET_COLOR  = new Color(255, 230, 50);
    static final Color ENEMY_BOMB_COLOR = new Color(255, 80, 80);
    static final Color[] ENEMY_COLORS = {
        new Color(255, 100, 200),
        new Color(120, 180, 255),
        new Color(255, 165, 60),
        new Color(160, 255, 160)
    };

    // ── État du jeu ──────────────────────────────────────────────────────────
    record Rect(int x, int y, int w, int h) {
        boolean intersects(Rect o) {
            return x < o.x + o.w && x + w > o.x && y < o.y + o.h && y + h > o.y;
        }
    }

    static class Entity {
        int x, y, w, h;
        boolean alive = true;
        Entity(int x, int y, int w, int h) { this.x=x; this.y=y; this.w=w; this.h=h; }
        Rect rect() { return new Rect(x, y, w, h); }
    }

    static class Player extends Entity {
        int lives = 3;
        int invincibleTicks = 0;
        Player() { super(W/2 - 20, H - 70, 40, 24); }
    }

    static class Bullet extends Entity {
        int dy;
        Bullet(int x, int y, int dy) { super(x, y, 4, 14); this.dy = dy; }
    }

    static class Enemy extends Entity {
        int row;
        Enemy(int x, int y, int row) { super(x, y, ENEMY_W, ENEMY_H); this.row = row; }
    }

    static class Barrier extends Entity {
        int health = 4;
        Barrier(int x, int y) { super(x, y, 64, 20); }
    }

    static class Star { int x, y, brightness; }

    // ── Moteur sonore (synthèse pure, aucun fichier) ─────────────────────────
    static final int SAMPLE_RATE = 44100;

    /** Joue un son dans un thread daemon — ne bloque jamais le jeu. */
    static void playSound(byte[] pcm) {
        Thread t = new Thread(() -> {
            try {
                AudioFormat fmt = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, fmt);
                if (!AudioSystem.isLineSupported(info)) return;
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(fmt, pcm.length);
                line.start();
                line.write(pcm, 0, pcm.length);
                line.drain();
                line.close();
            } catch (Exception ignored) {}
        });
        t.setDaemon(true);
        t.start();
    }

    /** Génère un son à partir de paramètres (onde carrée + sweep de fréquence). */
    static byte[] synth(double startHz, double endHz, double durationSec, double volume, boolean square) {
        int n = (int)(SAMPLE_RATE * durationSec);
        byte[] buf = new byte[n];
        for (int i = 0; i < n; i++) {
            double t   = (double) i / SAMPLE_RATE;
            double hz  = startHz + (endHz - startHz) * ((double) i / n);
            double val;
            if (square) {
                // onde carrée
                val = (Math.sin(2 * Math.PI * hz * t) >= 0) ? 1.0 : -1.0;
            } else {
                // onde sinusoïdale
                val = Math.sin(2 * Math.PI * hz * t);
            }
            // Enveloppe : fondu en fin
            double env = Math.min(1.0, (n - i) / (SAMPLE_RATE * 0.02));
            buf[i] = (byte)(val * env * volume * 127);
        }
        return buf;
    }

    /** Concatène deux tableaux PCM. */
    static byte[] concat(byte[] a, byte[] b) {
        byte[] r = new byte[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    // Sons pré-générés
    static final byte[] SND_SHOOT    = synth(880, 220,  0.12, 0.5, true);
    static final byte[] SND_EXPLODE  = synth(200,  40,  0.25, 0.9, true);
    static final byte[] SND_HIT_PLAY = concat(synth(150, 80, 0.10, 0.8, true),
                                              synth(100, 50, 0.15, 0.7, true));
    static final byte[] SND_MARCH_A  = synth(160, 160,  0.06, 0.35, true);
    static final byte[] SND_MARCH_B  = synth(120, 120,  0.06, 0.35, true);
    static final byte[] SND_MARCH_C  = synth(100, 100,  0.06, 0.35, true);
    static final byte[] SND_MARCH_D  = synth( 80,  80,  0.06, 0.35, true);
    static final byte[] SND_VICTORY  = concat(
        concat(synth(523, 523, 0.12, 0.6, false), synth(659, 659, 0.12, 0.6, false)),
        concat(synth(784, 784, 0.12, 0.6, false), synth(1046,1046,0.20, 0.6, false)));
    static final byte[] SND_GAMEOVER = concat(
        concat(synth(300, 150, 0.20, 0.7, true), synth(150,  80, 0.20, 0.7, true)),
                synth( 80,  40, 0.40, 0.8, true));
    static final byte[] SND_BARRIER  = synth(300, 200,  0.07, 0.3, true);

    static final byte[][] MARCH = {SND_MARCH_A, SND_MARCH_B, SND_MARCH_C, SND_MARCH_D};

    // ── Champs ───────────────────────────────────────────────────────────────
    Player player;
    ArrayList<Bullet> playerBullets = new ArrayList<>();
    ArrayList<Bullet> enemyBullets  = new ArrayList<>();
    ArrayList<Enemy>  enemies       = new ArrayList<>();
    ArrayList<Barrier> barriers     = new ArrayList<>();
    ArrayList<Star>   stars         = new ArrayList<>();

    int  score       = 0;
    int  highScore   = 0;
    int  level       = 1;
    int  enemyDirX   = 1;         // direction horizontale des ennemis
    int  enemyTick   = 0;
    int  bombCooldown= 0;
    boolean gameOver = false;
    boolean win      = false;
    boolean started  = false;
    boolean[] keys   = new boolean[256];
    int  shootCooldown = 0;
    int  marchStep     = 0;   // index dans MARCH[]
    Random rng = new Random();

    // ── Constructeur ─────────────────────────────────────────────────────────
    SpaceInvaders() {
        setPreferredSize(new Dimension(W, H));
        setBackground(BG);
        setFocusable(true);
        addKeyListener(this);
        generateStars();
        initLevel();
        new Timer(16, this).start(); // ~60 fps
    }

    void generateStars() {
        stars.clear();
        for (int i = 0; i < 120; i++) {
            Star s = new Star();
            s.x = rng.nextInt(W);
            s.y = rng.nextInt(H);
            s.brightness = 60 + rng.nextInt(195);
            stars.add(s);
        }
    }

    void initLevel() {
        player = new Player();
        playerBullets.clear();
        enemyBullets.clear();
        enemies.clear();
        barriers.clear();
        enemyDirX = 1;
        enemyTick = 0;
        gameOver = false;
        win = false;
        shootCooldown = 0;

        // Créer les ennemis
        int startX = 80;
        int startY = 60;
        for (int r = 0; r < ENEMY_ROWS; r++)
            for (int c = 0; c < ENEMY_COLS; c++)
                enemies.add(new Enemy(
                    startX + c * (ENEMY_W + ENEMY_GAP_X),
                    startY + r * (ENEMY_H + ENEMY_GAP_Y),
                    r));

        // Créer les boucliers
        int[] bx = {80, 230, 380, 530, 680};
        for (int bxi : bx)
            barriers.add(new Barrier(bxi, H - 130));
    }

    // ── Boucle de jeu ────────────────────────────────────────────────────────
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!started || gameOver || win) { repaint(); return; }

        // Mouvement joueur
        if (keys[KeyEvent.VK_LEFT]  || keys[KeyEvent.VK_A]) player.x = Math.max(0, player.x - PLAYER_SPEED);
        if (keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]) player.x = Math.min(W - player.w, player.x + PLAYER_SPEED);

        // Tir joueur
        if ((keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_UP]) && shootCooldown <= 0) {
            playerBullets.add(new Bullet(player.x + player.w/2 - 2, player.y - 14, -BULLET_SPEED));
            shootCooldown = 18;
            playSound(SND_SHOOT);
        }
        if (shootCooldown > 0) shootCooldown--;
        if (player.invincibleTicks > 0) player.invincibleTicks--;

        // Mouvement ennemis
        enemyTick++;
        int interval = Math.max(6, ENEMY_MOVE_INTERVAL - enemies.size() / 2 - (level - 1) * 4);
        if (enemyTick >= interval) {
            enemyTick = 0;
            playSound(MARCH[marchStep % 4]);
            marchStep++;
            boolean hitEdge = false;
            for (Enemy en : enemies)
                if ((enemyDirX > 0 && en.x + en.w + 8 >= W) || (enemyDirX < 0 && en.x - 8 <= 0))
                    { hitEdge = true; break; }
            if (hitEdge) {
                enemyDirX = -enemyDirX;
                for (Enemy en : enemies) en.y += ENEMY_STEP_DOWN;
            } else {
                int speed = 4 + level;
                for (Enemy en : enemies) en.x += enemyDirX * speed;
            }
        }

        // Tir ennemi
        if (bombCooldown-- <= 0 && !enemies.isEmpty()) {
            bombCooldown = Math.max(20, 60 - level * 5 - rng.nextInt(20));
            Enemy shooter = enemies.get(rng.nextInt(enemies.size()));
            enemyBullets.add(new Bullet(shooter.x + shooter.w/2 - 2, shooter.y + shooter.h, 5 + level));
        }

        // Déplacer les balles
        for (Bullet b : playerBullets) b.y += b.dy;
        for (Bullet b : enemyBullets)  b.y += b.dy;

        // Collisions balles joueur <-> ennemis
        Iterator<Bullet> bi = playerBullets.iterator();
        while (bi.hasNext()) {
            Bullet b = bi.next();
            if (b.y + b.h < 0) { bi.remove(); continue; }
            boolean hit = false;
            for (Enemy en : enemies) {
                if (en.alive && b.rect().intersects(en.rect())) {
                    en.alive = false;
                    score += (ENEMY_ROWS - en.row) * 10;
                    hit = true;
                    playSound(SND_EXPLODE);
                    break;
                }
            }
            if (hit) { bi.remove(); continue; }
            for (Barrier br : barriers) {
                if (br.health > 0 && b.rect().intersects(br.rect())) {
                    br.health--;
                    playSound(SND_BARRIER);
                    bi.remove(); break;
                }
            }
        }
        enemies.removeIf(en -> !en.alive);

        // Collisions balles ennemies <-> joueur / barrières
        Iterator<Bullet> ei = enemyBullets.iterator();
        while (ei.hasNext()) {
            Bullet b = ei.next();
            if (b.y > H) { ei.remove(); continue; }
            boolean hit = false;
            for (Barrier br : barriers) {
                if (br.health > 0 && b.rect().intersects(br.rect())) {
                    br.health--;
                    ei.remove(); hit = true; break;
                }
            }
            if (hit) continue;
            if (player.invincibleTicks <= 0 && b.rect().intersects(player.rect())) {
                player.lives--;
                player.invincibleTicks = 120;
                ei.remove();
                playSound(SND_HIT_PLAY);
                if (player.lives <= 0) {
                    gameOver = true;
                    if (score > highScore) highScore = score;
                    playSound(SND_GAMEOVER);
                }
            }
        }

        // Ennemis atteignent le bas
        for (Enemy en : enemies)
            if (en.y + en.h >= H - 60) {
                gameOver = true;
                if (score > highScore) highScore = score;
                playSound(SND_GAMEOVER);
                break;
            }

        // Victoire
        if (enemies.isEmpty()) {
            win = true;
            level++;
            highScore = Math.max(highScore, score);
            playSound(SND_VICTORY);
        }

        repaint();
    }

    // ── Rendu ────────────────────────────────────────────────────────────────
    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fond étoilé
        for (Star s : stars) {
            int b = s.brightness;
            g.setColor(new Color(b, b, b));
            g.fillRect(s.x, s.y, 2, 2);
        }

        if (!started) { drawIntro(g); return; }

        // Barrières
        for (Barrier br : barriers) {
            if (br.health <= 0) continue;
            int alpha = 60 + br.health * 45;
            g.setColor(new Color(80, 200, 80, Math.min(255, alpha)));
            g.fillRoundRect(br.x, br.y, br.w, br.h, 8, 8);
            g.setColor(new Color(120, 255, 120, Math.min(255, alpha)));
            g.drawRoundRect(br.x, br.y, br.w, br.h, 8, 8);
        }

        // Ennemis
        for (Enemy en : enemies) {
            Color c = ENEMY_COLORS[en.row % ENEMY_COLORS.length];
            g.setColor(c);
            drawEnemy(g, en.x, en.y, en.row);
        }

        // Joueur
        boolean visible = player.invincibleTicks <= 0 || (player.invincibleTicks / 6) % 2 == 0;
        if (visible) {
            g.setColor(PLAYER_COLOR);
            drawPlayer(g, player.x, player.y, player.w, player.h);
        }

        // Balles joueur
        g.setColor(BULLET_COLOR);
        for (Bullet b : playerBullets) {
            g.fillRoundRect(b.x, b.y, b.w, b.h, 3, 3);
        }

        // Balles ennemies
        g.setColor(ENEMY_BOMB_COLOR);
        for (Bullet b : enemyBullets) {
            g.fillOval(b.x, b.y, b.w + 2, b.h / 2 + 4);
        }

        // HUD
        drawHUD(g);

        // Écrans de fin
        if (gameOver) drawOverlay(g, "GAME OVER", "Score : " + score, "Appuie sur R pour rejouer");
        if (win)      drawOverlay(g, "NIVEAU " + level + " !", "Score : " + score, "Appuie sur ENTRÉE pour continuer");
    }

    void drawPlayer(Graphics2D g, int x, int y, int w, int h) {
        // Corps principal
        int[] xp = {x + w/2, x + w, x + w - 6, x + 6, x};
        int[] yp = {y, y + h, y + h, y + h, y + h};
        g.fillPolygon(xp, yp, 5);
        // Canon
        g.fillRect(x + w/2 - 3, y - 10, 6, 12);
        // Cockpit
        g.setColor(new Color(180, 255, 210));
        g.fillOval(x + w/2 - 7, y + 4, 14, 10);
    }

    void drawEnemy(Graphics2D g, int x, int y, int row) {
        switch (row % 4) {
            case 0 -> { // Octopus
                g.fillOval(x + 6, y, 24, 18);
                g.setColor(BG);
                g.fillOval(x + 9, y + 4, 5, 5);
                g.fillOval(x + 22, y + 4, 5, 5);
                g.setColor(ENEMY_COLORS[0]);
                g.fillRect(x + 4, y + 14, 5, 5);
                g.fillRect(x + 27, y + 14, 5, 5);
            }
            case 1 -> { // Crab
                g.fillRoundRect(x + 4, y + 4, 28, 14, 6, 6);
                g.fillRect(x, y + 6, 8, 4);
                g.fillRect(x + 28, y + 6, 8, 4);
                g.setColor(BG);
                g.fillOval(x + 9, y + 6, 5, 5);
                g.fillOval(x + 22, y + 6, 5, 5);
            }
            case 2 -> { // Squid
                g.fillOval(x + 8, y + 2, 20, 16);
                g.fillRect(x + 10, y + 14, 4, 6);
                g.fillRect(x + 22, y + 14, 4, 6);
                g.setColor(BG);
                g.fillOval(x + 11, y + 5, 5, 5);
                g.fillOval(x + 20, y + 5, 5, 5);
            }
            default -> { // UFO mini
                g.fillOval(x + 4, y + 8, 28, 12);
                g.fillOval(x + 10, y + 2, 16, 12);
                g.setColor(BG);
                g.fillOval(x + 11, y + 9, 4, 4);
                g.fillOval(x + 21, y + 9, 4, 4);
            }
        }
    }

    void drawHUD(Graphics2D g) {
        g.setFont(new Font("Monospaced", Font.BOLD, 16));
        g.setColor(new Color(200, 230, 255));
        g.drawString("SCORE " + score, 10, 24);
        g.drawString("MEILLEUR " + highScore, W/2 - 70, 24);
        g.drawString("NIVEAU " + level, W - 100, 24);

        // Vies
        g.setColor(PLAYER_COLOR);
        g.drawString("♥ x" + player.lives, 10, 48);

        // Ligne du sol
        g.setColor(new Color(50, 120, 50));
        g.fillRect(0, H - 56, W, 2);
    }

    void drawOverlay(Graphics2D g, String title, String sub, String hint) {
        g.setColor(new Color(0, 0, 10, 180));
        g.fillRect(0, 0, W, H);

        g.setFont(new Font("Monospaced", Font.BOLD, 48));
        g.setColor(new Color(255, 220, 60));
        FontMetrics fm = g.getFontMetrics();
        g.drawString(title, (W - fm.stringWidth(title)) / 2, H/2 - 40);

        g.setFont(new Font("Monospaced", Font.PLAIN, 24));
        g.setColor(Color.WHITE);
        fm = g.getFontMetrics();
        g.drawString(sub, (W - fm.stringWidth(sub)) / 2, H/2 + 10);

        g.setFont(new Font("Monospaced", Font.ITALIC, 16));
        g.setColor(new Color(160, 200, 255));
        fm = g.getFontMetrics();
        g.drawString(hint, (W - fm.stringWidth(hint)) / 2, H/2 + 50);
    }

    void drawIntro(Graphics2D g) {
        g.setFont(new Font("Monospaced", Font.BOLD, 52));
        g.setColor(new Color(255, 220, 60));
        String t = "SPACE INVADERS";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(t, (W - fm.stringWidth(t)) / 2, 160);

        g.setFont(new Font("Monospaced", Font.PLAIN, 18));
        g.setColor(Color.WHITE);
        String[] lines = {
            "← → ou A D  :  Déplacer",
            "ESPACE ou ↑  :  Tirer",
            "R            :  Recommencer",
            "",
            "Appuie sur ENTRÉE pour jouer"
        };
        int y = 260;
        for (String l : lines) {
            fm = g.getFontMetrics();
            g.drawString(l, (W - fm.stringWidth(l)) / 2, y);
            y += 32;
        }
    }

    // ── Entrées clavier ──────────────────────────────────────────────────────
    @Override public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k < 256) keys[k] = true;

        if (!started && k == KeyEvent.VK_ENTER) { started = true; }
        if (gameOver && k == KeyEvent.VK_R) { score = 0; level = 1; initLevel(); started = true; }
        if (win && k == KeyEvent.VK_ENTER) { initLevel(); started = true; }
        if (k == KeyEvent.VK_R && !gameOver) { score = 0; level = 1; initLevel(); started = true; }
    }
    @Override public void keyReleased(KeyEvent e) { if (e.getKeyCode() < 256) keys[e.getKeyCode()] = false; }
    @Override public void keyTyped(KeyEvent e) {}

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            SpaceInvaders game = new SpaceInvaders();
            frame.add(game);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            game.requestFocusInWindow();
        });
    }
}
