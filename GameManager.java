import java.util.Random;

public class GameManager {
    private static GameManager instancia;
    private Jugador jugador;
    private Jugador computadora;
    private Random random;

    private GameManager() {
        jugador = new Jugador();
        computadora = new Jugador();
        random = new Random();
    }

    public static GameManager getInstancia() {
        if (instancia == null) {
            instancia = new GameManager();
        }
        return instancia;
    }

    public void iniciarJuego() {
        jugador.getTablero().dibujar(false);
        computadora.getTablero().dibujar(true);
    }

    public String turnoJugador(int x, int y) {
        String resultado = computadora.getTablero().recibirDisparo(x, y);
        if (computadora.getTablero().todosHundidos()) {
            return resultado + "\n¡Ganaste!";
        }
        return resultado + "\n" + turnoComputadora();
    }

    private String turnoComputadora() {
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        String resultado = jugador.getTablero().recibirDisparo(x, y);
        if (jugador.getTablero().todosHundidos()) {
            return resultado + "\n¡Perdiste!";
        }
        return "Computadora dispara a (" + x + "," + y + "): " + resultado;
    }
}
