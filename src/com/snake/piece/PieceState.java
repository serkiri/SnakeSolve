package com.snake.piece;


public enum PieceState {
	S0, 
	S1, 
	S2, 
	S3; 
	
	public PieceState getNextState(){
		switch (this) {
			case S0:
				return S1;
			case S1:
				return S2;
			case S2:
				return S3;
			case S3:
				return S3;
			default:
				return null;
		}
	}
	
	public static PieceState firstState(){
		return S0;
	}

	public static PieceState lastState(){
		return S3;
	}

	public boolean isLastState(){
		return this==lastState();
	}

}
