import java.util.*;

public class DataExportDemo {
    public static void main(String[] args) {
        DataExporter csvExporter = new CSVExporter();
        DataExporter pdfExporter = new PDFExporter();

        csvExporter.exportData();
        csvExporter.exportToJSON();

        pdfExporter.exportData();
        pdfExporter.exportToJSON();
    }
}

interface DataExporter {
    void exportData();

    default void exportToJSON() {
        System.out.println("Exporting data to JSON format");
    }
}

class CSVExporter implements DataExporter {
    public void exportData() {
        System.out.println("Exporting data to CSV format");
    }
}

class PDFExporter implements DataExporter {
    public void exportData() {
        System.out.println("Exporting data to PDF format");
    }
}
