import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
	/**
	 * This class draws a text in the lowest layer
	 * @author saman
	 *
	 */
public class Text implements Component {
	private int x;
	private int y;
	private String text;
	public Text(String txt , int x,int y) {
		this.x=x;
		this.y = y;
		text =txt;
	}
	/**
	 * draw method, writes a string
	 */
	@Override
	public void draw(Graphics g) {
	      g.drawString(text, x, y);
	}
}