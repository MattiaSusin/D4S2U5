package mattiasusin.D3S2U5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autori")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autore {

    @OneToMany
    @JoinColumn(name = "blog_post_id")
    private List<BlogPost> blogPosts;

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private int dataDiNascita;
    private String avatar;

    //TO STRING
    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
