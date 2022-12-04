package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class basvuruformController {
	public basvuruformController() {
		baglanti=VeritabaniUtil.baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea adres;

    @FXML
    private TextField adsoyad;

    @FXML
    private TextField bolum;

    @FXML
    private ComboBox<String> cinsiyet;

    @FXML
    private TextField dil;

    @FXML
    private DatePicker dt;

    @FXML
    private Button ekle1;

    @FXML
    private Button ekle2;

    @FXML
    private TextField firma1;

    @FXML
    private TextField firma2;

    @FXML
    private ToggleButton gonder;

    @FXML
    private ComboBox<String> kan;

    @FXML
    private TextField kurum;
    @FXML
    private ImageView img1;
    @FXML
    private AnchorPane pane1;



    @FXML
    private TextField mail;

    @FXML
    private DatePicker mt;

    @FXML
    private TextField poz1;

    @FXML
    private TextField poz2;

    @FXML
    private TextField pozisyon;

    @FXML
    private TextField ref1;

    @FXML
    private TextField ref2;

    @FXML
    private TextField reftel1;

    @FXML
    private TextField reftel2;

    @FXML
    private TextField tc;

    @FXML
    private TextField tel;
    int k=0; int l=0;
    @FXML
    void ekle1_Click(ActionEvent event) {
    	
    	if(k==0)
    	{
    	firma2.setVisible(true);
        poz2.setVisible(true);
        ekle1.setText("-");
        k=1;
    	}
    	else 
    	{
    		firma2.setVisible(false);
            poz2.setVisible(false);
            ekle1.setText("+");
            k=0;
    	}
    }

    @FXML
    void ekle2_Click(ActionEvent event) {
    	if(l==0)
    	{
    	ref2.setVisible(true);
        reftel2.setVisible(true);
        ekle2.setText("-");
        l=1;
    	}
    	else 
    	{
    		reftel2.setVisible(false);
            ref2.setVisible(false);
            ekle2.setText("+");
            l=0;
    	}
    }
    Connection baglanti=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    @FXML
    void gonder_Click(ActionEvent event) {
    	sql="insert into tbl_basvuru(basvurutarihi,ad,telno,adres,eposta,tc,cinsiyet,dogumtarihi,kan,okul,bolum,yil,yabancidil,firma,pozisyon,firma2,pozisyon2,ref1ad,ref1no,ref2ad,ref2no,tercihpozisyon) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	if(pozisyon.getText()=="" || adsoyad.getText()=="" || tel.getText()=="" || mail.getText()=="" || adres.getText()=="" || tc.getText()=="" || cinsiyet.getSelectionModel().getSelectedItem()==null || kan.getSelectionModel().getSelectedItem()==null )
    	{
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setHeaderText("Zorunlu alanlar boþ geçilemez!");
    	alert.showAndWait();
    		
    	}
    	else
    	{
    	try {
    		LocalDate date = LocalDate.now();
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,date.toString() );
    		sorgu.setString(2, adsoyad.getText());
    		sorgu.setString(3, tel.getText());
    		sorgu.setString(4, mail.getText());
    		sorgu.setString(5, adres.getText());
    		sorgu.setString(6, tc.getText());
    		sorgu.setString(7, cinsiyet.getSelectionModel().getSelectedItem());
    		sorgu.setString(8, dt.getValue().toString());
    		sorgu.setString(9, kan.getSelectionModel().getSelectedItem());
    		sorgu.setString(10, kurum.getText());
    		sorgu.setString(11, bolum.getText());
    		sorgu.setString(12, mt.getValue().toString());
    		sorgu.setString(13, dil.getText());
    		sorgu.setString(14, firma1.getText());
    		sorgu.setString(15, poz1.getText());
    		sorgu.setString(16, firma2.getText());
    		sorgu.setString(17, poz2.getText());
    		sorgu.setString(18, ref1.getText());
    		sorgu.setString(19, reftel1.getText());
    		sorgu.setString(20, ref2.getText());
    		sorgu.setString(21, reftel2.getText());
    		sorgu.setString(22, pozisyon.getText());
    		sorgu.executeUpdate();
    		
    		img1.setVisible(true);
    		FadeTransition fadein=new FadeTransition(Duration.seconds(1.5),img1);
            fadein.setFromValue(0.0);
            fadein.setToValue(0.80);
            fadein.play();
            
            FadeTransition fadeout=new FadeTransition(Duration.seconds(1.5),pane1);
            fadeout.setFromValue(1.0);
            fadeout.setToValue(0.2);
            fadeout.play();
    		
            Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information");
    		alert.setHeaderText(null);
    		alert.setContentText("Ýþleminiz Baþarýyla Gerçekleþtirildi!");
    		alert.showAndWait();
    		gonder.setVisible(false);
    	} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}	
    		
    		
    	}

    }

    @FXML
    void initialize() {
    	img1.setVisible(false);
    	firma2.setVisible(false);
        poz2.setVisible(false);
    	ref2.setVisible(false);
    	reftel2.setVisible(false);
    	
    	cinsiyet.getItems().add("Erkek");
    	cinsiyet.getItems().add("Kadin");
    	
    	kan.getItems().add("A rh+");
    	kan.getItems().add("A rh-");
    	kan.getItems().add("B rh+");
    	kan.getItems().add("A rh-");
    	kan.getItems().add("AB rh+");
    	kan.getItems().add("AB rh-");
    	kan.getItems().add("0 rh+");
    	kan.getItems().add("0 rh-");
    	
    	FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),pane1);
        fadein.setFromValue(0.07);
        fadein.setToValue(1.0);
        fadein.play();
    	
    }

}
