package how3d.renderable3d;

import java.awt.Graphics;

import how3d.Vector3D;

public interface Renderable3D {
    
    public void render(Graphics g, Vector3D camPos, double fov, int swidth, int sheight);

}
