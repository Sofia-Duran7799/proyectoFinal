import java.util.*;

public abstract class Barco implements IDibujable {
    protected int tamaño;
    protected List<Posicion> posiciones;
    protected boolean[] tocado;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.posiciones = new ArrayList<>();
        this.tocado = new boolean[tamaño];
    }

    public boolean registrarDisparo(int x, int y) {
        for (int i = 0; i < posiciones.size(); i++) {
            Posicion p = posiciones.get(i);
            if (p.getX() == x && p.getY() == y) {
                tocado[i] = true;
                return true;
            }
        }
        return false;
    }

    public boolean estaHundido() {
        for (boolean t : tocado) {
            if (!t) return false;
        }
        return true;
    }

    public void setPosiciones(List<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public List<Posicion> getPosiciones() {
        return posiciones;
    }

    public abstract String getNombre();

    @Override
    public void dibujar() {
        for (Posicion p : posiciones) {
            p.dibujar("gray");
        }
    }
}
