package org.example.ShipGame.Ship;

import java.util.LinkedList;
import java.util.List;

public class ShipList {

    public static List<Ship> getShips(){
        List<Ship> shipsToDeploy = new LinkedList<>();
        for (Ship ship : Ship.values()){
            for (int i = 1 ; i <= ship.amountOfAvailableShips ; i++){
                shipsToDeploy.add(ship);
            }
        }
        return shipsToDeploy;
    }

}
