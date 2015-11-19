package hipster.view;

import hipster.controller.HipsterController;
import hipster.model.Book;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;

	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		phraseComboBox = new JComboBox<String>();
		bookPageCountLabel = new JLabel("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		changeBookButton = new JButton("Change books");
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, bookPageCountLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookAuthorLabel, 55, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPriceLabel, 19, SpringLayout.SOUTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookPriceLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 22, SpringLayout.SOUTH, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 19, SpringLayout.SOUTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookSubjectLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookAuthorLabel, 14, SpringLayout.SOUTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookTitleLabel, 58, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, phraseComboBox, 92, SpringLayout.EAST, changeBookButton);
		baseLayout.putConstraint(SpringLayout.NORTH, bookTitleLabel, 22, SpringLayout.SOUTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 1, SpringLayout.NORTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 6, SpringLayout.EAST, changeBookButton);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, changeBookButton, 98, SpringLayout.WEST, this);
	}

	/**
	 * Helper method to load all GUI components into the panel
	 */
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				setBackground(randomColor());
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
		});
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book Subject: " + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book Author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book Title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book Pages: " + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Book Price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book Author: ");
					bookTitleLabel.setText("Book Title: ");
					bookPageCountLabel.setText("Book Pages: ");
					bookPriceLabel.setText("Book Price: ");
				}
			}
		});
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(phraseComboBox);
		this.add(bookAuthorLabel);
		this.add(bookPageCountLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
		this.add(changeBookButton);
	}
	
	private Color randomColor()
	{
		Random rand = new Random();
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		
		Color randomColor = new Color(r, g, b);
		
		return randomColor;
	}
}
