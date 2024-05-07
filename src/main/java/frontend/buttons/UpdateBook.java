package frontend.buttons;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import books.backend.Books;
import frontend.UpdateBookWindow;

@SuppressWarnings("serial")
public class UpdateBook extends AppButtons {

	private Books book;

	public UpdateBook(String text, Books book) {

		super(text);
		this.book = book;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public void mousePressed(MouseEvent e) {

		if (e.getButton() == 1) {

			@SuppressWarnings("unused")
			UpdateBookWindow updateBookWindow = new UpdateBookWindow(book);
		}
	}
}
