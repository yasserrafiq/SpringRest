package com.yasser.SpringDemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@Getter
@Setter
@ToString
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String type;
}
