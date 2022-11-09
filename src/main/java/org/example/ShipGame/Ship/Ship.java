package org.example.ShipGame.Ship;

public enum Ship {
    ONE(1,4),
    TWO(2,3),
    THREE(3,2),
    FOUR(4,1);

    public int shipSize;
    public int amountOfAvailableShips;

    Ship(int shipSize, int amountOfAvailableShips) {
        this.shipSize = shipSize;
        this.amountOfAvailableShips = amountOfAvailableShips;
    }
}