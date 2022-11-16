package org.BattleShipGame.Square;

public class Square {
    private Integer x;

    private Integer y;
    private SquareStatus squareStatus;

    public Square(Integer x, Integer y, SquareStatus squareStatus) {
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

    @Override
    public String toString() {
        return x + " " + y + " " + squareStatus.toString();
    }
}
