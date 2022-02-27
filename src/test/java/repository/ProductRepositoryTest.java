package repository;

import domain.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void save() {
        ProductRepository repository = new ProductRepository();
        Product book1 = new Book(111, "Евгений Онегин", 110, "Пушкин А.С.");
        Product book2 = new Book(112, "Герой нашего времени", 120, "Лермонтов М.Ю.");
        Product book3 = new Book(113, "Война и мир", 260, "Толстой Л.Н.");
        Product smartphone1 = new Smartphone(114, "Galaxy", 22500, "Samsung");
        Product smartphone2 = new Smartphone(44, "Nova", 18000, "Huawei");
        Product smartphone3 = new Smartphone(77, "Iphone", 50000, "Apple");

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        ProductRepository repository = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void removeById() {
        ProductRepository repository = new ProductRepository();
        Product one = new Product(111, "First", 125);
        Product two = new Product(112, "Second", 524);
        Product three = new Product(113, "Third", 5582);

        repository.save(one);
        repository.save(two);
        repository.save(three);

        repository.removeById(112);

        Product[] expected = {one, three};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeNotFoundId() {
        ProductRepository repository = new ProductRepository();
        Product one = new Product(111, "First", 125);
        Product two = new Product(112, "Second", 524);
        Product three = new Product(113, "Third", 5582);

        repository.save(one);
        repository.save(two);
        repository.save(three);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(114));
    }
}