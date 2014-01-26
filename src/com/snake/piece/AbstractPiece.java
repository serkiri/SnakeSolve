package com.snake.piece;

public abstract class AbstractPiece {

	protected final Coords currentPosition;
	protected final Coords previousPosition;
	protected Coords nextPosition;
	protected PieceState pieceState;
	
	public AbstractPiece(final Coords currentPosition, final Coords previousPosition) {
		this.currentPosition = currentPosition;
		this.previousPosition = previousPosition;
		pieceState = PieceState.firstState();
		calculateNextPosition();
	}
	
	public AbstractPiece(AbstractPiece previousPiece) {
		this(previousPiece.getNextPosition(), previousPiece.getCurrentPosition());
	}
	
	public void rotate(){
		pieceState = pieceState.getNextState();
		calculateNextPosition();
	}

	protected abstract void calculateNextPosition();
	
	protected abstract String getName();
	
	public Coords getCurrentPosition() {
		return currentPosition;
	}
	
	public Coords getPreviousPosition() {
		return previousPosition;
	}

	public Coords getNextPosition() {
		return nextPosition;
	}

	public PieceState getPieceState() {
		return pieceState;
	}

	@Override
	public String toString() {
		return getName() + "{" + currentPosition
				+ ", " + pieceState + "}";
	}

}
