package mock.data;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;

import java.util.ArrayList;
import java.util.List;


public class DataMockLoader {

    static List<Customer> customers = new ArrayList<>();
    static List<Account> accounts = new ArrayList<>();

    public static List<Customer> getCustomers(){
        return DataMockLoader.customers;

        }

    public static List<Account> getAccounts(){
        return  DataMockLoader.accounts;
    }


    public void cargarDatos( ) {


     char[] password1 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
     char[] password2 = {'m', 'y', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
     char[] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
     char[] password4 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3'};
     char[] password5 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', 'a', 'b', 'c'};

     Customer customer1 = new Customer("Michael Knight", " 4 Liberton Park", password1, "michaelknight@gmail.com", "Michael");
     customers.add(customer1);
     Customer customer2 = new Customer("Willie Sanders", " 25 Rose Crescent", password2, "williesanders@gmail.com", "Willie");
     customers.add(customer2);
     Customer customer3 = new Customer("John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
     customers.add(customer3);
     Customer customer4 = new Customer("Richard Mouse", " 7 Lasswade", password4, "richarmouse@gmail.com", "Richard");
     customers.add(customer4);
     Customer customer5 = new Customer("David Horse", " 3 Newington Road", password5, "davidhorse@gmail.com", "David");
     customers.add(customer5);



     Account accountS1 = new Account(1234, Account.TypeAccount.SAVINGS, customer1);
     accounts.add(accountS1);
     Account accountS2 = new Account(1235, Account.TypeAccount.SAVINGS, customer2);
     accounts.add(accountS2);
     Account accountS3 = new Account(1236, Account.TypeAccount.SAVINGS, customer3);
     accounts.add(accountS3);
     Account accountS4 = new Account(1237, Account.TypeAccount.SAVINGS, customer4);
     accounts.add(accountS4);
     Account accountS5 = new Account(1238, Account.TypeAccount.SAVINGS, customer5);
     accounts.add(accountS5);

     Account accountM1 = new Account(2234, Account.TypeAccount.MARKET, customer1);
     accounts.add(accountM1);
     Account accountM2 = new Account(2235, Account.TypeAccount.MARKET, customer2);
     accounts.add(accountM2);
     Account accountM3 = new Account(2236, Account.TypeAccount.MARKET, customer3);
     accounts.add(accountM3);
     Account accountM4 = new Account(2237, Account.TypeAccount.MARKET, customer4);
     accounts.add(accountM4);
     Account accountM5 = new Account(2238, Account.TypeAccount.MARKET, customer5);
     accounts.add(accountM5);


     Account accountB1 = new Account(3234, Account.TypeAccount.BROKERAGE, customer1);
     accounts.add(accountB1);
     Account accountB2 = new Account(3235, Account.TypeAccount.BROKERAGE, customer2);
     accounts.add(accountB2);
     Account accountB3 = new Account(3236, Account.TypeAccount.BROKERAGE, customer3);
     accounts.add(accountB3);
     Account accountB4 = new Account(3237, Account.TypeAccount.BROKERAGE, customer4);
     accounts.add(accountB4);
     Account accountB5 = new Account(3238, Account.TypeAccount.BROKERAGE, customer5);
     accounts.add(accountB5);

 }
}
