package org.sberuniversity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {
    ArrayList<Person> someCollectionTest = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        someCollectionTest.add(new Person("Антон", 23));
        someCollectionTest.add(new Person("Вероника", 53));
        someCollectionTest.add(new Person("Владик", 44));
        someCollectionTest.add(new Person("Сережа", 35));
    }

    @Test
    public void StreamOfTest() {
        ArrayList<Person> result = someCollectionTest;
        assertEquals(someCollectionTest.size(), result.size());
    }

    @Test
    public void StreamFilterTest() {
        List<Person> result = someCollectionTest.stream()
                .filter(person -> person.getAge() > 30)
                .collect(Collectors.toList());
        assertEquals(3, result.size());
    }

    @Test
    public void StreamtransformTest() {
        Stream<Person> result = someCollectionTest.stream()
                .map(p -> new Person(p.getName(), p.getAge() + 30));
        assertEquals(4, result.count());
    }

    @Test
    public void StreamToMapTest() {
        Map<String, Integer> result = someCollectionTest.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        assertEquals(4, result.size());

    }

}