package wcci.blogplatform.models;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TagEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "tags")
	private Collection<Post> posts = new ArrayList<Post>();
	 
	private String name;
	
	protected TagEntity() {
	}
	
	public TagEntity(String name) {
		this.name = name;
	}
	
	public void addPost(Post post) {
		this.posts.add(post);
	}

	public Long getId() {
		return id;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TagEntity other = (TagEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		
}
