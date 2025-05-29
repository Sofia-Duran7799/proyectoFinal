public class TableroView {

    private Square[][] casillas;
    private final int SIZE = 40;

    private Canvas canvas;

    public TableroView() {
        canvas = Canvas.getCanvas();
        casillas = new Square[10][10];

        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                // Creamos Square con posición x,y en pixeles
                int x = col * SIZE + 50;
                int y = fila * SIZE + 50;
                Square sq = new Square();
                sq.moveHorizontal(x);
                sq.moveVertical(y);
                sq.changeSize(SIZE);
                sq.changeColor("blue");

                casillas[fila][col] = sq;
                sq.makeVisible();
            }
        }
    }

    public void dibujarTablero() {
        // En este proyecto Shapes, el Square ya se dibuja al hacer makeVisible()
        // Pero si quieres repintar, puedes hacer algo aquí
    }

    public Square[][] getCasillas() {
        return casillas;
    }
}
