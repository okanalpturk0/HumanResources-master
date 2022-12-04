package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.MySQL.Util.VeritabaniUtil;

import javafx.scene.control.Button;

public class kayitlar {
	Connection baglanti=null ;
	PreparedStatement sorgu=null;
	ResultSet getirilen=null;
	String sql;

	
	
	int no,id,sifre,admin;
	String tc,ad,pozisyon,tel,mail,dt;
	public Button update_;
	public Button delete_;
	

	
	public kayitlar(int no, int id, int sifre, int admin, String tc, String ad, String pozisyon, String tel,
			String mail, String dt, Button update_, Button delete_) {
		//super();
		this.no = no;
		this.id = id;
		this.sifre = sifre;
		this.admin = admin;
		this.tc = tc;
		this.ad = ad;
		this.pozisyon = pozisyon;
		this.tel = tel;
		this.mail = mail;
		this.dt = dt;
		this.update_ = update_;
		this.delete_ = delete_;
		baglanti=VeritabaniUtil.baglan();
		update_.setOnAction(e->{
			sql="update tbl_uyeler set id=?,sifre=?,admin=?,tc=?,adsoyad=?,pozisyon=?,tel=?,email=?,dogumtarihi=? where uyeno=?;";

			try {
				
				sorgu = baglanti.prepareStatement(sql);
				for (kayitlar kayit:uyelerController.kayitlarliste)
				{
				if(kayit.getUpdate()==update_)	
					{
						sorgu.setInt(1, kayit.getId());
						sorgu.setInt(2, kayit.getSifre());
						sorgu.setInt(3, kayit.getAdmin());
						sorgu.setString(4, kayit.getTc());
						sorgu.setString(5, kayit.getAd());
						sorgu.setString(6, kayit.getPozisyon());
						sorgu.setString(7, kayit.getTel());
						sorgu.setString(8, kayit.getMail());
						sorgu.setString(9, kayit.getDt());			
						sorgu.setInt(10, kayit.getNo());
						
					}
				}
				sorgu.executeUpdate();
			} catch (Exception e1) {
				
			}
		});
		
		delete_.setOnAction(e->{
			sql="delete from tbl_uyeler where uyeno=?;";
			sorgu=null;
				try {
					for (kayitlar kayit:uyelerController.kayitlarliste)
					{
						if(kayit.getDelete()==delete_)	
						{
							sorgu = baglanti.prepareStatement(sql);
							sorgu.setInt(1, kayit.getNo());
							
							uyelerController.kayitlarliste.remove(uyelerController.indis);
						}
					}
					sorgu.executeUpdate();
					
					
				} catch (Exception e1) {

				}
		});
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSifre() {
		return sifre;
	}
	public void setSifre(int sifre) {
		this.sifre = sifre;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getPozisyon() {
		return pozisyon;
	}
	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public Button getUpdate() {
		return update_;
	}
	public void setUpdate(Button update) {
		this.update_ = update;
	}
	public Button getDelete() {
		return delete_;
	}
	public void setDelete(Button delete) {
		this.delete_ = delete;
	}
	
	
	

}
