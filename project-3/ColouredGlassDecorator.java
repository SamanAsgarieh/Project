import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * This class is the top layer of decoration which gets all the 
 * layers underneath and draws them layer by layer before drawing itself
 * @author saman
 *
 */
public class ColouredGlassDecorator extends Decorator {
	/**
	 * constructor which receives an object of type ColourFrameDecorator and 4 integers which 
	 * identify the location and size of the rectangle.
	 * @param clrFrmDecor
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public ColouredGlassDecorator(ColourFrameDecorator clrFrmDecor,int x,int y,int width,int height) {
		super.cmp=clrFrmDecor;
		super.x = x;
		super.y = y;
		super.width = width;
		super.height=height;
	}
	/**
	 * draw method, draws a transparent rectangle
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		cmp.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
		g2d.fillRect(x, y, width, height);

	}

}
