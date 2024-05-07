package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import frontend.layouts.UpButtons;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public Window() {

		layoutManager();

		setTitle("Gerenciador de Livros");
		setSize(850, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setVisible(true);
	}

	public void layoutManager() {

		setLayout(new BorderLayout());

		UpButtons buttons = new UpButtons(this);
		add(buttons, BorderLayout.NORTH);
	}

	public static void main(String[] args) {

		new Window();
	}
}
