package org.sberuniversity;

import java.util.ArrayList;
import java.util.Map;



public class Main {
    public static void main(String[] args) {
        ArrayList<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person("Антон", 23));
        someCollection.add(new Person("Вероника", 53));
        someCollection.add(new Person("Владик", 44));
        someCollection.add(new Person("Сережа", 35));

        Map m = Streams.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.getName(), p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p);
        System.out.println(m);
    }
}