package frontend.buttons;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import books.backend.Books;
import inf.Dao;

@SuppressWarnings("serial")
public class DeleteButton extends AppButtons {
	
	private Books book;
	
	public DeleteButton(String text, Books book) {
		
		super(text);
		this.book = book;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == 1) {
			
			Dao<Books> booksDao = new Dao<>(Books.class);
			
			booksDao.deleteBook(book);
			JOptionPane.showMessageDialog(this, "Livro excluído com sucesso!");
			
			booksDao.closeDao();
		}
	}
}
