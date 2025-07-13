package kr.co.brownyc.es8.repository;

import kr.co.brownyc.es8.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
