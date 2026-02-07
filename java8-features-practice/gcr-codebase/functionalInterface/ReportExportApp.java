interface DataExporter {
    void exportCSV();
    void exportPDF();

    default void exportJSON() {
        System.out.println("Exporting report in JSON format");
    }
}

class ReportGenerator implements DataExporter {
    public void exportCSV() {
        System.out.println("Exporting report in CSV format");
    }
    public void exportPDF() {
        System.out.println("Exporting report in PDF format");
    }
}

public class ReportExportApp {
    public static void main(String[] args) {
        DataExporter exporter = new ReportGenerator();
        exporter.exportCSV();
        exporter.exportPDF();
        exporter.exportJSON();
    }
}
