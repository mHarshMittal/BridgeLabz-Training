
import java.util.*;

abstract class Festival {
	String name;
	String location;
	int date;

	Festival(String name, String location, int date) {
		this.name = name;
		this.location = location;
		this.date = date;
	}

	abstract void displayDetails();
}

class MusicFestival extends Festival {
	String headliner;
	String musicGenre;
	int ticketPrice;

	MusicFestival(String name, String location, int date, String headliner, String musicGenre, int ticketPrice) {
		super(name, location, date);
		this.headliner = headliner;
		this.musicGenre = musicGenre;
		this.ticketPrice = ticketPrice;
	}

	@Override
	void displayDetails() {
		System.out.println("Festival Name: " + name);
		System.out.println("Location: " + location);
		System.out.println("Date: " + date);
		System.out.println("Headliner: " + headliner);
		System.out.println("Music Genre: " + musicGenre);
		System.out.println("Ticket Price: " + ticketPrice);
	}
}

class FoodFestival extends Festival {
	String cuisine;
	int numStalls;
	int entryFee;

	FoodFestival(String name, String location, int date, String cuisine, int numStalls, int entryFee) {
		super(name, location, date);
		this.cuisine = cuisine;
		this.numStalls = numStalls;
		this.entryFee = entryFee;
	}

	@Override
	void displayDetails() {
		System.out.println("Festival Name: " + name);
		System.out.println("Location: " + location);
		System.out.println("Date: " + date);
		System.out.println("Cuisine: " + cuisine);
		System.out.println("Number of Stalls: " + numStalls);
		System.out.println("Entry Fee: " + entryFee);
	}
}

class ArtFestival extends Festival {
	String artType;
	int numArtists;
	int exhibitionFee;

	ArtFestival(String name, String location, int date, String artType, int numArtists, int exhibitionFee) {
		super(name, location, date);
		this.artType = artType;
		this.numArtists = numArtists;
		this.exhibitionFee = exhibitionFee;
	}

	@Override
	void displayDetails() {
		System.out.println("Festival Name: " + name);
		System.out.println("Location: " + location);
		System.out.println("Date: " + date);
		System.out.println("Art Type: " + artType);
		System.out.println("Number of Artists: " + numArtists);
		System.out.println("Exhibition Fee: " + exhibitionFee);
	}
}

public class FestivalManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Festival> festivals = new HashMap<>();

		while (true) {
			String line = sc.nextLine().trim();
			if (line.equals("EXIT"))
				break;

			String[] parts = line.split(" ");

			if (parts[0].equals("ADD_FESTIVAL")) {
				String type = parts[1];
				String name = parts[2];
				String location = parts[3];
				int date = Integer.parseInt(parts[4]);

				switch (type) {
				case "MUSIC":
					String headliner = parts[5];
					String musicGenre = parts[6];
					int ticketPrice = Integer.parseInt(parts[7]);
					festivals.put(name, new MusicFestival(name, location, date, headliner, musicGenre, ticketPrice));
					break;

				case "FOOD":
					String cuisine = parts[5];
					int numStalls = Integer.parseInt(parts[6]);
					int entryFee = Integer.parseInt(parts[7]);
					festivals.put(name, new FoodFestival(name, location, date, cuisine, numStalls, entryFee));
					break;

				case "ART":
					String artType = parts[5];
					int numArtists = Integer.parseInt(parts[6]);
					int exhibitionFee = Integer.parseInt(parts[7]);
					festivals.put(name, new ArtFestival(name, location, date, artType, numArtists, exhibitionFee));
					break;
				}

			} else if (parts[0].equals("DISPLAY_DETAILS")) {
				String name = parts[1];
				if (festivals.containsKey(name)) {
					festivals.get(name).displayDetails();
				} else {
					System.out.println("Festival Not Found");
				}
			}
		}

		sc.close();
	}
}