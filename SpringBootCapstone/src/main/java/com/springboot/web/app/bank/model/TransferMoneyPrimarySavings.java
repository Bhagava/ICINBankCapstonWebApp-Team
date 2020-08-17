package com.springboot.web.app.bank.model;

public class TransferMoneyPrimarySavings {

	private String accType;
	private String accNo;
	private String amount;
	
	
	public TransferMoneyPrimarySavings(String accType, String accNo, String amount) {
		super();
		this.accType = accType;
		this.accNo = accNo;
		this.amount = amount;
	}
	
	
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNo == null) ? 0 : accNo.hashCode());
		result = prime * result + ((accType == null) ? 0 : accType.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
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
		TransferMoneyPrimarySavings other = (TransferMoneyPrimarySavings) obj;
		if (accNo == null) {
			if (other.accNo != null)
				return false;
		} else if (!accNo.equals(other.accNo))
			return false;
		if (accType == null) {
			if (other.accType != null)
				return false;
		} else if (!accType.equals(other.accType))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TransferMoneyPrimarySavings [accType=" + accType + ", accNo=" + accNo + ", amount=" + amount + "]";
	}
	
	

	
}
