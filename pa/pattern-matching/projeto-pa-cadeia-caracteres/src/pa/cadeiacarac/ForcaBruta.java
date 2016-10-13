package pa.cadeiacarac;
public class ForcaBruta {
	private static int subsString(String p, String t){
		int n = t.length();
		int m = p.length();
		int j = 0;		
		for (int i = 0; i < n-m; i++){
			j = 0;
			while(j < m && t.charAt(i+j) == p.charAt(j)){
				j++;
			}
			if (j == m) return i;
		} return -1;		
	}
	
	public static void main(String[] args) {
		String t = "The book is on the table";
		String p = "book";
		
		int i = subsString(p, t);
		System.out.println("Resultado: " + i);
	}
}
