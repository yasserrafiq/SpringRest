package com.yasser.SpringDemo.dto;

import lombok.Data;
import javax.persistence.Entity;
import java.sql.Time;
import java.sql.Date;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
@Data
public class Order {

	@Id
	private int order_id;
	private int user_id;
	private int product_id;
	private Date order_date;
	private Time order_time;
}
