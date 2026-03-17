
import java.util.*;

class VersionedFile {
	String version;
	int size;

	VersionedFile(String version, int size) {
		this.version = version;
		this.size = size;
	}
}

public class VersionControlledStorage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, List<VersionedFile>> storage = new HashMap<>();

		Map<String, Set<String>> versionTracker = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");

			String command = parts[0];

			switch (command) {
			case "UPLOAD":
				String fileName = parts[1];
				String version = parts[2];
				int size = Integer.parseInt(parts[3]);

				storage.putIfAbsent(fileName, new ArrayList<>());
				versionTracker.putIfAbsent(fileName, new HashSet<>());
				if (!versionTracker.get(fileName).contains(version)) {
					storage.get(fileName).add(new VersionedFile(version, size));
					versionTracker.get(fileName).add(version);
				}
				break;
			case "FETCH":
				fileName = parts[1];
				if (!storage.containsKey(fileName) || storage.get(fileName).isEmpty()) {
					System.out.println("File Not Found");
					break;
				}
				List<VersionedFile> versions = storage.get(fileName);
				versions.sort((v1, v2) -> {
					if (v1.size != v2.size)
						return v1.size - v2.size;
					return v1.version.compareTo(v2.version);
				});

				for (VersionedFile v : versions) {
					System.out.println(fileName + " " + v.version + " " + v.size);
				}
				break;
			case "LATEST":
				fileName = parts[1];
				if (!storage.containsKey(fileName) || storage.get(fileName).isEmpty()) {
					System.out.println("File Not Found");
					break;
				}
				List<VersionedFile> allVersions = storage.get(fileName);
				VersionedFile latest = allVersions.get(allVersions.size() - 1);
				System.out.println(fileName + " " + latest.version + " " + latest.size);
				break;
			case "TOTAL_STORAGE":
				fileName = parts[1];
				if (!storage.containsKey(fileName) || storage.get(fileName).isEmpty()) {
					System.out.println("File Not Found");
					break;
				}
				int total = storage.get(fileName).stream().mapToInt(v -> v.size).sum();
				System.out.println(fileName + " " + total);
				break;
			}
		}
		sc.close();
	}
}