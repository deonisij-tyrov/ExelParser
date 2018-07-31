import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstFileLoader {
    private List<FirstFile> cellMap;

    public List<FirstFile> getCellMap() {
        return cellMap;
    }

    public void pars(String name) throws IOException, IllegalStateException {
        cellMap = new ArrayList<>();

        InputStream inputStream = null;
        HSSFWorkbook workbook = null;

            inputStream = new FileInputStream(name);
            System.out.println(name);
            workbook = new HSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        for (int i = 0; i < 2; i++) {
            iterator.next();
        }
        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            Cell docRealize = null, imei = null, sum = null, nomenclature = null, brunch = null;
            for (int i = 0; i < 18; i++) {
                Cell cell = cellIterator.next();
                if (i == 8) {
                    docRealize = cell;
                }
                if (i == 9) {
                    imei = cell;
                }
                if (i == 12) {
                    sum = cell;
                }
                if (i == 16) {
                    nomenclature = cell;
                }
                if (i == 16) {
                    brunch = cell;
                }
            }
            try {

                cellMap.add(new FirstFile(docRealizeParser(docRealize.toString()), imei, sum.toString(), nomenclature.toString(), brunch(brunch)));
            } catch (NumberFormatException e) {
//                System.out.println(e.getLocalizedMessage());
                System.out.printf("%s %s %s %s \n", docRealize.toString(), imei.toString(), sum.toString(), nomenclature.toString());
            }
        }
    }

    private String docRealizeParser(String string) {
        String[] strings = string.split(" ");
        for (String s : strings) {
            if (s.contains("-")) {
                return s.split("-")[1];
            }
        }
        return null;
    }

    private String brunch(Cell cell) {
        if (cell.getStringCellValue().equalsIgnoreCase("Смартфоны")) {
            return "Смартфоны";
        } else {
            return "Аксессуары";
        }
    }
}
