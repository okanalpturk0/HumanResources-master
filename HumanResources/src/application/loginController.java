package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;
import javafx.util.Duration;

public class loginController {
	public static int userid;
	public static String userad;
	public static int sifre;
	public loginController() {
		baglanti1=VeritabaniUtil.baglan();
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton admin;

    @FXML
    private AnchorPane pane1;

    @FXML
    private Button tbn_login;

    @FXML
    private TextField txt_id;
    @FXML
    private AnchorPane pane2;

    @FXML
    private TextField txt_pw;
    @FXML
    private Label lbl1;
    @FXML
    private ImageView img1;

    @FXML
    private RadioButton user;
    
    Connection baglanti1=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql1;
    

    @FXML
    void tbn_loginClick(ActionEvent event) {
    	Alert alert=new Alert(AlertType.ERROR);
        alert.setHeaderText("Giris Bilgileri Hatalý");
        
    	
    	sql1="select * from tbl_login where kullanici_adi=? and sifre=? and admin=?";
    	try {
    		
    		
    		if(admin.isSelected())
    		{	
    			sorgu=baglanti1.prepareStatement(sql1);
        		sorgu.setString(1, txt_id.getText().trim());
        		sorgu.setString(2, txt_pw.getText().trim());
    			sorgu.setString(3, "1");
    			ResultSet getirilen= sorgu.executeQuery();
    			if(!getirilen.next())
        		{ alert.showAndWait(); txt_pw.setText(""); }
        		else {
        			userid=getirilen.getInt(1);
        			userad=getirilen.getString("adsoyad");
        			sifre=getirilen.getInt("sifre");
        			try {
        	    		Stage stage=new Stage();
        	        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("adminpanel.fxml"));
        	        	Scene scene1=new Scene(paneadmin,600,650);
        	        	stage.setScene(scene1);
        	        	stage.show();
        	        	
        				
        			} catch (Exception e) {
        				System.out.println(e.getMessage().toString());
        			}
        			
        			
        			
        		FadeTransition fadein=new FadeTransition(Duration.seconds(2.0),img1);
                fadein.setFromValue(0.17);
                fadein.setToValue(0.9);
                fadein.play();}
    		}
    			else if(user.isSelected())
    			{sorgu=baglanti1.prepareStatement(sql1);
        		sorgu.setString(1, txt_id.getText().trim());
        		sorgu.setString(2, txt_pw.getText().trim());
    			sorgu.setString(3, "0");
    			ResultSet getirilen= sorgu.executeQuery();
    			if(!getirilen.next())
        		{ alert.showAndWait();txt_pw.setText(""); }
        		else {
        			userid=getirilen.getInt(1);
        			userad=getirilen.getString("adsoyad");
        			sifre=getirilen.getInt("sifre");
        			try {
        	    		Stage stage=new Stage();
        	        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("userpanel.fxml"));
        	        	Scene scene1=new Scene(paneadmin,600,650);
        	        	stage.setScene(scene1);
        	        	stage.show();
        	        	
        				
        			} catch (Exception e) {
        				System.out.println(e.getMessage().toString());
        			}
        			
        		
        		
        		FadeTransition fadein=new FadeTransition(Duration.seconds(2.0),img1);
                fadein.setFromValue(0.17);
                fadein.setToValue(0.9);
                fadein.play();
        		
        						}
    				
    			}

    	
    	} catch (Exception e) {
    		System.out.println(e.getMessage().toString());
			
		}

    }

    @FXML
    void initialize() {
    	
    	
    	img1.setPreserveRatio(true);
    	img1.fitWidthProperty().bind(pane1.widthProperty());
    	img1.fitHeightProperty().bind(pane1.heightProperty());

    	ToggleGroup grup1 = new ToggleGroup();
        admin.setToggleGroup(grup1);
        user.setToggleGroup(grup1);
        user.setSelected(true);
        
        FadeTransition fadeout=new FadeTransition(Duration.seconds(2.7),img1);
        fadeout.setFromValue(0.9);
        fadeout.setToValue(0.17);
        fadeout.play();
        
        FadeTransition fadein=new FadeTransition(Duration.seconds(3.4),pane2);
        fadein.setFromValue(0.0);
        fadein.setToValue(1.0);
        fadein.play();
 
        
    }
    
}
