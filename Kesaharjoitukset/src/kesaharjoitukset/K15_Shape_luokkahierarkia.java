package kesaharjoitukset;

import java.util.ArrayList;
import java.util.List;

public class K15_Shape_luokkahierarkia {
	public static void main(String args[]) {
		List<Shape> s = new ArrayList<Shape>();
		s.add(new Circle(6));
		s.add(new Rectangle(4, 5));
		Shape.tulostaPintaalat(s);
	//	Shape.tulostaPintaalatGener(s); Tämän ideaa en tajunnut
	}

}
abstract class Shape {
	private String name; // kuvion nimi
	
	public Shape (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static void tulostaPintaalat(List<Shape> s) {
		String output = "";
		for(int i = 0; i<s.size();i++) {
		switch (s.get(i).getName()) {
		case "Rectangle": {
			output = "Rectangle, "+ ((Rectangle) s.get(i)).getArea();
			break;
		}
		case "Circle": {
			output = "Circle, "+((Circle) s.get(i)).getArea();
			break;
		}
		default: {
			output = "";
			break;
		}
		}
		System.out.println(output);
		}
	}
		
}


class Rectangle extends Shape {
	private int x, y;
	public Rectangle(int x, int y) {
		super("Rectangle");
		this.x = x;
		this.y = y;
	}
	public String getArea() {
		//Tässä kaari on ymmärretty kaikkien suorakulmion sivujen yhteenlasketuksi
		//mitaksi eli piiriksi.
		return x+"*"+y+"="+(double)(x*y)+", kaari: "+(double)(x*2+y*2);
	}
}
	
class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		super("Circle");
		this.radius = radius;
	}
	
	public String getArea() {
		//Tässä kaari on ymmärretty ympyrän kehän pituudeksi
		return "PI*"+radius+"^2="+Math.PI*Math.pow((double)radius,2)+", kaari: "+((Math.PI*radius*2));
	}
}