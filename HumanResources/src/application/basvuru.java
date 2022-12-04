package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class basvuru {
	Connection baglanti=null ;
	PreparedStatement sorgu=null;
	ResultSet getirilen=null;
	String sql;	
	
	int basvuruno;
	String basvurutarihi,ad,telno,adres,eposta,tc,cinsiyet,dogumtarihi,kan,okul,bolum,yil,yabancidil,firma,pozisyon,firma2,pozisyon2,ref1ad,ref1no,ref2ad,ref2no,tercihpozisyon;
	public basvuru(int basvuruno,
			String basvurutarihi, String ad, String telno, String adres, String eposta, String tc, String cinsiyet,
			String dogumtarihi, String kan, String okul, String bolum, String yil, String yabancidil, String firma,
			String pozisyon, String firma2, String pozisyon2, String ref1ad, String ref1no, String ref2ad,
			String ref2no, String tercihpozisyon) {
	
		this.basvuruno = basvuruno;
		this.basvurutarihi = basvurutarihi;
		this.ad = ad;
		this.telno = telno;
		this.adres = adres;
		this.eposta = eposta;
		this.tc = tc;
		this.cinsiyet = cinsiyet;
		this.dogumtarihi = dogumtarihi;
		this.kan = kan;
		this.okul = okul;
		this.bolum = bolum;
		this.yil = yil;
		this.yabancidil = yabancidil;
		this.firma = firma;
		this.pozisyon = pozisyon;
		this.firma2 = firma2;
		this.pozisyon2 = pozisyon2;
		this.ref1ad = ref1ad;
		this.ref1no = ref1no;
		this.ref2ad = ref2ad;
		this.ref2no = ref2no;
		this.tercihpozisyon = tercihpozisyon;
	}
	

	public int getBasvuruno() {
		return basvuruno;
	}
	public void setBasvuruno(int basvuruno) {
		this.basvuruno = basvuruno;
	}
	public String getBasvurutarihi() {
		return basvurutarihi;
	}
	public void setBasvurutarihi(String basvurutarihi) {
		this.basvurutarihi = basvurutarihi;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getDogumtarihi() {
		return dogumtarihi;
	}
	public void setDogumtarihi(String dogumtarihi) {
		this.dogumtarihi = dogumtarihi;
	}
	public String getKan() {
		return kan;
	}
	public void setKan(String kan) {
		this.kan = kan;
	}
	public String getOkul() {
		return okul;
	}
	public void setOkul(String okul) {
		this.okul = okul;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public String getYil() {
		return yil;
	}
	public void setYil(String yil) {
		this.yil = yil;
	}
	public String getYabancidil() {
		return yabancidil;
	}
	public void setYabancidil(String yabancidil) {
		this.yabancidil = yabancidil;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	public String getPozisyon() {
		return pozisyon;
	}
	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}
	public String getFirma2() {
		return firma2;
	}
	public void setFirma2(String firma2) {
		this.firma2 = firma2;
	}
	public String getPozisyon2() {
		return pozisyon2;
	}
	public void setPozisyon2(String pozisyon2) {
		this.pozisyon2 = pozisyon2;
	}
	public String getRef1ad() {
		return ref1ad;
	}
	public void setRef1ad(String ref1ad) {
		this.ref1ad = ref1ad;
	}
	public String getRef1no() {
		return ref1no;
	}
	public void setRef1no(String ref1no) {
		this.ref1no = ref1no;
	}
	public String getRef2ad() {
		return ref2ad;
	}
	public void setRef2ad(String ref2ad) {
		this.ref2ad = ref2ad;
	}
	public String getRef2no() {
		return ref2no;
	}
	public void setRef2no(String ref2no) {
		this.ref2no = ref2no;
	}
	public String getTercihpozisyon() {
		return tercihpozisyon;
	}
	public void setTercihpozisyon(String tercihpozisyon) {
		this.tercihpozisyon = tercihpozisyon;
	}
	
	
	
}
