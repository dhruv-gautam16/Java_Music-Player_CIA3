
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dhruv gautam
 */
public class musicPlayer {
    static musicPlayer player = new musicPlayer();
    static Clip clip;
    
    private musicPlayer(){
        
        
    }
    public static musicPlayer getInstance(){
        return player;
    }
    
    public static void loadMusic(String filepath){
        try{
            File musicPath = new File(filepath);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                System.out.println("Intialized");
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}

