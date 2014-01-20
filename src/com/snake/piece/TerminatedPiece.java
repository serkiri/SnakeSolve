package com.snake.piece;

public class TerminatedPiece extends AbstractPiece {

	public TerminatedPiece() {
		this(new Coords(0, 0, 0), null);
	}

	public TerminatedPiece(Coords currentPosition) {
		this(currentPosition, null);
	}

	public TerminatedPiece(Coords currentPosition, Coords previousPosition) {
		super(currentPosition, previousPosition);
		pieceState = PieceState.lastState();
	}

	@Override
	protected void calculateNextPosition() {
		if (nextPosition != null){
			Coords direction = new Coords(1, 0, 0);
			nextPosition = currentPosition.move(direction);
		} else {
			nextPosition = null;
		}
	}
	
}
