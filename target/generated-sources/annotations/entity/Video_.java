package entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Video.class)
public abstract class Video_ {

	public static volatile SingularAttribute<Video, String> active;
	public static volatile SingularAttribute<Video, String> description;
	public static volatile SingularAttribute<Video, String> videoId;
	public static volatile SingularAttribute<Video, String> title;
	public static volatile SingularAttribute<Video, Category> category;
	public static volatile SingularAttribute<Video, String> poster;
	public static volatile SingularAttribute<Video, String> views;

	public static final String ACTIVE = "active";
	public static final String DESCRIPTION = "description";
	public static final String VIDEO_ID = "videoId";
	public static final String TITLE = "title";
	public static final String CATEGORY = "category";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";

}

