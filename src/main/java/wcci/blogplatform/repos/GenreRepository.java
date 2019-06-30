package wcci.blogplatform.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogplatform.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{

	Genre findByName(String genre);

}
