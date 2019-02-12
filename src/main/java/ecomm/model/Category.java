package ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Category 
{	
	@Id
	@GeneratedValue
	int categoryId;
	String categoryName;
	String categoryDes;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDes() {
		return categoryDes;
	}
	public void setCategoryDes(String categoryDes) {
		this.categoryDes = categoryDes;
	}
}
