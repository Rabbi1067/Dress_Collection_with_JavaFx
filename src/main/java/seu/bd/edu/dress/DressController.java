package seu.bd.edu.dress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DressController implements Initializable {
/*
    public static String    name1 = "";
    public static String type1= "";
    public static String size1 = "";
    public static String color1 = "";
    public static String details1 = "";
    public static String price1 = "";
    public static String   purchas1 = "";
    public static String quantity1 = "";
    public static String discount1 = "";
    public static String customer1 = "";
    public static String boosting1 = "";*/


    @FXML
    public  CheckBox boostingCheckBox;

    @FXML
    public ColorPicker colorField;

    @FXML
    public Label customerLabel;

    @FXML
    public ToggleGroup customerToggle;

    @FXML
    public TextArea detailsField;

    @FXML
    public Label detailsLabel;

    @FXML
    public PasswordField discountField;

    @FXML
    public Label discountLabel;

    @FXML
    public TextField nameField;

    @FXML
    public Label nameLabel;

    @FXML
    public Slider priceField;

    @FXML
    public Label priceLabel;

    @FXML
    public DatePicker purchaseField;

    @FXML
    public Label purchaseLabel;

    @FXML
    public Spinner<Integer> quantityField;

    @FXML
    public Label quantityLabel;

    @FXML
    private Label saveLabel;

    @FXML
    public ComboBox<String> sizeField;

    @FXML
    public Label sizeLabel;

    @FXML
    public ChoiceBox<String> typeField;

    @FXML
    public Label typeLabel;

    @FXML
    public Label colorLabel;

    @FXML
    public Label priceValueLabel;

    @FXML
    public ImageView uploadImageView;

    @FXML
    public Button uploadButton;

    @FXML
    public Label imageErrorLabel;

    public File selectedFile;
    public static ObservableList<Dress> dressList = FXCollections.observableArrayList();


    // ✅ Image Upload Handler
    @FXML
    void handleUpload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        selectedFile = fileChooser.showOpenDialog(null);
        //or
        /*
     Get current stage
    Stage stage = (Stage) uploadButton.getScene().getWindow();

     Open file chooser with stage
    selectedFile = fileChooser.showOpenDialog(stage);
         */

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            uploadImageView.setImage(image);
            imageErrorLabel.setText("");
        }
    }

    //Image Validation
    boolean validateImage() {
        if (selectedFile == null) {
            imageErrorLabel.setText("Picture is required");
            imageErrorLabel.setStyle("-fx-text-fill: red;");
            return false;
        }
        return true;
    }




    @FXML
    public void saveEvent(ActionEvent event) {

        // ----- Input Validation -----
        boolean valid = true;

        if (nameField.getText().trim().isEmpty()) {
            nameLabel.setText("Dress name is required.");
            nameLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            nameLabel.setText("");
        }

        if (typeField.getValue() == null) {
            typeLabel.setText("Dress type is required.");
            typeLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            typeLabel.setText("");
        }

        if (sizeField.getValue() == null) {
            sizeLabel.setText("Available size is required.");
            sizeLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            sizeLabel.setText("");
        }

        if (colorField.getValue() == null) {
            colorLabel.setText("Dress Color is required.");
            colorLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            colorLabel.setText("");
        }

        double priceValue = priceField.getValue();
        if (priceValue < 500 || priceValue > 5000) {
            priceLabel.setText("Price must be between 500 and 5000.");
            priceLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            priceLabel.setText("");

        }

        if (detailsField.getText().length() > 50) {
            detailsLabel.setText("Only 50 characters is allowed.");
            detailsLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            detailsLabel.setText("");
        }

        if (purchaseField.getValue() == null || purchaseField.getValue().isAfter(LocalDate.now())) {
            purchaseLabel.setText("Date can't be future date.");
            purchaseLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            purchaseLabel.setText("");
        }

        if (quantityField.getValue() <= 0) {
            quantityLabel.setText("Quantity can't be less than zero.");
            quantityLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            quantityLabel.setText("");
        }

        if (discountField.getText().trim().isEmpty()) {
            discountLabel.setText("Discount code required.");
            discountLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            discountLabel.setText("");
        }

        if (customerToggle.getSelectedToggle() == null) {
            customerLabel.setText("Targeted customer is required.");
            customerLabel.setStyle("-fx-text-fill: red;");
            valid = false;
        } else {
            customerLabel.setText("");
        }

        if (!validateImage()) valid = false;
        if (!valid) {
            saveLabel.setText("Please correct the errors.");
            saveLabel.setStyle("-fx-text-fill: red;");
            return;
        } else {
            saveLabel.setText("All inputs are valid!");
            saveLabel.setStyle("-fx-text-fill: green;");
        }

            String name = nameField.getText();
            String type = typeField.getValue();
            String size = sizeField.getValue();
            String color = colorField.getValue().toString();
            int price = (int) priceField.getValue();
            String details = detailsField.getText();
            String purchaseDate = purchaseField.getValue().toString();
            int quantity = quantityField.getValue();
            String discount = discountField.getText();
            RadioButton selectedCustomer = (RadioButton) customerToggle.getSelectedToggle();
            String customer = selectedCustomer.getText();
            String boosting = (boostingCheckBox.isSelected() ? "Yes" : "No");
            String imagePath = selectedFile.getAbsolutePath();

        /*name1=name;
        type1=type;
        size1=size;
        color1=color;
        price1 = String.valueOf(price);
        details1= details;
        purchas1= purchaseDate;
        quantity1 = String.valueOf(quantity);
        discount1=discount;
        customer1=customer;
        boosting1= boosting;*/


        // ----- Create Dress object and add to list  -----
        Dress dress = new Dress(name, type, size, color, price, details, purchaseDate, quantity, discount, customer, boosting, imagePath);
        dressList.add(dress);

        // // ----- Dress Information save txt file  -----
        try {
            RandomAccessFile raf = new RandomAccessFile("dress.txt", "rw");
            raf.seek(raf.length());
                raf.writeBytes(name + "," +
                        type + "," +
                        size + "," +
                        color + "," +
                        price + "," +
                        details + "," +
                        purchaseDate + "," +
                        quantity + "," +
                        discount + "," +
                        customer + "," +
                        boosting +","+
                        imagePath + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }

        // ----- Successful Message -----
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Dress Information Saved Successfully!");
        alert.showAndWait();

        }

        // // ----- ChangeScene  -----
        @FXML
    public void showList(ActionEvent event) {

            HelloApplication.changeScene("dressCollection.fxml");
    }

    // ----- ComboBox data upload  -----

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> types = FXCollections.observableArrayList("Hoodie", "Sweater", "T-Shirt", "Jacket", "Jeans", "Shorts", "Shirt", "Skirt");
        typeField.setItems(types);

        ObservableList<String> sizes = FXCollections.observableArrayList("Small", "Medium", "Large");
        sizeField.setItems(sizes);

        quantityField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 0));


        priceField.valueProperty().addListener((obs, oldVal, newVal) -> {
            priceValueLabel.setText("Price: " + newVal.intValue() + " BDT");
            priceValueLabel.setStyle("-fx-text-fill: green;");
        });


    }
}
