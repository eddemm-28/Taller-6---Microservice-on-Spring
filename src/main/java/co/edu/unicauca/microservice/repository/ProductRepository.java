package co.edu.unicauca.microservice.repository;

import co.edu.unicauca.microservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Capa de persistencia: simula una base de datos guardando
 * los productos en una lista en memoria.
 */
@Repository
public class ProductRepository {

    private final List<Product> products = new CopyOnWriteArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public ProductRepository() {
        // Datos iniciales de prueba
        save(new Product(1L, "Laptop Dell", 3500000.0));
        save(new Product(2L, "Mouse Inalámbrico", 80000.0));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            // Si el cliente no envía id, se genera uno automáticamente
            product.setId(sequence.incrementAndGet());
        } else {
            // Si ya existe un producto con ese id, se reemplaza
            products.removeIf(p -> p.getId().equals(product.getId()));
            sequence.accumulateAndGet(product.getId(), Math::max);
        }
        products.add(product);
        return product;
    }

    public boolean existsById(Long id) {
        return products.stream().anyMatch(p -> p.getId().equals(id));
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
