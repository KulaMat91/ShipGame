package org.example.ShipGame;

public enum Ship {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    public int shipSize;

    Ship(int shipSize) {
        this.shipSize = shipSize;
    }
}
