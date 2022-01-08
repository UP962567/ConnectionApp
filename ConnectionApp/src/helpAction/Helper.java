package helpAction;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Helper {
    public static int Location;
    public static int BoardLocation;
    public static JFrame frame;
    public Clip clip;
    public long clipTimePosition;
    public int musicnr;
    public JTable table;

    public JTable getTable() {return table;}

    public void setTable(JTable table) {this.table = table;}

    public static int getLocation() {return Location;}
    public void setLocation(int location) {Location = location;}

    public static int getBoardLocation() {return BoardLocation;}
    public static void setBoardLocation(int boardLocation) {BoardLocation = boardLocation;}

    public JFrame getFrame() {return frame;}
    public void setFrame(JFrame frame) {Helper.frame = frame;}

    public int getMusicnr() {return musicnr;}
    public void setMusicnr(int musicnr) {this.musicnr = musicnr;}

    public long getClipTimePosition() {return clipTimePosition;}
    public void setClipTimePosition(long clipTimePosition) {this.clipTimePosition = clipTimePosition;}

    public void playMusic(){
        try {
            File musicPath = new File("src/Sound/test.wav");
            if(musicPath.exists()){
                if(getMusicnr() == 1){
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                else if(getMusicnr() == 2){
                    setClipTimePosition(clip.getMicrosecondPosition());
                    clip.stop();
                }
            } else{
                System.out.println("Cant find file!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


