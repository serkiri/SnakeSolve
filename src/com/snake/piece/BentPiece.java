package com.snake.piece;

public class BentPiece extends AbstractPiece {

	public BentPiece(AbstractPiece previousPiece) {
		super(previousPiece);
	}

	@Override
	protected void calculateNextPosition() {
		Coords direction = currentPosition.determineDirection(previousPosition);
		int rollFactor = pieceState.ordinal();
		direction = direction.transpose();
		if (rollFactor % 2 == 1 ){
			direction = direction.transpose();
		}
		if (rollFactor / 2 == 1 ){
			direction = direction.inverse();
		}
		nextPosition = currentPosition.move(direction);
	}
	
	@Override
	protected String getName() {
		return "BP";
	}

}
