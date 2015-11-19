package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "This is so mainstream!";
		hipsterPhrases[1] = "I don't mean sound like a hipster, but, ";
		hipsterPhrases[2] = "Insert sarcastic phrase here";
		hipsterPhrases[3] = "I was into code before it was cool";
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		
		firstBook = new Book();
		firstBook.setAuthor("Andy Weir");
		firstBook.setTitle("The Martian");
		firstBook.setSubject("Science Fiction");
		firstBook.setPageCount(369);
		firstBook.setPrice(14.88);
		
		secondBook = new Book();
		secondBook.setAuthor("Orson Scott Card");
		secondBook.setTitle("Enders Game");
		secondBook.setSubject("Science Fiction");
		secondBook.setPageCount(384);
		secondBook.setPrice(5.99);
		
		thirdBook = new Book(374, "Suzanne Collins", "Dystopian", "The Hunger Games", 6.99);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}
	
	public Book[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}
}
