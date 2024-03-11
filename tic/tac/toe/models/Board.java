package tic.tac.toe.models;

public class Board {
    private Block[][] board = new Block[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Block();
            }
        }
    }

    public Block[][] getBoard(){
        return board;
    }

    public boolean isFull(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].getMove() == Move.None){
                    return false;
                }
            }
        }
        return true;
    }

}
