package method;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.ProductMapper;
import product.Product;

//测试-查询全部
	public class Method{
		
		//测试-查询全部
		public static void queryAllProduct() throws IOException {
			Reader reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			
			ProductMapper prodcutMapper=session.getMapper(ProductMapper.class);
			Product products=prodcutMapper.queryAllProduct();
			System.out.println(products);
			session.close();
		}
		
		
		
		//查询首次验证时间
	    public static Date queryTimeById() throws IOException {
			
			Reader reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			
			ProductMapper prodcutMapper=session.getMapper(ProductMapper.class);
			String v_idString="1234567890123456";
			Date date=prodcutMapper.queryTimeById(v_idString);
			session.commit();
//			System.out.println(date);
			session.close();
			return date;
		}
	    
	    //查询验证次数
	    public static int queryNumById() throws IOException {
			
			Reader reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			
			ProductMapper prodcutMapper=session.getMapper(ProductMapper.class);
			String v_idString="1234567890123456";
			int num=prodcutMapper.queryNumById(v_idString);
			session.commit();
//			System.out.println(num);
			session.close();
			return num;
		}
	    
	    //查询v_id是否存在
	       public static boolean queryIdExist(String v_id) throws IOException {
			
	    	
			Reader reader=Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=sessionFactory.openSession();
			
			ProductMapper prodcutMapper=session.getMapper(ProductMapper.class);
			
			String v_idString=prodcutMapper.queryIdExist(v_id);
			session.commit();
			session.close();
			if(v_idString!=null)
			return true;
			else return false;	
		}
	       
	     //修改时间
	   	public static void updateTimeById() throws IOException {
	   		Reader reader=Resources.getResourceAsReader("conf.xml");
	   		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	   		SqlSession session=sessionFactory.openSession();
	   		
	   		ProductMapper prodcutMapper=session.getMapper(ProductMapper.class);
	   		
	   		String v_idString="1234567890123456";
	   		prodcutMapper.updateTimeById(v_idString);
	   		session.commit();
	   		System.out.println("记录验证日期成功！");
	   		session.close();
	   	}
	   	
	   	//增加验证次数
	   	public static void updateNumById() throws IOException {
	   		
	   		int count=queryNumById()+1;
	   		Reader reader=Resources.getResourceAsReader("conf.xml");
	   		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	   		SqlSession session=sessionFactory.openSession();
	   		
	   		ProductMapper prodcutMapper=session.getMapper(ProductMapper.class);
	   		Product product=new Product();
	   		product.setV_id("1234567890123456");
	   		product.setNum(count);
	   		prodcutMapper.updateNumById(product);
	   		session.commit();
	   		System.out.println("修改验证次数成功！");
	   		session.close();
	   	}
	   	
	   	//main方法
	   	public static void Main() throws IOException {
				if(queryNumById()==0)
				updateNumById();
				DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
				System.out.println("当前验证次数为："+queryNumById());
				if(queryNumById()>5) {
					System.out.println("当前验证次数已超过5次，首次认证时间为"+df4.format(queryTimeById())+"请注意购买渠道，谨防假冒");
					return;
				}
				System.out.println("首次验证时间为："+df4.format(queryTimeById()));
			}
    }
	   	
   	
