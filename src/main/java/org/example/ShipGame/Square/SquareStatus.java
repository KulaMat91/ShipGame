package org.example.ShipGame.Square;

public enum SquareStatus {
 WATER('~'),
 WATER_BUT_SHIP_CANNOT_BE_DEPLOYED('-'),
 SHIP('s'),
 HITTED('x'),
 MISSED('o'),
 SUNK('%');

 private Character character;

    SquareStatus(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        String str = "" + this.character;
        return str;
    }

}

