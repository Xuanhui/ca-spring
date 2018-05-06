package sa45.t6.sims.model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productconsumption")
public class ProductConsumption {
	@Id
	@Column(name="id")
	private int id;
	@Basic
	@Column(name="prodconsumptionlistid")
	private int prodconsumptionlistid;
	public ProductConsumptionList getmProductConsumption() {
		return mProductConsumption;
	}

	public void setmProductConsumption(ProductConsumptionList mProductConsumption) {
		this.mProductConsumption = mProductConsumption;
	}

	public Partinfo getMpartinfo() {
		return mpartinfo;
	}

	public void setMpartinfo(Partinfo mpartinfo) {
		this.mpartinfo = mpartinfo;
	}

	@Column(name="partinfoid")
	private int partinfoid;
	@ManyToOne
	@JoinColumn(name="prodconsumptionlistid",referencedColumnName ="id",insertable = false, updatable = false)
	private ProductConsumptionList mProductConsumption;
	@ManyToOne
	@JoinColumn(name="partinfoid",referencedColumnName ="id",insertable = false, updatable = false)
	private Partinfo mpartinfo;

	public ProductConsumption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductConsumption(int id, int prodconsumptionlistid, int partinfoid) {
		super();
		this.id = id;
		this.prodconsumptionlistid = prodconsumptionlistid;
		this.partinfoid = partinfoid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProdconsumptionlistid() {
		return prodconsumptionlistid;
	}

	public void setProdconsumptionlistid(int prodconsumptionlistid) {
		this.prodconsumptionlistid = prodconsumptionlistid;
	}

	public int getPartinfoid() {
		return partinfoid;
	}

	public void setPartinfoid(int partinfoid) {
		this.partinfoid = partinfoid;
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
		ProductConsumption other = (ProductConsumption) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductConsumption [id=" + id + ", prodconsumptionlistid=" + prodconsumptionlistid + ", partinfoid="
				+ partinfoid + "]";
	}

}





