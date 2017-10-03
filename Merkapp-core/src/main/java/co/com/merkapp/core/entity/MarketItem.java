package co.com.merkapp.core.entity;

import javax.persistence.*;

@Entity(name = "MARKETLIST")
public class MarketItem {

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ITEMNAME")
	private String item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setUser(User user){
		this.user = user;
	}
}