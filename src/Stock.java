//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Stock represent a set of products stacked one above the other.
 * Due to the stack layout, it is not possible that two workshops take two products 
 * at the same time.
 */
class Stock {
	/**
	 * Number of products in the stack
	 */
    private int nbProducts, limitProducts;
    /**
     * Name of the stock
     */
    private String name;

    /**
     * Constructor
     * @param name: Name of the new stock
     * @param nbProducts: Initial number of products
     */
    public Stock(String name, int nbProducts, int limitProducts) {
        this.nbProducts = nbProducts;
        this.limitProducts = limitProducts;
        this.name = name;
        this.print();
    }

    /**
     * Add a product on top of the stack
     */
    synchronized public void stock() {
    	while(this.nbProducts >= this.limitProducts) {
    		try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
        nbProducts++;
//        this.print();
        this.notifyAll();
    }

    /**
     * Remove the highest product on the stack
     */
    synchronized public void destock() {
    	while(this.nbProducts <= 0) {
    		try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
        nbProducts--;
//        this.print();
        
        this.notifyAll();
    }

    /**
     * Print the state of the stock object
     */
    public synchronized void print() {
        System.out.println("Thread : "+Thread.currentThread().getName()+", Stock " + name + ": " + nbProducts + " product(s).");
    }

    /** 
     * Method main for unit testing
     * @param args Not used
     */
    static public void main(String[] args) {



    }
}
