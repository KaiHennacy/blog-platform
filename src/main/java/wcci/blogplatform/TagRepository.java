package wcci.blogplatform;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Long>{

	TagEntity findByName(String name);

}
