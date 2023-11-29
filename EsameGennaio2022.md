# Elezioni del presidente della... bocciofila


Obiettivo dell'esercizio è progettare e realizzare un insieme di classi atte a produrre un semplice programma Java che si occupi di gestire le votazioni per la presidenza della bocciofila. 

Il sistema (di cui l'interfaccia è data nella figura sottostante) ha una prima vista [`CandidaView`](src/main/java/it/unimi/di/prog2/esame/view/CandidaView.java) con una casella di testo e un bottone **Candida**.

Mediante questa vista si possono inserire fino a 5 nomi tra cui i membri della bocciofila potranno scegliere chi votare.
Se un nome è già presente, vuoto, o più corto di 3 caratteri deve essere rifiutato.

Se sono presenti almeno 2 nomi di candidati si può iniziare la votazione (ma altri candidati potranno essere aggiunti anche a votazione iniziata).

Nelle due viste [`VotaView`](src/main/java/it/unimi/di/prog2/esame/view/VotaView.java) della riga sottostante (una _situata_ nella sede della bocciofila, l'altra nel posteggio come postazione drive-through riservata ai positivi covid) compariranno tali nomi (in ordine alfabetico e con in più in fondo la voce standard "SCHEDA BIANCA") con a fianco un bottone **Vota** per potere votare. In queste stesse viste c'è in cima una casella di testo in cui inserire il proprio codice numerico segreto che ci identifica come abilitati alla votazione.

Un voto deve essere accettato solo se il codice è tra quelli validi (per semplificazione sono da considerare codici validi i numeri da 1 a 4000) e non ha ancora votato.
Se il voto non viene accettato (codice sbagliato o già usato) lo sfondo della vista deve diventare rosso, altrimenti se accettato deve diventare verde.

Attenzione che per garantire un livello basilare di segretezza della votazione, accedendo alle informazioni memorizzate nel modello, non deve essere possibile collegare un voto a un codice del votante, e non vengono forniti fuori distribuzione dei voti se non hanno votato almeno 3 persone.

Nella ultima vista [`RisultatiView`](src/main/java/it/unimi/di/prog2/esame/view/RisultatiView.java) in fondo comparirà 
- il numero totale dei votanti

e (se hanno votato almeno 3 persone)

- la classifica dei candidati ordinata dal più votato al meno votato
- il numero di schede bianche sarà comunque l’ultima voce.

Viene fornita anche una prima versione della classe  [`Main`](src/main/java/it/unimi/di/prog2/esame/Main.java) che permette d'istanziare la parte statica delle viste, di una interfaccia [`Presenter`](src/main/java/it/unimi/di/prog2/esame/presenter/Presenter.java) e della classe  [`VotaPresenter`](src/main/java/it/unimi/di/prog2/esame/presenter/VotaPresenter.java) già predisposta ad ascoltare gli eventi dei bottoni della vista del seggio [`Sede Bocciofila`](src/main/java/it/unimi/di/prog2/esame/view/VotaView.java).

Completare il codice, in modo da realizzare un'organizzazione del sistema di tipo *Model-View-Presenter*.

**TUTTE LE CLASSI DATE POSSONO ESSERE DA VOI MODIFICATE (CANCELLATE, COMPLETATE) PER ADERIRE A VOSTRE IDEE DI PROGETTAZIONE**


Lanciando il programma (tramite il task `run` di gradle) si ottiene una interfaccia come quella nella figura sottostante, e alla pressione del bottone **Vota** nella vista **Sede Bocciofila** viene invocato il metodo di [`VotaPresenter`](src/main/java/it/unimi/di/prog2/esame/presenter/VotaPresenter.java) collegato all'evento che stampa sulla console i parametri ricevuti (Codice segreto inserito, e nome candidato collegato al bottone Vota).

![GUI](gui0.png)

## SUGGERIMENTI

Per semplificare il riconoscimento dei candidati già inseriti, è possibile uniformarne la memorizzazione e presentazione in stringhe di soli caratteri maiuscoli senza spazi in cima e in fondo.

## ALTRE RICHIESTE E DOMANDA

Vi abbiamo al momento fornito classi concrete (e l'interfaccia `Presenter`), qualora lo riteneste utile per un buon design potete chiaramente introdurre astrazioni (interfacce o classi astratte), corredando l'aggiunta con la spiegazione del perché i cambiamenti effettuati migliorino il progetto. Nel caso, invece, non riteneste opportuno l'uso di ulteriori interfacce e classi astratte, motivate questa scelta.
