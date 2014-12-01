package com.example.boardgame;

import java.util.ArrayList;


public class BoardState extends Board{
	
	
	private Player _player1; //**player one
	
	private Player _player2; //**player two
	
	private Player _currentplayer; //**current player
	
	private boolean canmoveagain ;
	
	

	
	private boolean isgamefinished;
	
	
	
	public BoardState(){
		displayBoard(white_bowl , black_bowl , true);
	}
	
	/**Define the game two player
	 * 
	 * @param player1         player one
	 * @param player2         player two
	 */
	public void setPlayer(Player player1 , Player player2)
	{
		_player1 = player1;
		_player2 = player2;
		
	}
	
	
	/** Game finished
	 * 
	 * @return true if game finished  otherwise false
	 */
	public boolean gameFinished()
	{
		
		return isgamefinished;
		
	}
	
	/** set this game as finish
	 * 
	 * @param f true for finish
	 */
	public void setGameFinish(boolean f)
	{
		
		isgamefinished = f;
	}
	
	public boolean canMoveAgain()//Just for now to test move function it will be one of local player property in final release
	{
		return canmoveagain;
	}
	
	public void setCanMoveAgain(boolean m)//Just for now to test move function it will be one of local player property in final release
	{
		canmoveagain = m;
	}
	
	
	/**Return the color of Player
	 * 
	 * @return true if player is white otherwise false
	 */
	
	public boolean isCurrentPlayerwhite()
	{
		
		return _currentplayer.isWhite();
	}
	
	/**Current Player
	 * 
	 * @return current player
	 */
	
	public Player getCurrentPlayer()
	{
		return _currentplayer;
	}
	
	/**Return waiting player
	 * 
	 * @return non current player
	 */
	public Player getWaitingPlayer()
	{
		
		if(_player1 == _currentplayer)
		{
			return _player2;
		}
		
		else
		{
			return _player1;
		}
		
	}
	/**set turn to player that having specefic color
	 * 
	 * @param white true for white player,false for black player
	 */
	
	public void setCurrentPlayer(boolean white)
	
	{
		Player p = _player1;
		if(white && !_player1.isWhite() ||
				!white && _player1.isWhite())
		{
			p = _player2;
		}
		
		_currentplayer = p;
		
	}
	/**Check if all player bowls is empty
	 * 
	 * @param p list of player bowls
	 * @return true if all bowls empty , otherwise false
	 */
	
	public boolean isPlayerAllBowlsEmpty(ArrayList <Bowl> p)
	{
		
		for(Bowl b : p)
		{
			if(b.getNumberofSeeds() != 0)
			{
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * 
	 */
	public void setTurn()
	
	{
		
	}
	
	/**Moving seeds from specefic index that belong to the Bowl with specefic color
	 * to Bowls or Tray destination on the board.
	 * 
	 * @param index source Bowl in board
	 * @param whit  color of Bowls that seeds move from it to other Bowls and Tray
	 */
	
	public void makeMove(int index , boolean white){
		
		canmoveagain = false;
		ArrayList<Bowl> playerbowls = new ArrayList<Bowl>();
		ArrayList<Bowl> opponentbowls = new ArrayList<Bowl>();
		playerbowls = white_bowl;
		opponentbowls = black_bowl;
		Tray playertray = white_tray;
		
	    if(!white)
	    {
	    	playerbowls = black_bowl;
	    	playertray = black_tray;
	    	opponentbowls = white_bowl;
	    	
	    }
		
		
			if(playerbowls.get(index-1).getNumberofSeeds() == 0)//check the number of current bowl seeds
				return;
			int numberofmoves = playerbowls.get(index-1).getNumberofSeeds();//number of destination
			playerbowls.get(index-1).decreasNumberofSeeds(numberofmoves);
			//System.out.printf("%5d\n",player.size());
			
			index+=1;
			for(int i = 0 ; i < numberofmoves ; i++){
				//
			if(index == boardpos)//can we  move seeds to opponent Tray!
				index = 1;
			if((i+1) == numberofmoves){//check the status of last seeds
				//System.out.printf("%5d%5d\n",player.get(index-1).getNumberofSeeds(),index);
				if(index-1 == 6)//if last seed destination is player Tray
				{
					playertray.increasenumberofSeeds(1);
					canmoveagain = true;
					displayBoard(playerbowls , opponentbowls , white);
					return;
				}
				if(index-1 <= 5 && playerbowls.get(index-1).getNumberofSeeds() == 0)//If last seed destination is empty
				{
					//System.out.printf("%5d%5d\nfghfghfghfghfgh:",player.get(index-1).getNumberofSeeds(),index);
					//return;
					//Get opponent index to move its seeds to player Tray
					int opponentindex = 0;
					switch(index-1)
					{
					case 0 :
						opponentindex = 5;
						break;
					case 1 :
						opponentindex = 4;
						break;
					case 2 :
						opponentindex = 3;
						break;
					case 3 :
						opponentindex = 2;
						break;
					case 4 :
						opponentindex = 1;
						break;
					case 5 :
						opponentindex = 0;
						break;
					}
					int seeds = opponentbowls.get(opponentindex).getNumberofSeeds();
					opponentbowls.get(opponentindex).decreasNumberofSeeds(seeds);
					playertray.increasenumberofSeeds(seeds+1);
					displayBoard(playerbowls , opponentbowls , white);
					return;
					
				}
				
				
			}
			
			if(index-1 == 6)
			{
				playertray.increasenumberofSeeds(1);
				//continue;
			}
			if(index-1 <= 5)
			{
				playerbowls.get(index-1).increasNumberofSeeds(1);;
				//continue;
				
			}
			
			if(index-1 >= 7)
			{
				opponentbowls.get(index-8).increasNumberofSeeds(1);
				//continue;
			}
			index++;
			}
			displayBoard(playerbowls , opponentbowls , white);
			if(isPlayerAllBowlsEmpty(playerbowls))//Check if all player bowls is empty
			{
				int remainoppseeds = 0;
				for(Bowl  b : opponentbowls)
				{
					
					remainoppseeds+=b.getNumberofSeeds();
					int seeds = b.getNumberofSeeds();
					b.decreasNumberofSeeds(seeds);
				
				}
				playertray.increasenumberofSeeds(remainoppseeds);
				System.out.printf("\n");
				displayBoard(playerbowls , opponentbowls , white);
				setGameFinish(true);
				
			}
			
			
		
				   
	
		
		}
	
	
	public void displayBoard(ArrayList<Bowl> p , ArrayList<Bowl> opp , boolean white){
		
		if(white)
		{
		   for (int i = opp.size() ; i > 0 ; i--)
			    System.out.printf("%5d", opp.get(i-1).getNumberofSeeds());
		   System.out.printf("\n\n%5d%25d\n\n",black_tray.getnumberofSeeds(),white_tray.getnumberofSeeds());
		   for(int i = 0 ; i < p.size() ; i++)
				System.out.printf("%5d", p.get(i).getNumberofSeeds());
				
		}
		 else
		 {
			 for (int i = p.size() ; i > 0 ; i--)
					System.out.printf("%5d", p.get(i-1).getNumberofSeeds());
			 System.out.printf("\n%5d%25d\n",black_tray.getnumberofSeeds(),white_tray.getnumberofSeeds());
			 for(int i = 0 ; i < opp.size() ; i++)
					System.out.printf("%5d", opp.get(i).getNumberofSeeds());
		 }
			   
		   
		
		  
		   
		}
	

	}
