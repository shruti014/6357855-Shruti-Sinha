// Animal Interface
interface Animal{
    void makeSound();
}


class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Factory class
class AnimalFactory {
    public static Animal createAnimal(String animalType) {
        if (animalType.equalsIgnoreCase("dog")) {
            System.out.println("Dog Object created.");
            return new Dog();
        } else if (animalType.equalsIgnoreCase("cat")) {
            System.out.println("Cat Object created.");
            return new Cat();
        } else {
            // default case
            System.out.println("Invalid animal type.");
            return null;
        }
    }
}

// Main class
public class exercise2 {
    public static void main(String[] args) {
        // Requesting Dog Obj.
        System.out.println("Requesting Dog:");
        Animal a1 = AnimalFactory.createAnimal("dog");
        a1.makeSound();

        // Requesting Cat Obj.
        System.out.println("Requesting Cat:");  
        Animal a2 = AnimalFactory.createAnimal("cat");
        a2.makeSound();

        // Requesting Horse Obj.
        System.out.println("Requesting Horse:");  
        Animal a3 = AnimalFactory.createAnimal("horse");
        if (a3 != null) a3.makeSound(); // Safe Check as a3 will return null
    }
}