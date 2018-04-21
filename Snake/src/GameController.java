/**
 *
 * @author Zeying Li
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
    
public class GameController implements KeyListener, Runnable {
        
    private Grid grid;
    private boolean running;
    private boolean over = false;

    GameController(Grid g) {
            this.grid = g;
            this.running = true;
    }
    	
    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        switch(keyCode) {
        case KeyEvent.VK_UP:	grid.changeDirection(Direction.UP); break;
        case KeyEvent.VK_DOWN:	grid.changeDirection(Direction.DOWN); break;
        case KeyEvent.VK_LEFT:	grid.changeDirection(Direction.LEFT); break;
        case KeyEvent.VK_RIGHT:	grid.changeDirection(Direction.RIGHT); break;

        }

        isOver(grid.nextRound());
        SnakeView.draw();      
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void isOver(boolean o) {
        if(!o) {
                this.running = false;
                SnakeView.showGameOverMessage();
                System.exit(0);
        }
    }

    @Override
    public void run() {

            while (running) {
            try {
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
                isOver(grid.nextRound());
                SnakeView.draw();
            } catch (InterruptedException e) {
                break;
            }
        }

        running = false;
    }   
}
