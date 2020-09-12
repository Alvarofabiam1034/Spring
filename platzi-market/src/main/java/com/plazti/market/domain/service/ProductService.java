package com.plazti.market.domain.service;

import com.plazti.market.domain.Product;
import com.plazti.market.persistence.ProductoRepository;
import com.plazti.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//define que es un servicio de la logica de negicio
public class ProductService {

    @Autowired
    private ProductoRepository productoRepository = new ProductoRepository();

    public List<Product> getAll(){
        return productoRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productoRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productoRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productoRepository.save(product);
    }

    public boolean delete(int producttId) {

        //Si existia el producto y fue eliminado responde true de lo contrario response false
        return getProduct(producttId).map(Product ->{
           productoRepository.delete(producttId);
           return true;
        }).orElse(false);
    }


}
