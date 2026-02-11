import java.sql.*;

public class BillingDAO {

    public void generate(int visitId,double amount)throws Exception{
        Connection c=DBUtil.getConn();
        PreparedStatement ps=c.prepareStatement(
                "insert into bills(visit_id,total,status) values(?,?, 'UNPAID')");
        ps.setInt(1,visitId);
        ps.setDouble(2,amount);
        ps.executeUpdate();
        c.close();
    }

    public void pay(int billId,String mode)throws Exception{
        Connection c=DBUtil.getConn();
        c.setAutoCommit(false);

        PreparedStatement b=c.prepareStatement(
                "update bills set status='PAID',mode=?,date=now() where id=?");
        b.setString(1,mode);
        b.setInt(2,billId);
        b.executeUpdate();

        PreparedStatement t=c.prepareStatement(
                "insert into payment_transactions(bill_id) values(?)");
        t.setInt(1,billId);
        t.executeUpdate();

        c.commit();
        c.close();
    }
}
