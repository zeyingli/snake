/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
import javax.swing.*;
public class snakeApp {

    public void init(){
        JFrame window = new JFrame("Snake Game");
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
    }
    public static void main(String[] args) 
    {
        snakeApp snakeApp = new snakeApp();
        snakeApp.init();
    }
    
}
