import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author chengou
 */
public class SnakeView {

    private final Grid grid;
    private static JPanel canvas;
    
    public void initial(){
        canvas = new JPanel(){
            @Override
            public void paintComponent(Graphics graphics){
                super.paintComponent(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    public static void draw() {
        canvas.repaint();
    }
    
    public JPanel getCanvas() {
        return canvas;
    }
    
    public SnakeView(Grid grid) {
        this.grid = grid;
    }

    public void drawSnake(Graphics graphics, Snake snake) {
        Iterator<Node> iter = snake.getBody().iterator();
        
        Node n = new Node(0, 0);
        n = iter.next();
        
        this.drawSquare(graphics, n, Color.red);
        
        while(iter.hasNext())
        {
            n = iter.next();
            this.drawSquare(graphics, n, Color.green);
        }
             
    }

    public void drawFood(Graphics graphics, Node squareArea) {
        this.drawCircle(graphics, squareArea, Color.blue);
    }
    
    public static void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "Game Over, You Died", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
    public void drawSquare(Graphics graphics, Node squareArea, Color color)
    {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX(), squareArea.getY(), size, size);
    }
    public void drawCircle(Graphics graphics, Node squareArea, Color color)
    {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX(),squareArea.getY(),size,size);
    }
}
