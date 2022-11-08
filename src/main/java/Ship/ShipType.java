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

    public final int size;
    public final int number;

    ShipType(int size, int number) {
        this.size = size;
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public int getNumber() {
        return number;
    }
}
