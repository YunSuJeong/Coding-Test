import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<Integer> list = new ArrayList<Integer>();
		for(String s : str.split(" ")) {
			list.add(Integer.parseInt(s));
		}
		
		Collections.sort(list);
		
		for(int l : list) {
			System.out.print(l+" ");
		}
	}

}
