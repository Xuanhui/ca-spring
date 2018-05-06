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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="partinfo")
public class Partinfo {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="partnumber")
	private int partnumber;
	@Column(name="status")
	private String status;
	@Column(name="supplierid")
	private int supplierid;
	public Product getMproduct() {
		return mproduct;
	}
	public void setMproduct(Product mproduct) {
		this.mproduct = mproduct;
	}
	public Supplier getMsupplier() {
		return msupplier;
	}
	public void setMsupplier(Supplier msupplier) {
		this.msupplier = msupplier;
	}
	public List<ProductConsumption> getPartitems() {
		return partitems;
	}
	public void setPartitems(List<ProductConsumption> partitems) {
		this.partitems = partitems;
	}
	@ManyToOne
	@JoinColumn(name="partnumber",referencedColumnName = "partnumber", insertable = false, updatable = false)
	private Product mproduct;
	@ManyToOne
	@JoinColumn(name="supplierid",referencedColumnName = "id", insertable = false, updatable = false)
	private Supplier msupplier;
	@OneToMany(mappedBy="mpartinfo",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<ProductConsumption> partitems;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public Partinfo(int id, int partnumber, String status, int supplierid) {
		super();
		this.id = id;
		this.partnumber = partnumber;
		this.status = status;
		this.supplierid = supplierid;
	}
	public Partinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Partinfo other = (Partinfo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "partinfo [id=" + id + ", partnumber=" + partnumber + ", status=" + status + ", supplierid=" + supplierid
				+ "]";
	}

}


