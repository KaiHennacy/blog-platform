package wcci.blogplatform;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Genre genre;
	
	@ManyToOne
	private Author author;
	
	@ManyToMany
	private Collection<TagEntity> tags = new ArrayList<TagEntity>();
	
	private String title;
	private String content;
	
	protected Post() {
		
	}
	
	public Post(String title, Author author, String content, Genre genre) {
		this.title = title;
		this.author = author;
		this.content = content;
		this.genre = genre;
	}
	
	public void addTag(TagEntity tag) {
		this.tags.add(tag);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public String getContent() {
		return content;
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
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		
}
