package ms;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

@Test
public class MinesweeperTest extends ReadFileTest{

    public void testCase0() throws IOException {
        generateBoardTest(0);
    }

    public void testCase1() throws IOException {
        checkMoveTest(1);
    }

    public void testCase2() throws IOException {
        winnerTest(2);
    }

    private void generateBoardTest(int i) throws IOException {
        int n = readInput(i);
        List<String> expectedOutput = readOutput(i);
        int[][] board = Minesweeper.generateBoardStatic(n);
        List<String> output = new ArrayList<String>();
        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                output.add(String.valueOf(board[row][column]));
            }
        }

        Assert.assertEquals(output, expectedOutput);
    }

    private void checkMoveTest(int i) throws IOException {
        int n =  readInput(i);
        List<String> expectedOutput = readOutput(i);
        int[][] board = Minesweeper.generateBoardStatic(3);
        boolean out = Minesweeper.checkMove(board, n%10, n/10);
        List<String> output = new ArrayList<String>();
        output.add(String.valueOf(out));
        Assert.assertEquals(output, expectedOutput);
    }

    private void winnerTest(int i) throws IOException {
        List<String> expectedOutput = readOutput(i);
        int board[][] = Minesweeper.generateBoardStatic(3);
        int count = Minesweeper.countMines(board,3);
        List<String> n = readFile(i, "input");

        Boolean gameOver = false;
        for (int j=0 ; j<3*3-count; j++){
            int x = (Integer.parseInt(n.get(j)))/10;
            int y = (Integer.parseInt(n.get(j)))%10;
            gameOver = Minesweeper.checkMove(board, x, y);
            if (!gameOver){
                board[x][y] = -1;
            }
        }

        List<String> winnerBoard = new ArrayList<String>();
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                winnerBoard.add(String.valueOf(board[row][column]));
            }
        }

        Assert.assertEquals(winnerBoard, expectedOutput);
    }
}
