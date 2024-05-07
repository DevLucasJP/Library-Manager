package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import books.backend.Books;
import frontend.buttons.UpdateButton;
import frontend.layouts.UpdateBookL;

@SuppressWarnings("serial")
public class UpdateBookWindow extends JFrame {

	private Books book;

	public UpdateBookWindow(Books book) {

		this.book = book;

		layoutManager();

		setTitle("Atualizar Livro");
		setSize(400, 300);
		setLocationRelativeTo(null);

		setVisible(true);
	}

	public void layoutManager() {

		setLayout(new BorderLayout());

		UpdateBookL updateBookLayout = new UpdateBookL();
		add(updateBookLayout, BorderLayout.CENTER);

		UpdateButton updateButton = new UpdateButton("Atualizar", updateBookLayout.getNameField(),
				updateBookLayout.getAuthorField(), updateBookLayout.getYearReleaseField(), book, this);
		add(updateButton, BorderLayout.SOUTH);
	}
}
