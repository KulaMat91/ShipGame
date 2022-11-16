package org.BattleShipGame.Square;

public class Square {
    private int x;
    private int y;
    private SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus squareStatus) {
        this.x = x;
        this.y = y;
        this.squareStatus = squareStatus;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public Integer[] getSquareCoordinates(){
        return new Integer[]{x , y};
    }
}
