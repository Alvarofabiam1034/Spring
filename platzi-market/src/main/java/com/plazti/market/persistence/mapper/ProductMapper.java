package com.plazti.market.persistence.mapper;

import com.plazti.market.domain.Category;
import com.plazti.market.domain.Product;
import com.plazti.market.persistence.entity.Categoria;
import com.plazti.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
// Al definir el componentModel como spring le estamos diciendo que es un objeto de spring
//Permitiendo realizar la inyeccion de dependecias
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source="idProducto",target="productId"),
            @Mapping(source="nombre",target="name"),
            @Mapping(source="idCategoria",target="categoryId"),
            @Mapping(source="precioVenta",target="price"),
            @Mapping(source="cantidadStock",target="stock"),
            @Mapping(source="estado",target="active"),
            @Mapping(source="categoria",target="category")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    //Define que esta conversión es la inversa de la superior
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}
