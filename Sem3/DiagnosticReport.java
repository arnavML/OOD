package Sem3;

public class DiagnosticReport {
    private String reportDetails;

    public DiagnosticReport(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    @Override
    public String toString() {
        return "DiagnosticReport{" +
                "reportDetails='" + reportDetails + '\'' +
                '}';
    }
}
