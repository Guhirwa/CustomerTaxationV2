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

        while (condition) {
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
                    TaxPayer existingTaxPayer = dao.searchTaxPayer(taxPayer);

                    if (existingTaxPayer != null) {
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

                        if (dao.updateTaxPayer(existingTaxPayer) > 0) {
                            System.out.println("Tax Payer updated successfully!");
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
                    if (dao.deleteTaxPayer(tin) > 0) {
                        System.out.println("Tax Payer deleted successfully.");
                    } else {
                        System.out.println("Deletion failed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter TIN to search: ");
                    tin = input.next();
                    TaxPayer result = dao.searchTaxPayer(tin);
                    System.out.println(result != null ? result : "Tax Payer not found.");
                    break;

                case 5:
                    List<TaxPayer> taxPayers = dao.findAllTaxPayers();
                    taxPayers.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Thank you for using the system!");
                    condition = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        input.close();
    }
}
