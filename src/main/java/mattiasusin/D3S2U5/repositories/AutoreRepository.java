package mattiasusin.D3S2U5.repositories;

import mattiasusin.D3S2U5.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {

}
