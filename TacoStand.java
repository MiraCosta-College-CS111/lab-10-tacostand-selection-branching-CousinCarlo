public class TacoStand
{
    public static final String BAR = "----------------------------------------";
    public static final double COST_SUPPLY_PER_TACO = 0.75;
    public static final int NUM_TACO_TYPES = 4;

    private static int numAsada = 0, numPollo = 0, numLengua = 0, numUltimate = 0;
    private static double totalFunds = 0;

    public static void initialize()
    {
        numAsada = numPollo = numLengua = numUltimate = 0;
        totalFunds = 0.0D;
    }

    public static void printMenu()
    {
        System.out.println("Menu options:\n" + TacoStand.BAR);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", 2.5);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)", 1.75);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 3, "Lengua (Beef Tongue)", 3.0);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 4, "Ultimate Taco", 18.0);
        System.out.println(TacoStand.BAR);
    }

    public static String getStatus()
    {
        return String.format("%s%nMCC Taco Stand Status%n%s%n" +
            "%-23s$%-7.2f%n%s%n" +
            "%-23s%2d tacos%n" +
            "%-23s%2d tacos%n" +
            "%-23s%2d tacos%n" +
            "%-23s%2d tacos%n%s",
            TacoStand.BAR, TacoStand.BAR, 
            "Funds Available:", TacoStand.totalFunds, TacoStand.BAR,
            "# of Asada Left:", TacoStand.numAsada,
            "# of Pollo Left:", TacoStand.numPollo,
            "# of Lengua Left:", TacoStand.numLengua,
            "# of Ultimate Left:",TacoStand.numUltimate, TacoStand.BAR);
    }

    public static void addTotalFunds(int funds)
    {
        TacoStand.totalFunds += funds;
    }

    public static boolean orderSupplies(double budget)
    {
        if (budget > totalFunds) return false;

        int tacosEach = (int)(budget / COST_SUPPLY_PER_TACO / NUM_TACO_TYPES);

        numAsada += tacosEach;
        numPollo += tacosEach;
        numLengua += tacosEach;
        numUltimate += tacosEach;

        totalFunds -= budget;

        return true;
    }

    public static void updateTotalFunds(int tacoOption, int numTacos)
    {
        double price = 0;

        switch (tacoOption) {
            case 1: price = 2.5; numAsada -= numTacos; break;
            case 2: price = 1.75; numPollo -= numTacos; break;
            case 3: price = 3.0; numLengua -= numTacos; break;
            case 4: price = 18.0; numUltimate -= numTacos; break;
        }

        totalFunds += price * numTacos;
    }

    public static boolean areTacosAvailable(int tacoOption, int numTacos)
    {
        switch (tacoOption) {
            case 1: return numAsada >= numTacos;
            case 2: return numPollo >= numTacos;
            case 3: return numLengua >= numTacos;
            case 4: return numUltimate >= numTacos;
            default: return false;
        }
    }
}
