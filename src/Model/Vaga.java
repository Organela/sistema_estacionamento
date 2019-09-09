package Model;

public class Vaga {

	public int numero;
	public boolean status;

	public Vaga() {
		super();
		this.numero = 0;
		this.status = false;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
