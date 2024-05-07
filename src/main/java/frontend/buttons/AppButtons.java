package frontend.buttons;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class AppButtons extends JButton implements MouseListener {

	public AppButtons(String text) {
		
		setText(text);
		setBackground(Color.WHITE);
		addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
