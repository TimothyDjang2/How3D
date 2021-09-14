package how3d;
public class Vector3D {
    
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    /**returns a vector2d for a point on the canvas.
     * 
     * @param camPos  | camera position
     * @param fov     | fov in degrees
     * @param swidth  | window width
     * @param sheight | window height
     * @return
     * */
    public Vector2D toCanvas(Vector3D camPos, double fov, int swidth, int sheight) {

        double vDist = 1; //semi-arbitrary number that moves the rendering plane closer/farther from the camera
        double aspectRatio = swidth / sheight;
        double vwidth = Math.sin(MathUtils.toRadians(fov / 2)) * 2 * vDist;
        double vheight = vwidth / aspectRatio;

        //z is being used as distance from the camera
        double xOfs = ((x - camPos.getX()) / (z - camPos.getZ())) + (0.5 * vwidth); //add half vwidth so the offset's value goes from 0 - vwidth;
        double yOfs = ((y - camPos.getY()) / (z - camPos.getZ())) + (0.5 * vheight);

        //percent across screen * screen dimension
        double xOut = ((xOfs / vwidth) * swidth);
        double yOut = sheight - ((yOfs / vheight) * sheight);

        return new Vector2D(xOut, yOut);

    }

}
