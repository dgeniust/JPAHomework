package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "videos")
@NamedQuery(name = "Video.findAll", query = "Select c from Video c")
public class Video implements Serializable{
	private static final long serialVersionUID = -74014124559999475L;
	
	@Id
	@Column(name="VideoId")
	private String videoId;
	
	@Column(name="Active")
	private String active;
	
	@Column(name="Description", columnDefinition = "nvarchar(500) NULL")
	private String description;
	
	@Column(name="Poster", columnDefinition = "nvarchar(500) NULL")
	private String poster;
	
	@Column(name="TitleVideo", columnDefinition = "nvarchar(500) NULL")
	private String title;
	
	@Column(name="Views")
	private String views;
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;

	public Video() {
	}

}
