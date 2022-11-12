public enum ShipType {
    BOAT(1),
    BLACK_PEARL(2),
    SUBMARINE(3),
    TITANIC(4),
    LEGO_SHIP(5);

    public final int length;
    public int number;

    ShipType(int length) {
        this.length = length;
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