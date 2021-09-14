package how3d.renderable3d;

import java.awt.Graphics;
import how3d.RGB;
import how3d.Vector3D;

public class Rect3D implements Renderable3D {
    
    private Vector3D a, b, c, d;
    private RGB color;

    /**
     * a & c should be on the same diagonal, as should b & d
     */
    public Rect3D(Vector3D a, Vector3D b, Vector3D c, Vector3D d, RGB color) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

        Triangle3D t1 = new Triangle3D(a, b, c, color);
        Triangle3D t2 = new Triangle3D(a, d, c, color);
        t1.render(g, camPos, fov, swidth, sheight);
        t2.render(g, camPos, fov, swidth, sheight);

    }

}
