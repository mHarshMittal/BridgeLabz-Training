import java.sql.*;

public class PatientDAO {

    public void add(String name,String dob,String phone,String addr,String blood) throws Exception {
        Connection c=DBUtil.getConn();

        PreparedStatement check=c.prepareStatement(
                "select * from patients where phone=?");
        check.setString(1,phone);

        if(check.executeQuery().next()){
            System.out.println("Patient exists");
            return;
        }

        PreparedStatement ps=c.prepareStatement(
                "insert into patients(name,dob,phone,address,blood) values(?,?,?,?,?)");

        ps.setString(1,name);
        ps.setString(2,dob);
        ps.setString(3,phone);
        ps.setString(4,addr);
        ps.setString(5,blood);
        ps.executeUpdate();

        System.out.println("Patient added");
        c.close();
    }

    public void searchByName(String key) throws Exception {
        Connection c=DBUtil.getConn();
        PreparedStatement ps=c.prepareStatement(
                "select * from patients where name like ?");
        ps.setString(1,"%"+key+"%");
        ResultSet rs=ps.executeQuery();

        while(rs.next())
            System.out.println(rs.getInt("id")+" "+rs.getString("name"));

        c.close();
    }

    public void updatePhone(int id,String phone)throws Exception{
        Connection c=DBUtil.getConn();
        PreparedStatement ps=c.prepareStatement(
                "update patients set phone=? where id=?");
        ps.setString(1,phone);
        ps.setInt(2,id);
        ps.executeUpdate();
        c.close();
    }
}
