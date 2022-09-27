package comcom.in28minutes.rest.webservices.restfulwebservices.user2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	String title;
	String price;
	@Column(length = 800)
	String description;
	@Column(length = 500)
	String category;
	@Column(length = 500)
	String image;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Rate rating_ID;

	public void setRating(Rate rating) {
		this.rating_ID = rating;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	public Rate getRating() {
		return rating_ID;
	}

	public User2(Integer id, String title, String price, String description, String category, String image,
			Rate rating) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
		this.rating_ID = rating;
	}

	public User2() {

	}

}
