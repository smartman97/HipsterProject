package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
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

	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		
		setupArray();
		
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "This is so mainstream!";
		hipsterPhrases[1] = "I don't mean sound like a hipster, but, ";
		hipsterPhrases[2] = "Insert sarcastic phrase here";
		hipsterPhrases[3] = "I was into code before it was cool";
	}
}
