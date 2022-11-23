package com.example.demo;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editInfoSceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String username;
    private String password;
    private String data,data2;
    private String[] idPassword;

    @FXML
    private Label usernameLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private Button addPhoto;
    @FXML
    private TextField newUsernameTextField;
    @FXML
    private TextField oldPasswordTextField;
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private ImageView userPhoto;

    final FileChooser fileChooser = new FileChooser();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        addPhoto.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        setExtFilters(fileChooser);
                        File file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                            openNewImageWindow(file);
                        }
                    }
                });
    }
    public void getData(String u){
        username = u;
        usernameLabel.setText(u);
        try {
            Image image = new Image(getClass().getResourceAsStream("photo/" + username + ".png")); // + string name;
            userPhoto.setImage(image);
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public boolean checkSpace(String t){
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==' '){
                return true;
            }
        }
        return false;
    }

    public void setData(){
        try{
            data = "";
            FileReader r = new FileReader("src/main/dataBase/id_password.txt");
            int tmp;
            while((tmp=r.read())!=-1) {
                data += (char)tmp;
            }
            r.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try{
            data2 = "";
            FileReader r = new FileReader("src/main/dataBase/data.txt");
            int tmp;
            while((tmp=r.read())!=-1) {
                data2 += (char)tmp;
            }
            r.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean isUsernameUsed(){
        idPassword = data.split("[\\r\\n]+");
        for(int i=0;i<idPassword.length;i++) {
            String[] t = idPassword[i].split(" ");
            if(!t[0].equals(username)&&t[0].equals(newUsernameTextField.getText())){
                return true;
            }
            else if(t[0].equals(username)){
                password = t[1];
            }
        }
        return false;
    }

    public void editUser2(){
        String newData ="";
        String[] dat = data2.split("[\\r\\n]+");
        for(int i=0;i< dat.length;i++){
            String[] t = dat[i].split(" ");
            if(!t[0].equals(username)) {
                newData+=dat[i];
            }
            else{
                newData+=newUsernameTextField.getText()+" "+t[1]+" "+t[2]+" "+t[3]+" "+t[4]+" "+t[5]+" "+t[6]+" "+t[7];
            }
            if(i!=dat.length-1){
                newData+="\n";
            }
        }

        try{
            FileWriter w = new FileWriter("src/main/dataBase/data.txt");
            w.write(newData);
            w.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        username = newUsernameTextField.getText();
    }

    public void editUser(){
        String newData ="";
        for(int i=0;i< idPassword.length;i++){
            String[] t = idPassword[i].split(" ");
            if(!t[0].equals(username)) {
                newData+=idPassword[i];
            }
            else{
                newData+=newUsernameTextField.getText()+" "+newPasswordTextField.getText();
            }
            if(i!=idPassword.length-1){
                newData+="\n";
            }
        }

        try{
            FileWriter w = new FileWriter("src/main/dataBase/id_password.txt");
            w.write(newData);
            w.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        if(!username.equals(newUsernameTextField.getText())){
            editUser2();
        }
    }

    public void finishButtonAction(ActionEvent event) throws  java.io.IOException{
        setData();
        if(isUsernameUsed()){
            errorLabel.setText("Username is used.");
        }
        else if(!password.equals(oldPasswordTextField.getText())){
            errorLabel.setText("Password Incorrect.");
        }
        else if(newUsernameTextField.getText()==""||oldPasswordTextField.getText()==""||
                newPasswordTextField.getText()==""|| confirmPasswordTextField.getText()=="") {
            errorLabel.setText("Missing requirement.");
        }
        else if(!confirmPasswordTextField.getText().equals(newPasswordTextField.getText())){
            errorLabel.setText("Password not match.");
        }
        else if(checkSpace(newUsernameTextField.getText())||checkSpace(newPasswordTextField.getText())||checkSpace(confirmPasswordTextField.getText())){
            errorLabel.setText("Space(\" \") is banned.");
        }
        else{
            editUser();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("info.fxml"));
            root = loader.load();

            infoSceneController info = loader.getController();
            info.getData(username);
            info.loadContent();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void cancelButtonAction(ActionEvent event) throws java.io.IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("info.fxml"));
        root = loader.load();

        infoSceneController info = loader.getController();
        info.getData(username);
        info.loadContent();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void setExtFilters(FileChooser chooser){
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    private void openNewImageWindow(File file){
        Stage secondStage = new Stage();

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItem_Save = new MenuItem("Save Image");
        menuFile.getItems().addAll(menuItem_Save);
        menuBar.getMenus().addAll(menuFile);

        Label name = new Label(file.getAbsolutePath());
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();

        menuItem_Save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Image");

                File file = fileChooser.showSaveDialog(secondStage);
                if (file != null) {
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(imageView.getImage(),
                                null), "png", file);
                    } catch (IOException ex) {
                        Logger.getLogger(
                                registerSceneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 10, 0, 10));
        vbox.getChildren().addAll(name, imageView);

        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setImage(image);
        imageView.setSmooth(true);
        imageView.setCache(true);

        Scene scene = new Scene(new VBox(), 400, 350);
        ((VBox)scene.getRoot()).getChildren().addAll(menuBar, vbox);

        secondStage.setTitle(file.getName());
        secondStage.setScene(scene);
        secondStage.show();
    }
}
