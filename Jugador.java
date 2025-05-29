public class Jugador {
    private Tablero tablero;

    public Jugador() {
        tablero = new Tablero();
        tablero.colocarBarcosAleatoriamente();
    }

    public Tablero getTablero() {
        return tablero;
    }
}
