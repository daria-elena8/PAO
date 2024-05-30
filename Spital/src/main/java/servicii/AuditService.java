package servicii;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private String fileName;
    private static AuditService instance;

    private AuditService() {
    }

    public AuditService(String fileName){
        this.fileName = fileName;
    }
    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void logAction(String action) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(timestamp + " - " + action);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
