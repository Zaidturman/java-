
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;    // Using Swing's components and containers

/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class CGMoveALine extends JFrame implements KeyListener {

    // Define constants for the various dimensions
    private int x = 0;
    private int y = 0;
    private int x1 = 200;
    private int y1 = 200;
    private int x2 = 300;
    private int y2 = 300;
    private int x3 = 400;
    private int y3 = 400;
    private boolean isRectVisible = false;
    private boolean isSquareVisible = false;
    private boolean isCircleVisible = false;

    // The moving line from (x1, y1) to (x2, y2), initially position at the center
    private DrawCanvas canvas; // The custom drawing canvas (an innder class extends JPanel)
    private Object graphics;

    // Constructor to set up the GUI components and event handlers
    public CGMoveALine() {
        // Set up a panel for the buttons

        JPanel btnPanel = new JPanel(new FlowLayout());

        JButton btnUp = new JButton("Move TOP ");
        btnPanel.add(btnUp);
        btnUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                y1 -= 10;
                y2 -= 10;
                y3 -= 10;
                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton btnDown = new JButton("Move Down ");
        btnPanel.add(btnDown);
        btnDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                y1 += 10;
                y2 += 10;
                y3 += 10;

                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });

        JButton btnLeft = new JButton("Move Left ");
        btnPanel.add(btnLeft);
        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                x1 -= 10;
                x2 -= 10;
                x3 -= 10;

                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton btnRight = new JButton("Move Right");
        btnPanel.add(btnRight);
        btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                x1 += 10;
                x2 += 10;
                x3 += 10;

                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton addRect = new JButton("add rect");
        btnPanel.add(addRect);
        addRect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                isRectVisible = !isRectVisible;

                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton addSquare = new JButton("add Square");
        btnPanel.add(addSquare);
        addSquare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                isSquareVisible = !isSquareVisible;

                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton addCircle = new JButton("add Circle");
        btnPanel.add(addCircle);
        addCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                isCircleVisible = !isCircleVisible;

                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });

        // Set up a custom drawing JPanel
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(x1, y1));

        // Add both panels to this JFrame's content-pane
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);

        // "super" JFrame fires KeyEvent
        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt) {

                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_A:
                        x1 -= 10;

                        repaint();
                        break;
                    case KeyEvent.VK_D:
                        x1 += 10;

                        repaint();
                        break;
                    case KeyEvent.VK_S:
                        y1 += 10;

                        repaint();
                        break;
                    case KeyEvent.VK_W:
                        y1 -= 10;

                        repaint();
                        break;
                    case KeyEvent.VK_F:

                        x2 -= 10;

                        repaint();
                        break;
                    case KeyEvent.VK_H:

                        x2 += 10;

                        repaint();
                        break;
                    case KeyEvent.VK_G:

                        y2 += 10;

                        repaint();
                        break;
                    case KeyEvent.VK_T:

                        y2 -= 10;

                        repaint();
                        break;
                    case KeyEvent.VK_J:

                        x3 -= 10;

                        repaint();
                        break;
                    case KeyEvent.VK_L:

                        x3 += 10;

                        repaint();
                        break;
                    case KeyEvent.VK_K:

                        y3 += 10;

                        repaint();
                        break;
                    case KeyEvent.VK_I:

                        y3 -= 10;

                        repaint();
                        break;
                    case KeyEvent.VK_Z:

                        isRectVisible = !isRectVisible;

                        repaint();
                        break;
                    case KeyEvent.VK_1:

                        isSquareVisible = !isSquareVisible;

                        repaint();
                        break;
                    case KeyEvent.VK_2:

                        repaint();
                        break;
                }
            }

        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
        setTitle("Move");
        pack();           // pack all the components in the JFrame
        setVisible(true); // show it
        requestFocus();   // set the focus to JFrame to receive KeyEvent
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
     */
    class DrawCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.drawString("لاضافة مستطيل اضغط على الز المخصص لاضافة المستطيل في الاسفل", 40, 40);
            g.drawString("لاضافة مربع اضغط على الز المخصص لاضافة مربع في الاسفل", 40, 60);
            g.drawString("لاضافة دائره اضغط على الز المخصص لاضافة دائره في الاسفل", 40, 80);
            g.drawString("   لتحريك المستطيل للاعلى استخدمW  وللاسفل استخدم S ولليمين استخمد D ولليسار استخدم  A ", 40, 100);
            g.drawString("   لتحريك المربع  للاعلى استخدمT  وللاسفل استخدم G ولليمين استخمد H ولليسار استخدم  F ", 40, 120);

            g.drawString("   لتحريك الدائره للاعلى استخدمI  وللاسفل استخدم K ولليمين استخمد L ولليسار استخدم  J", 40, 140);

            if (isRectVisible) {
                g.fillRect(x1, y1, 250, 100); // Draw the rect
            }
            if (isSquareVisible) {
                g.fillRect(x2, y2, 100, 100); // Draw the rect
            }
            if (isCircleVisible) {
                g.fillOval(x3, y3, 100, 100);

            }
        }
    }

    // The entry main() method
    public static void main(String[] args) {

        CGMoveALine frame = new CGMoveALine();
        frame.setVisible(true);// Run GUI codes on the Event-Dispatcher Thread for thread safety

    }
}
