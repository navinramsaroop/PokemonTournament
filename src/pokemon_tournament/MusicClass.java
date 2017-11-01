package pokemon_tournament;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;

public class MusicClass implements Runnable {

	private ArrayList<String> musicFiles;
	private int currentSongIndex;
	public MusicClass(ArrayList<String> musicFiles) {
		this.musicFiles = musicFiles;
	}
	
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		playSound(musicFiles.get(currentSongIndex));
	}
	
	private void playSound(String fileName) {
		try {
			File soundFile = new File(fileName);
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-5);
			clip.start();
			
			LineListener line = new LineListener() {

				public void update(LineEvent event) {
					if(event.getType() == Type.STOP) {
						currentSongIndex++;
						System.out.println("Entered update");
						playSound(musicFiles.get(currentSongIndex));
					}
					if(currentSongIndex >= musicFiles.size()) {
						currentSongIndex = 0;
						playSound(musicFiles.get(currentSongIndex));
					}
				}
			};
			clip.addLineListener(line);
		}
		catch (Exception e) {
			
		}
	}

}
