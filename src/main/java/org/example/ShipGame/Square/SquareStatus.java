package org.example.ShipGame.Square;

public enum SquareStatus {
 WATER('~'),
    TEST('-'),
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

