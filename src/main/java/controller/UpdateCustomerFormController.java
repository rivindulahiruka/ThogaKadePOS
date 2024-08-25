package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpdateCustomerFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNotFound;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private JFXTextField txtxSearchId;

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

           txtNotFound.setText("Customer Not Found");
        }

    }

    public void btnUpdateCustomerOnAction(ActionEvent actionEvent) {

        String customerId = txtxSearchId.getText();
        Customer customer = DBConnection.getInstance().findCustomerById(customerId);

        if (customer!=null){
            String newTitle = (String) cmbTitle.getValue();
            String newName = txtName.getText();
            String newAddress = txtAddress.getText();
            String newNumber = txtNumber.getText();
            LocalDate newDob = dateDOB.getValue();

            customer.setName(newTitle+""+newName);
            customer.setAddress(newAddress);
            customer.setNumber(newNumber);
            customer.setDob(newDob);


        }
        txtNotFound.setText("Customer Update Succesfully");
    }
    private void clearFields() {

        txtName.clear();
        txtAddress.clear();
        txtNumber.clear();
        dateDOB.setValue(null);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr.");
        titles.add("Mrs.");

        cmbTitle.setItems(titles);
    }
}
