package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Test {

	public static void main1(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			Statement st =con.createStatement();
			String query = "create table employee("
					+ "id int not null,"
					+ "name varchar(50) not null,"
					+ "age int not null,"
					+ "mobile long not null,"
					+ "primary key(id)"
					+ ")";
			int result=st.executeUpdate(query);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main2(String[] args) {
		String query = "ALTER TABLE employee ADD COLUMN qual varchar(50) not null";
		try {
			int st= JDBCConnection.st().executeUpdate(query);
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main3(String[] args) {
		String query = "ALTER TABLE employee modify column id int not null auto_increment";
		try {
			int st= JDBCConnection.st().executeUpdate(query);
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main4(String[] args) {
		String query = "insert into employee (name, age, mobile, qual) values ('hari', 23, 3645, 'mca')";
		try {
			int st= JDBCConnection.st().executeUpdate(query);
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main5(String[] args) {
		String query = "create table Company("
				+ "id int not null auto_increment,"
				+ "role varchar(50) not null,"
				+"sal double not null,"
				+ "empid int not null,"
				+"primary key(id)"
				+ ")";
		try {
			int i =JDBCConnection.st().executeUpdate(query);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main6(String[] args) {

		String query = "insert into company (role, sal, empid) values ('hr', 50000, 5)";
		try {
			int st= JDBCConnection.st().executeUpdate(query);
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main7(String[] args) {
		String query = "create table EmployeeProject (id int not null auto_increment, empid int not null, pjid int not null, primary key(id))";
		try {
			int i = JDBCConnection.st().executeUpdate(query);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}public static void main8(String[] args) {
		String query = "select * from employee order by name asc";
		try {
		ResultSet rs = JDBCConnection.st().executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString("id")+" "+rs.getString("name")+" "+rs.getString("age")+" "+rs.getString("mobile")+" "+rs.getString("qual")+" ");
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main9(String[] args) {

		String query = "select * from employee e inner join Company c where e.id=c.empid";
		try {
		ResultSet rs = JDBCConnection.st().executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString("id")+" "
					+rs.getString("name")+" "+rs.getString("age")+" "
					+rs.getString("mobile")+" "+rs.getString("qual")+" "
					+rs.getString("c.role")+" "+rs.getString("sal"));
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public static void main10(String[] args) {


		String query = "select * from employee e inner join Company c inner join employeeproject ep inner join project p where e.id=c.empid and e.id=ep.empid and ep.pjid=p.id order by p.name asc"
				+ "";
		try {
		ResultSet rs = JDBCConnection.st().executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString("id")+" "
					+rs.getString("name")+" "+rs.getString("age")+" "
					+rs.getString("mobile")+" "+rs.getString("qual")+" "
					+rs.getString("c.role")+" "+rs.getString("sal")
					+" "+rs.getString("p.name"));
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main11(String[] args) {
		String query = "\r\n"
				+ "select distinct(e.name) from employee e join Company c join employeeproject ep  join project p where e.id=c.empid and e.id=ep.empid and ep.pjid=p.id and e.age=(\r\n"
				+ "select distinct(e.age) from employee e join employeeproject ep where e.id=ep.empid and e.qual='mtech' and ep.pjid=("
				+ "select p.id from project p where p.name like 'h%')) ;\r\n";
		try {
		ResultSet rs = JDBCConnection.st().executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main12(String[] args) {
		Connection con;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			st = con.prepareStatement("insert into project (name) values (?)");
			st.setString(1, "python");
	boolean d = st.execute();
			System.out.println(d +" com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			PreparedStatement ps =con.prepareStatement("insert into employee (name, age, qual, mobile) values (?,?,?,?)");
			employee e = new employee("prasad", 29, "ba", 5656556);
			ps.setString(1, e.getName());
			ps.setInt(2, e.getAge());
			ps.setString(3, e.getQual());
			ps.setLong(4, e.getMobile());
			boolean b = ps.execute();
		
			System.out.println(b+" completed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
