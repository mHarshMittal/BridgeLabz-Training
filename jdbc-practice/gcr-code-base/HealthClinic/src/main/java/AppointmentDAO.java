import java.sql.*;

public class AppointmentDAO {

    public void book(int pid,int did,String date,String time)throws Exception{
        Connection c=DBUtil.getConn();

        PreparedStatement chk=c.prepareStatement(
                "select count(*) from appointments where doctor_id=? and date=? and time=?");
        chk.setInt(1,did);
        chk.setString(2,date);
        chk.setString(3,time);

        ResultSet rs=chk.executeQuery();
        rs.next();
        if(rs.getInt(1)>0){
            System.out.println("Slot full");
            return;
        }

        PreparedStatement ps=c.prepareStatement(
                "insert into appointments(patient_id,doctor_id,date,time,status) values(?,?,?,?, 'SCHEDULED')");
        ps.setInt(1,pid);
        ps.setInt(2,did);
        ps.setString(3,date);
        ps.setString(4,time);
        ps.executeUpdate();
        c.close();
    }

    public void cancel(int id)throws Exception{
        Connection c=DBUtil.getConn();
        c.setAutoCommit(false);

        PreparedStatement p1=c.prepareStatement(
                "update appointments set status='CANCELLED' where id=?");
        p1.setInt(1,id);
        p1.executeUpdate();

        PreparedStatement p2=c.prepareStatement(
                "insert into appointment_audit(app_id,msg) values(?,?)");
        p2.setInt(1,id);
        p2.setString(2,"Cancelled");
        p2.executeUpdate();

        c.commit();
        c.close();
    }
}
