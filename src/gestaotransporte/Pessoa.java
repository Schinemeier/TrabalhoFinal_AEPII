package gestaotransporte;

public class Pessoa {
	protected Integer id = 1000;
	protected String nome;
	protected String cpf;
	protected String cidade;
	protected String cnh;
	
	public Pessoa(String nome, String cpf, String cidade, String cnh) {
		this.id += 1;
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		this.cnh = cnh;
	}
	
	public void listar() {
		
	}
}
