package SegreteriaCorsoLaurea;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CorsoLaurea cl = new CorsoLaurea("Ingegneria informatica e dell'automazione", 100);
		Studente studenteSelezionato = null;
		
		// variabili in comune
		String nome, matricola;
		
		int scelta;
		Scanner in = new Scanner(System.in);
		
		System.out.println(cl.toString());
		
		do
		{
			System.out.println("+----------------------+");
			System.out.println("| MENU CORSO DI LAUREA |");
			System.out.println("+----------------------+");
			System.out.println("1 - iscrivi studente (verra' selezionato per MENU STUDENTE)");
			System.out.println("2 - ritira studente");
			System.out.println("3 - ricerca studente (verra' selezionato per MENU STUDENTE)");
			System.out.println("4 - laurea studente");
			System.out.println("5 - visualizza lista studenti iscritti");
			System.out.println("6 - visualizza lista studenti laureati");
			System.out.println("7 - accedi al MENU STUDENTI");
			System.out.println("0 - chiudi programma");
			
			System.out.print("> Digitare un comando: ");
			scelta = in.nextInt();
			
			in.nextLine();
			
			switch (scelta)
			{
				case 1:
					// iscrizione studente
					System.out.print("Inserire nome: ");
					nome = in.nextLine();
					System.out.print("Inserire matricola: ");
					matricola = in.nextLine();
					
					Studente s = new Studente(nome, matricola);
					if (cl.iscriviStudente(s))
					{
						studenteSelezionato = s;
						System.out.println("Studente iscritto con successo al corso di laurea.\n");
						System.out.println("========>> Studente selezionato:\n" + studenteSelezionato.toString());
					}
					else
						System.out.println("Impossibile iscrivere lo studente");
					
					break;
				case 2:
					// ritira studente
					System.out.print("Inserire matricola dello studente da ritirare: ");
					matricola = in.nextLine();
					
					if (cl.ritiraStudente(matricola))
					{
						System.out.println("Studente " + matricola + " ritirato.");
						if (studenteSelezionato.getMatricola().equals(matricola))	
						{
							studenteSelezionato = null;
							System.out.println("=======>> Nessun studente selezionato per MENU STUDENTI");
						}
					}
					else
						System.out.println("Impossibile ritirare lo studente.");
					
					break;
				case 3:
					// ricerca studente e selezione per MENU STUDENTI
					System.out.print("Inserire matricola da ricercare: ");
					matricola = in.nextLine();
					
					Studente studTrovato = cl.cercaStudente(matricola);
					if (studTrovato != null)
					{
						studenteSelezionato = studTrovato;
						System.out.println("Studente individuato:\n" + studTrovato.toString());
						System.out.println("=======>> Studente selezionato:\n" + studenteSelezionato.toString());
					}
					else
						System.out.println("Studente non trovato");
					
					break;
				case 4:
					// laurea studente
					System.out.print("Inserire matricola da laureare: ");
					matricola = in.nextLine();
					
					if (cl.laureaStudente(matricola))
					{
						System.out.println("Studente laureato con successo");
						if (studenteSelezionato.getMatricola().equals(matricola))
						{
							studenteSelezionato = null;
							System.out.println("========>> Nessun studente selezionato per MENU STUDENTI");
						}
					}
					else
						System.out.println("Impossibile laureare lo studente");
					
					break;
				case 5:
					// stampa lista studenti iscritti
					System.out.println(cl.stampaListaStudenti(false));
					break;
				case 6:
					// stampa lista studenti laureati
					System.out.println(cl.stampaListaStudenti(true));
					break;
				case 7:
					// accedi al MENU STUDENTI
					if (studenteSelezionato == null)
					{
						System.out.println("Nessun studente selezionato. Per poter accedere al MENU STUDENTI e' necessario "
								         + "selezionare uno studente con cui interagire.");
						System.out.println("E' possibile selezionare uno studente cercandolo o aggiungendolo.");
						break;
					}
					
					/*
					 * QUI INIZIA IL MENU STUDENTI
					 */
					
					System.out.println("SITUAZIONE STUDENTE SELEZIONATO:\n");
					System.out.println(studenteSelezionato.toString());
					
					do
					{
						System.out.println("+---------------+");
						System.out.println("| MENU STUDENTE |");
						System.out.println("+---------------+");
						System.out.println("1 - aggiungi esame");
						System.out.println("2 - rimuovi esame");
						System.out.println("3 - cerca esame");
						System.out.println("4 - promuovi ad un esame");
						System.out.println("5 - visualizza situazione generale");
						System.out.println("0 - torna al MENU CORSO DI LAUREA");
						
						System.out.print("Digitare comando: ");
						scelta = in.nextInt();
						
						in.nextLine();
						
						switch(scelta)
						{
							case 1:
								// aggiungi esame
								int numeroCrediti;
								
								System.out.print("Inserire il nome dell'esame: ");
								nome = in.nextLine();
								System.out.print("Inserire il numero di crediti dell'esame: ");
								numeroCrediti = in.nextInt();
								
								Esame e = new Esame (nome, numeroCrediti);
								if (studenteSelezionato.aggiungiEsame(e))
									System.out.println("Esame aggiunto correttamente");
								else
									System.out.println("Impossibile aggiungere l'esame");
								
								break;
							case 2:
								// rimuovi esame
								System.out.print("Inserire il nome dell'esame da rimuovere: ");
								nome = in.nextLine();
								
								if (studenteSelezionato.rimuoviEsame(nome))
									System.out.println("Esame rimosso correttamente");
								else
									System.out.println("Impossibile rimuovere l'esame");
								
								break;
							case 3:
								// cerca esame
								System.out.print("Inserire il nome dell'esame da cercare: ");
								nome = in.nextLine();
								
								Esame esameTrovato = studenteSelezionato.cercaEsame(nome);
								if (esameTrovato != null)
									System.out.println("Esame trovato:\n" + esameTrovato.toString());
								else
									System.out.println("Nessun esame trovato");
								
								break;
							case 4:
								// promuovi ad un esame
								double votoEsame;
								
								System.out.print("Inserire il nome dell'esame da promuovere: ");
								nome = in.nextLine();
								System.out.print("Inserire il voto: ");
								votoEsame = in.nextDouble();
								
								if (studenteSelezionato.promuoviEsame(nome, votoEsame))
									System.out.println("Esame promosso correttamente");
								else
									System.out.println("Impossibile promuovere l'esame");
								
								break;
							case 5:
								// stampa situazione generale
								System.out.println(studenteSelezionato.toString());
								break;
						}
					} while (scelta != 0);
					
					scelta = 99;
					break;
			}
		} while (scelta != 0);
		
		System.out.println("Arrivederci!!!!!!!");
	}

}
