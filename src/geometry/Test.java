package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1= new Circle();
		Point p1=new Point();
		p1.setX(5);
		p1.setY(3);
		c1.setCenter(p1);
		System.out.println("Centar kruga je "+c1.getCenter().getX()+","+c1.getCenter().getY());

	}

}
