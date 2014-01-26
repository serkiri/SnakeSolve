package com.snake.piece;

public class StraightPiece extends AbstractPiece {

	public StraightPiece(AbstractPiece previousPiece) {
		super(previousPiece);
		pieceState = PieceState.lastState();
	}

	@Override
	protected void calculateNextPosition() {
		Coords direction = currentPosition.determineDirection(previousPosition);
		nextPosition = currentPosition.move(direction);
	}
	
	@Override
	protected String getName() {
		return "SP";
	}
}
