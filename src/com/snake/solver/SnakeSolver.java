package com.snake.solver;

import java.util.ArrayList;

import com.snake.piece.AbstractPiece;
import com.snake.piece.BentPiece;
import com.snake.piece.PieceType;
import com.snake.piece.StraightPiece;
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
	
	private ArrayList<AbstractPiece> snake = new ArrayList<AbstractPiece>();

	private AbstractPiece getLastPlacedPiece(){
		return snake.get(snake.size()-1);
	}
	
	private boolean isFreeSpaceLeft(){
		return snake.size() < SNAKE.length;
	}
	
	private void placeNextPiece() {
		if(isFreeSpaceLeft()){
			switch (SNAKE[snake.size()]){
				case TERMINATED_PIECE:
					if (snake.size() == 0){
						snake.add(new TerminatedPiece());
					}else{
						snake.add(new TerminatedPiece(getLastPlacedPiece()));
					}
					break;
				case STRAIGHT_PIECE:
					snake.add(new StraightPiece(getLastPlacedPiece()));
					break;
				case BENT_PIECE:
					snake.add(new BentPiece(getLastPlacedPiece()));
					break;
			}
		}
	}
	
	private boolean isSelfBite(){
		return false;
	}

	private boolean isTooWide(){
		return false;
	}

	private boolean stepBackAndTurnIfPossible(){
		return true;
	}
	
	private void solutionIsFound(){
		
	}

	private void solve() {
		while(true){
			printSnake();
			if(isFreeSpaceLeft()){
				placeNextPiece();
			}else{
				solutionIsFound();
			}
			if (isSelfBite()){
				if(stepBackAndTurnIfPossible()){
					continue;
				} else {
					break;
				}
			}
			if (isTooWide()){
				if(stepBackAndTurnIfPossible()){
					continue;
				} else {
					break;
				}
			}
		}
	}

	public void printSnake(){
		System.out.println(snake);
	}
	
	public static void main(String[] args) {
		SnakeSolver solver = new SnakeSolver();
		solver.solve();
		
	}

}
