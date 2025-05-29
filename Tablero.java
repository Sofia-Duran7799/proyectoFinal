import java.util.*;

public class Tablero {
    private List<Barco> barcos;

    public Tablero() {
        barcos = new ArrayList<>();
    }

    public void colocarBarcosAleatoriamente() {
        Random rand = new Random();
        Barco[] plantilla = { new Submarino(), new Destructor(), new Portaaviones() };

        for (Barco b : plantilla) {
            boolean colocado = false;
            while (!colocado) {
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);
                boolean horizontal = rand.nextBoolean();
                List<Posicion> pos = new ArrayList<>();
                boolean valido = true;

                for (int j = 0; j < b.tamaño; j++) {
                    int nx = horizontal ? x + j : x;
                    int ny = horizontal ? y : y + j;
                    if (nx >= 10 || ny >= 10 || hayBarcoEn(nx, ny)) {
                        valido = false;
                        break;
                    }
                    pos.add(new Posicion(nx, ny));
                }

                if (valido) {
                    b.setPosiciones(pos);
                    barcos.add(b);
                    colocado = true;
                }
            }
        }
    }

    private boolean hayBarcoEn(int x, int y) {
        for (Barco b : barcos) {
            for (Posicion p : b.getPosiciones()) {
                if (p.equals(x, y)) return true;
            }
        }
        return false;
    }

    public String recibirDisparo(int x, int y) {
        for (Barco b : barcos) {
            if (b.registrarDisparo(x, y)) {
                if (b.estaHundido()) return "¡Hundiste un " + b.getNombre() + "!";
                return "¡Tocado!";
            }
        }
        return "Agua.";
    }

    public boolean todosHundidos() {
        for (Barco b : barcos) {
            if (!b.estaHundido()) return false;
        }
        return true;
    }

    public void dibujar(boolean ocultar) {
        for (Barco b : barcos) {
            if (!ocultar) b.dibujar();
        }
    }
}
