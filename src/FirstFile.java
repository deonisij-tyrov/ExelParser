import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;

@Data
public class FirstFile {
    private String docNumber;
    private Cell imei;
    private String sum;
    private String nomenclature;
    private String brunch;

    public FirstFile(String docNumber, Cell imei, String sum, String nomenclature, String brunch) {
        this.docNumber = docNumber;
        this.imei = imei;
        this.sum = sum;
        this.nomenclature = nomenclature;
        this.brunch = brunch;
    }

    public String getBrunch() {
        return brunch;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Cell getImei() {
        return imei;
    }

    public String getSum() {
        return sum;
    }

    public String getNomenclature() {
        return nomenclature;
    }
}
