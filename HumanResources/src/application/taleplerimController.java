package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class taleplerimController {
	Connection connection=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    
public taleplerimController() {
	connection=VeritabaniUtil.baglan();
}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label aciklama;

    @FXML
    private Label aciklama2;

    @FXML
    private Label baslangic;

    @FXML
    private Label bitis;

    @FXML
    private ComboBox<Integer> combo1;

    @FXML
    private RadioButton izin;

    @FXML
    private Label kisi;

    @FXML
    private Label kisi2;

    @FXML
    private Label miktar;

    @FXML
    private Label onaydurumu;

    @FXML
    private Label onaydurumu2;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane_izin;

    @FXML
    private AnchorPane pane_prim;

    @FXML
    private RadioButton prim;

    @FXML
    private Label tarih;

    @FXML
    private Label tarih2;
    void izinGetir()
    {
    	String sqll="select tarih,baslangic,bitis,aciklama,gonderenad,onaydurumu from tbl_izin where id=?";
    	try {
    		sorgu = connection.prepareStatement(sqll);
    		sorgu.setInt(1, Integer.parseInt(selectedItem.toString()));
    		getirilen = sorgu.executeQuery();
    		if (getirilen.next()) {
    			tarih2.setText(getirilen.getString("tarih"));
    			baslangic.setText(getirilen.getString("baslangic"));
    			bitis.setText(getirilen.getString("bitis"));
    			aciklama2.setText(getirilen.getString("aciklama"));
    			kisi2.setText(getirilen.getString("gonderenad"));
    			onaydurumu2.setText(getirilen.getString("onaydurumu"));
    			
    			
    		}
    		
    		
		} catch (Exception e) {
		
		}
    }
    void primGetir()
    {
    	String sqll="select tarih,primmiktari,onaydurumu,aciklama,gonderenad from tbl_prim where id=?";
    	try {
    		sorgu = connection.prepareStatement(sqll);
    		sorgu.setInt(1, Integer.parseInt(selectedItem.toString()));
    		getirilen = sorgu.executeQuery();
    		if (getirilen.next()) {
    			tarih.setText(getirilen.getString("tarih"));
    			miktar.setText(getirilen.getString("primmiktari"));
    			aciklama.setText(getirilen.getString("aciklama"));
    			kisi.setText(getirilen.getString("gonderenad"));
    			onaydurumu.setText(getirilen.getString("onaydurumu"));
    			
    			
    		}
    		
    		
		} catch (Exception e) {
		
		}
    }
    @FXML
    void izin_selected(ActionEvent event) {
    	pane_prim.setVisible(false);
    	pane_izin.setVisible(true);
    	combo1.getItems().clear();
    	ekle("select id from tbl_izin where gonderenid=?",loginController.userid);
    }
    public void ekle(String sql,int id)
    {
    	try {
    		PreparedStatement sorgu = connection.prepareStatement(sql);        	
        	sorgu.setInt(1, loginController.userid);
    		ResultSet getirilen = sorgu.executeQuery();   	
        	while (getirilen.next()) {
        		combo1.getItems().add(getirilen.getInt("id"));
        	}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    	
    }
    @FXML
    void onayla_izinClick(ActionEvent event) {

    }

    @FXML
    void onayla_primClick(ActionEvent event) {

    }

    @FXML
    void prim_selected(ActionEvent event) {
    	pane_izin.setVisible(false);
    	pane_prim.setVisible(true);
    	combo1.getItems().clear();
    	ekle("select id from tbl_prim where gonderenid=?",loginController.userid);
    }

    @FXML
    void reddet_izinClick(ActionEvent event) {
    	
       
    }

    @FXML
    void reddet_primClick(ActionEvent event) {

    }
    Object selectedItem;
    @FXML
    void initialize() {
    	FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),pane1);
        fadein.setFromValue(0.07);
        fadein.setToValue(1.0);
        fadein.play();
    	combo1.setOnAction((event) -> {
    	    int selectedIndex = combo1.getSelectionModel().getSelectedIndex();
    	     selectedItem = combo1.getSelectionModel().getSelectedItem();
    	     if(prim.isSelected()) 
    	     {
    	    	 primGetir();
    	     }
    	     else if(izin.isSelected()){
    	    	 izinGetir();
    	    	 }
    	});
    	
    	ToggleGroup tg = new ToggleGroup();
    	izin.setToggleGroup(tg);
    	prim.setToggleGroup(tg);
    	
    		
    }

}
