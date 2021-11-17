package sample;

public class TTTLogic
{
    public static final int X = 1, O = 2, EMPTY = 3;
    private int[][] board;
    private int turn;

    public TTTLogic()
    {
        this.board = new int[3][3];

        for(int i=0; i< this.board.length; i++)
            for(int j=0; j<this.board[i].length; j++)
            {
                this.board[i][j] = EMPTY;
            }

        this.turn = O;
    }

    private void switchTurns()
    {
        if(this.turn == X)
            this.turn = O;
        else
            this.turn = X;
    }

    public boolean isEmpty(int row, int col)
    {
        return this.board[row][col] == EMPTY;
    }

    public void putSign(int row, int col)
    {
        /* get inside the if statment if the rectangle is empty*/
        if(isEmpty(row, col))
        {
            board[row][col] = this.turn;
            this.switchTurns();
        }
    }

    public int getTurn()
    {
        return this.turn;
    }

    public String getBoardValue(int row, int col)
    {
        return "" + "board[" + row + "][" + col + "] = " + this.turn;
    }


}
