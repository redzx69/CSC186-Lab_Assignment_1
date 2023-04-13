import java.util.Scanner;

public class SuperBand {
    static double highestCharge = 0;
    static String highestChargeName = "";
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of customers: ");
        int numCust = in.nextInt();

        double totalCharges = 0;
        int countPackageA = 0, countPackageB = 0;
        for(int i = 0; i < numCust; i++)
        {
            System.out.println("\nCustomer " + (i+1));
            System.out.print("Enter name: ");
            String name = in.next();
            System.out.print("Enter Package type (A - advance, B - Basic) : ");
            char packageType = in.next().toUpperCase().charAt(0);
            
                //count number of customers using each package
                if(packageType == 'A')
                {
                    countPackageA++;
                }
                else if(packageType == 'B')
                {
                    countPackageB++;
                }
            
            System.out.print("Enter Total Internet use (in MB) : ");
            int dataUsed = in.nextInt();
            double charge = calCharge(packageType, dataUsed); //calc charge
            System.out.printf("Total charge is RM%.2f%n", charge);
            
            totalCharges += charge; 
            
            //find the customer with the highest charge
            if(charge > highestCharge)
            {
                highestCharge = charge;
                highestChargeName = name;
            }
            
        }
        in.close(); //close input stream

        //final output
        System.out.printf("%nTotal charges: RM%.2f%n", totalCharges);
        System.out.println("Number of customers using package A: " + countPackageA);
        System.out.println("Number of customers using package B: " + countPackageB);
        System.out.printf("The customer with the highest charge is %s with RM%.2f", highestChargeName, highestCharge);
    }

    public static double calCharge(char packageType, int dataUsed)
    {
        int dataQuota = 0, price = 0;
        double charge = 0, ppuCharge = 0; //ppu is Pay-per-use

        switch(packageType)
        {
            case 'A':
                dataQuota = 10000;
                price = 88;
                ppuCharge = 0.05;
                break;
            case 'B':
                dataQuota = 6000;
                price = 48;
                ppuCharge = 0.10;
                break;
            default:
                System.out.println("Invalid package type.");
                break;
        }

        if(dataUsed >= dataQuota)
        {
            charge = price + (dataUsed - dataQuota) * ppuCharge;
        }
        else
        {
            charge = price;
        }

        return charge;
    }
}