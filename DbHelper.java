package kırtasiyeotomasyonuu;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

//Veritabanı işelmlerini gerçekleştirmek için yarıdmcı sınıf oluşturdum . 
public class DbHelper {
    static String username = "root";
    static String password = "918273645ozlem";
    static String dbUrl = "jdbc:mysql://localhost:3306/kırtasiye";

    // veritabanı bağlantısını sağlayan metot.
    public Connection getConnection() throws SQLException {
  // DriverManager sınıfı kullanarak veritabanına bağlanmak için kullandım .
        return (Connection) DriverManager.getConnection(dbUrl, username, password);

    }
//SQL istisna durumları için hata gösterme metodu oluşturdum.
    public void ShowError(SQLException ex) {
        System.out.println("Error :" + ex.getMessage());
        System.out.println("Error Code :" + ex.getErrorCode());

    }
}
