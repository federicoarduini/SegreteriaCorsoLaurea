package SegreteriaCorsoLaurea;

public class CorsoLaurea 
{
	private final int MIN_CREDITI;
	private String nome;
	private Studente[] listaStudenti;
	
	public CorsoLaurea (String nome, int min_crediti)
	{
		this.setNome(nome);
		this.listaStudenti = new Studente[10];
		this.MIN_CREDITI = min_crediti;
	}

	public int getMinCrediti()
	{
		return MIN_CREDITI;
	}

	public String getNome()
	{
		return nome;
	}

	private void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public Boolean iscriviStudente (Studente s)
	{
		for (int i = 0; i < this.listaStudenti.length; i++)
		{
			if (this.listaStudenti[i] == null)
			{
				this.listaStudenti[i] = s;
				return true;
			}
		}
		
		return false;
	}
	
	public Studente cercaStudente (String matricola)
	{
		for (int i = 0; i < this.listaStudenti.length; i++)
		{
			if (this.listaStudenti[i] != null && this.listaStudenti[i].getMatricola().equals(matricola))
				return this.listaStudenti[i];
		}
		
		return null;
	}
	
	public Boolean ritiraStudente (String matricola)
	{
		for (int i = 0; i < this.listaStudenti.length; i++)
		{
			if (this.listaStudenti[i] != null && this.listaStudenti[i].getMatricola().equals(matricola))
			{
				this.listaStudenti[i] = null;
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean laureaStudente (String matricola)
	{
		for (int i = 0; i < this.listaStudenti.length; i++)
		{
			if (this.listaStudenti[i] != null && this.listaStudenti[i].getMatricola().equals(matricola))
			{
				this.listaStudenti[i].laureaStudente();
				
				if (this.listaStudenti[i].getNumeroCrediti() > this.getMinCrediti())
					this.listaStudenti[i] = null;
				
				return true;
			}
		}
		
		return false;
	}
	
	public String stampaListaStudenti (Boolean laureati)
	{
		String s = "Lista studenti:\n";
		
		for (int i = 0; i < this.listaStudenti.length; i++)
		{
			if (laureati)
			{
				if (this.listaStudenti[i] != null && this.listaStudenti[i].laureato)
				{
					s += this.listaStudenti[i].toString();
					s += "\n";					
				}
			}
			else if (this.listaStudenti[i] != null && !this.listaStudenti[i].laureato)
			{
				s += this.listaStudenti[i].toString();
				s += "\n";
			}	
		}
		
		return s;
	}
	
	public String toString()
	{
		String s = "CORSO: " + this.getNome() + " - " + this.getMinCrediti() + " CFU\n";
		s += "Studenti iscritti:\n";
				
		for (int i = 0; i < this.listaStudenti.length; i++)
		{
			if (this.listaStudenti[i] != null)
				s += this.listaStudenti[i].toString();
		}
		
		return s;
	}
}
