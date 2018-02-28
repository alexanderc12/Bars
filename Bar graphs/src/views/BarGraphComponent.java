package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

import models.InvalidParameterException;
/**
 * Compoenete que permite mostrar una barra de varios colores de acuerdo a los porcentajes asignados,
 *  esto con el fin construir un diagrama de barras
 * @author Alexander Castro
 *
 */
public class BarGraphComponent extends JPanel{

	private static final long serialVersionUID = 1L;
	private double[] data;
	private Color [] colors;

	private BarGraphComponent(double [] data, Color [] colors) {
		this.data = data;
		this.colors = colors;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, getWidth(), getHeight());
		int startPointY = 0;
		for (int i = 0; i < data.length; i++) {
			g.setColor(colors[i]);
			int actualHeight = (int) (data[i] * getHeight());
			g.fillRect(0, startPointY, getWidth(), actualHeight);	
			g.setColor(Color.WHITE);
			g.drawString((data[i] * 100) + "%", getWidth() / 2, startPointY + (actualHeight / 2));
			startPointY += actualHeight;
		}
	}
	
	public static BarGraphComponent create(double [] data, Color [] colors){
		if (data.length != colors.length || Arrays.stream(data).sum() != 1) {
			throw new InvalidParameterException();
		}
		return new BarGraphComponent(data, colors);
	}
}