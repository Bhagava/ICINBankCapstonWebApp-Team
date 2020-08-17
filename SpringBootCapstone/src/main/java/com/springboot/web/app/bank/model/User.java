package com.springboot.web.app.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String fullname;
	private String surname;
	private String mailid;
	private Long phonenumber;
	private String address;
	private String password;
	private String status;
	
//	@Null
//	private int primay_id;
//	@Null
//	private int savings_id;
//	
	

    public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@OneToOne
    private PrimaryAccount primaryAccount;

    @OneToOne
    private SavingsAccount savingsAccount;
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Chequebook> ChequeBookList;
	
	
	public List<Chequebook> getChequeBookList() {
		return ChequeBookList;
	}


	public void setChequeBookList(List<Chequebook> chequeBookList) {
		ChequeBookList = chequeBookList;
	}


	public User() {
	}
	


	


	public User(Long id, String fullname, String surname, String mailid, Long phonenumber, String address,
			String password, String status, PrimaryAccount primaryAccount, SavingsAccount savingsAccount,
			List<Chequebook> chequeBookList) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.surname = surname;
		this.mailid = mailid;
		this.phonenumber = phonenumber;
		this.address = address;
		this.password = password;
		this.status = status;
		this.primaryAccount = primaryAccount;
		this.savingsAccount = savingsAccount;
		ChequeBookList = chequeBookList;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public PrimaryAccount getPrimaryAccount() {
		return primaryAccount;
	}


	public void setPrimaryAccount(PrimaryAccount primaryAccount) {
		this.primaryAccount = primaryAccount;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ChequeBookList == null) ? 0 : ChequeBookList.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mailid == null) ? 0 : mailid.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + ((primaryAccount == null) ? 0 : primaryAccount.hashCode());
		result = prime * result + ((savingsAccount == null) ? 0 : savingsAccount.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (ChequeBookList == null) {
			if (other.ChequeBookList != null)
				return false;
		} else if (!ChequeBookList.equals(other.ChequeBookList))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mailid == null) {
			if (other.mailid != null)
				return false;
		} else if (!mailid.equals(other.mailid))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (primaryAccount == null) {
			if (other.primaryAccount != null)
				return false;
		} else if (!primaryAccount.equals(other.primaryAccount))
			return false;
		if (savingsAccount == null) {
			if (other.savingsAccount != null)
				return false;
		} else if (!savingsAccount.equals(other.savingsAccount))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", surname=" + surname + ", mailid=" + mailid
				+ ", phonenumber=" + phonenumber + ", address=" + address + ", password=" + password + ", status="
				+ status + ", primaryAccount=" + primaryAccount + ", savingsAccount=" + savingsAccount
				+ ", ChequeBookList=" + ChequeBookList + "]";
	}
	
}

