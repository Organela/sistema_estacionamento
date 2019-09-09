package Model;

public class Carro {
	
	public int id;
	public String placa;
	public String nome;
	
	
	public Carro(int id, String placa, String nome) {
		super();
		this.id = id;
		this.placa = placa;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
