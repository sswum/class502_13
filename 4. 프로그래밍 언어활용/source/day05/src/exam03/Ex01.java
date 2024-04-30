package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Human human = new Human(); // Human, Animal
        human.move();

        Tiger tiger = new Tiger(); // tiger , Animal
        tiger.move();

        Bird bird = new Bird(); //bird, Animal
        bird.move();
/*
        Animal[] animals = new Animal[3];
        animals[0]=human;
        animals[1]=tiger;
        animals[2]=bird; */

/*
       for (Animal animal : animals) {
           animal.move();
        }

       if(animal instaceof Human){
            Human human = (Human) animal;
            human.reading();
        } else if (anmal instanceof Tiger) {
           Tiger tiger = (Tiger) animal;
           tiger.hunting();
        }

*/
    }
}

