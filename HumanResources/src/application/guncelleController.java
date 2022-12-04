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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class guncelleController {

	Connection connection=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
public guncelleController() {
	connection=VeritabaniUtil.baglan();
}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button guncelle;

    @FXML
    private ImageView img1;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private AnchorPane pane1;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    void guncelle_Click(ActionEvent event) {
    	if(Integer.parseInt(txt1.getText().trim())==loginController.sifre)
    	{
    		if(Integer.parseInt(txt2.getText().trim())==Integer.parseInt(txt3.getText().trim()))
    		{
    			
    			sql="update tbl_login set sifre=? where kullanici_adi=?";
    			try {
    				sorgu = connection.prepareStatement(sql); 
    				sorgu.setInt(1,Integer.parseInt(txt2.getText().trim()) );
    	    		sorgu.setInt(2, loginController.userid);
    	    		sorgu.executeUpdate();
    				Alert alert1 = new Alert(AlertType.INFORMATION);
    	      		alert1.setTitle("Information");
    	      		alert1.setHeaderText(null);
    	      		alert1.setContentText("Ýþleminiz Baþarýyla Gerçekleþtirildi!");
    	      		alert1.showAndWait();
    	      		img1.setVisible(true);
    	      		FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),img1);
    	            fadein.setFromValue(0.07);
    	            fadein.setToValue(0.8);
    	            fadein.play();

					} 
    			catch (Exception e) {
					System.out.println(e.getMessage().toString());
				}
    			
    		
    		}
    		else {alert("Yeni Þifreler Uyuþmuyor!");}
    		
    	}
    	else { 
    		alert("Eski Þifre Hatalý!");
    	}
    	
    }
    public void alert(String mesaj)
    {
    	Alert alert1=new Alert(AlertType.ERROR);
        alert1.setHeaderText(mesaj);
        alert1.showAndWait();
    }

    @FXML
    void initialize() {
    	FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),pane1);
        fadein.setFromValue(0.07);
        fadein.setToValue(1.0);
        fadein.play();
        
    }

}
