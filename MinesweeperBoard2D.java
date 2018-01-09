
/**
 * Write a description of class MinesweeperBoard2D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2D{
    Cell[][] board;
    int rows;
    int columns;
    public MinesweeperBoard2D(int rows, int columns, int bombs)
    {
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;

        board = new Cell[rows][columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addBombs(bombs);
        addNums();
    }

    public MinesweeperBoard2D()
    {
        this(10,10,25);
    }

    public void addBombs(int bombs) { //throws Exception{
        for (int i = 0; i < bombs; i++)
        {
            int rowIndex = (int)((Math.random() * ((rows) - 1)));
            int colIndex = (int)((Math.random() * ((columns) - 1)));

            if (board[rowIndex][colIndex].isBomb())
            {
                i--;
            }
            else
            {
                board[rowIndex][colIndex].setBomb();
            }
        }
    }

    public void addNums(){
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if(board[i][j].isBomb())
                {
                    if((i > 0) && (j > 0)){board[i-1][j-1].addValue();}
                    if(i > 0){board[i-1][j].addValue();}
                    if((i > 0) && (j < columns-1)){board[i-1][j+1].addValue();}
                    if(j > 0){board[i][j-1].addValue();}
                    if(j < columns-1){board[i][j-1].addValue();}
                    if((i < rows-1) && (j > 0)){board[i+1][j-1].addValue();}
                    if(i < rows-1){board[i+1][j].addValue();}
                    if((i < rows-1) && (j < columns-1)){board[i+1][j+1].addValue();}
                }
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int val = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++){
                if (board[i][j].isBomb())
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print(board[i][j].getValue() + " ");
                }
            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++)
            {
                board[i][j]= new Cell();
                panel.add(board[i][j].getButton());
            }
        }
        return panel;
    }

}
