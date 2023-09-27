package br.udesc.SchoolManagerAPI.utils;

import java.util.List;

public class SchoolManagerUtils {

    public static String buildReport(String reportName, List<Object[]> rows, int colums) {
        StringBuilder reportContent = new StringBuilder(reportName);
        reportContent.append("\n");
        reportContent.append("-------------------------------------------");
        reportContent.append("\n");

        for (Object[] obj : rows) {
            for (int i = 0; i < colums; i++) {
                if (i != colums - 1) {
                    reportContent.append(obj[i]).append(" - ");
                } else {
                    reportContent.append(obj[i]);
                }
            }
            reportContent.append("\n");
        }

        reportContent.append("-------------------------------------------");

        return reportContent.toString();
    }

}
