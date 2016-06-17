package scoreFiles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GamePlayersInfo implements Comparable<GamePlayersInfo>{

	private String name;
	private int score;
	private String d;

	public GamePlayersInfo(String n, int s) {
		this((new SimpleDateFormat("dd/MM/yyyy")).format(new Date()), n, s);
	}

	public GamePlayersInfo(String d, String n, int s) {
		this.name = n;
		this.score = s;
		this.d = d;
	}
	
	@Override
	public String toString() {
		//return d + System.lineSeparator() + name + System.lineSeparator() + score;
		return toScreen();
	}
	
	public String toScreen(){
		return d + " " + name + " " + score + System.lineSeparator();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof GamePlayersInfo))
			return false;
		else{
			GamePlayersInfo g = (GamePlayersInfo) obj;
			return g.d.equals(d);
		}
	}
	
	@Override
	public int hashCode() {
		return d.hashCode();
	}

	@Override
	public int compareTo(GamePlayersInfo o) {
		if(score>o.score){
			return 1;
		}else if(score<o.score){
			return -1;
		}else{
			return 0;
		}
		
	}

}
