package com.plazti.market.persistence.crud;

import com.plazti.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //@Query(value="SELECT * FROM productos WHERE id_categoria =?",nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> finByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
