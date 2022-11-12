package org.example.ShipGame.Ship;

import java.util.LinkedList;
import java.util.List;

public class ShipList {

    public static LinkedList<ShipType> getShips(){
        LinkedList<ShipType> shipsToDeploy = new LinkedList<>();
        for (ShipType ship : ShipType.values()){
            for (int i = 1 ; i <= ship.amountOfAvailableShips ; i++){
                shipsToDeploy.add(ship);
            }
        }
        return shipsToDeploy;
    }

}
