package d_assertj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ZooTest {
    @Test

    public void newlyCreatedZoo_shouldBeEmpty() {
        Zoo zoo = new Zoo();

        List<Animal> allAnimals = zoo.getAllAnimals();
        //       Assertions.assertThat(allAnimals).hasSize(0);
        Assertions.assertThat(allAnimals).isEmpty();
    }

    @Test
    public void whenAddingOneAnimal_thereShouldBeOneAnimalInTheZoo(){
        Zoo zoo = new Zoo();
        Animal animal = new Animal("Żyrafa");
        zoo.addAnimal(animal);
        List<Animal> allAnimals = zoo.getAllAnimals();
      //  Assertions.assertThat(allAnimals).hasSize(1);
        Assertions.assertThat(allAnimals).containsExactly(animal);

    }
    // "Stefan" -> "Zwierzątko      Stefan"
    @Test
    public void generateNameWithPrefix_thereShouldBePrefixAtTheBeginning(){
        Zoo zoo = new Zoo();
        Animal animal = new Animal("Zebra");
        String generatedName  = zoo.generateNameWithPrefix(animal);
        System.out.println(generatedName);
        Assertions.assertThat(generatedName).startsWith("Zwierzątko")
        .endsWith("Zebra");
    }

}


