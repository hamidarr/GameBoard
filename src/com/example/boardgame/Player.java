package com.example.boardgame;
public class Player {
	
	private int p_id;//Id of this player
	private String p_name; //Name of this player
	private boolean p_white;//color of the player
	
	/**constructor
	 * 
	 * @param id  the id of this player
	 * @param name    the name of this player 
	 * @param white   the color of this player
	 */
	public Player(int id , String name , boolean white)
	{
		p_id = id;
		p_name = name;
		setWhite(white);
	}
	
	/**set player color
	 * 
	 * @param white true for white , false for black
	 */
	
	public void setWhite(boolean white)
	{
		p_white = white;
	}
	
	/**Return the Id of this player
	 * 
	 * @return  the player id
	 */
	
	public int getId()
	{
		return p_id;
	}
	
	/**Return the name of this player
	 * 
	 * @return the player name
	 */
	
	public String getName()
	{
		
		return p_name;
		
	}
	
	/**Return color of this player
	 * 
	 * @return the color of player
	 */
	
	public boolean isWhite()
	{
		return p_white;
	}

}

