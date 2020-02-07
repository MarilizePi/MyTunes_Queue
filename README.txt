project folder:
MarilizePi-cs1c-project04

Brief description of submitted files:

src/cs1c/MillionSongDataSubset.java
    - Parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    - Stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.


src/queues/MyTunes.java
    - Creates an object of type Jukebox to read the input file used to fill the three Queue objects with SongEntry items.
    - Includes main.

src/queues/Jukebox.java
    - Jukebox class manages three objects of type Queue: favorites, road trip and lounge.
    - It read text the txt file and adds songs to the respective playlists.

src/queues/Queue.java
    - The class Queue<Type>, that implements Iterable, manages items in a single linked list,
      where we can enqueue() items to the end and dequeue() items from the from of the queue.

-----

resources/music_genre_subset.json
    - Contains songs in a JSON format (over 59600 songs).

resources/RUN.txt
    - Console outputs various tests/runs of MyTunes.java class.
    - It displays the respective playlist and amount of songs requested by the user.

resources/tunes.txt
    - List of songs to be used while testing the code.
    - Testing adding and removing items/songs from queues, when the requested number is less than number of songs in queue.

resources/tunes2.txt
    - Tests when there is one song in each queue.

resources/tunes3.txt
    - Testing input "0" from user when the file has songs it it.

resources/tunes4.txt
    - Testing request from user is the same as the amount of songs in file.

resources/tunes5.txt
    - Testing file that has zero songs in the playlists.

resources/tunes6.txt
    - Testing file that has two out of the three playlists.

resources/tunes_truncated.txt
    - Same as tunes2. Tests when there is one song in each queue.

-----

.gitignore
    - .gitignore content tells git to ignore specified files or folder.

-----

README.txt
    - Description of submitted files.