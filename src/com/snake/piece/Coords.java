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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coords other = (Coords) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
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
		int x = -1 * this.getX();
		int y = -1 * this.getY();
		int z = -1 * this.getZ();
		
		return new Coords(x, y, z);
	}


}
