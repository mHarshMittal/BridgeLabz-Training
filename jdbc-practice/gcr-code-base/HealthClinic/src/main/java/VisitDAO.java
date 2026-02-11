import java.sql.*;

public class VisitDAO {

    public void addVisit(int appId,String diag,String pres,String notes)throws Exception{
        Connection c=DBUtil.getConn();
        c.setAutoCommit(false);

        PreparedStatement v=c.prepareStatement(
                "insert into visits(appointment_id,diagnosis,prescription,notes) values(?,?,?,?)");
        v.setInt(1,appId);
        v.setString(2,diag);
        v.setString(3,pres);
        v.setString(4,notes);
        v.executeUpdate();

        PreparedStatement a=c.prepareStatement(
                "update appointments set status='COMPLETED' where id=?");
        a.setInt(1,appId);
        a.executeUpdate();

        c.commit();
        c.close();
    }
}
