package br.udesc.SchoolManagerAPI.utils;

import java.util.List;

public class SchoolManagerUtils {

    private static final String DELIMITER = "-------------------------------------------";

    public static String buildReport(String reportName, List<Object[]> rows, int columns) {
        StringBuilder reportContent = new StringBuilder(reportName);
        reportContent.append("\n");
        reportContent.append(DELIMITER);
        reportContent.append("\n");

        for (Object[] row : rows) {
            for (int i = 0; i < columns; i++) {
                reportContent.append(row[i]);

                boolean isLastElement = i >= columns - 1;
                if (!isLastElement) {
                    reportContent.append(" - ");
                }
            }
            reportContent.append("\n");
        }

        reportContent.append(DELIMITER);

        return reportContent.toString();
    }

}
