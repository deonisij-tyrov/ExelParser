import lombok.Data;

@Data
public class SecondFile {
    private int id;
    private String state;
    private String date;
    private String email;
    private String buyer;
    private String docNumbers;

    public SecondFile(int id, String state, String date, String email, String buyer, String docNumbers) {
        this.id = id;
        this.state = state;
        this.date = date;
        this.email = email;
        this.buyer = buyer;
        this.docNumbers = docNumbers;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getDocNumbers() {
        return docNumbers;
    }
}
