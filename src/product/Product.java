package product;

import java.sql.Date;

public class Product {

	private String v_id;
	private Date time;
	private int num;
	private int p_id;
	
	@Override
	public String toString() {
		return "验证码:"+this.v_id+"--"+"时间："+this.time+"--"+"验证次数："+this.num;
		
	}
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(java.util.Date date) {
		this.time = (Date) date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
	
}
