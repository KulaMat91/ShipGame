package org.BattleShipGame.Ship;

public enum ShipType {
    ONE(1,0),
    TWO(2,1),
    THREE(3,0),
    FOUR(4,0);

    public int shipSize;
    public int amountOfAvailableShips;

    ShipType(int shipSize, int amountOfAvailableShips) {
        this.shipSize = shipSize;
        this.amountOfAvailableShips = amountOfAvailableShips;
    }
}