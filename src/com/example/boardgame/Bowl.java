package com.example.boardgame;
public class Bowl {
	private int numberofSeeds;
	
	/**Constructor
	 * 
	 */
	public Bowl()
	{
		numberofSeeds = 3;//each bowl have 3 seeds by default 
	}
	
	/**Check if bowl is empty
	 * 
	 * @return  true if bowl is empty , otherwise false
	 */
	public boolean isBowlEmpty()
	{
		if (numberofSeeds == 0)
			return true;
		else return false;
	}
	
    /**Return number of seeds in bowl
     * 
     * @return number of seeds for this bowl
     */
	public int getNumberofSeeds()
    {
    	return numberofSeeds;
    }
    
    
	/**Increase number of seeds in this bowl
	 * 
	 * @param num  The number of seeds to add this bowl
	 */
	public void increasNumberofSeeds(int num)
    {
    	numberofSeeds+=num;
    	
    }
    
	/**Decrease number of seeds in this bowl
	 * 
	 * @param num number of seeds to subract from this bowl
	 */
    public void decreasNumberofSeeds(int num)
    {
    	
    	numberofSeeds-=num;
    	
    }
}


