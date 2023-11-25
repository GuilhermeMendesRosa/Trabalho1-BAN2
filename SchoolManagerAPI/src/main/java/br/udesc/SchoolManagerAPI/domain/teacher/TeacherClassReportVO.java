package br.udesc.SchoolManagerAPI.domain.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
class TeacherClassReportVO {

    String teacherName;
    String className;

    public static List<Object[]> getRows(List<TeacherClassReportVO> teacherClassReportVOList) {
        List<Object[]> resultList = new ArrayList<>();

        for (TeacherClassReportVO teacherClassReportVO : teacherClassReportVOList) {
            Object[] resultArray = new Object[]{teacherClassReportVO.getTeacherName(), teacherClassReportVO.getClassName()};
            resultList.add(resultArray);
        }
        return resultList;
    }
}