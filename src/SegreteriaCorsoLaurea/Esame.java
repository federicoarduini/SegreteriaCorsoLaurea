package SegreteriaCorsoLaurea;

public class Esame
{
	private String nome;
	private int numeroCrediti;
	private double voto;
	
	public Esame (String nome, int numeroCrediti)
	{
		this.setNome(nome);
		this.setNumeroCrediti(numeroCrediti);
		this.setVoto(0);
	}

	public String getNome() 
	{
		return nome;
	}

	public int getNumeroCrediti()
	{
		return numeroCrediti;
	}

	public double getVoto()
	{
		return voto;
	}

	private void setNome(String nome)
	{
		this.nome = nome;
	}

	private void setNumeroCrediti(int numeroCrediti)
	{
		this.numeroCrediti = numeroCrediti;
	}

	private void setVoto(double voto)
	{
		this.voto = voto;
	}
	
	public int promuovi (double voto)
	{
		this.setVoto(voto);
		
		if (voto >= 18)
			return this.getNumeroCrediti();
		else
			return 0;
	}
	
	public String toString()
	{
		String s = "Esame di " + this.getNome() + " - " + this.getNumeroCrediti() + " CFU\n";

		if (this.getVoto() > 0)
			s += "Promosso con " + this.getVoto() + " punti\n";
		
		return s;
	}
}
