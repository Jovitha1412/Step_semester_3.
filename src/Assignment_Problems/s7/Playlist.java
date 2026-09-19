
package classproblem.s7;

public class Playlist {

    private String[] songs;
    private int count;

    // Constructor
    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    // Add a song
    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    // Return a safe copy of the songs
    public String[] getSongs() {
        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    // Return number of songs
    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("First song in playlist: " + p.getSongs()[0]);
        System.out.println("Number of songs: " + p.getSongCount());
    }
}
