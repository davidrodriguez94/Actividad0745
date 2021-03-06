/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // El limite de billetes a la venta
    private int limite;
    // Posibilidad de premio
    private boolean premio;
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean ticketPremio, int limiteBillete)
    {
        premio = ticketPremio;
        limite = limiteBillete;
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     * Si se ha superado el l�mite de billetes, no deja meter m�s dinero
     */
    public void insertMoney(int amount)
    {
        if(amount > 0 & limite > 0) {
            balance = balance + amount;
        }
        else if(amount > 0 & limite == 0){
            System.out.println("ERROR. NO HAY BILLETES");
        }
        else {
            System.out.println("ERROR. Introduzca un valor superior a 0");
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price & premio == true) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            
            System.out.println("##################");
            System.out.println("# ��PREMIO!!");
            System.out.println("# Ticket de regalo");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
            limite = limite -1;
        }
        else if(balance >= price & premio == false){
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
            limite = limite -1;
        }
        else {
            System.out.println("You must insert at least: " +
                (price - balance) + " more cents.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * Simula el vaciado de la m�quina s�lo si la maquina no esta en uso
     */
    public int emptyMachine()
    {
        int vaciarMaquina = -1;
        if(balance == 0){
            vaciarMaquina = total;
            balance = 0;
        }
        else{
            System.out.println("La m�quina est� siendo usada en este momento. Espere a que la operaci�n finalice");
        }
        return vaciarMaquina;
    }

}

