/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
public class snakeApp {

    public void init(){
        JFrame window = new JFrame("Snake Game");
        Grid myGrid = new Grid(50*Settings.DEFAULT_NODE_SIZE, 50*Settings.DEFAULT_NODE_SIZE);
        
        SnakeView snakeView = new SnakeView(myGrid);
        snakeView.init();
        
        window.setPreferredSize(new Dimension(500,500));
        
        window.add(snakeView.getCanvas(), BorderLayout.CENTER);
        
        snakeView.draw();
        
        window.setResizable(false);
            
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setVisible(true);
        
    }
    public static void main(String[] args) 
    {
        snakeApp snakeApp = new snakeApp();
        snakeApp.init();
    }
    
}
