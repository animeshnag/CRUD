import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    public static void main(String[] args){
        CRUD obj1=new CRUD();
        //obj1.create_data(2, "animesh", "Banglore", 20, "SE" );
        //obj1.update_data(2, "ANIMESH", "BanglorE", 20, "SE" );
        //obj1.read_data(1);
        obj1.delete_data(2);
    }
    public void create_data(int id, String name, String city, int age, String deptName){
        DB obj=new DB();
        Connection connection=obj.getConnection();

        PreparedStatement ps=null;
        try{
            String query="insert into employee(id, name, city, age, deptName) values (?, ?, ?,?,?)";
            ps=connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, city);
            ps.setInt(4, age);
            ps.setString(5, deptName);
            System.out.println(ps);
            ps.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void read_data(int id){
        DB obj=new DB();
        Connection connection=obj.getConnection();

        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String query="select * from employee where id=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1, id);

            System.out.println(ps);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("city"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getString("deptName"));
                ps.executeUpdate();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_data(int id){
        DB obj=new DB();
        Connection connection=obj.getConnection();
        PreparedStatement ps=null;
        try{
            String query="delete from employee where id=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1, id);

            System.out.println("\ninside Delete" + ps);
            ps.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
