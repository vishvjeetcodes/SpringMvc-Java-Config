package com.decode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductBean 
{
	@Id
	private int productCode;
	private String productName;
	private int productPrice;
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductBean [productCode=" + productCode + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}
}
