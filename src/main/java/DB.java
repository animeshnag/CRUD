import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class DB {

    public static void main(String[] args){
        DB obj=new DB();
        System.out.println(obj.getConnection());

    }

    public Connection getConnection(){ // throws ClassNotFoundException {

        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
        }
        catch(Exception e){
            System.out.println("e");
        }
        return connection;

        /*String url = "jdbc:mysql://localhost:3306/CRUD\",\"root\",\"root\n";
        String user = "root";
        String password = "root";
        Connection myCon = getConnection(url, user, password);
        Statement st = myCon.createStatement();
        String sql = "select * from crud.employee";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
        }*/
    }


}
