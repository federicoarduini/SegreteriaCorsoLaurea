package SegreteriaCorsoLaurea;

public class Studente
{
	public Boolean laureato;
	public String nome;
	public String matricola;
	public int numeroCrediti;
	public Esame[] pianoStudi;
	
	public Studente (String nome, String matricola)
	{
		this.setNome(nome);
		this.setMatricola(matricola);
		this.pianoStudi = new Esame[10];
		this.setLaureato(false);
		this.setNumeroCrediti(0);
	}

	public String getNome()
	{
		return nome;
	}

	public String getMatricola()
	{
		return matricola;
	}

	private void setNome(String nome) 
	{
		this.nome = nome;
	}

	private void setMatricola(String matricola) 
	{
		this.matricola = matricola;
	}
	
	public Boolean getLaureato() 
	{
		return laureato;
	}

	private void setLaureato(Boolean laureato) 
	{
		this.laureato = laureato;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	private void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}

	public Boolean aggiungiEsame(Esame e)
	{
		for (int i = 0; i < this.pianoStudi.length; i++)
		{
			if (this.pianoStudi[i] == null)
			{
				this.pianoStudi[i] = e;
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean rimuoviEsame(String nomeEsame)
	{
		for (int i = 0; i < this.pianoStudi.length; i++)
		{
			if (this.pianoStudi[i] != null && this.pianoStudi[i].getNome().equals(nomeEsame))
			{
				this.pianoStudi[i] = null;
				return true;
			}
		}
		
		return false;
	}
	
	public Esame cercaEsame(String nomeEsame)
	{
		for (int i = 0; i < this.pianoStudi.length; i++)
		{
			if (this.pianoStudi[i] != null && this.pianoStudi[i].getNome().equals(nomeEsame))
				return this.pianoStudi[i];
		}
		
		return null;
	}
	
	public Boolean promuoviEsame (String nomeEsame, double voto)
	{
		for (int i = 0; i < this.pianoStudi.length; i++)
		{
			if (this.pianoStudi[i] != null && this.pianoStudi[i].getNome().equals(nomeEsame))
			{
				this.setNumeroCrediti(this.getNumeroCrediti() + this.pianoStudi[i].promuovi(voto));
				return true;
			}
		}
		
		return false;
	}
	
	public String toString()
	{
		double mediaVoti = 0;
		int numeroEsamiSuperati = 0;
		String s = "";
		
		s += "Studente " + this.getNome() + " - matricola " + this.getMatricola() + "\n";
		s += "Piano di studi:\n";
		
		for (int i = 0; i < this.pianoStudi.length; i++)
		{
			if (this.pianoStudi[i] != null)
			{
				s += this.pianoStudi[i].toString();
				if (this.pianoStudi[i].getVoto() >= 18)
				{
					mediaVoti += this.pianoStudi[i].getVoto();
					numeroEsamiSuperati++;
				}
			}
		}
		
		if (numeroEsamiSuperati > 0)
			mediaVoti = mediaVoti / numeroEsamiSuperati;
		
		s += numeroEsamiSuperati + " esami superati\n";
		s += "Media dei voti: " + mediaVoti + "\n";
		s += "Totale dei crediti: " + this.getNumeroCrediti() + "\n";
		
		if (this.getLaureato())
			s += "STUDENTE LAUREATO\n";
		
		return s;
	}
	
	public void laureaStudente()
	{
		this.setLaureato(true);
	}
}
