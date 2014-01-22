package com.snake.solver;

import java.util.ArrayList;

import com.snake.piece.AbstractPiece;
import com.snake.piece.PieceType;
import com.snake.piece.TerminatedPiece;

import static com.snake.piece.PieceType.*;


public class SnakeSolver {
	
	private static final PieceType[] SNAKE = {
		TERMINATED_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		BENT_PIECE,
		STRAIGHT_PIECE,
		TERMINATED_PIECE
	};
	
	private ArrayList<AbstractPiece> snake;
	private int placedPieceNum;

	public void prepareNewSnake(){
		snake = new ArrayList<AbstractPiece>();
		snake.add(new TerminatedPiece());
		placedPieceNum = 0;
	}

	private void placeNextPiece() {
		if()snake.get
	}

	private void solve() {
//		while(true){
		placeNextPiece();	
//		}
	}

	public void printSnake(){
		System.out.println(snake);
	}
	
	public static void main(String[] args) {
		SnakeSolver solver = new SnakeSolver();
		solver.prepareNewSnake();
		solver.printSnake();
		solver.solve();
		
	}

}
