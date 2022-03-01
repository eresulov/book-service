package Polymorphism;

public class MainClass {
	public static void speaktry(Animal animal) {
		animal.speak();
	}
public static void main(String[] args) {
	Animal animal=new Animal("Heyvan");
	Bird bird=new Bird("Ceka");
	Dog dog=new Dog("Charli");
	Cat cat=new Cat("Mastik");
	/*animal.speak();
	bird.speak();
	dog.speak();
	cat.speak();*/
	speaktry(new Dog("Body"));
	speaktry(new Cat("MAsssdiikk"));
}
}
