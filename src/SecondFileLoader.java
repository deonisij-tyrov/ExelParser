import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecondFileLoader {
    private List<SecondFile> cells;

    public List<SecondFile> getCells() {
        return cells;
    }

    public void pars(String name) throws IOException, IllegalStateException {
        cells = new ArrayList<>();

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
            Cell id = null, state = null, date = null, email = null, buyer = null, docNumbers = null;
            for (int i = 0; i < 11; i++) {
                Cell cell = cellIterator.next();
                if (i == 0) {
                    id = cell;
                }
                if (i == 1) {
                    state = cell;
                }
                if (i == 2) {
                    date = cell;
                }
                if (i == 4) {
                    email = cell;
                }
                if (i == 5) {
                    buyer = cell;
                }
                if (i == 9) {
                    docNumbers = cell;
                }
            }
            if (docNumbers.toString() != "" && docNumbers.toString() != null) {
                try {
                    cells.add(new SecondFile(Integer.parseInt(id.toString().substring(1)), state.toString(), date.toString(), email.toString(), buyer.toString(), docNumbers.toString()));
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                    System.out.println(e.getLocalizedMessage());
                    System.out.printf("%s %s %s %s %s %s\n", id.toString(), state.toString(), date.toString(), email.toString(), buyer.toString(), docNumbers.toString());
                }
            }
        }
    }

}
