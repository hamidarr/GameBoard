package com.example.boardgame;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class BoardMain {

	public static void main (String[] args) {
		BoardState b1 = new BoardState();
		for(;;){
			String rad; 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        System.out.println("\nChoose bowl to move:");
	        try{
	            rad = br.readLine(); 
	            int r = Integer.parseInt(rad);
	            System.out.println("\nChoose Player:");
	            rad = br.readLine(); 
	            int r1 = Integer.parseInt(rad);
	            if(r1 == 1)
	            b1.makeMove(r, true);
	            else if(r1 == 0)
	            	b1.makeMove(r, false);
	            
	           
	           
	            
	        }
	        
	        catch(Exception e){
	            System.out.println("Write an integer number <= 6 "); 
	            //break;
	           
	        }
			
			 
			
			
		}
	}

	}
