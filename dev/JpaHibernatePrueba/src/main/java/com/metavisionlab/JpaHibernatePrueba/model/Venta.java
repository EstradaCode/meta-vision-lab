package com.metavisionlab.JpaHibernatePrueba.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter @Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_venta;
    public LocalDate fecha_venta;
    private Double total;
    @ManyToMany // many to many porque: una venta puede tener muchos productos y muchas ventas pueden tener el mismo producto.
    @JoinTable( // me crea una tabla intermedia para resolver las relaciones mtm
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> listaProductos;
    @ManyToOne
    @JoinColumn(name= "id_cliente")
    private Cliente cliente;
}
