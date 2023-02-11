public class Main {
    public static void main(String[] args) {
        Animal a = new Animal("Masha");
        System.out.println(a);

        Mammal m = new Mammal("Tom");
        System.out.println(m);

        Cat c = new Cat("Ferdinant");
        System.out.println(c);
        c.greets();

        Dog d = new Dog("Gerri");
        System.out.println(d);
        d.greets();
        d.greets(d);
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Animal[name=\"%s\"]", this.name);
    }
}

class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Mammal[%s]", super.toString());
    }
}

class Cat extends Mammal {
    public Cat(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return String.format("Cat[%s]", super.toString());
    }
}
class Dog extends Mammal {
    public Dog(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("Woof");
    }

    // overloaded method
    public void greets(Dog another) {
        System.out.println("Woooof");
    }

    @Override
    public String toString() {
        return String.format("Dog[%s]", super.toString());
    }
}
