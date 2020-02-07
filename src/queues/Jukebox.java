package queues;

import cs1c.SongEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Jukebox class manages three objects of type Queue: favorites, road trip and lounge.
 * It read text the txt file and adds songs to the respective playlists.
 *
 * @author Pires, Marilize.
 */

public class Jukebox {

    //Class attributes/playlist.
    private Queue<SongEntry> favoritePL;
    private Queue<SongEntry> roadTripPL;
    private Queue<SongEntry> loungePL;

    /**
     * Constructor that initializes the class attributes.
     */
    Jukebox() {
        this.favoritePL = new Queue<>("favorites");
        this.roadTripPL = new Queue<>("road trip");
        this.loungePL = new Queue<>("lounge");
    }

    /**
     * fillPlaylists() method read the txt file,
     * then adds songs to the respective playlist (favorites, road trip, or lounge).
     *
     * @param requestedFile String that stores the name of the test file to read from.
     * @param allSongs      SongEntry array that reads from the JSON file.
     */
    public void fillPlaylists(String requestedFile, SongEntry[] allSongs) {

        try {
            Scanner scanner = new Scanner(new File(requestedFile));

            //It loops through the requestedFile.
            while (scanner.hasNextLine()) {

                //
                String[] token = scanner.nextLine().split("[,]");

                //It loops through the list of all songs.
                for (int i = 0; i < allSongs.length; i++) {

                    //It finds the song title in allSongs from the requestedFile.
                    if (allSongs[i].getTitle().equals(token[1])) {

                        //The below if statements compare the playlist and enqueues the song(s) found
                        //into the appropriate playlist. Otherwise, it will print a "warning".
                        if (token[0].equals("favorites")) {
                            this.favoritePL.enqueue(allSongs[i]);
                            break;
                        } else if (token[0].equals("road trip")) {
                            this.roadTripPL.enqueue(allSongs[i]);
                            break;
                        } else if (token[0].equals("lounge")) {
                            this.loungePL.enqueue(allSongs[i]);
                            break;
                        } else {
                            System.out.println("Invalid playlist name.");
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * @return accessor method that returns favorite playlist.
     */
    public Queue<SongEntry> getFavoritePL() {
        return favoritePL;
    }

    /**
     * @return accessor method that returns road trip playlist.
     */
    public Queue<SongEntry> getRoadTripPL() {
        return roadTripPL;
    }

    /**
     * @return accessor method that returns lounge playlist.
     */
    public Queue<SongEntry> getLoungePL() {
        return loungePL;
    }
}
