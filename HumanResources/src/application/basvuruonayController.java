package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;


import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class basvuruonayController {
	 public static int sayi;
	public basvuruonayController() {
		
		connection=VeritabaniUtil.baglan();
		 
		
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
    private TextField cinsiyet;

    @FXML
    private TextField dil;

    @FXML
    private TextField dt;

    @FXML
    private TextField firma1;

    @FXML
    private TextField firma2;

    @FXML
    private ImageView img1;

    @FXML
    private TextField kan;

    @FXML
    private TextField kurum;

    @FXML
    private TextField mail;

    @FXML
    private TextField mezuntarihi;

    @FXML
    private ToggleButton onayla;

    @FXML
    private AnchorPane pane1;

    @FXML
    private TextField poz1;

    @FXML
    private TextField poz2;

    @FXML
    private TextField pozisyon;

    @FXML
    private ToggleButton reddet;

    @FXML
    private TextField ref1;

    @FXML
    private TextField ref2;

    @FXML
    private TextField reftel1;

    @FXML
    private TextField reftel2;
    @FXML
    private ComboBox<Integer> combo1;
    


    @FXML
    private TextField tc;

    @FXML
    private TextField tel;
    public void ekle() {
    	sql="insert into tbl_uyeler(id,sifre,admin,tc,adsoyad,pozisyon,tel,email,dogumtarihi) values(?,?,?,?,?,?,?,?,?)";
    	try {	
    		Random rastgele = new Random();
    		sayi = 100000 + rastgele.nextInt(899999);
    		sorgu=connection.prepareStatement(sql);
    		sorgu.setInt(1, sayi);
    		sorgu.setInt(2, 1234);
    		sorgu.setInt(3, 0);
    		sorgu.setString(4, tc.getText().trim());
    		sorgu.setString(5, adsoyad.getText());
    		sorgu.setString(6, pozisyon.getText());
    		sorgu.setString(7, tel.getText().trim());
    		sorgu.setString(8, mail.getText().trim());
    		sorgu.setString(9, dt.getText().trim());
    		sorgu.executeUpdate();
    		
    	
		} catch (Exception e) {
		
		}
    	
    	
    }

    @FXML
    void onayla_Click(ActionEvent event) {
    	ekle();
    	
    	sql="insert into tbl_login(kullanici_adi,sifre,admin,adsoyad) values (?,?,?,?)";
    	try {
    		sorgu=connection.prepareStatement(sql);
    		sorgu.setInt(1, sayi);
    		sorgu.setInt(2, 1234);
    		sorgu.setInt(3, 0);
			sorgu.setString(4, adsoyad.getText());
			sorgu.executeUpdate();
			String d="Kullanýcý adý : "+sayi+"  Þifre : 1234 ";
			alert(d);
			
			
		} catch (Exception e) {
	
		}
    	basvuruSil();
    }
    public void alert(String metin)
    {
    	Alert alert1 = new Alert(AlertType.INFORMATION);
  		alert1.setTitle("Information");
  		alert1.setHeaderText(null);
  		alert1.setContentText(metin);
  		alert1.showAndWait();
    	
    }
    public void basvuruSil() {
sql="delete from tbl_basvuru where basvuruno=?;";
		
    	
    		try {
    			sorgu = connection.prepareStatement(sql);
    			sorgu.setInt(1,Integer.parseInt(selectedItem.toString()));
    			sorgu.executeUpdate();
    			
    			alert("Ýþleminiz Baþarýyla Gerçekleþtirildi");
          		
          		adsoyad.setText("");
        		tel.setText("");
        		mail.setText("");
        		adres.setText("");
        		tc.setText("");
        		cinsiyet.setText("");
        		kan.setText("");
        		dt.setText("");
        		kurum.setText("");
        		bolum.setText("");
        		mezuntarihi.setText("");
        		dil.setText("");
        		firma1.setText("");
        		poz1.setText("");
        		firma2.setText("");
        		poz2.setText("");
        		ref1.setText("");
        		reftel1.setText("");
        		ref2.setText("");
        		reftel2.setText("");
        		pozisyon.setText("");
        		combo1.getItems().remove(selectedItem);
    		} catch (Exception e1) {
    			
    	
    		}

    }
    
    @FXML
    void reddet_Click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Kontrol");
    	alert.setHeaderText("Baþvuruyu reddetmek üzeresiniz.Devam etmek istiyor musunuz?");
    	ButtonType btn1=new ButtonType("Evet");
    	ButtonType btn2=new ButtonType("Hayýr");
    	alert.getButtonTypes().setAll(btn1, btn2);
    	Optional<ButtonType> sonuc= alert.showAndWait();
    	if(sonuc.get()==btn1) {
    	basvuruSil();
    	}
    	else if(sonuc.get()==btn2) {
    		
    	}
    	else {};
    	
    	
    }
    Connection connection=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
    void getData(int basvuruNo) {
    	sql = "SELECT * FROM tbl_basvuru where basvuruno = ?";
    	try {
    		sorgu = connection.prepareStatement(sql);
        	sorgu.setInt(1, basvuruNo);
        	
        	getirilen = sorgu.executeQuery();
        	
        	
        	if (getirilen.next()) {
        		adsoyad.setText(getirilen.getString("ad"));
        		tel.setText(getirilen.getString("telno"));
        		mail.setText(getirilen.getString("eposta"));
        		adres.setText(getirilen.getString("adres"));
        		tc.setText(getirilen.getString("tc"));
        		cinsiyet.setText(getirilen.getString("cinsiyet"));
        		kan.setText(getirilen.getString("kan"));
        		dt.setText(getirilen.getString("dogumtarihi"));
        		kurum.setText(getirilen.getString("okul"));
        		bolum.setText(getirilen.getString("bolum"));
        		mezuntarihi.setText(getirilen.getString("yil"));
        		dil.setText(getirilen.getString("yabancidil"));
        		firma1.setText(getirilen.getString("firma"));
        		poz1.setText(getirilen.getString("pozisyon"));
        		firma2.setText(getirilen.getString("firma2"));
        		poz2.setText(getirilen.getString("pozisyon2"));
        		ref1.setText(getirilen.getString("ref1ad"));
        		reftel1.setText(getirilen.getString("ref1no"));
        		ref2.setText(getirilen.getString("ref2ad"));
        		reftel2.setText(getirilen.getString("ref2no"));
        		pozisyon.setText(getirilen.getString("tercihpozisyon"));

        		
        	}
		} catch (Exception e) {
		
		}
    	
    }
    Object selectedItem;
    @FXML
    void initialize() 
    	 {
    	FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),pane1);
        fadein.setFromValue(0.07);
        fadein.setToValue(1.0);
        fadein.play();
	    	String sql = "SELECT basvuruno FROM tbl_basvuru";
	    	try {
	    		PreparedStatement sorgu = connection.prepareStatement(sql);        	
	        	ResultSet getirilen = sorgu.executeQuery();   	
	        	while (getirilen.next()) {
	        		combo1.getItems().add(getirilen.getInt("basvuruno"));
	        		System.out.println(getirilen.getInt("basvuruno"));
	        	}
			} catch (Exception e) {
			
			}
	    	// Listener
	    	combo1.setOnAction((event) -> {
	    	    int selectedIndex = combo1.getSelectionModel().getSelectedIndex();
	    	     selectedItem = combo1.getSelectionModel().getSelectedItem();
	    	    

	    	    getData(Integer.parseInt(selectedItem.toString()));
	    	});
	    	
    	 }
}