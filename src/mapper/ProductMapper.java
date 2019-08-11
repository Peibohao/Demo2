package mapper;

import java.sql.Date;
import java.util.List;

import product.Product;

public interface ProductMapper {

	//查询
		 String queryIdExist(String v_id);
		
		 Product queryProductById(String v_id);
		
		 Date queryTimeById(String v_id);
		
		 int queryNumById(String v_id);
		 
		 //修改
		 void updateTimeById(String v_id);
		 
		 void updateNumById(Product product);
		
		//测试用查询全部
		 Product queryAllProduct();
		 
		 int querydatanum();
	
}
