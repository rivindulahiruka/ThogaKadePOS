package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import model.Customer;

public class SearchCustomerFormController {

    public JFXTextField txtNotFound;
    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private JFXTextField txtxSearchId;

    @FXML
    void btnSearchOnAction(ActionEvent event) {

        String customerId = txtxSearchId.getText();
        Customer customer = DBConnection.getInstance().findCustomerById(customerId);
        if (customer != null) {
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtNumber.setText(customer.getNumber());
            dateDOB.setValue(customer.getDob());

        } else {
            txtNotFound.setText("Customer Not Found");

        }

    }
}
