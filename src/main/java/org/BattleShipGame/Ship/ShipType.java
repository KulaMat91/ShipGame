package org.BattleShipGame.Ship;

public enum ShipType {
    ONE(1,0),
    TWO(2,3),
    THREE(3,2),
    FOUR(4,1);

    public int shipSize;
    public int amountOfAvailableShips;

    ShipType(int shipSize, int amountOfAvailableShips) {
        this.shipSize = shipSize;
        this.amountOfAvailableShips = amountOfAvailableShips;
    }
}