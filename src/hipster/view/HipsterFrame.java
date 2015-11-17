package hipster.view;

import hipster.controller.HipsterController;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HipsterFrame extends JFrame
{
	private HipsterController baseController;
	private HipsterPanel basePanel;

	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel); // Must be the first line of setupFrame() -Installs panel in the frame.
		this.setSize(400, 400); // Fine a good size for the application.
		this.setTitle("Hipster!");
		this.setResizable(false); // Advisable not required.
		this.setVisible(true); // Must be the last line of setupFrame()
	}

	public HipsterController getBaseController()
	{
		return baseController;
	}
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
}
