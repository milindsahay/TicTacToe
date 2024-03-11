package tic.tac.toe.models;

public class Block {
    private Move move;

    public Block() {
        this.move = Move.None;
    }

    public void setMove(Move move){
        this.move = move;
    }

    public Move getMove(){
        return move;
    }


}
