
/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int rows, int columns, int bombs)
    {
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;

        board = new Cell[rows * columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addBombs(bombs);
        addNums();
    }

    public MinesweeperBoard2()
    {
        this(10,10,25);
    }

    public void addBombs(int bombs) { //throws Exception{
        for (int i = 0; i < bombs; i++)
        {
            int index = (int)((Math.random() * ((rows * columns) - 1)));

            if (board[index].isBomb())
            {
                i--;
            }
            else
            {
                board[index].setBomb();
            }
        }
    }

    //Mk 1
    public void addNums(){
        int index = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (board[index].getValue() != -1)
                {
                    //TOP-LEFT CORNER
                    if (index == 0)
                    {
                        if (board[index + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + columns + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //TOP-RIGHT CORNER
                    else if(index == columns - 1)
                    {
                        if (board[index - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + columns - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //BOTTOM-LEFT CORNER
                    else if(index == (rows - 1) * columns)
                    {
                        if (board[index + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - columns + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //BOTTOM-RIGHT CORNER
                    else if (index == (rows * columns) - 1)
                    {
                        if (board[index - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - columns - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //TOP ROW
                    else if (index < columns)
                    {
                        //CHECKING SIDES
                        if (board[index - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        //CHECKING BOTTOM
                        if (board[index + (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns + 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //BOTTOM ROW
                    else if (i == (rows - 1))
                    {
                        //CHECKING ABOVE
                        if (board[index - (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - (columns)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - (columns + 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        //CHECKING SIDES
                        if (board[index - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //LEFT-MOST COLUMN
                    else if (index == (i * columns))
                    {
                        if (board[index - columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns + 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    //RIGHT-MOST COLUMN
                    else if (index == ((i + 1) * columns) - 1)
                    {
                        if (board[index - (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - columns].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns)].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                    else
                    {
                        //THIS IS FOR SURROUNDED CELLS
                        //CHECKING ABOVE
                        if (board[index - (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - (columns)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index - (columns + 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        //CHECKING SIDES
                        if (board[index - 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + 1].isBomb())
                        {
                            board[index].addValue();
                        }
                        //CHECKING BOTTOM
                        if (board[index + (columns - 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns)].isBomb())
                        {
                            board[index].addValue();
                        }
                        if (board[index + (columns + 1)].isBomb())
                        {
                            board[index].addValue();
                        }
                    }
                }
                index++;
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int val = 0;
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++){
                if (board[val].isBomb())
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print(board[val].getValue() + " ");
                }
                val++;
            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i < rows*columns; i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }

}
