package wcci.blogplatform;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "genre")
	private Collection<Post> posts;
	
	private String type;
	
	protected Genre() {
	}
	
	public Genre(String type) {
		this.type = type;
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	public void addPost(Post post) {
		this.posts.add(post);
	}


	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Genre other = (Genre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}
