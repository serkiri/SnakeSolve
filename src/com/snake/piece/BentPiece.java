package com.snake.piece;

public class BentPiece extends AbstractPiece {

	public BentPiece(Coords currentPosition, Coords previousPosition) {
		super(currentPosition, previousPosition);
	}

	@Override
	protected void calculateNextPosition() {
		Coords direction = currentPosition.determineDirection(previousPosition);
		int rollFactor = pieceState.ordinal();
		direction = direction.transpose();
		if (rollFactor % 2 == 1 ){
			direction = direction.transpose();
		}
		if (rollFactor / 2 == 2 ){
			direction = direction.inverse();
		}
		nextPosition = currentPosition.move(direction);
	}
	
}
