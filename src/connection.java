import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class connection {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/praful", "root", "mysql");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from employe where id=1");
		while (rs.next()) {
			
			WebDriver driver= new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=in");
			
			driver.findElement(By.id("username")).sendKeys(rs.getString("name"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("age"));

			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("loaction"));
			System.out.println(rs.getString("age"));
			System.out.println("succesfull");
			System.out.println("Database testing");
			System.out.println("Api testing");
			
		}
	}

}
