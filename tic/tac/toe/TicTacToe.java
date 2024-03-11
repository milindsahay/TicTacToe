package tic.tac.toe;

import tic.tac.toe.models.Board;
import tic.tac.toe.models.Move;

import java.util.Scanner;

public class TicTacToe {
    Board board;

    public TicTacToe() {
        board = new Board();
        System.out.println("Welcome to Tic Tac Toe!");
    }
    public void play() {
        while (true){
            if (makeMove("X")) break;
            if(board.isFull()){
                System.out.println("Game is a draw!");
                break;
            }
            if (makeMove("O")) break;
        }
    }

    public boolean makeMove(String player){
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Player %s: please enter x coordinate for your position", player));
        int x = scanner.nextInt();
        System.out.println(String.format("Player %s: please enter y coordinate for your position", player));
        int y = scanner.nextInt();
        Move move = Move.valueOf(player);
        while (!moveValidator(x, y, move)){
            System.out.println("Invalid move, please try again");
            System.out.println(String.format("Player %s: please enter x coordinate for your position", player));
            x = scanner.nextInt();
            System.out.println(String.format("Player %s: please enter y coordinate for your position", player));
            y = scanner.nextInt();
        }
        board.getBoard()[x][y].setMove(move);

        if(checkWinnings(x, y)){
            System.out.println(String.format("Player %s wins!!", player));
            return true;
        }

        return false;
    }

    private boolean moveValidator(int x, int y, Move move) {
        if(x<0 || x>2 || y<0 || y>2 || !move.equals(Move.None)) return false;
        return true;
    }


    public boolean checkWinnings(int x, int y){
        Move move = board.getBoard()[x][y].getMove();
        if(board.getBoard()[x][0].getMove() == move && board.getBoard()[x][1].getMove() == move && board.getBoard()[x][2].getMove() == move){
            return true;
        }
        if(board.getBoard()[0][y].getMove() == move && board.getBoard()[1][y].getMove() == move && board.getBoard()[2][y].getMove() == move){
            return true;
        }
        if(board.getBoard()[0][0].getMove() == move && board.getBoard()[1][1].getMove() == move && board.getBoard()[2][2].getMove() == move){
            return true;
        }
        if(board.getBoard()[0][2].getMove() == move && board.getBoard()[1][1].getMove() == move && board.getBoard()[2][0].getMove() == move){
            return true;
        }
        return false;
    }
}
