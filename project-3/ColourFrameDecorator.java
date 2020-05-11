import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
/**
 * This class is the third layer which receives the layers underneath and calls their draw method
 * before drawing itself
 * @author saman
 *
 */
public class ColourFrameDecorator extends Decorator {
int thickness;
/**
 * constructor which receives an object of type BorderDecorator and 5 integers which 
 * identify the location, size and thickness of the colored frame.
 * @param clrFrmDecor
 * @param x
 * @param y
 * @param width
 * @param height
 * @param t
 */
	public ColourFrameDecorator(BorderDecorator brdrDecor,int x,int y,int width,int height,int t) {
		super.x = x;
		super.y = y;
		super.width = width;
		super.height=height;
		thickness = t;
		super.cmp=brdrDecor;
	}

	
	/**
	 * draw method, draws a red rectangle
	 */
	@Override
	public void draw(Graphics g) {
		cmp.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(Color.red);
		g2d.drawRect(x, y, width, height);

	}

}
