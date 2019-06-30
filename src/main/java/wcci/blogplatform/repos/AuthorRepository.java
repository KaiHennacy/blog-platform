package wcci.blogplatform.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogplatform.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	Author findByName(String author);

}
