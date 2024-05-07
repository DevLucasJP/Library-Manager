package frontend.layouts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddBookL extends JPanel {

	private JTextField nameField = new JTextField(20);
	private JTextField authorField = new JTextField(20);
	private JTextField yearReleaseField = new JTextField(20);

	public AddBookL() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		addLabel("Nome: ", gbc, 0, 0);
		addTextField(nameField, gbc, 1, 0);
		addLabel("Autor: ", gbc, 0, 1);
		addTextField(authorField, gbc, 1, 1);
		addLabel("Ano de Lançamento: ", gbc, 0, 2);
		addTextField(yearReleaseField, gbc, 1, 2);
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getAuthorField() {
		return authorField;
	}

	public JTextField getYearReleaseField() {
		return yearReleaseField;
	}

	private void addLabel(String text, GridBagConstraints gbc, int column, int line) {

		JLabel label = new JLabel(text);

		gbc.gridx = column;
		gbc.gridy = line;
		gbc.anchor = GridBagConstraints.WEST;

		add(label, gbc);
	}

	private void addTextField(JTextField textField, GridBagConstraints gbc, int column, int line) {

		gbc.gridx = column;
		gbc.gridy = line;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		add(textField, gbc);
	}
}
