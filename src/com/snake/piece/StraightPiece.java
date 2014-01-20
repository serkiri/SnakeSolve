package com.snake.piece;

public class StraightPiece extends AbstractPiece {

	public StraightPiece(Coords currentPosition, Coords previousPosition) {
		super(currentPosition, previousPosition);
		pieceState = PieceState.lastState();
	}

	@Override
	protected void calculateNextPosition() {
		Coords direction = currentPosition.determineDirection(previousPosition);
		nextPosition = currentPosition.move(direction);
	}
	
}
