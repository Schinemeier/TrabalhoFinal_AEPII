package gestaotransporte;
import java.io.Serializable;


public class Pessoa {
	protected Integer id = 1000;
	protected String nome;
	protected String cpf;
	protected String cidade;
	
	
	
	public Pessoa(String nome, String cpf, String cidade) {
		this.id += 1;
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		
	}
	
}
