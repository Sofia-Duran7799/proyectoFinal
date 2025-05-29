public class Posicion {
    private int x, y;
    private Square square;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
        this.square = new Square();
        square.changeSize(20);
        square.moveHorizontal(30 + x * 22);
        square.moveVertical(30 + y * 22);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void dibujar(String color) {
        square.changeColor(color);
        square.makeVisible();
    }

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }
}
