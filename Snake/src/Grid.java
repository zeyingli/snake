/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  
 * @author tim
 */
/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
public class Grid 
{
    private Snake snake;
    private final int height , width;
    private Node food;
    
    private Direction snakeDirection = Direction.LEFT;  
       
    public Grid(int h, int w) // Constructor
    {
        this.width = h; 
        this.height= w; 
       
    }
    
    private Snake initializeSnake()
    {
        snake = new Snake();
        
        // Set body
        int x, y;
        x = width / 2;
        y = height / 2;
        
        for (int i = 0; i < 5; i++)
        {
            snake.addTail(new Node(x, y));
            x = x + Settings.DEFAULT_NODE_SIZE;
        }
        
        // Update Status
        return snake;
    }

    


}
