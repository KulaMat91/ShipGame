package Ship;

import java.util.List;

public class Ship {
    private List<Square> squares;
    private ShipType shipType;

    public Ship(List<Square> newShip, ShipType shipType) {
        this.squares = newShip;
        this.shipType = shipType;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public ShipType getShipType() {
        return shipType;
    }



}
