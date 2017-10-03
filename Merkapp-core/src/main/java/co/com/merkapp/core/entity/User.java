package co.com.merkapp.core.entity;

import java.util.List;

import javax.persistence.*;

@Entity(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LASTNAME")
	private String lastame;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<MarketItem> itemList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastame() {
		return lastame;
	}

	public void setLastame(String lastame) {
		this.lastame = lastame;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addMarketItem(MarketItem marketItem){
		this.itemList.add(marketItem);
		marketItem.setUser(this);
	}

	public void removeMarketItem(MarketItem marketItem){
		this.itemList.remove(marketItem);
		marketItem.setUser(null);
	}

	public List<MarketItem> getItemList(){
		return this.itemList;
	}
}
