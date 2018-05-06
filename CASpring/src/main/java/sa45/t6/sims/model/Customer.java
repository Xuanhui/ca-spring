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
@Table(name="userinfo")
public class Customer {
	@Id
	@Column(name="id")
	private int id;
	@Basic
	@Column(name="name")
	private String name;
	@Column(name="lastname")
	private String lastname;
	@Column(name="firstname")
	private String firstname;
	@Column(name="phonenumber")
	private int phonenumber;
	@Column(name="countrycode")
	private int countrycode;
	@Column(name="department")
	private String department;
	@Column(name="type")
	private String type;
	@Column(name="password")
	private String password;
	@Column(name="tmp")
	private String tmp;
	@OneToMany(mappedBy="mcustomer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<ProductConsumptionList> partitems;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public Customer(int id, String name, String lastname, String firstname, int phonenumber, int countrycode,
			String department, String type, String password, String tmp) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phonenumber = phonenumber;
		this.countrycode = countrycode;
		this.department = department;
		this.type = type;
		this.password = password;
		this.tmp = tmp;
	}
	public Customer() {
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", phonenumber=" + phonenumber + ", countrycode=" + countrycode + ", department=" + department
				+ ", type=" + type + ", password=" + password + ", tmp=" + tmp + "]";
	}
	
}



