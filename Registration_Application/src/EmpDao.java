import java.util.*;
import java.sql.*;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SCOTT","TIGER");
			System.out.println("OK");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user_info values (?,?,?,?,?,?,?)");
			String s1=e.getName();
			String s2=e.getPassword();
			String s3=e.getFirstName();
			String s4=e.getLastName();
			String s5=e.getEmail()	;	
			String s6=e.getPhoneNo();
			String s7=e.getCountry();

			ps.setString(1,s1);
			ps.setString(2,s2);
			ps.setString(3,s3);
			ps.setString(4,s4);
			ps.setString(5,s5);
			ps.setString(6,s6);
			ps.setString(7,s7);
			
			status=ps.executeUpdate();

		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update user_info set username=?, password=?, firstname=?, lastname=?, email=?,phoneno=?, country=? where username=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getFirstName());
			ps.setString(4, e.getLastName());
			ps.setString(5,e.getEmail());
			ps.setString(6, e.getPhoneNo());
			ps.setString(7,e.getCountry());
			ps.setString(8,e.getName());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static void delete(String username){
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from user_info where username=?");
			ps.setString(1,username);
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e1){e1.printStackTrace();}
		
		
	}
	public static Emp getEmployeeById(String user){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user_info where username=?");
			ps.setString(1,e.getName());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setName(rs.getString(1));
				e.setPassword(rs.getString(2));
				e.setFirstName(rs.getString(3));
				e.setLastName(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPhoneNo(rs.getString(6));
				e.setCountry(rs.getString(7));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user_info");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				
				e.setName(rs.getString(1));
				e.setPassword(rs.getString(2));
				e.setFirstName(rs.getString(3));
				e.setLastName(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPhoneNo(rs.getString(6));
				e.setCountry(rs.getString(7));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
}
