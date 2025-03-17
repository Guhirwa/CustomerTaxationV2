/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.TaxPayerDao;
import java.util.Scanner;
import model.TaxPayer;

/**
 *
 * @author jeremie
 */
public class App {
    public static void main(String[] args) {
        boolean condition = true;
        Scanner input = new Scanner(System.in);
        while(condition){
            System.out.println("====================");
            System.out.println("  TAXATION SYSTEM ");
            System.out.println("====================");
            System.out.println("1. Create Tax Payer");
            System.out.println("2. Update Tax Payer");
            System.out.println("3. Delete Tax Payer");
            System.out.println("4. Search Tax Payer");
            System.out.println("5. Find All Tax Payer");
            System.out.println("0. Exit");
            System.out.println("-----------");
            System.out.print("Enter Choice: ");
            int choice = input.nextInt();
            String answer;
            TaxPayer taxPayerObj = new TaxPayer();
            TaxPayerDao dao = new TaxPayerDao();
            String names;
            String nid;
            Double amount;
            String tin;
            switch(choice){
                case 1:
                    System.out.print("Enter Names: ");
                    names = input.next();
                    System.out.print("Enter TIN: ");
                    tin = input.next();
                    System.out.print("Enter NID: ");
                    nid = input.next();
                    System.out.print("Enter Amount: ");
                    amount = input.nextDouble();
                    
                    // set values to model
                    taxPayerObj.setNames(names);
                    taxPayerObj.setAmount(amount);
                    taxPayerObj.setNid(nid);
                    taxPayerObj.setTin(tin);
                    
                    int feedback = dao.createTaxPayer(taxPayerObj);
                    if(feedback > 0){
                        System.out.println("Data Created Successful");
                    }else{
                        System.out.println("Data not Inserted!!");
                    }
                    
                    System.out.println("Do you wish to continue to use the system \n Enter Yes to continue and no to quit");
                    answer = input.next();
                    if(answer.equalsIgnoreCase("Yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        System.exit(0);
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using the system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
                    System.out.println("Do you wish to continue to use the system \n Enter Yes to continue and no to quit");
                    answer = input.next();
                    if(answer.equalsIgnoreCase("Yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        System.exit(0);
                    }
            }
            
        }
    }
}
