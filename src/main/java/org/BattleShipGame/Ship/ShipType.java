package org.BattleShipGame.Ship;

public enum ShipType {
    ONE(1,2),
    TWO(2,2),
    THREE(3,0),
    FOUR(4,1);

    public int shipSize;
    public int amountOfAvailableShips;

    ShipType(int shipSize, int amountOfAvailableShips) {
        this.shipSize = shipSize;
        this.amountOfAvailableShips = amountOfAvailableShips;
    }
}