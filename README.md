# SegreteriaCorsoLaurea
Esercizio del 2-11-2021.

## Testo
La segreteria di un corso di laurea desidera sviluppare un archivio elettronico per la gestione di tutti gli studenti,
di tutti gli appelli d'esame, e delle sessioni di laurea. Implementare le classi Esame, Studente e CorsoLaurea e
i metodi per effettuare le seguenti operazioni:
- Iscrivere uno studente ad un corso di laurea.
- Cercare uno studente tra gli iscritti ad un corso di laurea.
- Ritirare uno studente da un corso di laurea.
- Laureare uno studente iscritto ad un corso di laurea (rimuovere lo studente dal corso se ha raggiunto
un numero di crediti pari o superiore a MIN_CREDITI).
- Visualizzare gli studenti iscritti ad un corso di laurea.
- Visualizzare gli studenti laureati in un corso di laurea.
- Creare un piano di studio per uno studente (una lista di esami).
- Aggiungere un esame ad un piano di studio.
- Rimuovere un esame da un piano di studio.
- Cercare un esame in un piano di studio.
- Promuovere uno studente ad un esame con un voto.
- Visualizzare gli esami effettuati da uno studente, con il numero totale di crediti e la media dei voti.
- Implementare i vari metodi getter e setter, limitare il più possibile gli attributi public e l’utilizzo di
attributi e metodi static.
- Implementare una classe con il metodo main da cui testate tutti i punti qui elencati richiamando i
metodi opportuni. Opzionale: creare una classe per testare ogni classe, ad esempio TestEsame,
TestStudente, TestCorsoLaurea.
### Suggerimenti:
- Le istanze della classe Esame si dovrebbero riferire agli esami aggiunti dallo studente, non ai tipi di
esami. Ad esempio, non esiste una sola istanza di Programmazione ad Oggetti, ma una per ogni
studente iscritto all’esame. Questo è un suggerimento, se preferite potete anche provare una soluzione
diversa. Opzionale: creare una classe TipoEsame oltre a Esame.
- Ogni Esame ha un nome e un numero di crediti. Considerando il punto precedente, si può considerare
il voto come un ulteriore attributo di Esame.
- Ogni Studente ha un nome, una matricola e un piano di studi (lista di esami).
- Ogni CorsoLaurea ha un nome, una lista di studenti e un numero minimo di crediti per laurearsi.
