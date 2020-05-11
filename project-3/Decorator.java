/**
 * this is an abstract class which decorators extend and have access to its variables.
 * @author saman
 *
 */
public abstract class Decorator implements Component {
	protected Component cmp;
	public int height;
	protected int x;
	protected int y;
	protected int width;
}
