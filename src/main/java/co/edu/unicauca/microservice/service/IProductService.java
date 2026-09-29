package co.edu.unicauca.microservice.service;

import co.edu.unicauca.microservice.model.Product;

import java.util.List;

/**
 * Contrato de la capa de negocio para la gestión de productos.
 */
public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    Product update(Long id, Product product);

    boolean delete(Long id);
}
