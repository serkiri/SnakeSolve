package com.snake.piece;

public class StraightPiece extends AbstractPiece {

	public StraightPiece(Coords currentPosition, Coords previousPosition) {
		super(currentPosition, previousPosition);
	}

	@Override
	protected void calculateNextPosition() {
		// pNext = 2p[current] - p[previous] 
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		StraightPiece sp = new StraightPiece(new Coords(0,0,0), null);
		System.out.println(sp);
		System.out.println(sp.getPieceState().isLastState());
		sp.rotate();
		System.out.println(sp);
		System.out.println(sp.getPieceState().isLastState());
		sp.rotate();
		System.out.println(sp);
		System.out.println(sp.getPieceState().isLastState());
		sp.rotate();
		System.out.println(sp);
		System.out.println(sp.getPieceState().isLastState());
		sp.rotate();
		System.out.println(sp);
		System.out.println(sp.getPieceState().isLastState());
	}
}
