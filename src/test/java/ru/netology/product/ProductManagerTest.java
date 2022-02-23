package ru.netology.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void findOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);

        Product book1 = new Book(111, "Евгений Онегин", 110, "Пушкин А.С.");
        Product book2 = new Book(112, "Герой нашего времени", 120, "Лермонтов М.Ю.");
        Product book3 = new Book(113, "Война и мир", 260, "Толстой Л.Н.");
        Product smartphone1 = new Smartphone(114, "Galaxy", 22500, "Samsung");
        Product smartphone2 = new Smartphone(44, "Nova", 18000, "Huawei");
        Product smartphone3 = new Smartphone(77, "Iphone", 50000, "Apple");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);


        Product[] expected = new Product[]{book2};
        Product[] actual = productManager.searchBy("Герой нашего времени");
        assertArrayEquals(expected, actual);
    }

}