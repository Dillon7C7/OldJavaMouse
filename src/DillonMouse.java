//By Dillon Dommer
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DillonMouse {

	public static void main(String[] args) {

		Mouse frame = new Mouse();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
}

class Mouse extends JFrame implements ActionListener {

	JPanel pane, buttons, circle; // Panes
	JButton redb, blueb, greenb, whiteb, purpleb; // For red, green, blue,
													// white and purple buttons

	/* Menu */
	JMenuBar menu;
	JMenu close;
	JMenuItem exit;
	private int x, y; // To get the mouse coordinates.
	boolean red, blue, green, white, purple, clear; // Colors for the buttons,
													// true =
													// color of circle.
	int radi = 15; // Radius of the circle(s).

	// Constructor
	public Mouse() {

		super("Mouse Droppings");

		// External Frame
		setSize(400, 400);
		setLocation(400, 250);
		setResizable(false);

		// Mouse Listener
		addMouseListener(new MouseAdapter()

		{
			// Only two of the five methods are needed
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}

			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}
		});

		pane = (JPanel) getContentPane();
		pane.setLayout(new BorderLayout());

		menu = new JMenuBar(); // Menu

		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		// Creating the color buttons
		redb = new JButton("Red");
		blueb = new JButton("Blue");
		greenb = new JButton("Green");
		whiteb = new JButton("White");
		purpleb = new JButton("Purple");
		exit = new JMenuItem("Exit"); // Exit Button
		exit.setAccelerator(KeyStroke.getKeyStroke( // Hot key
				KeyEvent.VK_Z, ActionEvent.SHIFT_MASK));

		// Menu
		close = new JMenu("File");
		close.add(exit);
		menu.add(close);

		// Button action listeners
		redb.addActionListener(this);
		blueb.addActionListener(this);
		greenb.addActionListener(this);
		whiteb.addActionListener(this);
		purpleb.addActionListener(this);
		exit.addActionListener(this);

		// Adding color buttons to JPanel
		buttons.add(redb);
		buttons.add(blueb);
		buttons.add(greenb);
		buttons.add(whiteb);
		buttons.add(purpleb);
		buttons.setBackground(Color.orange);

		circle = new JPanel(); // This is where the circles will be drawn
		circle.setBackground(Color.yellow);

		pane.add(circle, BorderLayout.CENTER); /* Add the 2 panes to pane */
		pane.add(buttons, BorderLayout.SOUTH);

		setJMenuBar(menu); // Adds menu to frame

		// Make sure all panes are visible.
		System.out.println(redb.getPreferredSize());
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) { // Menu button event
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}

		// The true vales colors of the circles. (English)
		if (e.getActionCommand().equals("Red")) {
			red = true;
			blue = false;
			green = false;
			white = false;
			purple = false;
		}

		else if (e.getActionCommand().equals("Blue")) {
			red = false;
			blue = true;
			green = false;
			white = false;
			purple = false;
		}

		else if (e.getActionCommand().equals("Green")) {
			red = false;
			blue = false;
			green = true;
			white = false;
			purple = false;
		}

		else if (e.getActionCommand().equals("White")) {
			red = false;
			blue = false;
			green = false;
			white = true;
			purple = false;
		}

		else if (e.getActionCommand().equals("Purple")) {
			red = false;
			blue = false;
			green = false;
			white = false;
			purple = true;
		}
	}

	public void paint(Graphics g) {
		// Sets the color of the circle(s)
		if (red == true) {
			g.setColor(Color.RED);
		}

		else if (blue == true) {
			g.setColor(Color.BLUE);
		}

		else if (green == true) {
			g.setColor(Color.GREEN);
		}

		else if (white == true) {
			g.setColor(Color.WHITE);
		}

		else if (purple == true) {
			g.setColor(Color.MAGENTA);
		}

		else {
			g.setColor(Color.BLACK); // Default color in case none are selected.
		}

		// Location, width, and height of circle(s).
		g.fillOval(x - radi, y - radi, 2 * radi, 2 * radi);
	}
}
