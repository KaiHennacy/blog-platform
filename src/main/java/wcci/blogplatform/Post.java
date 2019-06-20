package wcci.blogplatform;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String author;
	private String content;
	
	protected Post() {
		
	}
	
	public Post(String title, String author, String content) {
		this.title = title;
		this.author = author;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}
}
