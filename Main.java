import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameManager juego = GameManager.getInstancia();
        juego.iniciarJuego();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa coordenadas (x y): ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            String mensaje = juego.turnoJugador(x, y);
            System.out.println(mensaje);
            if (mensaje.contains("¡Ganaste!") || mensaje.contains("¡Perdiste!")) break;
        }
    }
}
