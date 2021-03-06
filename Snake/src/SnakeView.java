import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cheng Ou, Zeying Li, Tiancheng Zhang
 */
public class SnakeView {

    private final Grid grid;
    private static JPanel canvas;
    
    public void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics){
                super.paintComponent(graphics);
                drawBackground(graphics);
                drawGridBackground(graphics);
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
    public void drawBackground(Graphics graphics){
   BufferedImage background = null;
   try{
       background = ImageIO.read(new File("src/image/background.jpg"));
       
   }catch(Exception e){
       e.getMessage();
   }
      graphics.drawImage(background, 0, 0, canvas);
    }
    
   
    
    public void drawSnake(Graphics graphics, Snake snake) {
        Iterator<Node> iter = snake.getBody().iterator();
        
        Node n = new Node(0, 0);
        n = iter.next();
        
        drawSquare(graphics, n, Color.red);
        
        while(iter.hasNext())
        {
            n = iter.next();
            drawSquare(graphics, n, Color.green);
        }
             
    }

    public void drawFood(Graphics graphics, Node squareArea) {
        this.drawCircle(graphics, squareArea, Color.red);
    }
    
    public static void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
   
    public void drawGridBackground(Graphics graphics)
    {
     
        graphics.setColor(Color.gray);
        for (int i = 0; i < 50; i++)
        {
            graphics.drawLine(0, i * Settings.DEFAULT_NODE_SIZE, this.grid.getWidth(), i * Settings.DEFAULT_NODE_SIZE);
            
        }
        for (int i = 0; i < 50; i++)
        {
            graphics.drawLine(i * Settings.DEFAULT_NODE_SIZE, 0, i * Settings.DEFAULT_NODE_SIZE, this.grid.getHeight()); 
        }
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
