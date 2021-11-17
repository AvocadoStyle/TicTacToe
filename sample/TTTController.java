import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import sample.TTTLogic;

public class TTTController
{
    @FXML
    private Canvas canvas;
    private double height;
    private double width;

    private TTTLogic _game;

    private final int LINES = 3;


    @FXML
    public void initialize()
    {
        this._game = new TTTLogic();
        GraphicsContext g = canvas.getGraphicsContext2D();
        System.out.println("hey");

        height = this.canvas.getHeight() / 3;
        width = this.canvas.getWidth() / 3;

        g.strokeRect(0,0,canvas.getWidth(), canvas.getHeight());

        for(int i=1; i < LINES; i++)
        {
            g.strokeLine(width*i, 0, width*i, this.canvas.getHeight());
            g.strokeLine(0, height*i, this.canvas.getWidth(), height*i);
        }
    }

    /**
     * draws a sign: O or X inside a closing rectangle(represents the place where we can put a sign).
     * sign will switch from O to X and X to O
     * @param x from where the rectangle starts
     * @param y from where the rectangle starts
     * @param width width of the blocking rectangle
     * @param height height of the blocking rectangle
     * @param sign X or O
     */
    public void drawSign(double x, double y, double width, double height, int sign)
    {
        GraphicsContext g = canvas.getGraphicsContext2D();
        if(sign == TTTLogic.X)
        {
            g.strokeLine(x, y, x+width, y+height);
            g.strokeLine(x+width, y, x, y + height);
        }
        else if(sign == TTTLogic.O)
        {
            g.strokeOval(x, y, width, height);
        }
    }

    @FXML
    void click(MouseEvent event)
    {
        /*getting the coordinates of the lines*/
        int row = (int)(event.getX() / this.width);
        int col = (int)(event.getY() / this.height);

        if(this._game.isEmpty(row, col))
        {
            this._game.putSign(row, col);
            drawSign(row*this.width, col*this.height, this.width, this.height, this._game.getTurn());
            System.out.println(this._game.getBoardValue(row, col)); // X = 1, O = 2


        }


    }
}
