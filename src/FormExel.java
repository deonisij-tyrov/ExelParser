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
    public void pars(List<FirstFile> firstFileClassList, List<SecondFile> secondFileClassList) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("my sheet");

        int n = 1;
        Iterator<SecondFile> it = secondFileClassList.iterator();
        while (it.hasNext()) {

            SecondFile secondFileClass = it.next();
//            System.out.println(secondFileClass.getDocNumbers() +" "+ n);
            for (int i = 0; i < firstFileClassList.size(); i++) {
                if (secondFileClass.getDocNumbers().contains(firstFileClassList.get(i).getDocNumber()) && secondFileClass.getDocNumbers() != null && secondFileClass.getDocNumbers() != "") {
                    Row row = sheet.createRow(n);
//                    System.out.println(secondFileClass.getDocNumbers());
//                    System.out.println(firstFileClassList.get(i).getDocNumber());
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
                    row.createCell(13).setCellValue("test");
                    n++;
                }
            }

        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("/home/denis/IdeaProjects/resTest.xls"));
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
