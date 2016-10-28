package co.com.merkapp.core.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID", nullable=false)
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

	public List<MarketItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<MarketItem> itemList) {
		this.itemList = itemList;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
