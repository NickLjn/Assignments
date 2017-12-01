package Edit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LyricAnalyzer {
	private HashMap<String, ArrayList<Integer>> map;
	
	public void read(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int index = 1;
		while (true){
			String line = br.readLine();
			String[] words = line.toUpperCase().split(" ");
			for(int i = 0; i<words.length; i++) {
				if(i == words.length-1) {
					add(words[i], -index);
				}
				
				else add(words[i],index);
				++ index;
			}
			br.close();
		}
		
	}

	private void add(String lyricWord, int wordPosition) {
		if (map.containsKey(lyricWord)) {
			map.get(lyricWord).add(wordPosition);
		}else {
			ArrayList<Integer> position = new ArrayList<>();
			position.add(wordPosition);
			map.put(lyricWord, position);
		}
	}
	
	public void displayWords() {
		String[] w=new String[map.size()];
        map.keySet().toArray(w);
        Arrays.sort(w);        
        for (String s:w){
            StringBuilder sb=new StringBuilder();
            sb.append(s);
            sb.append(": ");
            String list=map.get(s).toString();
            sb.append(list.substring(1, list.length()-1));
            System.out.println(sb.toString());
        }
        System.out.println();
    }
	
	
	
	public void writeLyrics(File file) throws IOException {
		String[] Lyrics=new String[this.count()+1];
		Object[] words=map.keySet().toArray();
		for(int i=0;i<words.length;i++){
			String word=(String) words[i];
			for(int j=0;j<map.get(word).size();j++){
				int index=map.get(word).get(j);
				if(index<0){
					index=(-1)*index;
					Lyrics[index]=word+"\n";
				}else{
					Lyrics[index]=word+" ";
				}	
			}
	    }
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		for(int i=1;i<Lyrics.length;i++){
			pw.print(Lyrics[i]);
		}
		pw.close();
	}
	
	
	public int count() {
		return map.size();
	}
	
	
	public String mostFrequentWord() {
		int max =0;
		String res = "";
		for(String key:map.keySet()) {
			 if (map.get(key).size() > max) {
					max = map.get(key).size();
					res = key;
			 }
		}
		return res;
	}
	
	public static void main (String args[]) throws IOException {
		LyricAnalyzer la = new LyricAnalyzer();
		File f = new File("test1.txt");
		la.read(f);
		la.displayWords();
		File fw = new File ("output1.txt");
		la.writeLyrics(fw);
	}
	
}
