package frontend.layouts;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import books.backend.Books;
import frontend.buttons.AllBooks;
import frontend.buttons.DeleteButton;
import frontend.buttons.UpdateBook;

@SuppressWarnings("serial")
public class AllBooksL extends JPanel {

	public AllBooksL() {

		setLayout(new GridLayout(0, 5));

		addFixedComponent("Nome do Livro");
		addFixedComponent("Autor");
		addFixedComponent("Ano de Lançamento");
		addFixedComponent("Alterar Livro");
		addFixedComponent("Excluir Livro");
	}

	private void addFixedComponent(String text) {

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel label = new JLabel(text);
		panel.add(label);
		this.add(panel);
	}

	public void addNewComponent(Books book, AllBooks allBooks) {

		String yearRelease = Integer.toString(book.getYearRelease());

		JButton nameButton = new JButton();
		nameButton.setBackground(Color.WHITE);
		nameButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		nameButton.setText(book.getName());
		this.add(nameButton);
		UpButtons.getAllBooks().add(nameButton);

		JButton authorButton = new JButton();
		authorButton.setBackground(Color.WHITE);
		authorButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		authorButton.setText(book.getAuthor());
		this.add(authorButton);
		UpButtons.getAllBooks().add(authorButton);

		JButton yearReleaseButton = new JButton();
		yearReleaseButton.setBackground(Color.WHITE);
		yearReleaseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		yearReleaseButton.setText(yearRelease);
		this.add(yearReleaseButton);
		UpButtons.getAllBooks().add(yearReleaseButton);

		UpdateBook updateBook = new UpdateBook("Alterar", book);
		this.add(updateBook);
		UpButtons.getAllBooks().add(updateBook);

		DeleteButton deleteBook = new DeleteButton("Excluir", book);
		this.add(deleteBook);
		UpButtons.getAllBooks().add(deleteBook);
	}
}
