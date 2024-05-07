package frontend.buttons;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import frontend.layouts.AllBooksL;
import frontend.layouts.PaginationButtons;
import frontend.layouts.UpButtons;

@SuppressWarnings("serial")
public class NextButton extends AppButtons {

	private AllBooks allBooks;
	private AllBooksL allBooksLayout;

	public NextButton(String text, AllBooks allBooks, AllBooksL allBooksLayout) {

		super(text);
		this.allBooks = allBooks;
		this.allBooksLayout = allBooksLayout;
	}

	public AllBooks getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(AllBooks allBooks) {
		this.allBooks = allBooks;
	}

	public AllBooksL getAllBooksLayout() {
		return allBooksLayout;
	}

	public void setAllBooksLayout(AllBooksL allBooksLayout) {
		this.allBooksLayout = allBooksLayout;
	}

	public void mousePressed(MouseEvent e) {

		UpButtons.offsetPlus();

		for (JButton comp : UpButtons.getAllBooks()) {
			allBooksLayout.remove(comp);
		}

		UpButtons.getAllBooks().clear();

		UpButtons.getMainWindow().remove(UpButtons.getLabels().get(1));
		UpButtons.getLabels().remove(1);

		if (!UpButtons.checkFirstPag() && !UpButtons.checkLastPag()) {

			PaginationButtons pagButtons = new PaginationButtons(allBooks, allBooksLayout, 2);
			UpButtons.getMainWindow().add(pagButtons, BorderLayout.SOUTH);
			UpButtons.getLabels().add(pagButtons);
		} else {
			
			PaginationButtons pagButtons = new PaginationButtons(allBooks, allBooksLayout, 3);
			UpButtons.getMainWindow().add(pagButtons, BorderLayout.SOUTH);
			UpButtons.getLabels().add(pagButtons);
		}

		UpButtons.getMainWindow().revalidate();
		UpButtons.getMainWindow().repaint();

		allBooks.generatePagination(allBooksLayout, UpButtons.getLimit(), UpButtons.getOffset());
	}
}
