/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ContainerListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class snakeApp {

    public void init(){
        JFrame window = new JFrame("Snake Game");
        Grid myGrid = new Grid(50*Settings.DEFAULT_NODE_SIZE, 50*Settings.DEFAULT_NODE_SIZE);
        
        SnakeView snakeView = new SnakeView(myGrid);
        snakeView.init();
        
        GameController snakeController = new GameController(myGrid);
        
        window.setPreferredSize(new Dimension(500,500));
        
        window.add(snakeView.getCanvas(), BorderLayout.CENTER);
        
        snakeView.draw();
        
        window.setResizable(false);
        
        window.addKeyListener((KeyListener)snakeController);
        new Thread(snakeController).start();
            
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setVisible(true);
        
    }
    public static void main(String[] args) 
    {
        snakeApp app = new snakeApp();
        app.init();
    }
    
}
