package frontend.buttons;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import frontend.layouts.AddBookL;
import frontend.layouts.UpButtons;

@SuppressWarnings("serial")
public class AddBook extends AppButtons {

	public AddBook(String text) {
		super(text);
	}

	public void mousePressed(MouseEvent e) {

		if (e.getButton() == 1) {

			UpButtons.removeComponents();
			UpButtons.setOffset(0);

			AddBookL addBookLayout = new AddBookL();
			RegisterButton registerButton = new RegisterButton("Cadastrar", addBookLayout.getNameField(),
					addBookLayout.getAuthorField(), addBookLayout.getYearReleaseField());

			UpButtons.getMainWindow().add(addBookLayout, BorderLayout.CENTER);
			UpButtons.getLabels().add(addBookLayout);
			UpButtons.getMainWindow().add(registerButton, BorderLayout.SOUTH);
			UpButtons.getButtons().add(registerButton);

			UpButtons.getMainWindow().revalidate();
			UpButtons.getMainWindow().repaint();
		}
	}
}
