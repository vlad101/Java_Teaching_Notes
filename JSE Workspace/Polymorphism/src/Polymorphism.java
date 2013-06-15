class Animal 
{
	public void makeNoice(){ System.out.println("Animals don't make noice!"); }  // the method never gets called
}

class Dog extends Animal
{
	public void makeNoice(){ System.out.println("Roof!"); } // the method overrides animal's method noice
}

class Cat extends Animal
{
	public void makeNoice(){ System.out.println("Meow!"); } // the method overrides animal's method noice
}

public class Polymorphism
{
	public static void main(String[] args) 
	{
		Animal[] animal = {new Dog(), new Cat()}; // put objects into an array of Animal objects
		int cat = 0;
		for(Animal a : animal)
			a.makeNoice();
		Dog dog = new Dog();
		if(dog instanceof Animal) // if(dog instanceof Dog)
			System.out.println("Yes, dog is Gog");
	}
}
