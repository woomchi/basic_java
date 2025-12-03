package section2;

public class Ortholine {
	public MyPoint2 u;
	public MyPoint2 v;
	
	public Ortholine(MyPoint2 p, MyPoint2 q) {
		u = p;
		v = q;
		if( p.x > q.x || p.x == q.x && p.y > q.y) {
			swap();
		}
	}
	private void swap() {
		MyPoint2 tmp = u;
		u = v;
		v = tmp;
	}
	
	public Ortholine( int x1, int x2, int y1, int y2) {
		u = new MyPoint2(x1, y1);
		v = new MyPoint2(x2, y2);
	}
	
	public boolean isVertical() {
		// 수직 선분인지 판별
		return u.x == v.x;
	}

	public boolean intersects(Ortholine other) {	
		//본인과 다른 성분 교차 여부 확인
		if( isVertical() && !other.isVertical()) {
			return other.u.x < u.x && other.v.x > v.x && other.u.y > u.y && other.u.y < v.y;
		}else if(!isVertical() && other.isVertical()) {
			return other.u.y < u.y && other.v.y > u.y &&u.x < other.u.x && other.v.x < v.x;
		}else{
			return false;
		}
	}
	
}
