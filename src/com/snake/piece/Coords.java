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

	public Coords determineDirection(Coords previousPoint){
		int x = this.getX() - previousPoint.getX();
		int y = this.getY() - previousPoint.getY();
		int z = this.getZ() - previousPoint.getZ();
		
		return new Coords(x, y, z);
	}
	
	public Coords move(Coords direction){
		int x = this.getX() + direction.getX();
		int y = this.getY() + direction.getY();
		int z = this.getZ() + direction.getZ();
		
		return new Coords(x, y, z);
	}

	public Coords transpose(){
		int x = this.getZ();
		int y = this.getX();
		int z = this.getY();
		
		return new Coords(x, y, z);
	}

	public Coords inverse(){
		int x = -1 * this.getZ();
		int y = -1 * this.getX();
		int z = -1 * this.getY();
		
		return new Coords(x, y, z);
	}


}
