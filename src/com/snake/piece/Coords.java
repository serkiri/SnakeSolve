package com.snake.piece;

public class Coords {

	private final int x;
	private final int y;
	private final int z;	

	public Coords(final int x, final int y, final int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
