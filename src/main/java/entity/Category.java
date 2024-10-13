package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "Select c FROM Category c")
public class Category implements Serializable{
	private static final long serialVersionUID = 5302027001308063983L;
	
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
//	public Video addVideo(Video video) {
//		getVideos().add(video);
//		video.setCategory(this);
//		return video;
//	}
//	public Video removeVideo(Video video) {
//		getVideos().remove(video);
//		video.setCategory(null);
//		return video;
//	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CategoryId")
	private int categoryId;

	@Column(name = "Categoryname", columnDefinition = "nvarchar(50) not null")
	private String categoryname;
	
	@Column(name = "Images", columnDefinition = "nvarchar(500) null")
	private String images;
	
	@Column(name = " Status")
	private int status;
	
	@OneToMany(mappedBy = "category")
	private List<Video> videos;
}
