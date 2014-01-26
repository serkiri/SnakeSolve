package com.snake.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.snake.piece.AbstractPiece;
import com.snake.piece.BentPiece;
import com.snake.piece.Coords;
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
	
	private List<AbstractPiece> snake = new ArrayList<AbstractPiece>();

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
		Set<Coords> coords = new HashSet<Coords>();
		for(AbstractPiece piece : snake){
			if (!coords.add(piece.getCurrentPosition())){
				return true;
			}
		}
		return false;
	}

	private boolean isTooWide(){
		if ( snake == null || snake.size() < 3){
			return false;
		}
		Coords firstPieceCoords = snake.get(0).getCurrentPosition();
		int xMin = firstPieceCoords.getX();
		int xMax = firstPieceCoords.getX();
		int yMin = firstPieceCoords.getY();
		int yMax = firstPieceCoords.getY();
		int zMin = firstPieceCoords.getZ();
		int zMax = firstPieceCoords.getZ();
		for(AbstractPiece piece : snake){
			Coords currentPieceCoords = piece.getCurrentPosition();
			if(xMin > currentPieceCoords.getX()){
				xMin = currentPieceCoords.getX();
			}
			if(xMax < currentPieceCoords.getX()){
				xMax = currentPieceCoords.getX();
			}
			if(yMin > currentPieceCoords.getY()){
				yMin = currentPieceCoords.getY();
			}
			if(yMax < currentPieceCoords.getY()){
				yMax = currentPieceCoords.getY();
			}
			if(zMin > currentPieceCoords.getZ()){
				zMin = currentPieceCoords.getZ();
			}
			if(zMax < currentPieceCoords.getZ()){
				zMax = currentPieceCoords.getZ();
			}
			
			if(xMax - xMin >=3) return true;
			if(yMax - yMin >=3) return true;
			if(zMax - zMin >=3) return true;
		}
		return false;
	}

	private boolean stepBackAndTurnIfPossible(){
		if ( snake == null || snake.size() < 2){
			return false;
		}
		for (int i = snake.size() - 2; i >= 0; i--){
			if (!snake.get(i).getPieceState().isLastState()){
				snake.get(i).rotate();
				snake = snake.subList(0, i + 1);
				return true;
			}
		}
		return false;
	}
	
	private void solutionIsFound(){
		System.out.println("solved!");
		printSnake();
	}

	private void solve() {
		while(true){
			if(isFreeSpaceLeft()){
				placeNextPiece();
//				printSnake();
			}else{
				solutionIsFound();
				if(stepBackAndTurnIfPossible()){
//					printSnake();
					continue;
				} else {
					break;
				}
			}
			if (isSelfBite()){
				if(stepBackAndTurnIfPossible()){
//					printSnake();
					continue;
				} else {
					break;
				}
			}
			if (isTooWide()){
				if(stepBackAndTurnIfPossible()){
//					printSnake();
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
