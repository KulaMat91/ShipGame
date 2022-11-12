import java.util.List;

public class Ship {
    private List<Square> newShip;
    private ShipType shipType;

    public Ship(List<Square> newShip, ShipType shipType) {
        this.newShip = newShip;
        this.shipType = shipType;
    }

    public List<Square> getSquares() {
        return newShip;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void add(Square square){
        newShip.add(square);
    }
}
