package org.BattleShipGame.Square;

public enum SquareStatus {
 WATER('~'),
 SHIP('S'),
 HIT('X'),
 MISS('o'),
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

