package mattiasusin.D3S2U5.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "blogPosts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;

    @Id
    @GeneratedValue
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private double tempoDiLettura;


    // TO STRING
    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
