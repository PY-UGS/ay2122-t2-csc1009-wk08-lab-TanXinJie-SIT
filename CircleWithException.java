import java.util.Scanner;

public class CircleWithException {
    double radius;
    double area;
    double diameter;
    static final double PI = 3.14159;
    
    public CircleWithException() {
    }
    
    public CircleWithException(double radius) throws IllegalArgumentException{
        if (radius <0) throw new IllegalArgumentException("Radius cannot be negative!");
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) throws IllegalArgumentException{
        if (radius <0) throw new IllegalArgumentException("Radius cannot be negative!");
        this.radius = radius;
    }
    
    public double getArea() throws Exception{
        this.area = this.radius * this.radius * PI;
        if (this.area > 1000) throw new Exception("Area is bigger than 1000!");
        return area;
    }
    
    public double getDiameter() {
        return diameter;
    }
}

class CircleWithExceptionExample{
    public static void main(String[] args){
        System.out.println("Creating a circle with -5 radius");
        try{
            CircleWithException cir1 = new CircleWithException(-5);
            System.out.println(cir1.getRadius());
        }
        catch (Exception e){
            System.out.println(e);
        }
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of the circle: ");
        try{
            double rad = sc.nextDouble();
            CircleWithException cir4 = new CircleWithException(rad);
            System.out.printf("Your circle area is %f\n", cir4.getArea());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
