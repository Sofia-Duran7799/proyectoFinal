Este proyecto implementa una versión simplificada del clásico juego BattleShip (Hundir la Flota), 
utilizando los principios de la Programación Orientada a Objetos como herencia, interfaces, bajo acoplamiento, 
y cohesión. También emplea el proyecto Shapes de BlueJ para la visualización gráfica.

- Características principales
Dos tableros de juego (jugador y computadora) de 10x10.

Colocación aleatoria de barcos sin solapamiento.

Turnos alternos entre jugador y computadora.

Mensajes de estado visuales al acertar o hundir un barco.

Finalización del juego con mensaje de victoria o derrota.

Interfaz gráfica usando Canvas, Square y Text.


- Instrucciones de ejecución
1. Asegúrate de tener BlueJ instalado y abre el proyecto que contiene todas las clases, incluyendo las del paquete Shapes (Canvas, Square, etc.).

2. Haz clic en "Compile" en BlueJ para compilar todas las clases.

3. Haz clic derecho sobre la clase Main y selecciona void main(String[] args) para comenzar el juego


Reglas del juego
1. Cada quien tiene un tablero con barcos acomodados aleatoriamente.

2. Comienza el juego y el jugador y computadora seleccionan una coordenadas.

3. Al seleccionar las coordenadas, se dispara una bomba

4. Si la bomba cae en el agua, no pasa nada, siguiente turno. Si pega en un barco, se marca como ¡Tocado!

5. Cada barco tiene tamaños diferentes. Uno puede tener solo 2 toques de ataque, otro puede tener hasta 4

6. Cuando un barco es tocado en todos sus puntos, se hunde. 

7. El juego se acaba cuando a un jugador hunde todos los barcos al oponente y el jugador que hunde todos los barcos del oponente gana.
