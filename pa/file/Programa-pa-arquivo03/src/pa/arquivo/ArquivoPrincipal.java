package pa.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class ArquivoPrincipal {

	public static void main(String[] args) {
		String fileName1 = "teste.txt";
		String fileName2 = "teste2.txt";
		try {
			File f = new File(fileName1);
			if (f.exists()) {
				System.out.println("Arquivo existe.");
			} else {
				System.out.println("Arquivo não existe.");
				f.createNewFile();
				System.out.println("Arquivo criado com sucesso.");
			}
			System.out.println("Tamanho: "+ f.length() + " bytes") ;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String l = br.readLine();
			while (l != null) {
				System.out.println("Read: " + l);
				l = br.readLine();
			}
			br.close();
			fr.close();
			
			File f2 = new File(fileName2);
			if (!f2.exists()){
				f2.createNewFile();
			}
			FileWriter fw = new FileWriter(f2);
			fw.write("Olá mundo 2\n");
			fw.write("De novo . . .");
			fw.close();
			File[] listRoots = f2.listRoots();
			for (File i: listRoots){
				System.out.println(i.toString());
			}
			System.out.println("Tamanho: "+ f2.length() + " bytes") ;
			
			FileOutputStream fos = new FileOutputStream(f2, true);
			fos.write(2);
			fos.write(80);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
