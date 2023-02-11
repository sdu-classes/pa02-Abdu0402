public class Main {
            public static void main(String[] args)
                Shape s1 = new Shape();
                s1.setColor("green");
                s1.setFilled(false);

                Shape s2 = new Shape("green", false);


                System.out.println(s1);
                System.out.println(s2);

                Circl c1 = new Circl();
                System.out.println(c1);

                Rectangle r1 = new Rectangle();
                Rectangle r2 = new Rectangle(3.0, 4.0, "yellow", false);

                System.out.println(r1);
                System.out.println(r2);

                Square sq1 = new Square();
                System.out.println(sq1.getWidth());
                System.out.println(sq1.getLength());
                sq1.setSide(10);
                System.out.println(sq1.getWidth());
                System.out.println(sq1.getLength());
                sq1.setWidth(3);
                System.out.println(sq1.getWidth());
                System.out.println(sq1.getLength());
            }
        }
class Shape {
    private String color = "red";
    private boolean filled = true;

    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {

        return String.format("A shape with color of %s and %s", this.color, this.filled ? "filled" : "not filled");
    }
}
class Circl extends Shape {
    private double radius = 1.0;

    public Circl() {

    }

    public Circl(double r) {
        this.radius = r;
    }

    public Circl(double r, String c, boolean f) {
        super(c, f);
        this.radius = r;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }


    @Override
    public String toString() {
        return String.format(
                "A Circle with radius=%.2f, which is a subclass of %s",
                this.radius,
                super.toString()
        );
    }
}
class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {

    }

    public Rectangle(double wid, double len) {
        this.width = wid;
        this.length = len;
    }

    public Rectangle(double wid, double len, String c, boolean f) {
        super(c, f);
        this.width = wid;
        this.length = len;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double r) {
        this.width = r;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double r) {
        this.length = r;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }


    @Override
    public String toString() {
        return String.format(
                "A Rectangle with width=%.2f and length=%.2f, which is a subclass of %s",
                this.width,
                this.length,
                super.toString()
        );
    }
}
class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return this.getLength(); 
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        this.setSide(side);
    }

    @Override
    public void setWidth(double side) {
        this.setSide(side);
    }
}
