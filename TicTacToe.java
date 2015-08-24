package tictactoe;

import java.util.Scanner;

public class TicTacToe {

	public static void print(String board[])
	{
		
		for(int i=0;i<9;i++)
		{
			System.out.print(board[i]);
			if((i+1)%3==0)
			{
				System.out.println();
				if(i+1!=9)
				System.out.println("----------");
			}
			else {
				System.out.print(" | ");
			}
		}
	}

	public static void move(String[] board,int p,String currentPlayer)
	{
		p--;
		Scanner s=new Scanner(System.in);
		boolean done=false;
		while(!done)
		{
			if(p>=0 && p<9 && board[p]==" ")
			{
				board[p]=currentPlayer;
				done=true;
			}
			else
			{
				System.out.println("wrong input!!Try Again");
				p=s.nextInt();
				p--;
			}
		}
		print(board);
	}

	public static int status(String[] board)
	{
		//check rows
		for(int i=0;i<9;i=i+3)
		{
			if(board[i]==board[i+1] && board[i]==board[i+2])
			{
				if(board[i]=="O")
					return 1;
				else
					if(board[i]=="X")
						return 2;
			}
		}

		// check column
		for(int i=0;i<3;i++)
		{
			if(board[i]==board[i+3] && board[i]==board[i+6])
			{
				if(board[i]=="O")
					return 1;

				if(board[i]=="X")
					return 2;
			}
		}

		// check diagonal
		if(board[0]==board[4] && board[4]==board[8])
		{
			if(board[0]=="O")
				return 1;
			else
				if(board[4]=="X")
					return 2;
		}

		if(board[2]==board[4] && board[4]==board[6])
		{
			if(board[4]=="O")
				return 1;
			else
				if(board[4]=="X")
					return 2;
		}
		//check empty spaces
		for(int i=0;i<9;i++)
		{
			if(board[i]==" ")
				return 4;
		}
		return 3;
	}

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		String[] board={" "," "," "," "," "," "," "," "," "};
		print(board);
		int gameStatus=4;

		String player1="O";
		String player2="X";

		boolean player1Turn=true;
		String currentPlayer;
		int pos;

		while(gameStatus==4)
		{
			if(player1Turn)
				currentPlayer=player1;
			else
				currentPlayer=player2;

			System.out.print("chance of("+ currentPlayer +" )enter position= ");
			pos=s.nextInt();
			move(board, pos, currentPlayer);
			gameStatus=status(board);
			player1Turn=!player1Turn;
		}

		if (gameStatus==1)
			System.out.println("PlayerOne Wins!!!!!!!111111111");
		else
		{
			if(gameStatus==2)
				System.out.println("PlayerTwo wins!!!!!!!!!!!2222222");
			else 
				System.out.println("It Is A TIE!!!!!!!!!");
		}
	}
}