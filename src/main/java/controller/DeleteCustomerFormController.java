package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.util.List;

public class DeleteCustomerFormController {

    public JFXTextField txtxSearchId;
    @FXML
    private JFXComboBox<?> cmdTitle;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String customerId=txtxSearchId.getText();
        Customer customer =  DBConnection.getInstance().findCustomerById(customerId);
            if (customer!=null){
                DBConnection.getInstance().getConnection().remove(customer);
            }
            clearFields();



    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String customerId=txtxSearchId.getText();
        Customer customer =  DBConnection.getInstance().findCustomerById(customerId);
        if (customer!=null){
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtNumber.setText(customer.getNumber());
            dateDOB.setValue(customer.getDob());

        } else {

            System.out.println("Customer not found");
        }

    }
    private void clearFields() {

        txtName.clear();
        txtAddress.clear();
        txtNumber.clear();
        dateDOB.setValue(null);

    }
}

