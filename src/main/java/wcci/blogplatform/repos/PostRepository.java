package wcci.blogplatform.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogplatform.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

}
