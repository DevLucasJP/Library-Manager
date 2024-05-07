package frontend.layouts;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import books.backend.Books;
import frontend.buttons.AddBook;
import frontend.buttons.AllBooks;
import inf.Dao;

@SuppressWarnings("serial")
public class UpButtons extends JPanel {

	private static JFrame mainWindow;
	private static int dbSize;

	private static List<JPanel> labels = new ArrayList<>();
	private static List<JButton> buttons = new ArrayList<>();
	private static List<JButton> allBooks = new ArrayList<>();

	private static final int limit = 5;
	private static int offset = 0;

	public UpButtons() {
	}

	public UpButtons(JFrame mainWindow) {

		setMainWindow(mainWindow);

		setLayout(new FlowLayout());

		AddBook button1 = new AddBook("Adicionar Livro");
		add(button1);
		AllBooks button2 = new AllBooks("Ver Livros Cadastrados", this);
		add(button2);

		Dao<Books> booksDao = new Dao<>(Books.class);

		List<Books> tempList = booksDao.getAll();
		dbSize = tempList.size();

		booksDao.closeDao();
	}

	public static JFrame getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(JFrame mainWindow) {
		UpButtons.mainWindow = mainWindow;
	}

	public static int getDbSize() {
		return dbSize;
	}

	public static void setDbSize(int dbSize) {
		UpButtons.dbSize = dbSize;
	}

	public static List<JPanel> getLabels() {
		return labels;
	}

	public static void setLabels(List<JPanel> labels) {
		UpButtons.labels = labels;
	}

	public static List<JButton> getButtons() {
		return buttons;
	}

	public static void setButtons(List<JButton> buttons) {
		UpButtons.buttons = buttons;
	}

	public static List<JButton> getAllBooks() {
		return allBooks;
	}

	public static void setAllBooks(List<JButton> allBooks) {
		UpButtons.allBooks = allBooks;
	}

	public static int getLimit() {
		return limit;
	}

	public static int getOffset() {
		return offset;
	}

	public static void setOffset(int offset) {
		UpButtons.offset = offset;
	}

	public static void offsetPlus() {

		if (checkLastPag()) {
		} else {
			UpButtons.offset = UpButtons.offset + 5;
		}
	}

	public static void offsetMinus() {

		if (checkFirstPag()) {
		} else {
			UpButtons.offset = UpButtons.offset - 5;
		}
	}

	public static void removeComponents() {

		if (!getLabels().isEmpty()) {

			for (int i = 0; i < getLabels().size(); i++) {

				getMainWindow().remove(getLabels().get(i));
			}

			getLabels().clear();
		}

		if (!getButtons().isEmpty()) {

			for (int i = 0; i < getButtons().size(); i++) {

				getMainWindow().remove(getButtons().get(i));
			}

			getButtons().clear();
		}

		getMainWindow().revalidate();
		getMainWindow().repaint();
	}

	public static boolean checkFirstPag() {

		if (getOffset() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkLastPag() {

		if (getDbSize() - getOffset() <= 5) {
			return true;
		} else {
			return false;
		}
	}
}
