package latrattoria.api.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre_menu", nullable = false)
    private String nombre_menu;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "valoracion", nullable = false)
    private double valoracion;

    @Column(name = "url_img", nullable = false)
    private String url_img;

}
