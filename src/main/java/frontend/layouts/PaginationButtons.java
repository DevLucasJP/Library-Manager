package frontend.layouts;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import frontend.buttons.AllBooks;
import frontend.buttons.BackButton;
import frontend.buttons.NextButton;

@SuppressWarnings("serial")
public class PaginationButtons extends JPanel {

	private AllBooks allBooks;

	public PaginationButtons(AllBooks allBooks, AllBooksL allBooksLayout, int pagination) {

		this.allBooks = allBooks;

		setLayout(new FlowLayout());

		switch (pagination) {
		case 1:
			NextButton nextButton = new NextButton("Próxima", allBooks, allBooksLayout);
			add(nextButton);
			break;

		case 2:
			BackButton backButton2 = new BackButton("Voltar", allBooks, allBooksLayout);
			add(backButton2);
			NextButton nextButton2 = new NextButton("Próxima", allBooks, allBooksLayout);
			add(nextButton2);
			break;

		case 3:
			BackButton backButton = new BackButton("Voltar", allBooks, allBooksLayout);
			add(backButton);
			break;
		}

//		BackButton backButton = new BackButton("Voltar", allBooks, allBooksLayout);
//		add(backButton);
//		NextButton nextButton = new NextButton("Próxima", allBooks, allBooksLayout);
//		add(nextButton);
	}

	public AllBooks getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(AllBooks allBooks) {
		this.allBooks = allBooks;
	}
}
