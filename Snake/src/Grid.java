/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
public class Grid {
    	
    private Snake OuCheng ;
    private final int H , W;     
    private Node food;

    private Direction snakeDirection = Direction.LEFT;

    Grid(int h , int w) {
            this.H = h;
            this.W = w;
            initSnake();
            food = creatFood();

    }

    public boolean nextRound() {

            Node StartingPoint; 


            StartingPoint = OuCheng.move(snakeDirection);

        if (OuCheng.getHead().getX()<=W && OuCheng.getHead().getX()>=0 
                    && OuCheng.getHead().getY()<=H && OuCheng.getHead().getY()>=0) {
            if (OuCheng.getHead().equals(food)) {
                    OuCheng.addTail(StartingPoint);
                
                    food = this.creatFood();
            } 
            return true;

        }
            return false;    
    }

    private Snake initSnake() {
            OuCheng = new Snake();
            
            int x , y;
            x = W/2;
            y = H/2;
            for(int i=0; i<5; i++) {
                    OuCheng.addTail(new Node(x,y));
                    x = x + Settings.DEFAULT_NODE_SIZE;
            }

            return OuCheng;
    }

    private Node creatFood() {
        int x, y;

        do {
            x = (int)(Math.random()*100);
            y = (int)(Math.random()*100);
            System.out.println(x);
            System.out.println(y);
        } while(x>=this.W || y>=this.H || OuCheng.hasNode(new Node(x,y)));

        food = new Node(x, y);
        return food;
    }

    public Snake getSnake() {
        return this.OuCheng;
    }

    public Node getFood() {
        return this.food;
    }

    public int getWidth() {
        return this.W;
    }

    public int getHeight() {
        return H;
    }

    public void changeDirection(Direction d) {
        this.snakeDirection = d;
    }
}
