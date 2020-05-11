import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * this class creates an object of each layer and passes them to 
 * the next layer. It finally calls the draw method of the top layer.
 * It also contains main method.
 * @author saman
 *
 */
public class DemoDecoratorPattern extends JPanel {
	public DemoDecoratorPattern(){
		JFrame frame = new JFrame("Graphics Program");
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.setVisible(true);
	}
/**
 * creates an object of each layer and passes them to 
 * the next layer. It finally calls the draw method of the top layer.
 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Text txt= new Text("Hello World",120,150);
		BorderDecorator brd = new BorderDecorator(txt,100,100,100,100);
		ColourFrameDecorator clrFrmDecor = new ColourFrameDecorator(brd,95,95,112,112,10);
		//		clrFrmDecor.draw(g);
		int fontSize = 10;
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		ColouredGlassDecorator t = new ColouredGlassDecorator(clrFrmDecor,100,100,100,100);
		t.draw(g);
	}


/**
 * main method
 * @param args
 */
	public static void main (String[]args) {
		DemoDecoratorPattern d = new DemoDecoratorPattern();
	}
}