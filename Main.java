// PARTNER NAME:
// PARTNER NAME:
// CS111 SECTION #:
// DATE:

public class Main
{
	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
	{
		TacoStand.initialize();
		TacoStand.addTotalFunds(20);
		TacoStand.orderSupplies(15);

		System.out.println("OPENING UP THE STAND...");
		System.out.println( TacoStand.getStatus() +"\n\n");

		Main.printWelcome();
		System.out.println("\n");
		Main.takeOrder();
		System.out.println("--------CART IS CLOSED---------");
		System.out.println();
	System.out.println(TacoStand.getStatus());
	}

	public static void printWelcome()
	{
		UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
		UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
		UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
		UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
	}

	public static void takeOrder()
	{
		int option, numTacosOrdered;
		TacoStand.printMenu();
		option = UtilityBelt.readInt("Enter choice> ", 1, 4);
		numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);
		if (TacoStand.areTacosAvailable(option, numTacosOrdered)) {
			TacoStand.updateTotalFunds(option, numTacosOrdered);
			Main.printConfirmation(numTacosOrdered);
		} else {
			System.out.println("We don't have that many tacos, sorry! Try again :(");
		}
	}

	public static void printConfirmation(int numTacos)
{
    System.out.println("Here you go, buen provecho!");
	for (int i = 0; i < numTacos; i++) {
		System.out.print("🌮");
		
	}
	System.out.println("");
	System.out.println("");
}
}
