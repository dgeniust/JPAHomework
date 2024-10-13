package entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> images;
	public static volatile SingularAttribute<Category, String> categoryname;
	public static volatile ListAttribute<Category, Video> videos;
	public static volatile SingularAttribute<Category, Integer> categoryId;
	public static volatile SingularAttribute<Category, Integer> status;

	public static final String IMAGES = "images";
	public static final String CATEGORYNAME = "categoryname";
	public static final String VIDEOS = "videos";
	public static final String CATEGORY_ID = "categoryId";
	public static final String STATUS = "status";

}

