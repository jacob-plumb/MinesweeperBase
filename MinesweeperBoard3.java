
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

public class MinesweeperBoard3{
    Cell[] board;
    int rows;
    int columns;
    public MinesweeperBoard3(int rows, int columns, int bombs)
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

    public MinesweeperBoard3()
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

    //Mk 2
    public void addNums(){
        for (int i = 0; i < rows * columns; i++)
        {
            if(board[i].isBomb()){
                if((i >= columns) && (i%columns != 0)) {board[i - columns - 1].addValue();} //TOP LEFT
                if(i >= columns) {board[i - columns].addValue();} //TOP CENTER
                if((i >= columns) && (i%columns != (columns - 1))) {board[i - columns + 1].addValue();} //TOP RIGHT
                if(i%columns != 0) {board[i - 1].addValue();} //MIDDLE LEFT
                if(i%columns != (columns - 1)) {board[i + 1].addValue();} //MIDDLE RIGHT
                if((i < (rows - 1) * columns) && (i%columns != 0)) {board[i + columns - 1].addValue();} //BOTTOM LEFT
                if(i < ((rows - 1) * columns)) {board[i + columns].addValue();} //BOTTOM CENTER
                if((i < ((rows - 1) * columns) && (i%columns != (columns - 1)))) {board[i + columns + 1].addValue();} //BOTTOM RIGHT
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