package scoreFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Input {

	private static Input instance = null;
	private static Set<GamePlayersInfo> set = null;

	public static Input getInstance() {
		if (instance == null) {
			instance = new Input();
		}

		if (set == null) {
			set = new TreeSet<GamePlayersInfo>();
			read();
		}

		return instance;
	}
	
	public static void read() {
		try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] data = sCurrentLine.split("\\s+");
				String date = data[0];
				String name = data[1];
				int score = Integer.parseInt(data[2]);
				GamePlayersInfo g = new GamePlayersInfo(date, name, score);
				set.add(g);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getTopHighscore(int index) {

		if (index >= set.size()) {
			return "NO AVAILABLE PLAY YET";
		}

		List<GamePlayersInfo> nameList = new ArrayList<GamePlayersInfo>();
		nameList.addAll(set);

		return nameList.get(index).toScreen();
	}

}
