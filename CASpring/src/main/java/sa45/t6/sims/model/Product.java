package sa45.t6.sims.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="productinfo")
public class Product {
	@Id
	@Column(name="partnumber")
	private int partnumber;
	@Basic
	@Column(name="name")
	private String name;
	@Column(name="parttype")
	private String parttype;
	@Column(name="unitprice")
	private double unitprice;
	@Column(name="description")
	private String description;
	@Column(name="color")
	private String color;
	@Column(name="dimension")
	private String dimension;
	@Column(name="manufacturer")
	private String manufacturer;
	@Column(name="reorderpoint")
	private int reorderpoint;
	@Column(name="minreorderquantity")
	private int minreorderquantity;
	@Column(name="quantity")
	private int quantity;
	@Column(name="shelflocation")
	private String shelflocation;
	@Column(name="status")
	private String status;
	
	@OneToMany(mappedBy="mproduct",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Partinfo> partitems;
	//= new ArrayList<Partinfo>();
	
	public int getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParttype() {
		return parttype;
	}
	public void setParttype(String parttype) {
		this.parttype = parttype;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimention) {
		this.dimension = dimention;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getReorderpoint() {
		return reorderpoint;
	}
	public void setReorderpoint(int reorderpoint) {
		this.reorderpoint = reorderpoint;
	}
	public int getMinreorderquantity() {
		return minreorderquantity;
	}
	public void setMinreorderquantity(int minreorderquantity) {
		this.minreorderquantity = minreorderquantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShelflocation() {
		return shelflocation;
	}
	public void setShelflocation(String shelflocation) {
		this.shelflocation = shelflocation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Product(int partnumber, String name, String parttype, double unitprice, String description, String color,
			String dimention, String manufacturer, int reorderpoint, int minreorderquantity, int quantity,
			String shelflocation, String status) {
		super();
		this.partnumber = partnumber;
		this.name = name;
		this.parttype = parttype;
		this.unitprice = unitprice;
		this.description = description;
		this.color = color;
		this.dimension = dimention;
		this.manufacturer = manufacturer;
		this.reorderpoint = reorderpoint;
		this.minreorderquantity = minreorderquantity;
		this.quantity = quantity;
		this.shelflocation = shelflocation;
		this.status = status;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partnumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (partnumber != other.partnumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [partnumber=" + partnumber + ", name=" + name + ", parttype=" + parttype + ", unitprice="
				+ unitprice + ", description=" + description + ", color=" + color + ", dimension=" + dimension
				+ ", manufacturer=" + manufacturer + ", reorderpoint=" + reorderpoint + ", minreorderquantity="
				+ minreorderquantity + ", quantity=" + quantity + ", shelflocation=" + shelflocation + ", status="
				+ status + "]";
	}
}



