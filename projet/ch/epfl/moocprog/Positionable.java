package ch.epfl.moocprog;

public class Positionable {
	private ToricPosition position;
	
	public Positionable() {
		position = new ToricPosition();
	}
	
	public Positionable(ToricPosition toricPosition) {
		position = toricPosition;
	}
	
	public ToricPosition getPosition() {
		return position;
	}
	
	
	protected void setPosition(ToricPosition position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
