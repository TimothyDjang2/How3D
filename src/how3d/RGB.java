package how3d;
import java.awt.Color;

public class RGB {

    float r, g, b;
    
    public RGB(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color getLightColor(float l) {
        return new Color(r * l, g * l, b * l);
    }

    public Color getColor() { return new Color(r, g, b); }

}
