package com.apap.tutorial7.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;;


@Entity
@Table(name = "car")
	
public class CarModel implements Serializable,Comparable<CarModel> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "type", nullable = false)
	private String type;
	
	@NotNull
	@Column(name = "price", nullable = false)
	private Long price;
	
	@NotNull
	@Column(name = "amount", nullable = false)
	private Integer amount;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dealer_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonProperty(access = Access.WRITE_ONLY)
	private DealerModel dealer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public DealerModel getDealer() {
		return dealer;
	}

	public void setDealer(DealerModel dealer) {
		this.dealer = dealer;
	}
	
	public String toString() {
		return this.brand + " " + this.type + " "+ this.price + " " + this.amount;
	}
	
	@Override
    public int compareTo(CarModel other) {
        return this.getPrice() > other.getPrice() ? -1 : 1;
    }

}
