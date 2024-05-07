package frontend.buttons;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.List;

import books.backend.Books;
import frontend.layouts.AllBooksL;
import frontend.layouts.PaginationButtons;
import frontend.layouts.UpButtons;
import inf.Dao;

@SuppressWarnings("serial")
public class AllBooks extends AppButtons {

	public AllBooks(String text, UpButtons ub) {
		super(text);
	}

	public void mousePressed(MouseEvent e) {

		if (e.getButton() == 1) {

			UpButtons.removeComponents();

			AllBooksL allBooksLayout = new AllBooksL();
			UpButtons.getMainWindow().add(allBooksLayout, BorderLayout.CENTER);
			UpButtons.getLabels().add(allBooksLayout);

			PaginationButtons pagButtons = new PaginationButtons(this, allBooksLayout, 1);
			UpButtons.getMainWindow().add(pagButtons, BorderLayout.SOUTH);
			UpButtons.getLabels().add(pagButtons);

			generatePagination(allBooksLayout, UpButtons.getLimit(), UpButtons.getOffset());
		}
	}

	public void generatePagination(AllBooksL allBooksLayout, int limit, int offset) {

		Dao<Books> booksDao = new Dao<>(Books.class);

		List<Books> booksList = booksDao.getPag(limit, offset);

		for (Books book : booksList) {
			allBooksLayout.addNewComponent(book, this);
		}

		UpButtons.getMainWindow().revalidate();
		UpButtons.getMainWindow().repaint();
	}
}
