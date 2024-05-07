package frontend.buttons;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import books.backend.Books;
import frontend.UpdateBookWindow;
import inf.Dao;

@SuppressWarnings("serial")
public class UpdateButton extends AppButtons {

	private Books book;
	private UpdateBookWindow updateBookWindow;

	private JTextField nameField;
	private JTextField authorField;
	private JTextField yearReleaseField;

	public UpdateButton(String text, JTextField nameField, JTextField authorField, JTextField yearReleaseField,
			Books book, UpdateBookWindow updateBookWindow) {

		super(text);
		this.nameField = nameField;
		this.authorField = authorField;
		this.yearReleaseField = yearReleaseField;
		this.book = book;
		this.updateBookWindow = updateBookWindow;
	}

	public void mousePressed(MouseEvent e) {

		Dao<Books> booksDao = new Dao<>(Books.class);

		String name = nameField.getText();
		String author = authorField.getText();
		int yearRelease = 0;
		boolean nameCheck = name.isEmpty() && name.isBlank() ? true : false;
		boolean authorCheck = author.isEmpty() && author.isBlank() ? true : false;
		boolean yearConversion;
		boolean nameLength = false;
		boolean authorLength = false;

		try {

			yearRelease = Integer.parseInt(yearReleaseField.getText());
			yearConversion = true;
		} catch (NumberFormatException error) {
			yearConversion = false;
		}

		if (nameCheck) {
			book.setName(book.getName());
		} else {

			if (name.length() > 255) {
				nameLength = true;
			} else {
				book.setName(name);
			}
		}

		if (authorCheck) {
			book.setAuthor(book.getAuthor());
		} else {

			if (author.length() > 255) {
				authorLength = true;
			} else {
				book.setAuthor(author);
			}
		}

		if (!yearReleaseField.getText().isEmpty() && yearConversion) {
			book.setYearRelease(yearRelease);
		} else {
			book.setYearRelease(book.getYearRelease());
		}

		if (e.getButton() == 1 && (nameLength || authorLength)) {

			if (nameLength) {
				JOptionPane.showMessageDialog(this, "O nome do livro é longo demais!");
			} else if (authorLength) {
				JOptionPane.showMessageDialog(this, "O nome do autor é longo demais!");
			}
		} else if (e.getButton() == 1 && (!nameCheck || !authorCheck || yearConversion)
				&& (!nameLength || !authorLength)) {

			booksDao.updateBook(book);

			JOptionPane.showMessageDialog(this, "Livro atualizado com sucesso!");
			updateBookWindow.dispose();
		} else {

			JOptionPane.showMessageDialog(this, "Nenhuma alteração foi feita!");
			updateBookWindow.dispose();
		}

		booksDao.closeDao();
	}
}
