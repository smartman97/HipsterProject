package hipster.controller;

import hipster.model.Hipster;
import hipster.view.HipsterFrame;

public class HipsterController
{
	private HipsterFrame baseFrame;
	private Hipster firstHipster;
	
	public HipsterFrame getBaseFrame()
	{
		return baseFrame;
	}

	public Hipster getFirstHipster()
	{
		return firstHipster;
	}

	public HipsterController()
	{
		firstHipster = new Hipster();
		baseFrame = new HipsterFrame(this);
	}
	
	public void start()
	{
		String myName = baseFrame.getResponse("What is your name?");
		firstHipster.setName(myName);
		baseFrame.setTitle(myName + " First Project");
	}
}
