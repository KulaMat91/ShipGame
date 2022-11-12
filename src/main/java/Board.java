public class Board {

    private int sizeX;
    private int sizeY;
    private Square form[][];

    public Board(int sizeX, int sizeY, Square[][] form) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.form = form;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Square getSquare(int x, int y){
        return form[x][y];
    }

    public Square[][] fillBoard(int x, int y){
        form = new Square[sizeX][sizeY];
        for(int row = 0; row < x; row++){
            for(int col = 0; col < y; col++){
                form[row][col] = new Square(row, col, SquareStatus.OCEAN);
            }
        }
        return form;
    }

    public void buildShip(Square square, Ship ship){
        switch (ship.getShipType().length){
            case 1:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                break;
            case 2:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                int x = square.getX();
                int y = square.getY();
                ship.add(new Square(x, y+1,SquareStatus.SHIP));
                break;
            case 3:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y+1,SquareStatus.SHIP));
                ship.add(new Square(x, y+2,SquareStatus.SHIP));
                break;
            case 4:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y+1,SquareStatus.SHIP));
                ship.add(new Square(x, y+2,SquareStatus.SHIP));
                ship.add(new Square(x, y+3,SquareStatus.SHIP));
            case 5:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y+1,SquareStatus.SHIP));
                ship.add(new Square(x, y+2,SquareStatus.SHIP));
                ship.add(new Square(x, y+3,SquareStatus.SHIP));
                ship.add(new Square(x, y+4,SquareStatus.SHIP));
                break;
        }
    }




}
