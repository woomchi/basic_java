package section2;

public class OrthoPolygon {

	public int n;	//다각형 꼭짓점 개수
	public MyPoint2 [] vertices;	//꼭짓점 배열
	
	public OrthoPolygon( int k ) {	
		n = 0;
		vertices = new MyPoint2[k];
	}
	
	public void addVertex(int x, int y) {
		// 입력된 꼭짓점 정보 추가 및 꼭짓점 추가로 인한 개수 증가
		vertices[n++] = new MyPoint2(x, y);
	}
	
	public int maxX() {
		int max = vertices[0].x;
		for(int i=0;i<n;i++) {
			if(vertices[i].x > max) {
				max = vertices[i].x;
			}
		}
		return max;
	}
	
	public boolean contains(MyPoint2 p) {
		Ortholine arrow = new Ortholine(p, new MyPoint2( maxX() , p.y));
		int count = 0;
		for(int i=0;i<n;i++) {
			Ortholine edge = new Ortholine(vertices[i], vertices[(i+1)%n]);
			if(arrow.intersects(edge)) {
				count++;
			}
		}
		return count%2 == 1;
	}
}
