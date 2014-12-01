package com.example.boardgame;
public class Tray {
	
	private int numberofSeeds;
	
	/**Constructor
	 * 
	 */
	public Tray()
	{
		numberofSeeds = 0;//Tray have zero seed by default
	}
    
	/**Return number of seeds in this tray
	 * 
	 * @return number of seeds in this tray
	 */
	public int getnumberofSeeds()
	{
		
		return numberofSeeds;
	}
	
	/**Increase number of seeds for this tray
	 * 
	 * @param num number of seeds to add this tray
	 */
	public void increasenumberofSeeds(int num)
	{
		
		numberofSeeds+=num;
	}
}
