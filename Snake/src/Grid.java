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
        food = createFood();
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

     
  private Node createFood()
    {
        int x, y;
        
        // Randomly populate coordinate for food
        do {
            x = (int) (Math.random() * 100);
            y = (int) (Math.random() * 100);
            
            System.out.println(x);
            System.out.println(y);
        } while (x >= this.width || y >= this.height || snake.hasNode(new Node(x,y)));
        
        food = new Node(x, y);
        return food;
    }

      public boolean nextRound()
    {
        Node preTail; // Save previous tail
        
        // Move snake based on current direction
        preTail = snake.move(snakeDirection);
        
        if (snake.getHead().getX()<=width && snake.getHead().getX()>=0 
       && snake.getHead().getY()<=height && snake.getHead().getY()>=0)
        {
            if (snake.getHead().equals(food))
            {
                // Added the deleted tail from last MOVE operation
                snake.addTail(preTail);
                
                // Summon a new food
                food = this.createFood();
            }
            // Update gird status and return exit status
            return true;
        }
        return false;
    }
    

  public Snake getSnake()
  {
      return this.snake;
  }
  
  public Node getFood()
  {
      return this.food;
  }
  
  public int getWidth()
  {
      return this.width;
  }

  public int getHeight()
  {
      return this.height;
  }
  
  public void changeDirection(Direction d)
  {
      this.snakeDirection = d;
  }
}
