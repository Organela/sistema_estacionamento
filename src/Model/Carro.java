package Model;

import java.util.ArrayList;
import java.util.List;



/*
 * CREATE TABLE `carro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
 
  FOREIGN KEY (`Cliente_id`) REFERENCES cliente(`id`)
   
 )

 * */
import java.io.Serializable;


/*A tabela que recebe a foreing key � a tabela Hist�rico*/
public class Carro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int id;
	private String placa;
	private String nome;
	
	private List<Cliente> cliente;// Mover para classe historico
	
	public Carro() {
		this.cliente = new ArrayList<Cliente>();
		
	}
	public Carro(int id, String placa, String nome, List<Cliente> cliente) {
		super();
		this.id = id;
		this.placa = placa;
		this.nome = nome;
		this.cliente = cliente;
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
	public List<Cliente> getCliente() {
		return cliente;
	}
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
	
	@Override
	public String toString() {
		return "Carro [id=" + this.id + ", placa=" + this.placa + ", nome=" + this.nome  + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	
}