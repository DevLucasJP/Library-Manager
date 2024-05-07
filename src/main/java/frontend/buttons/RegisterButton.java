package frontend.buttons;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import books.backend.Books;
import frontend.layouts.UpButtons;
import inf.Dao;

@SuppressWarnings("serial")
public class RegisterButton extends AppButtons {

	private JTextField nameField;
	private JTextField authorField;
	private JTextField yearReleaseField;

	public RegisterButton(String text, JTextField nameField, JTextField authorField, JTextField yearReleaseField) {

		super(text);
		this.nameField = nameField;
		this.authorField = authorField;
		this.yearReleaseField = yearReleaseField;
	}

	public void mousePressed(MouseEvent e) {

		Dao<Books> booksDao = new Dao<>(Books.class);

		String name = nameField.getText();
		String author = authorField.getText();
		int yearRelease = 0;
		boolean nameCheck = !name.isEmpty() && !name.isBlank() ? true : false;
		boolean authorCheck = !author.isEmpty() && !author.isBlank() ? true : false;
		boolean yearConversion;
		boolean nameLength = name.length() > 255 ? true : false;
		boolean authorLength = author.length() > 255 ? true : false;

		try {

			yearRelease = Integer.parseInt(yearReleaseField.getText());
			yearConversion = true;
		} catch (NumberFormatException error) {
			yearConversion = false;
		}

		if (e.getButton() == 1 && (nameLength || authorLength || !yearConversion)) {

			if (nameLength) {
				JOptionPane.showMessageDialog(this, "O nome do livro é longo demais!");
			} else if (authorLength) {
				JOptionPane.showMessageDialog(this, "O nome do autor é longo demais!");
			} else {
				JOptionPane.showMessageDialog(this, "O ano digitado é inválido!");
			}
		} else if (e.getButton() == 1 && nameCheck && authorCheck && yearConversion) {

			Books newBook = new Books(name, author, yearRelease);
			Books tempBook = booksDao.getMinId();
			newBook.setId(tempBook.getId() + 1);
			booksDao.atomicInclude(newBook);

			UpButtons.removeComponents();

			UpButtons.getMainWindow().revalidate();
			UpButtons.getMainWindow().repaint();

			JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Nenhum livro foi cadastrado!");
		}

//		88888888

//		if (e.getButton() == 1 && nameCheck && authorCheck && yearConversion) {
//
//			Books newBook = new Books(name, author, yearRelease);
//			Books tempBook = booksDao.getMinId();
//			newBook.setId(tempBook.getId() + 1);
//			booksDao.atomicInclude(newBook);
//
//			UpButtons.removeComponents();
//
//			UpButtons.getMainWindow().revalidate();
//			UpButtons.getMainWindow().repaint();
//
//			JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
//		} else {
//			System.out.println("chegou aqui!");
//		}

		booksDao.closeDao();
	}
}
