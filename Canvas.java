import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

/**
 * Clase Canvas del proyecto Shapes (BlueJ).
 * Modificada para tener una ventana más grande.
 */
public class Canvas {
    private static Canvas canvasSingleton;

    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("Canvas", 800, 600, Color.white);
        }
        return canvasSingleton;
    }

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;
    private int width, height;
    private Map<Object, ShapeDescription> shapes;

    private Canvas(String title, int width, int height, Color bgColour) {
        this.width = width;
        this.height = height;
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setLocation(60, 60);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColour = bgColour;
        frame.pack();
        shapes = new LinkedHashMap<>();
        frame.setVisible(true);
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D) canvasImage.getGraphics();
        graphic.setColor(backgroundColour);
        graphic.fillRect(0, 0, width, height);
        graphic.setColor(Color.black);
    }

    public void draw(Object referenceObject, String color, Shape shape) {
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    public void erase(Object referenceObject) {
        shapes.remove(referenceObject);
        redraw();
    }

    private void redraw() {
        erase();
        for (ShapeDescription shape : shapes.values()) {
            shape.draw(graphic);
        }
        canvas.repaint();
    }

    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.fillRect(0, 0, width, height);
        graphic.setColor(original);
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Interrupción en Canvas.wait()");
        }
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }

    private class ShapeDescription {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            this.colorString = color;
        }

        public void draw(Graphics2D graphic) {
            setForegroundColor(graphic, colorString);
            graphic.fill(shape);
        }

        private void setForegroundColor(Graphics2D graphic, String colorString) {
            switch (colorString.toLowerCase()) {
                case "red": graphic.setColor(Color.red); break;
                case "black": graphic.setColor(Color.black); break;
                case "blue": graphic.setColor(Color.blue); break;
                case "yellow": graphic.setColor(Color.yellow); break;
                case "green": graphic.setColor(Color.green); break;
                case "magenta": graphic.setColor(Color.magenta); break;
                case "white": graphic.setColor(Color.white); break;
                case "gray": graphic.setColor(Color.gray); break;
                case "darkgray": graphic.setColor(Color.darkGray); break;
                case "lightgray": graphic.setColor(Color.lightGray); break;
                case "orange": graphic.setColor(Color.orange); break;
                case "pink": graphic.setColor(Color.pink); break;
                case "cyan": graphic.setColor(Color.cyan); break;
                default: graphic.setColor(Color.black); break;
            }
        }
    }
}
