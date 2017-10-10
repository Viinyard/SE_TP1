//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Factory represent a factory with two processing workshops.
 * A factory has a stock of products to process and, a stock of processed products (initially empty).
 * Both workshops process half of the products. The method activate() launch successively the two
 * workshops and then print the state of the stocks when the processing is finished.
 */
class Factory {
	/**
	 * source stock
	 */
    Stock sourceStock = new Stock("source", 10, 10);
    /**
     * destination stock
     */
    Stock destinationIntermediaire = new Stock("destination intermediaire", 0, 1);
    
    Stock destinationFinale = new Stock("destination finale", 0, 10);
    /**
     * processing workshops
     */
    
    Workshop workshop0 = new Workshop(sourceStock, destinationIntermediaire, 5);
    Workshop workshop1 = new Workshop(sourceStock, destinationIntermediaire, 5);
    Workshop workshop2 = new Workshop(destinationIntermediaire, destinationFinale, 5);
    Workshop workshop3 = new Workshop(destinationIntermediaire, destinationFinale, 5);
    
    /**
     * Launch the factory work
     */
    public void activate() {
    		workshop2.start();
    		workshop3.start();
    		workshop1.start();
    		workshop0.start();
    		
    		try {
				workshop1.join();
				workshop2.join();
	    		workshop3.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		
    		sourceStock.print();
    		destinationFinale.print();
    }
    
    /**
     * Entry point for the lab
     * @param args Not used
     */
    public static void main(String[] args) {
    	new Factory().activate();

    }
}
