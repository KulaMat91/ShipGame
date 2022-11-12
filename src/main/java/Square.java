public class Square {

    private int x;
    private int y;
    public SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus squareStatus) {
        this.x = x;
        this.y = y;
        this.squareStatus = squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public char getChar(){
        char sign = ' ';
        switch(squareStatus){
            case EMPTY:
                sign = '-';
            case HIT:
                sign = 'x';
            case SHIP:
                sign = '#';
            case OCEAN:
                sign = '~';
            case MISSED:
                sign = 'o';
        }
        return sign;
    }
}
