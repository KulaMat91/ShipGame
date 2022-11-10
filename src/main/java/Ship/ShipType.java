package Ship;
/*
Implement enum ShipType and it's methods.

    Enum ShipType represents ship types -
    Each ShipType has a unique length.

    Do dyspozycji gracze mają najczęściej:

    Cztery jednomasztowce (czyli statki na jedną kratkę),
    Trzy dwumasztowce (statki na dwie kratki),
    Dwa trzymasztowce (statki na trzy kratki),
    Oraz jeden czteromasztowiec (statek na cztery kratki).
 */

public enum ShipType {
    BOAT(1, 4),
    SAIL_BOAT(2, 3),
    SUBMARINE(3, 2),
    BLACK_PEARL(4, 1),
    ;

    public final int length;
    public int number;

    ShipType(int length, int number) {
        this.length = length;
        this.number = number;
    }

    public int getLength() {
        return length;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
