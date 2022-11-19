package org.BattleShipGame.Ship;

//TODO dziedziczenie statków
public enum ShipType {
    ONE(1,1),
    TWO(2,0),
    THREE(3,0),
    FOUR(4,1);

    public int shipSize;
    public int amountOfAvailableShips;

    ShipType(int shipSize, int amountOfAvailableShips) {
        this.shipSize = shipSize;
        this.amountOfAvailableShips = amountOfAvailableShips;
    }
}