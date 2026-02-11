import java.sql.*;

public class DoctorDAO {

    public void add(String name,int spec,String phone,double fee)throws Exception{
        Connection c=DBUtil.getConn();
        PreparedStatement ps=c.prepareStatement(
                "insert into doctors(name,specialty_id,phone,fee,is_active) values(?,?,?,?,true)");
        ps.setString(1,name);
        ps.setInt(2,spec);
        ps.setString(3,phone);
        ps.setDouble(4,fee);
        ps.executeUpdate();
        c.close();
    }

    public void deactivate(int id)throws Exception{
        Connection c=DBUtil.getConn();
        PreparedStatement chk=c.prepareStatement(
                "select * from appointments where doctor_id=? and date>=curdate()");
        chk.setInt(1,id);

        if(chk.executeQuery().next()){
            System.out.println("Has future appointments");
            return;
        }

        PreparedStatement ps=c.prepareStatement(
                "update doctors set is_active=false where id=?");
        ps.setInt(1,id);
        ps.executeUpdate();
        c.close();
    }
}
