package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class primController {
	Connection baglanti=null ;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
public primController() {
	baglanti=VeritabaniUtil.baglan();
}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private AnchorPane pane1;

    @FXML
    private TextField txt1;

    @FXML
    private TextArea txt2;

    @FXML
    void btn1_Click(ActionEvent event) {
    	sql="insert into tbl_prim(tarih,primmiktari,onaydurumu,aciklama,gonderenid,gonderenad) values(?,?,?,?,?,?)";
    	try {
    		LocalDate date = LocalDate.now();
    		sorgu=baglanti.prepareStatement(sql);
			sorgu.setString(1, date.toString());
			sorgu.setInt(2, Integer.parseInt(txt1.getText()));
			sorgu.setString(3, "Onay Bekliyor");
			sorgu.setString(4, txt2.getText());
			sorgu.setInt(5,loginController.userid);
			sorgu.setString(6, loginController.userad);
			sorgu.executeUpdate();
			
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information");
    		alert.setHeaderText(null);
    		alert.setContentText("Talebiniz Baþarýyla Ýletildi!");
    		alert.showAndWait();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void initialize() {
    	FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),pane1);
        fadein.setFromValue(0.07);
        fadein.setToValue(1.0);
        fadein.play();

    }

}
