import java.io.Serializable;

class UserBackupData implements Serializable {
    int id;
    String name;
}

public class BackupStorageApp {
    public static void main(String[] args) {
        UserBackupData data = new UserBackupData();
        System.out.println("Object marked Serializable for backup");
    }
}
