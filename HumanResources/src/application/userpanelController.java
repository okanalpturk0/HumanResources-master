package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class userpanelController {
	public userpanelController() {
		baglanti1=VeritabaniUtil.baglan();
		
	}
	Connection baglanti1=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql1;
	 
	  @FXML
	    private Button sifreguncelle;

	@FXML
	    private Button mailguncelle;
	@FXML
	 private ImageView cikis;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView basvuruOlustur;

    @FXML
    private ImageView basvurular;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView izin;

    @FXML
    private Label lbl_user;

    @FXML
    private ImageView menu;


    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane panemenu;

    @FXML
    private ImageView prim;

    @FXML
    private ImageView taleplerim;

    @FXML
    void basvuruOlustur_Click(MouseEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("basvuruform.fxml"));
        	Scene scene1=new Scene(paneadmin,809,911);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void basvurular_Click(MouseEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("basvuruonay.fxml"));
        	Scene scene1=new Scene(paneadmin,809,911);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void izin_Click(MouseEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("izin.fxml"));
        	Scene scene1=new Scene(paneadmin,333,432);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }
    @FXML
    void mailguncelle_Click(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("mailguncelle.fxml"));
        	Scene scene1=new Scene(paneadmin,389,275);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }
    @FXML
    void sifreguncelle_Click(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("guncelle.fxml"));
        	Scene scene1=new Scene(paneadmin,389,275);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }
    

    @FXML
    void cikis_Click(MouseEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Kontrol");
    	alert.setHeaderText("Uygulamayý kapatmak üzeresiniz.Devam etmek istiyor musunuz?");
    	ButtonType btn1=new ButtonType("Evet");
    	ButtonType btn2=new ButtonType("Hayýr");
    	alert.getButtonTypes().setAll(btn1, btn2);
    	Optional<ButtonType> sonuc= alert.showAndWait();
    	if(sonuc.get()==btn1) {
    		javafx.application.Platform.exit();
    	}
    	else if(sonuc.get()==btn2) {
    		
    	}
    	else {};
    	
    	
    } 
    	
    int sayi=1;
    @FXML
    void menu_Click(MouseEvent event) {
    	
    	if(sayi==1)
    	{	
    	TranslateTransition translate=new TranslateTransition();
        translate.setNode(pane2);
        translate.setDuration(Duration.millis(500));
        translate.setByX(130);
        translate.play();
        
    		
    		panemenu.setVisible(true);
    		FadeTransition fadein=new FadeTransition(Duration.seconds(0.3),panemenu);
            fadein.setFromValue(0.0);
            fadein.setToValue(0.60);
            fadein.play();
            
            FadeTransition fadeout=new FadeTransition(Duration.seconds(0.3),pane2);
            fadeout.setFromValue(1.0);
            fadeout.setToValue(0.17);
            fadeout.play();
            
            sayi=0;
            
    		
    	}
    	else {
    		TranslateTransition translate=new TranslateTransition();
            translate.setNode(pane2);
            translate.setDuration(Duration.millis(500));
            translate.setByX(-130);
            translate.play();
            
    		FadeTransition fadein=new FadeTransition(Duration.seconds(0.3),pane2);
            fadein.setFromValue(0.17);
            fadein.setToValue(1.0);
            fadein.play();
            
            FadeTransition fadeout=new FadeTransition(Duration.seconds(0.3),panemenu);
            fadeout.setFromValue(0.60);
            fadeout.setToValue(0.0);
            fadeout.play();
            
    		sayi=1;
    		
    	}
    	
    	
    }



    @FXML
    void prim_Click(MouseEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("prim.fxml"));
        	Scene scene1=new Scene(paneadmin,333,432);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void taleplerim_Click(MouseEvent event) {
    	try {
    		Stage stage=new Stage();
        	AnchorPane paneadmin=(AnchorPane) FXMLLoader.load(getClass().getResource("taleplerim.fxml"));
        	Scene scene1=new Scene(paneadmin,555,380);
        	stage.setScene(scene1);
        	stage.show();
        	
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void taleplistesi_Click(MouseEvent event) {

    }

    @FXML
    void uyeler_Click(MouseEvent event) {

    }

    @FXML
    void initialize() {
    	lbl_user.setText(loginController.userad);
    	panemenu.setVisible(false);
    	FadeTransition fadein=new FadeTransition(Duration.seconds(3.0),pane2);
        fadein.setFromValue(0.0);
        fadein.setToValue(1.0);
        fadein.play();

    	lbl_user.setText(loginController.userad);
    	
    	sql1="select kullanici_adi from tbl_login where kullanici_id=123456";
    	panemenu.setVisible(false);
    	

    }

}
