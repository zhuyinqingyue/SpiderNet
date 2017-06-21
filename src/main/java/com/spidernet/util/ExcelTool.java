package com.spidernet.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spidernet.dashboard.controller.EmployeeController;
import com.spidernet.dashboard.entity.ExcelImport;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelTool
{
    private static Logger logger = LoggerFactory
            .getLogger(EmployeeController.class);
    
    public static List<ExcelImport> getAllByExcel(String file)
    {
        List<ExcelImport> list = new ArrayList<ExcelImport>();
        try
        {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet(0);
            int clos = rs.getColumns();
            int rows = rs.getRows();

            for (int i = 1; i < rows; i++)
            {
                
                    String name = rs.getCell(0, i).getContents();
                    if(name == null || name.equals("")){
                        continue;
                    }
                    String er = rs.getCell(2, i).getContents();
                    String score = rs.getCell(8, i).getContents();
                    String passingMark = rs.getCell(9, i).getContents();

                    list.add(new ExcelImport( name, er,score,passingMark));
                
            }
        }
        catch (Exception e)
        {
            logger.error("[ExcelTool] exception",e);
        }
        return list;

    }

}
