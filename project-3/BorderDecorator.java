import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import javax.swing.JPanel;
/**
 * This class is the third layer which receives the layer underneath and calls their draw method
 * before drawing itself
 * @author saman
 *
 */
public class BorderDecorator extends Decorator {
	/**
	 * constructor which receives an object of type Text and 4 integers which 
	 * identify the location and size of the rectangle.
	 * @param clrFrmDecor
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public BorderDecorator(Text tx,int x,int y,int width , int height) {
		super.cmp=tx;
		super.x = x;
		super.y = y;
		super.width = width;
		super.height=height;
	}

	/**
	 * draw method, draws a dashed frame
	 */
	@Override
	public void draw(Graphics g) {
		cmp.draw(g);
		float dash1[] = { 10.0f };
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;		
		g2d.setStroke(new BasicStroke(3.0f,
				BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 1.0f));
		g2d.drawRect(x, y, width, height);

	}

}
