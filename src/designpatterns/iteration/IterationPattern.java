package designpatterns.iteration;

import java.util.*;

public class IterationPattern {
}


class SongInfo{

    String songName;
    String brandName;
    int yearReleased;

    public SongInfo(String songName, String brandName, int yearReleased) {
        this.songName = songName;
        this.brandName = brandName;
        this.yearReleased = yearReleased;
    }


    public String getSongName() {
        return songName;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getYearReleased() {
        return yearReleased;
    }
}


class SongOfThe70s implements SongIterator{
    ArrayList<SongInfo> bestSongs;

    public SongOfThe70s() {
        bestSongs = new ArrayList<>();
        addSong("xyz71", "abc71", 1971);
        addSong("xyz77", "abc77", 1977);
        addSong("xyz79", "abc79", 1979);
    }

    private void addSong(String songName, String brandName, int yearReleased) {
        bestSongs.add(new SongInfo(songName, brandName, yearReleased));
    }

    public ArrayList<SongInfo> getBestSongs() {
        return bestSongs;
    }

    @Override
    public Iterator createIterator() {
        return bestSongs.iterator();
    }
}

class SongOfThe80s implements SongIterator{
    SongInfo[] bestSongs;
    int arrayValue = 0;

    public SongOfThe80s() {
        bestSongs = new SongInfo[3];
        addSong("xyz81", "abc81", 1981);
        addSong("xyz87", "abc87", 1987);
        addSong("xyz89", "abc89", 1989);
    }

    private void addSong(String songName, String brandName, int yearReleased) {
        bestSongs[arrayValue] = new SongInfo(songName, brandName, yearReleased);
        arrayValue++;
    }

    public SongInfo[] getBestSongs() {
        return bestSongs;
    }

    @Override
    public Iterator createIterator() {
        return Arrays.asList(bestSongs).iterator();
    }
}


class SongOfThe90s implements SongIterator{
    Hashtable<Integer, SongInfo> bestSongs;
    int key = 0;

    public SongOfThe90s() {
        bestSongs = new Hashtable<>();
        addSong("xyz91", "abc91", 1991);
        addSong("xyz97", "abc97", 1997);
        addSong("xyz99", "abc99", 1999);
    }

    private void addSong(String songName, String brandName, int yearReleased) {
        bestSongs.put(key, new SongInfo(songName, brandName, yearReleased));
        key++;
    }

    public Hashtable<Integer, SongInfo> getBestSongs() {
        return bestSongs;
    }

    @Override
    public Iterator createIterator() {
        return bestSongs.values().iterator();
    }
}

class DiscJockey{
    SongOfThe70s songOfThe70s;
    SongOfThe80s songOfThe80s;
    SongOfThe90s songOfThe90s;

    SongIterator iter70sSong;
    SongIterator iter80sSong;
    SongIterator iter90sSong;

    public DiscJockey(SongOfThe70s songOfThe70s, SongOfThe80s songOfThe80s, SongOfThe90s songOfThe90s) {
        this.songOfThe70s = songOfThe70s;
        this.songOfThe80s = songOfThe80s;
        this.songOfThe90s = songOfThe90s;
    }

    public DiscJockey(SongIterator iter70sSong, SongIterator iter80sSong, SongIterator iter90sSong) {
        this.iter70sSong = iter70sSong;
        this.iter80sSong = iter80sSong;
        this.iter90sSong = iter90sSong;
    }

    public void showTheSongsBeforeIterationPattern(){
        ArrayList al70sSong = songOfThe70s.getBestSongs();
        System.out.println("Song of the 70's");
        for(int i=0; i< al70sSong.size(); i++) {
            SongInfo bestSong = (SongInfo) al70sSong.get(i);
            System.out.print(bestSong.getBrandName() + " ");
            System.out.print(bestSong.getSongName() + " ");
            System.out.print(bestSong.getYearReleased()+ "\n");
        }
        System.out.println();


        SongInfo[] al80sSong = songOfThe80s.getBestSongs();
        System.out.println("Song of the 80's ");
        for(int i=0; i< al80sSong.length; i++) {
            SongInfo bestSong = (SongInfo) al80sSong[i];
            System.out.print(bestSong.getBrandName() + " ");
            System.out.print(bestSong.getSongName() + " ");
            System.out.print(bestSong.getYearReleased()+ "\n");
        }
        System.out.println();


        Hashtable<Integer, SongInfo> al90sSong = songOfThe90s.getBestSongs();
        System.out.println("Song of the 90's ");
        for(Enumeration<Integer> e = al90sSong.keys();e.hasMoreElements();) {
            SongInfo bestSong =  al90sSong.get(e.nextElement());
            System.out.print(bestSong.getBrandName() + " ");
            System.out.print(bestSong.getSongName() + " ");
            System.out.print(bestSong.getYearReleased()+ "\n");
        }
        System.out.println();
    }


    public void showTheSongsAfterIterationPattern(){
        Iterator songs70 = iter70sSong.createIterator();
        Iterator songs80 = iter80sSong.createIterator();
        Iterator songs90 = iter90sSong.createIterator();
        System.out.println("Song of the 70's ");
        printTheSongs(songs70);
        System.out.println("Song of the 80's ");
        printTheSongs(songs80);
        System.out.println("Song of the 90's ");
        printTheSongs(songs90);
}

    private void printTheSongs(Iterator iterator) {
        while (iterator.hasNext()){
            SongInfo songInfo = (SongInfo) iterator.next();
            System.out.print(songInfo.getBrandName() + " ");
            System.out.print(songInfo.getSongName() + " ");
            System.out.print(songInfo.getYearReleased()+ "\n");
        }
        System.out.println();
    }
}


    interface SongIterator{
    Iterator createIterator();
}

class RadioStation{
    public static void main(String[] args) {
        SongIterator song70s = new SongOfThe70s();
        SongIterator song80s = new SongOfThe80s();
        SongIterator song90s = new SongOfThe90s();
        DiscJockey spb = new DiscJockey(song70s, song80s, song90s);
        //spb.showTheSongsBeforeIterationPattern();
        spb.showTheSongsAfterIterationPattern();
    }
}