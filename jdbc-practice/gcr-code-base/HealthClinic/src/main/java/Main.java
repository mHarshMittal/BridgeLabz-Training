public class Main {
    public static void main(String[] args) throws Exception {

        PatientDAO p=new PatientDAO();
        p.add("Rahul","2000-01-01","9999","Delhi","O+");
        p.searchByName("Rah");

        DoctorDAO d=new DoctorDAO();
        d.add("Dr.Gaur",1,"8888",500);

        AppointmentDAO a=new AppointmentDAO();
        a.book(1,1,"2026-02-12","10:00");

        VisitDAO v=new VisitDAO();
        v.addVisit(1,"Fever","Paracetamol","Rest");

        BillingDAO b=new BillingDAO();
        b.generate(1,500);
        b.pay(1,"CASH");
    }
}
