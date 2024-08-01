import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String[ROW][COL];

    public static void main(String[] args)
    {
        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;

        do
        {
            player = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();
            do
            {
                do
                {
                    display();
                    System.out.println("First move is " + player);
                    row = SafeInput.getRangedInt(in, "Enter row: ", 1,3);
                    col = SafeInput.getRangedInt(in,"Enter col: ", 1, 3);
                    row--; col--;
                }while(!isValidMove(row, col));
                board[row][col] = player;
                moveCnt++;

                if(moveCnt >= MOVES_FOR_WIN)
                {
                    if(isWin(player))
                    {
                        display();
                        System.out.println("Player " + player + " WINS!");
                        playing = false;
                    }
                }
                if(moveCnt >= MOVES_FOR_TIE)
                {
                    if(isTie())
                    {
                        display();
                        System.out.println("It's a TIE!");
                        playing = false;
                    }
                }
                if(player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }

            }while(playing);

            finished = SafeInput.getYNConfirm(in, "Are you finished with the game? ");
        }while(!finished);

    }

    private static boolean isDiagonalWin(String player)
    {

        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player) )
            return true;

        if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player) )
            return true;

        return false;
    }

    private static void clearBoard()
    {
        for(int row=0; row < ROW; row++)
        {
            for (int col=0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        for(int row=0; row < ROW; row++)
        {
            System.out.print("| ");
            for(int col=0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col)
    {

        if (board[row][col].equals(" "))
            return true;

        return false;
    }

    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isColWin(String player)
    {
        // This will check for a col win
        for(int col=0; col < COL; col++)
            if(board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
                return true;

        return false;
    }

    private static boolean isRowWin(String player)
    {
        // This will check for a row win
        for(int row=0; row < ROW; row++)
            if(board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
                return true;
        return false; //no row win
    }

    private static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;

        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X"))
            {
                xFlag = true;
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oFlag  = true;
            }

            if(! (xFlag && oFlag) )
            {
                return false;
            }

            xFlag = oFlag = false;
        }
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X"))
                xFlag = true;

            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O"))
                oFlag = true;

            if(! (xFlag && oFlag) )
                return false;

        }

        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X") )
            xFlag = true;

        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O") )
            oFlag = true;

        if(! (xFlag && oFlag) )
            return false;

        xFlag = oFlag = false;

        if(board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X") )
            xFlag = true;

        if(board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O") )
            oFlag = true;

        if(! (xFlag && oFlag) )
            return false;


        return true;
    }
}