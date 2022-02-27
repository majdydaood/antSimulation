package ch.epfl.moocprog;

import ch.epfl.moocprog.utils.Vec2d;
import static ch.epfl.moocprog.app.Context.getConfig;
import static ch.epfl.moocprog.config.Config.*;


final public class ToricPosition {
	final private Vec2d position;

	
	static private Vec2d clampedPosition(double x , double y) {
		final int w = getConfig().getInt(WORLD_WIDTH);
		final int h = getConfig().getInt(WORLD_HEIGHT);		
		if (x < 0) {
			x += w;
		}else if (x >= w) {
			x -= w;
		}
		
		if (y < 0) {
			y += h;
		}else if (y >= h) {
			y -= h;
		}
		
		return new Vec2d(x, y);
	}
	
	public ToricPosition(double x , double y) {
		this.position = clampedPosition(x, y);
	}
	
	public ToricPosition(Vec2d vec2d) {
		this.position = clampedPosition(vec2d.getX(), vec2d.getY());
	}
	
	public ToricPosition() {
		this.position = new Vec2d(0,0);
	}
	
	public ToricPosition add(ToricPosition that) {
		return new ToricPosition(this.position.add(that.position));
		
	}
	
	public ToricPosition add(Vec2d vec) {
		return new ToricPosition(this.position.add(vec));
	}
	
	public Vec2d toVec2d() {
		return clampedPosition(position.getX(),position.getY());
	}
	
	
	public Vec2d toricVector(ToricPosition that) {
		final int w = getConfig().getInt(WORLD_WIDTH);
		final int h = getConfig().getInt(WORLD_HEIGHT);
		double best = this.position.distance(that.position);
		Vec2d v = that.position;
		
		if (this.position.distance(that.position.add(new Vec2d(0, h))) < best) {
			v = that.position.add(new Vec2d(0, h));
			best = this.position.distance(that.position.add(new Vec2d(0, h)));
		}
		
		if (this.position.distance(that.position.add(new Vec2d(0, -h))) < best) {
			v = that.position.add(new Vec2d(0, -h));
			best = this.position.distance(that.position.add(new Vec2d(0, -h)));
		}

		if (this.position.distance(that.position.add(new Vec2d(w, 0))) < best) {
			v = that.position.add(new Vec2d(w, 0));
			best = this.position.distance(that.position.add(new Vec2d(w, 0)));
		}
		
		if (this.position.distance(that.position.add(new Vec2d(-w, 0))) < best) {
			v = that.position.add(new Vec2d(-w, 0));
			best = this.position.distance(that.position.add(new Vec2d(-w, 0)));
		}	
		
		if (this.position.distance(that.position.add(new Vec2d(w, h))) < best) {
			v = that.position.add(new Vec2d(w, h));
			best = this.position.distance(that.position.add(new Vec2d(w, h)));
		}
		
		if (this.position.distance(that.position.add(new Vec2d(-w, h))) < best) {
			v = that.position.add(new Vec2d(-w, h));
			best = this.position.distance(that.position.add(new Vec2d(-w, h)));
		}
		
		if (this.position.distance(that.position.add(new Vec2d(w, -h))) < best) {
			v = that.position.add(new Vec2d(w, -h));
			best = this.position.distance(that.position.add(new Vec2d(w, -h)));
		}
		
		if (this.position.distance(that.position.add(new Vec2d(-w, -h))) < best) {
			v = that.position.add(new Vec2d(-w, -h));
			best = this.position.distance(that.position.add(new Vec2d(-w, -h)));
		}
		
		
		return new Vec2d(v.getX() - this.position.getX(), v.getY() - this.position.getY() );
	}
	
	public double toricDistance(ToricPosition that) {
		return toricVector(that).length() - toricVector(this).length();
	}
	
	@Override
	public String toString() {
		return position.toString();
	}

}
