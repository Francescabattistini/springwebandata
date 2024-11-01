package francescabattistini.springwebandata.repository;

import francescabattistini.springwebandata.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Authorepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByEmail(String email);
}
