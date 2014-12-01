package com.example.boardgame;
import java.util.ArrayList;
public class Board {
	
	public int boardpos = 14;
	protected ArrayList<Bowl> white_bowl = new ArrayList<Bowl>(6);
	protected ArrayList<Bowl> black_bowl = new ArrayList<Bowl>(6);
	protected Tray white_tray = new Tray();
	protected Tray black_tray = new Tray();
	
	/**Constructor
	 * 
	 */
	public Board(){
		
		for (int i = 0 ; i <= 5 ; i++ ){
			Bowl whitebowl = new Bowl();
			Bowl blackbowl = new Bowl();
			white_bowl.add(whitebowl);
			black_bowl.add(blackbowl);
		}
	}
	
	
	public void addSeeds(int index , int seeds , boolean white)
	{
		
		
	}
	
	public void removeSeeds(int index , int seeds , boolean white)
	{
		
	}
	
	
	
	public int emptyBowls(boolean white)
	{
		int emptybowls = 0;
		return emptybowls;
	}
	
	 
		
		
	

}


