package org.example.ShipGame.Board;

public enum FieldStatus {
 WATER('~'),
 WATER_BUT_SHIP_CANNOT_BE_DEPLOYED('-'),
 SHIP('s'),
 HITTED('x'),
 MISSED('o');

 private Character character;

    FieldStatus(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }
}
