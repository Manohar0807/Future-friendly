package comcom.in28minutes.rest.webservices.restfulwebservices.user2;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="rating2")
public class Rate {
	@Id
	@GeneratedValue	
	private int  ratingID;
	
	private String rate ;
	private int count;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private User2 user2;
	 public User2 getUser2() {
		return user2;
	}
	public void setUser2(User2 user2) {
		this.user2 = user2;
	}
	public int getRatingID() {
			return ratingID;
		}
		public void setRatingID(int ratingID) {
			this.ratingID = ratingID;
		}
		public String getRate() {
			return rate;
		}
		public void setRate(String rate) {
			this.rate = rate;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
		
	
	
}