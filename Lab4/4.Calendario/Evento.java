package Calendario;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Evento {

	private final String nome;
	private final Date data;
	
	public Evento(Date data , String nome) {
		
		if(data == null)
			throw new IllegalArgumentException("Data nulla");
		if(nome == null)
			throw new IllegalArgumentException("Nome nullo");
		if(nome == "")
			throw new IllegalArgumentException("Nome vuoto");
		
		this.nome = nome;
		//this.data = data; 
		/* Ovviamente non va bene perché sto facendo riferimento ad una classe "Date" quindi non posso far
		 * puntare this.data ad un oggetto diverso ma comunque posso modificare l'oggetto date
		*/
		this.data = (Date)(data.clone()); //uso un clone e la classe non sarà mai mutabile
		
		/*Un metodo migliore , a mio avviso sarebbe stato direttamente creare una nuova istanza
		 * nel costruttore, anche perché clone in questo caso ok funziona ma non è così scontato
		 * su TUTTI gli oggetti...
		 * (nel costruttore) this.data = new Date(data.getTime()) , creo una copia , data rimane 
		 * immutabile e non uso clone.*/
		
		assert repOk() : "qualcosa non torna";
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Date getData() {
		//return this.data;
		//stesso discorso di prima , sto ritornando una data modificabile
		return (Date)(this.data.clone());
	}
	
	//SimpleDateFormat mi ritorna un nuovo oggetto di un qualsiasi Date ma correttamente formattato
	@Override
	public String toString() {
		//this.data.getDate() + "/" + (this.data.getMonth()+1) + "/" + (this.data.getYear()+1900)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(getData());
		return getNome() + " " + formattedDate;
	}
	
	public Evento copiaEvento(int n) {
		/* data.getTime() restituisce il valore temporale interno rappresentato dalla data. 
		 * Questo valore temporale è il numero di millisecondi 
		 * trascorsi dal 1 gennaio 1970, 00:00:00 UTC (Coordinated Universal Time)
		 * */
		Date nuovaData = new Date(this.data.getTime() + n * 24 * 60 * 60 * 1000);
		//n che moltiplica 24 h , 60 min , 60 sec, 1000 millisec
		return new Evento(nuovaData, this.nome);
	}
	public boolean equals(Object ob) {
		Evento e;

		if (ob instanceof Evento) {
			e = (Evento) ob;
		} else {
			return false;
		}

		if (this == e) {
			return true;
		}

		return this.nome.equals(e.nome) && this.data.equals(e.data);
	}
	
	
	
	//verifico il corretto inserimento dei dati attraverso una RI che userò nel costruttore
	private boolean repOk() {
		if((this.data != null) && (this.nome != null) && (this.nome != "")) 
			return true;

		return false;
	}
}
