/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
public class Grid {
    	
    private Snake snake ;
    private final int height , width;     
    private Node food;

    private Direction snakeDirection = Direction.LEFT;

    Grid(int h , int w) {
            this.height = h;
            this.width = w;
            initSnake();
            food = creatFood();

    }

    public boolean nextRound() {

            Node preTail; 


            preTail = snake.move(snakeDirection);

        if (snake.getHead().getX()<=width && snake.getHead().getX()>=0 
                    && snake.getHead().getY()<=height && snake.getHead().getY()>=0) {
            if (snake.getHead().equals(food)) {
                    snake.addTail(preTail);
                
                    food = this.creatFood();
            } 
            return true;

        }
            return false;    
    }

    private Snake initSnake() {
            snake = new Snake();
            
            int x , y;
            x = width/2;
            y = height/2;
            for(int i=0; i<5; i++) {
                    snake.addTail(new Node(x,y));
                    x = x + Settings.DEFAULT_NODE_SIZE;
            }

            return snake;
    }

    private Node creatFood() {
        int x, y;

        do {
            x = (int)(Math.random()*100);
            y = (int)(Math.random()*100);
            System.out.println(x);
            System.out.println(y);
        } while(x>=this.width || y>=this.height || snake.hasNode(new Node(x,y)));

        food = new Node(x, y);
        return food;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public Node getFood() {
        return this.food;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return height;
    }

    public void changeDirection(Direction d) {
        this.snakeDirection = d;
    }
}
