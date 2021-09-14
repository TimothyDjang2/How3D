package how3d;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import how3d.renderable3d.Line3D;
import how3d.renderable3d.Rect3D;
import how3d.renderable3d.Renderable3D;
import how3d.renderable3d.Triangle3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Core {

    public static JFrame window;
    public static JLabel content;
    public static BufferedImage display, buffer;
    public static Graphics dispG, bufG;

    public static ArrayList<Renderable3D> renderlist = new ArrayList<Renderable3D>();
    public static double fov = 90.0;
    private static Vector3D cameraPos = new Vector3D(0, 0, 0);

    public static void main(String[] args) {

        window = new JFrame();

        display = new BufferedImage(Constants.SWIDTH, Constants.SHEIGHT, BufferedImage.TYPE_INT_ARGB);
        buffer = new BufferedImage(Constants.SWIDTH, Constants.SHEIGHT, BufferedImage.TYPE_INT_ARGB);

        dispG = display.getGraphics();
        bufG = buffer.getGraphics();

        ImageIcon icon = new ImageIcon(display);

        content = new JLabel(icon);
        content.setSize(Constants.SWIDTH, Constants.SHEIGHT);

        window.setSize(Constants.SWIDTH, Constants.SHEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window.setContentPane(content);
        content.setVisible(true);



        renderlist.add(new Rect3D(new Vector3D(0, -1, 4), new Vector3D(0, -1, 12), new Vector3D(-1, 1, 12), new Vector3D(-1, 1, 4), new RGB(1.0f, 0.0f, 0.0f)));
        renderlist.add(new Triangle3D(new Vector3D(0, -1, 4), new Vector3D(-1, -1, 4), new Vector3D(-1, 1, 4), new RGB(0.6f, 0.0f, 0.0f)));

        renderlist.add(new Rect3D(new Vector3D(0, -1, 1), new Vector3D(0, -1, 12), new Vector3D(1, -1, 12), new Vector3D(1, -1, 1), new RGB(0.0f, 1.0f, 0.0f)));
        renderlist.add(new Rect3D(new Vector3D(1, -1, 12), new Vector3D(1, 1, 12), new Vector3D(1, 1, 6), new Vector3D(1, -1, 6), new RGB(0.0f, 0.5f, 0.0f)));
        //renderlist.add(new Triangle3D(new Vector3D(0, 0, 4), new Vector3D(1, 0, 4), new Vector3D(0, 1, 4), new RGB(0.0f, 1.0f, 0.0f)));

        //renderlist.add(new Triangle3D(new Vector3D(-3, -1, 6), new Vector3D(-3, 1, 6), new Vector3D(-3, -1, 12), new RGB(1.0f, 1.0f, 0.0f)));
        //renderlist.add(new Triangle3D(new Vector3D(-3, 1, 6), new Vector3D(-3, -1, 12), new Vector3D(-3, 1, 12), new RGB(1.0f, 1.0f, 0.0f)));

        //renderlist.add(new Triangle3D(new Vector3D(-1, 0.5, 1), new Vector3D(1, 0.5, 1), new Vector3D(0, 0.5, 6), new RGB(1.0f, 0.0f, 0.0f)));

        //renderlist.add(new Line3D(new Vector3D(1, -1, 0), new Vector3D(1, -1, 20), new RGB(1.0f, 1.0f, 1.0f)));

        renderGarbage();
        blit();

    }

    private static void blit() {
        dispG.drawImage(buffer, 0, 0, null);
        window.repaint();
    }

    private static void renderGarbage() {

        Graphics g = bufG;
        g.clearRect(0, 0, Constants.SWIDTH, Constants.SHEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.SWIDTH, Constants.SHEIGHT);
        g.setColor(Color.GREEN);

        for (Renderable3D r : renderlist) {

            r.render(g, cameraPos, fov, Constants.SWIDTH, Constants.SHEIGHT);
        
        }
    }

}