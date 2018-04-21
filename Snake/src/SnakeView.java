
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chengou
 */
public class SnakeView {

    private final Grid grid;

    public SnakeView(Grid grid) {
        this.grid = grid;
    }

    public void draw(Graphics graphics) {
        drawGridBackground(graphics);
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
    }

    public void drawSnake(Graphics graphics, Snake snake) {
    }

    public void drawFood(Graphics graphics, Node squareArea) {
    }

    public void drawGridBackground(Graphics graphics) {
    }

}
