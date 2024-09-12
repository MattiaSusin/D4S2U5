package mattiasusin.D3S2U5.repositories;

import mattiasusin.D3S2U5.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
}
