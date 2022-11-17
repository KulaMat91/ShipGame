package org.BattleShipGame.Ship;

import org.BattleShipGame.Square.Square;
import org.BattleShipGame.Square.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Ship {
private List<Square> shipSquares; //TODO przypisywanie pól do Shipa w momencie ustawiania na boardzie
    //zwracanie statku w momencie  trafienia w jakiekolwiek jego pole done
    public Ship() {
        shipSquares = new ArrayList<>();
    }

    public Ship getShipSquaresByCoordinates(Integer[] coordinates){
        for (Square square: shipSquares) {
            if (square.getSquareCoordinates().equals(coordinates)){
                return this;
            }
        }
        return null; //TODO Can we return something else?
    }

    public void setShipSquares(List<Square> shipSquares) {
        this.shipSquares = shipSquares;
    }

    public void setShipSquare(Square square){
        shipSquares.add(square);
    }

    public List<Square> getShipSquares() {
        return shipSquares;
    }

    public Boolean isShipAlive(){
        for (Square square : shipSquares){
            if (square.getSquareStatus().equals(SquareStatus.SHIP)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipSquares=" + shipSquares +
                '}';
    }

}
