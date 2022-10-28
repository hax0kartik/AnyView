package com.example.demo1.UI;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


class SidePane{
    private Label headerLabel;
    private Image logoImage;
    SidePane(){
        FileInputStream stream;
        try{
            stream = new FileInputStream("C:\\Users\\Kartik\\Desktop\\projects\\jp\\demo1\\src\\main\\resources\\address.png");
            logoImage = new Image(stream);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        ImageView imageView = new ImageView(logoImage);
        imageView.setFitWidth(20);
        imageView.setPreserveRatio(true);
        headerLabel = new Label("Address Book", imageView);
        headerLabel.setMinWidth(200);
        headerLabel.setTextAlignment(TextAlignment.CENTER);
        headerLabel.setAlignment(Pos.CENTER);
        headerLabel.setId("headerLabel");
    }

    public Label getHeaderLabel() {
        return headerLabel;
    }
}

class AddressBar{
    private TextField addressTextField;
    private HBox addressHBox;
    private GridPane addressGrid;
    private Button addressSignIn;
    private Image logoImage;

    AddressBar(){
        addressTextField = new TextField();
        addressTextField.setPromptText("Enter a vnc server address");
        addressTextField.setFocusTraversable(false);
        addressTextField.setPrefWidth(600);

        addressSignIn = new Button("Sign in..");
        addressSignIn.setGraphic(new FontIcon());
        addressSignIn.getStyleClass().add("account-button");

        FileInputStream stream;
        try{
            stream = new FileInputStream("C:\\Users\\Kartik\\Desktop\\projects\\jp\\demo1\\src\\main\\resources\\image.png");
            logoImage = new Image(stream);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        ImageView imageView = new ImageView(logoImage);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        addressHBox = new HBox(addressTextField, addressSignIn);
        addressHBox.setSpacing(10);
        addressGrid = new GridPane();
        addressGrid.setRowIndex(imageView, 0);
        addressGrid.setColumnIndex(imageView, 0);

        addressHBox.setStyle("-fx-padding: 8 0 0 0;");
        addressGrid.setRowIndex(addressHBox, 0);
        addressGrid.setColumnIndex(addressHBox, (int)imageView.getFitWidth());

        addressGrid.getChildren().addAll(imageView, addressHBox);
    }

    public HBox getAddressHBox() {
        return addressHBox;
    }

    public TextField getAddressTextField() {
        return addressTextField;
    }

    public GridPane getAddressGrid() {
        return addressGrid;
    }

    public Button getAddressSignIn() {
        return addressSignIn;
    }
}

class MainSection{
    private StackPane pane;
    private VBox vBox;
    private ImageView imageView;
    private Image deviceImage;

    MainSection(){
        FileInputStream stream;
        try{
            stream = new FileInputStream("C:\\Users\\Kartik\\Desktop\\projects\\jp\\demo1\\src\\main\\resources\\device.png");
            deviceImage = new Image(stream);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        imageView = new ImageView(deviceImage);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        Label label1 = new Label("There are no devices in your address book.");
        Label label2 = new Label("Enter the VNC server address or hostname in the search bar to connect to a device.");
        vBox = new VBox(imageView, label1, label2);
        vBox.setAlignment(Pos.CENTER);
        pane = new StackPane(vBox);
        pane.setStyle("-fx-padding: -8 0 0 -200;");
    }

    public StackPane getPane() {
        return pane;
    }
}

public class MainScreenComponents {
    private MenuBar menuBar;
    private AddressBar addressBar;
    private MainSection mainSection;
    private SidePane sidePane;
    private Menu menu[];
    final private String menustring[] = {"File", "View", "About"};

    MenuBar getMenubar(){
        return menuBar;
    }

    AddressBar getAddressBar(){
        if(addressBar == null){
            addressBar = new AddressBar();
        }
        return addressBar;
    }

    public MainSection getMainSection() {
        if(mainSection == null){
            mainSection = new MainSection();
        }
        return mainSection;
    }

    public SidePane getSidePane() {
        if(sidePane == null){
            sidePane = new SidePane();
        }
        return sidePane;
    }

    public void initializeMenuBar() {
        menu = new Menu[3];
        for (int i = 0; i < 3; i++) {
            menu[i] = new Menu(menustring[i]);
            menu[i].getStyleClass().add("menuitem");
        }

        /* Create menubar and attach menu components */
        menuBar = new MenuBar();
        menuBar.getStyleClass().add("menubar");

        menuBar.getMenus().addAll(menu[0], menu[1], menu[2]);

        /* Create menuitems for the "File" Menu */
        MenuItem f_menuitems[] = new MenuItem[3];
        SeparatorMenuItem f_menusitems[] = new SeparatorMenuItem[2];

        for (int i = 0; i < f_menusitems.length; i++) {
            f_menusitems[i] = new SeparatorMenuItem();
        }
        f_menuitems[0] = new MenuItem("New connection..");
        f_menuitems[1] = new MenuItem("Preferences");
        f_menuitems[2] = new MenuItem("Exit");
        menu[0].getItems().add(f_menuitems[0]);
        menu[0].getItems().add(f_menusitems[0]);
        menu[0].getItems().add(f_menuitems[1]);
        menu[0].getItems().add(f_menusitems[1]);
        menu[0].getItems().add(f_menuitems[2]);

        /* Create components for the "View" Menu */
        MenuItem v_menuitems[] = new MenuItem[2];
        SeparatorMenuItem v_menusitems[] = new SeparatorMenuItem[2];
        for (int i = 0; i < v_menusitems.length; i++) {
            v_menusitems[i] = new SeparatorMenuItem();
        }

        v_menuitems[0] = new MenuItem("Icons");
        v_menuitems[1] = new MenuItem("Details");
        RadioMenuItem v_menuitems_sidebarbutton = new RadioMenuItem("Sidebar");

        ToggleGroup grp = new ToggleGroup();
        grp.getToggles().add(v_menuitems_sidebarbutton);
        menu[1].getItems().add(v_menuitems[0]);
        menu[1].getItems().add(v_menusitems[0]);
        menu[1].getItems().add(v_menuitems[1]);
        menu[1].getItems().add(v_menusitems[1]);
        menu[1].getItems().add(v_menuitems_sidebarbutton);
    }
}
