package sa45.t6.sims.model;


import java.util.Date;
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
@Table(name = "productconsumptionlist")
public class ProductConsumptionList {
	public Customer getMcustomer() {
		return mcustomer;
	}

	public void setMcustomer(Customer mcustomer) {
		this.mcustomer = mcustomer;
	}

	public List<ProductConsumption> getPconitems() {
		return pconitems;
	}

	public void setPconitems(List<ProductConsumption> pconitems) {
		this.pconitems = pconitems;
	}

	@Id
	@Column(name="id")
	private int id;
	@Basic
	@Column(name="date")
	private Date date;
	@Column(name="userid")
	private int userid;
	@Column(name="custname")
	private String custname;
	@ManyToOne
	@JoinColumn(name="userid",referencedColumnName = "id", insertable = false, updatable = false)
	private Customer mcustomer;
	@OneToMany(mappedBy="mProductConsumption",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<ProductConsumption> pconitems;

	public ProductConsumptionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductConsumptionList(int id, Date date, int userid, String custname) {
		super();
		this.id = id;
		this.date = date;
		this.userid = userid;
		this.custname = custname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
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
		ProductConsumptionList other = (ProductConsumptionList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductConsumptionList [id=" + id + ", date=" + date + ", userid=" + userid + ", custname=" + custname
				+ "]";
	}

}





