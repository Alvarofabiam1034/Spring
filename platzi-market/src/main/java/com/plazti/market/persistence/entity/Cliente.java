package com.plazti.market.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String celular;
    private String direccion;

    //cliente es el nombre de la instancia Cliente en el objeto Compras
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @Column(name="correo_electronico")
    private String correoElectronico;


}
