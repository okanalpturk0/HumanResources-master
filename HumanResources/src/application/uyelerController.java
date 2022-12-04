package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.MySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

import java.sql.*;

public class uyelerController {       
	public uyelerController()
	{
		baglanti=VeritabaniUtil.baglan();
		
		
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
   
    @FXML
    private TableColumn<kayitlar, String> ad;

    @FXML
    private TableColumn<kayitlar, Integer> admin;

    @FXML
    private TableColumn<kayitlar, String> dt;

    @FXML
    private TableColumn<kayitlar, Integer> id;

    @FXML
    private TableColumn<kayitlar, String> mail;

    @FXML
    private TableColumn<kayitlar, Integer> no;

    @FXML
    private TableColumn<kayitlar, String> pozisyon;

    @FXML
    private TableColumn<kayitlar, Integer> pw;

    @FXML
    public TableView<kayitlar> table1;
    
    @FXML
    private TableColumn<kayitlar, String> tc;
    @FXML
    private TableColumn<kayitlar, Button> delete;
    @FXML
    private TableColumn<kayitlar, Button> update;

    @FXML
    private TableColumn<kayitlar, String> telefon;

    @FXML
    private TextField txt1;

    @FXML
    void txt1_Changes(KeyEvent event) {
    String	sql1="select * from tbl_uyeler where adsoyad like '%"+txt1.getText()+"%'";
    	doldur(table1,sql1);
    }
    
    @FXML
    private AnchorPane pane1;


    
    Connection baglanti=null ;
    PreparedStatement sorgu=null;
    static ResultSet getirilen=null;
    public static int indis;
    public static ObservableList<kayitlar> kayitlarliste;

    public void doldur(TableView tablo,String sql) 
    {	//sql="select * from tbl_uyeler";
    	
    	kayitlarliste = FXCollections.observableArrayList();
    	try {
    		
        	sorgu=baglanti.prepareStatement(sql);
    		getirilen =sorgu.executeQuery();
    		while(getirilen.next())
    		{
    			kayitlarliste.add(new kayitlar(getirilen.getInt("uyeno"),getirilen.getInt("id"),getirilen.getInt("sifre"),getirilen.getInt("admin"),getirilen.getString("tc"),getirilen.getString("adsoyad"),getirilen.getString("pozisyon"),getirilen.getString("tel"),getirilen.getString("email"),getirilen.getString("dogumtarihi"),new Button("update"),new Button ("delete")));
    		}
    		no.setCellValueFactory(new PropertyValueFactory<>("no"));
    		id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		pw.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		admin.setCellValueFactory(new PropertyValueFactory<>("admin"));
    		tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
    		ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
    		pozisyon.setCellValueFactory(new PropertyValueFactory<>("pozisyon"));
    		telefon.setCellValueFactory(new PropertyValueFactory<>("tel"));
    		mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    		dt.setCellValueFactory(new PropertyValueFactory<>("dt"));
    		update.setCellValueFactory(new PropertyValueFactory<>("update"));
    		delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
    		table1.setItems(kayitlarliste);
		
    	} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    	
    	
    }
    
    private void editableCols()
    {
    	id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    	id.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
    	});
    	pw.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    	pw.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setSifre(e.getNewValue());
    	});
    	
    	admin.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    	admin.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setAdmin(e.getNewValue());
    	});
    	
    	tc.setCellFactory(TextFieldTableCell.forTableColumn());
    	tc.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setTc(e.getNewValue());
    	});
    	
    	ad.setCellFactory(TextFieldTableCell.forTableColumn());
    	ad.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setAd(e.getNewValue());
    	});
    	pozisyon.setCellFactory(TextFieldTableCell.forTableColumn());
    	pozisyon.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setPozisyon(e.getNewValue());
    	});
    	telefon.setCellFactory(TextFieldTableCell.forTableColumn());
    	telefon.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setTel(e.getNewValue());
    	});
    	mail.setCellFactory(TextFieldTableCell.forTableColumn());
    	mail.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setMail(e.getNewValue());
    	});
    	
    	dt.setCellFactory(TextFieldTableCell.forTableColumn());
    	dt.setOnEditCommit(e-> {
    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setDt(e.getNewValue());
    	});
    	table1.setEditable(true);
    }
    
    @FXML
    void initialize() {
    	
    	
    	doldur(table1,"select * from tbl_uyeler");
    	editableCols();
    	table1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    	    if (newSelection != null) {
    	    	indis = table1.getSelectionModel().getSelectedIndex();
    	    }
    	});
    	FadeTransition fadein=new FadeTransition(Duration.seconds(1.4),pane1);
        fadein.setFromValue(0.07);
        fadein.setToValue(1.0);
        fadein.play();
       
    }
    
}
