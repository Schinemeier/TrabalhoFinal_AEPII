package gestaotransporte;

//import java.io.DataOutputStream;
//import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SalvarCarregar {
	
	public static void salvar(Pessoa pessoa) {
		String filepath = "db.bin";

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))){
			oos.writeObject(pessoa);//salvar objeto no arquivo
			System.out.println("Salvo com sucesso!");
		}catch(IOException e) {
			System.err.println("Erro ao salvar: "+ e.getMessage());
		}
		
		carregar();
	}
	
	public static void carregar() {
		String filepath = "db.bin";
		
		  try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
			  Pessoa pessoa = (Pessoa) ois.readObject();//ler objeto do arquivo 
			  System.out.println("Objeto lido: " + pessoa);
		  }catch (IOException | ClassNotFoundException e) {
	            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	      }
		
	}
	
}
