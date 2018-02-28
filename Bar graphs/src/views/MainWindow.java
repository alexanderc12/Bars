package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Ventana para demostrar el funcionamiento del componenete BarGraphComponent
 * @author Alexander
 *
 */
public class MainWindow extends JFrame{

	private static final Color[] COLORS_GRAPH_RIGHT = new Color [] {Color.decode("#d2ea32"), Color.decode("#016773"),
			Color.decode("#0066b2"), Color.decode("#f6b128")};
	private static final Color[] COLORS_GRAPH_LEFT = new Color [] {Color.decode("#ec1c24"), Color.decode("#fdbd10"),
					Color.decode("#0066b2"), Color.decode("#ed7902")};
	private static final double[] DATA_GRAPH_RIGHT = new double[] {0.1, 0.2, 0.3, 0.4};
	private static final double[] DATA_GRAPH_LEFT = new double[] {0.5, 0.2, 0.2, 0.1};
	private static final String ICON_PATH = "/img/icon.png";
	private static final String TITLE_EXAMPLE_LEFT = "Example #1";
	private static final String TITLE_EXAMPLE_RIGHT = "Example #2";
	private static final String TITLE = "Bar graphs";
	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		setTitle(TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ICON_PATH)).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		BarGraphComponent barGraphComponentLeft =  BarGraphComponent.create(DATA_GRAPH_LEFT, COLORS_GRAPH_LEFT);
		barGraphComponentLeft.setBorder(BorderFactory.createTitledBorder(TITLE_EXAMPLE_LEFT));
		((TitledBorder)barGraphComponentLeft.getBorder()).setTitleColor(Color.WHITE);
		panel.add(barGraphComponentLeft);
		
		BarGraphComponent barGraphComponentRight =  BarGraphComponent.create(DATA_GRAPH_RIGHT, COLORS_GRAPH_RIGHT);
		barGraphComponentRight.setBorder(BorderFactory.createTitledBorder(TITLE_EXAMPLE_RIGHT));
		((TitledBorder)barGraphComponentRight.getBorder()).setTitleColor(Color.WHITE);
		panel.add(barGraphComponentRight);
		
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
}