import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FormExel {
    public void pars(List<FirstFileClass> firstFileClassList, List<SecondFileClass> secondFileClassList) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("результаты парсиннга");

        int n = 1;
        Iterator<SecondFileClass> it = secondFileClassList.iterator();
        while (it.hasNext()) {
            Row row = sheet.createRow(n);
            SecondFileClass secondFileClass = it.next();

            for (int i = 0; i < firstFileClassList.size(); i++) {
                if (secondFileClass.getDocNumbers().contains(firstFileClassList.get(i).getDocNumber()) && secondFileClass.getDocNumbers() != null && secondFileClass.getDocNumbers() != "") {
                    row.createCell(0).setCellValue(secondFileClass.getId());
                    row.createCell(1).setCellValue(secondFileClass.getDate());
                    row.createCell(2).setCellValue(firstFileClassList.get(i).getDocNumber());
                    row.createCell(3).setCellValue(firstFileClassList.get(i).getNomenclature());
                    row.createCell(4).setCellValue(firstFileClassList.get(i).getBrunch());
                    try {
                        row.createCell(5).setCellType(0);
                        row.getCell(5).setCellValue(firstFileClassList.get(i).getImei().getNumericCellValue());
                    } catch (IllegalStateException e) {
                        try {
                            row.createCell(5).setCellType(1);
                            row.getCell(5).setCellValue(firstFileClassList.get(i).getImei().getStringCellValue());
                        } catch (IllegalStateException e1) {
                            System.out.println(e.getMessage());
                        }
                    }

                    row.createCell(6).setCellValue(secondFileClass.getEmail());
                    row.createCell(7).setCellValue(secondFileClass.getState());
                    row.createCell(8).setCellValue(firstFileClassList.get(i).getSum());
                    row.createCell(9).setCellValue(secondFileClass.getBuyer());
                    row.createCell(11).setCellValue(secondFileClass.getDocNumbers());
                    row.createCell(12).setCellValue(firstFileClassList.get(i).getDocNumber());
                    n++;
                }
            }

        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("c:\\ide\\resTest.xls"));
            workbook.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}
