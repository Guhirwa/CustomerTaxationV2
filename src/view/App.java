package view;

import dao.TaxPayerDao;
import model.TaxPayer;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaxPayerDao dao = new TaxPayerDao();
        boolean condition = true;

        do {
            System.out.println("====================");
            System.out.println("  TAXATION SYSTEM ");
            System.out.println("====================");
            System.out.println("1. Create Tax Payer");
            System.out.println("2. Update Tax Payer");
            System.out.println("3. Delete Tax Payer");
            System.out.println("4. Search Tax Payer");
            System.out.println("5. Find All Tax Payers");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Names: ");
                    input.nextLine();
                    String names = input.nextLine();
                    System.out.print("Enter TIN: ");
                    String tin = input.next();
                    System.out.print("Enter NID: ");
                    String nid = input.next();
                    System.out.print("Enter Amount: ");
                    Double amount = input.nextDouble();

                    TaxPayer taxPayer = new TaxPayer(names, tin, nid, amount);
                    if (dao.createTaxPayer(taxPayer) > 0) {
                        System.out.println("Tax Payer added successfully!");
                    } else {
                        System.out.println("Failed to add tax payer.");
                    }
                    break;

                case 2:
                    System.out.print("Enter TIN to update: ");
                    tin = input.next();
                    TaxPayer existingTaxPayer = dao.searchTaxPayer(tin);

                    if (existingTaxPayer != null) {
                        System.out.println("TAX PAYER INFORMATION");
                        System.out.println("----------------------");
                        System.out.println("TIN: " + existingTaxPayer.getTin());
                        System.out.println("NID: " + existingTaxPayer.getNid());
                        System.out.println("Names: " + existingTaxPayer.getNames());
                        System.out.println("Amount: " + existingTaxPayer.getAmount());

                        System.out.print("Enter new Names: ");
                        input.nextLine();
                        names = input.nextLine();
                        System.out.print("Enter new NID: ");
                        nid = input.next();
                        System.out.print("Enter new Amount: ");
                        amount = input.nextDouble();

                        existingTaxPayer.setNames(names);
                        existingTaxPayer.setNid(nid);
                        existingTaxPayer.setAmount(amount);

                        int rowsAffected = dao.updateTaxPayer(existingTaxPayer);
                        if (rowsAffected > 0) {
                            System.out.println("Tax Payer updated successfully!");
                            System.out.println();
                        } else {
                            System.out.println("Update failed.");
                        }
                    } else {
                        System.out.println("Tax Payer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter TIN to delete: ");
                    tin = input.next();

                    System.out.println("Are you sure you want to delete record? (y/n)");
                    String responce = input.next();
                    condition = responce.equalsIgnoreCase("y");

                    if (condition) {
                        if (dao.deleteTaxPayer(tin) > 0) {
                            System.out.println("Tax Payer deleted successfully.");
                        } else {
                            System.out.println("Deletion failed.");
                        }
                        break;
                    }

                case 4:
                    System.out.print("Enter TIN to search: ");
                    tin = input.next();
                    TaxPayer result = dao.searchTaxPayer(tin);
                    if(result != null) {
                        System.out.println("TAX PAYER INFORMATION");
                        System.out.println("----------------------");
                        System.out.println("TIN: " + result.getTin());
                        System.out.println("NID: " + result.getNid());
                        System.out.println("Names: " + result.getNames());
                        System.out.println("Amount: " + result.getAmount());
                    } else {
                        System.out.println("Tax Payer not found");
                    }
                    break;

                case 5:
                    int counter = 1;
                        List<TaxPayer> taxPayerList = dao.findAllTaxPayers();
                        for (TaxPayer taxPayer1 : taxPayerList) {
                            System.out.println("TAX PAYER " + counter + " INFORMATION");
                            System.out.println("----------------------");
                            System.out.println("TIN: " + taxPayer1.getTin());
                            System.out.println("NID: " + taxPayer1.getNid());
                            System.out.println("Names: " + taxPayer1.getNames());
                            System.out.println("Amount: " + taxPayer1.getAmount());
                            System.out.println("");

                            counter++;
                        }
                    break;

                case 0:
                    System.out.println("Thank you for using the system!");
                    condition = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println("Do you wish to continue ? (yes/no)");
            String choice2 = input.next();
            condition = choice2.equalsIgnoreCase("yes");
        } while(condition);
        input.close();
    }
}
