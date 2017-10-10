//Please comment each modification of this skeleton to highlight the code asked for this lab.


/**
 * Les objets instances de la classe Atelier representent des ateliers de transformation.
 * Le fonctionnement est le suivant : l'appel a transformer retire un element du stock A,
 * attend 100 ms, puis ajoute un element au stock B.
 * La methode travailler() effectue n transformations successives, n etant un parametre
 * fourni a la creation de l'objet.
 */

/**
 * Objects of class Workshop represent processing workshops. The operation is as follows:
 * The method processing() removes an element from a Stock A, waits 100 ms 1 and, finally adds 
 * an element to a Stock B. The method work() performs n processings successively.
 */

class Workshop extends Thread {

	/**
	 * source stock
	 */
    private Stock A;
    /**
     * destination stock
     */
    private Stock B;
    /** 
     * Number of processings to perform when the method work is called
     */
    private int nbProcessing;

    /**
     * Constructor
     * @param A: source stock
     * @param B: destination stock
     * @param nbProcessing: Number of processings to perform
     */
    public Workshop(Stock A, Stock B, int nbProcessing) {
        this.A = A;
        this.B = B;
        this.nbProcessing = nbProcessing;
    }

    /**
     * Perform one processing
     */
    public void processing() {
        A.destock();
//        try { Thread.sleep(100); } catch(InterruptedException e) {}
        B.stock();
    }

    /**
     * Perform nbProcessing processings
     */
    public void run() {
        for(; nbProcessing > 0; nbProcessing--)
            processing();
    }

    /**
     * Method main for unit testing
     * @param args Not used
     */
    static public void main(String[] args) {



    }
}
