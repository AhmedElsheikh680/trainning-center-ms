package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.CourseStudent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    String reportPackage = "/report";

    private List<Map<String, ?>> getList(List<CourseStudent> courseStudents) {
        List<Map<String, ?>> maps = new ArrayList<>();

        for (CourseStudent courseStudent : courseStudents) {
            Map<String, Object> m = new HashMap<>();

            m.put("studentName", courseStudent.getStudent().getName());
            m.put("courseName", courseStudent.getCourse().getName());
            m.put("price", courseStudent.getPrice());
            m.put("rest", courseStudent.getRest());

            maps.add(m);
        }
        return maps;
    }

    public void generateReport(Map<String, Object> parameters, List<CourseStudent> courseStudents, HttpServletResponse httpServletResponse) {
        try {
            JRDataSource jRDataSource = new JRBeanCollectionDataSource(getList(courseStudents));

            InputStream reportStream = getClass().getResourceAsStream(reportPackage + "/" + "courseStudent.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jRDataSource);

            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-disposition", "charset=UTF-8; inline; filename=\"courseStudent.pdf\"");
            httpServletResponse.setHeader("Cache-Control", "private");

            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
