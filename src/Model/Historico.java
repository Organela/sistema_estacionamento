package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE`Historico` (
  	`Carro_id` INT NOT NULL,
  	`Carro_Cliente_id` INT NOT NULL,
  	`Vaga_id` INT NOT NULL,
  	`horas`TIME NULL,
  	`data` DATE NULL,
    `Funcionario_id` INT NOT NULL,
    `preco` DOUBLE,
  
  	PRIMARY KEY (`Carro_id`,`data`),
    
  	FOREIGN KEY (`Carro_id`)REFERENCES carro(`id`),
  	FOREIGN KEY (`Carro_Cliente_id`)REFERENCES cliente(`id`),
  	FOREIGN KEY (`Vaga_id`) REFERENCES vaga(`id`),
    FOREIGN KEY (`Funcionario_id`) REFERENCES funcionario(`id`)   
);
);

 */
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private String data;
	private double horas;
	private float preco;
	
	private List<Cliente>cliente;
	private List<Carro>carro;
	private List<Vaga>vaga;
	private List<Funcionario>funcionario;
	
	
	
	public Historico() {
		
		this.cliente = new ArrayList<Cliente>();
		this.carro = new ArrayList<Carro>();
		this.vaga = new ArrayList<Vaga>();
		this.funcionario = new ArrayList<Funcionario>();
	
	}



	public Historico(String data, double horas, float preco, List<Cliente> cliente, List<Carro> carro, List<Vaga> vaga,
			List<Funcionario> funcionario) {
		super();
		this.data = data;
		this.horas = horas;
		this.preco = preco;
		this.cliente = cliente;
		this.carro = carro;
		this.vaga = vaga;
		this.funcionario = funcionario;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public double getHoras() {
		return horas;
	}



	public void setHoras(double horas) {
		this.horas = horas;
	}



	public float getPreco() {
		return preco;
	}



	public void setPreco(float preco) {
		this.preco = preco;
	}



	public List<Cliente> getCliente() {
		return cliente;
	}



	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}



	public List<Carro> getCarro() {
		return carro;
	}



	public void setCarro(List<Carro> carro) {
		this.carro = carro;
	}



	public List<Vaga> getVaga() {
		return vaga;
	}



	public void setVaga(List<Vaga> vaga) {
		this.vaga = vaga;
	}



	public List<Funcionario> getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Historico [data=" + data + ", horas=" + horas + ", preco=" + preco + ", cliente=" + cliente + ", carro="
				+ carro + ", vaga=" + vaga + ", funcionario=" + funcionario + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(horas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(preco);
		result = prime * result + ((vaga == null) ? 0 : vaga.hashCode());
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
		Historico other = (Historico) obj;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (Double.doubleToLongBits(horas) != Double.doubleToLongBits(other.horas))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (vaga == null) {
			if (other.vaga != null)
				return false;
		} else if (!vaga.equals(other.vaga))
			return false;
		return true;
	}



	


	



	
	
}