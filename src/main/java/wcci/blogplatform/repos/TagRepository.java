package wcci.blogplatform.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogplatform.models.TagEntity;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Long>{

	TagEntity findByName(String name);

}
