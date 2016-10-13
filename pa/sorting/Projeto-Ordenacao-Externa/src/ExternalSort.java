import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class ExternalSort {
	private static final int MAX_INT = 100001;
	static int N = 10000; // size of the file in disk
	static int M = 1000; // max items the memory buffer can hold

	public static void externalSort(String fileName) {
		String tfile = "temp-file-";
		int[] buffer = new int[M < N ? M : N];

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int slices = (int) Math.ceil((double) N / M);

			System.out.println("Slices: " + slices);
			
			int i, j;
			i = j = 0;
			// Iterate through the elements in the file
			for (i = 0; i < slices; i++) {
				// Read M-element chunk at a time from the file
				for (j = 0; j < (M < N ? M : N); j++) {
					String t = br.readLine();
					if (t != null)
						buffer[j] = Integer.parseInt(t);
					else
						break;
				}
				// Sort M elements
				Arrays.sort(buffer);

				// Write the sorted numbers to temp file
				FileWriter fw = new FileWriter(tfile + Integer.toString(i)
						+ ".txt");
				PrintWriter pw = new PrintWriter(fw);
				for (int k = 0; k < j; k++)
					pw.println(buffer[k]);

				pw.close();
				fw.close();
				System.out.print(i +" . . ");
			}
			System.out.println();

			br.close();
			fr.close();

			// Now open each file and merge them, then write back to disk
			int[] topNums = new int[slices];
			BufferedReader[] brs = new BufferedReader[slices];

			for (i = 0; i < slices; i++) {
				brs[i] = new BufferedReader(new FileReader(tfile
						+ Integer.toString(i) + ".txt"));
				String t = brs[i].readLine();
				if (t != null)
					topNums[i] = Integer.parseInt(t);
				else
					topNums[i] = Integer.MAX_VALUE;
			}

			System.out.println("Gerando o arquivo final");
			FileWriter fw = new FileWriter("external-sorted.txt");
			PrintWriter pw = new PrintWriter(fw);

			for (i = 0; i < N; i++) {
				int min = topNums[0];
				int minFile = 0;

				for (j = 0; j < slices; j++) {
					if (min > topNums[j]) {
						min = topNums[j];
						minFile = j;
					}
				}

				pw.println(min);
				String t = brs[minFile].readLine();
				if (t != null)
					topNums[minFile] = Integer.parseInt(t);
				else
					topNums[minFile] = Integer.MAX_VALUE;

			}
			System.out.println("Cleaning temp files . . .");
			for (i = 0; i < slices; i++){
				brs[i].close();
				File tFile = new File(tfile
						+ Integer.toString(i) + ".txt");
				tFile.delete();
			}

			pw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String generateInput(int n) {
		String fileName = "external-sort.txt";
		Random rand = new Random();

		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);

			for (int i = 0; i < n; i++)
				pw.println(rand.nextInt(MAX_INT));

			pw.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return fileName;
	}

	public static void main(String[] args) {
		System.out.println("Gerando o arquivo de entrada . . .");
		String fileName = generateInput(N);
		System.out.println("Arquivo gerado com sucesso!");
		System.out.println("Tamanho: " + new File(fileName).length()/1024 + " kBytes.");
		System.out.println("Iniciando a ordenação . . .");
		externalSort(fileName);
		System.out.println("Done!");
	}
}
