package how3d.renderable3d;
import java.awt.Graphics;

import how3d.RGB;
import how3d.Vector2D;
import how3d.Vector3D;

public class Triangle3D implements Renderable3D {
    
    private Vector3D a, b, c;
    private RGB color;

    public Triangle3D(Vector3D a, Vector3D b, Vector3D c, RGB color) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }

    /**
     * 
     * @param g       | Graphics component to draw to
     * @param camPos  | Camera position
     * @param fov     | FOV
     * @param swidth  | Width of window
     * @param sheight | Height of window
     */
    public void render(Graphics g, Vector3D camPos, double fov, int swidth, int sheight) {

        g.setColor(color.getColor());

        Vector2D p1 = a.toCanvas(camPos, fov, swidth, sheight);
        Vector2D p2 = b.toCanvas(camPos, fov, swidth, sheight);
        Vector2D p3 = c.toCanvas(camPos, fov, swidth, sheight);
        
        int[] xp = { (int)p1.getX(), (int)p2.getX(), (int)p3.getX() };
        int[] yp = { (int)p1.getY(), (int)p2.getY(), (int)p3.getY() };

        g.fillPolygon(xp, yp, 3);
    }

}
