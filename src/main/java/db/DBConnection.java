package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
private static DBConnection instance;
private List<Customer>connection;

    private DBConnection() {
        connection=new ArrayList<>();
    }
    public List<Customer> getConnection(){
        return connection;
    }

    public static DBConnection getInstance() {
        return null==instance?instance=new DBConnection():instance;
    }

    public Customer findCustomerById(String id) {
        for (Customer customer : connection) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null; // Return null if no customer is found
    }
}
