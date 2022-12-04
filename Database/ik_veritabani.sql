-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 03 Haz 2022, 13:58:34
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `ik_veritabani`
--
CREATE DATABASE IF NOT EXISTS `ik_veritabani` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ik_veritabani`;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_basvuru`
--

CREATE TABLE `tbl_basvuru` (
  `basvuruno` int(11) NOT NULL,
  `basvurutarihi` varchar(50) DEFAULT NULL,
  `ad` varchar(50) NOT NULL,
  `telno` varchar(20) NOT NULL,
  `adres` varchar(500) NOT NULL,
  `eposta` varchar(50) NOT NULL,
  `tc` varchar(50) NOT NULL,
  `cinsiyet` varchar(20) NOT NULL,
  `dogumtarihi` varchar(50) NOT NULL,
  `kan` varchar(20) NOT NULL,
  `okul` varchar(50) DEFAULT NULL,
  `bolum` varchar(50) DEFAULT NULL,
  `yil` varchar(50) DEFAULT NULL,
  `yabancidil` varchar(50) DEFAULT NULL,
  `firma` varchar(50) DEFAULT NULL,
  `pozisyon` varchar(50) DEFAULT NULL,
  `firma2` varchar(50) DEFAULT NULL,
  `pozisyon2` varchar(50) DEFAULT NULL,
  `ref1ad` varchar(50) DEFAULT NULL,
  `ref1no` varchar(50) DEFAULT NULL,
  `ref2ad` varchar(50) DEFAULT NULL,
  `ref2no` varchar(50) DEFAULT NULL,
  `tercihpozisyon` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_izin`
--

CREATE TABLE `tbl_izin` (
  `id` int(11) NOT NULL,
  `tarih` varchar(50) NOT NULL,
  `baslangic` varchar(50) NOT NULL,
  `bitis` varchar(50) NOT NULL,
  `aciklama` varchar(500) NOT NULL,
  `gonderenid` int(11) NOT NULL,
  `gonderenad` varchar(50) NOT NULL,
  `onaydurumu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_izin`
--

INSERT INTO `tbl_izin` (`id`, `tarih`, `baslangic`, `bitis`, `aciklama`, `gonderenid`, `gonderenad`, `onaydurumu`) VALUES
(1, '2022-05-31', '2022-05-13', '2022-05-20', 'gerekce1', 123456, 'Okan ALPTÜRK', 'REDDEDİLDİ');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_login`
--

CREATE TABLE `tbl_login` (
  `kullanici_adi` int(11) NOT NULL,
  `sifre` int(11) NOT NULL,
  `admin` int(11) NOT NULL,
  `adsoyad` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_login`
--

INSERT INTO `tbl_login` (`kullanici_adi`, `sifre`, `admin`, `adsoyad`) VALUES
(123456, 1234, 1, 'Okan ALPTÜRK'),
(654321, 1234, 0, 'Müslüm Gürses'),
(987654, 1234, 0, 'Zeki Müren'),
(987321, 1234, 0, 'Ferdi Tayfur'),
(493571, 1234, 0, 'Yildiz Tilbe');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_mesaj`
--

CREATE TABLE `tbl_mesaj` (
  `tarih` varchar(50) NOT NULL,
  `gonderenid` int(11) NOT NULL,
  `gonderenad` varchar(50) NOT NULL,
  `aliciad` varchar(50) NOT NULL,
  `konu` varchar(50) NOT NULL,
  `ileti` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_mesaj`
--

INSERT INTO `tbl_mesaj` (`tarih`, `gonderenid`, `gonderenad`, `aliciad`, `konu`, `ileti`) VALUES
('2022-06-01', 123456, 'Okan ALPTÜRK', 'Müslüm Gürses', 'baslik1', 'ileti1'),
('2022-06-01', 123456, 'Okan ALPTÜRK', 'MEHMET bilkay', 'baslik1', 'ileti1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_prim`
--

CREATE TABLE `tbl_prim` (
  `id` int(11) NOT NULL,
  `tarih` varchar(50) NOT NULL,
  `primmiktari` int(11) NOT NULL,
  `onaydurumu` varchar(50) NOT NULL,
  `aciklama` varchar(500) NOT NULL,
  `gonderenid` int(11) NOT NULL,
  `gonderenad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_prim`
--

INSERT INTO `tbl_prim` (`id`, `tarih`, `primmiktari`, `onaydurumu`, `aciklama`, `gonderenid`, `gonderenad`) VALUES
(5, '07.07.2018', 5555, 'REDDEDİLDİ', 'gggg', 123456, 'Okan ALPTÜRK'),
(6, '2022-06-01', 15000, 'Onay Bekliyor', 'düğün masrafı', 123456, 'Okan ALPTÜRK'),
(7, '2022-06-02', 8999, 'REDDEDİLDİ', 'gerekce1', 456123, 'Okan 2');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_uyeler`
--

CREATE TABLE `tbl_uyeler` (
  `uyeno` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `sifre` int(11) NOT NULL,
  `admin` int(11) NOT NULL,
  `tc` varchar(50) NOT NULL,
  `adsoyad` varchar(50) NOT NULL,
  `pozisyon` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dogumtarihi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_uyeler`
--

INSERT INTO `tbl_uyeler` (`uyeno`, `id`, `sifre`, `admin`, `tc`, `adsoyad`, `pozisyon`, `tel`, `email`, `dogumtarihi`) VALUES
(1, 123456, 1234, 1, '12345678998', 'Okan ALPTÜRK', 'CEO', '5315555555', 'okan@mail.com', '07.07.2000'),
(3, 654321, 1234, 0, '12345678997', 'Müslüm Gürses', 'Danısman', '05654444444', 'muslum@mail.com', '01.01.1953'),
(14, 987654, 1234, 0, '12345678958', 'Zeki Müren', 'Sanat Günesi', '5389998877', 'zeki@mail.com', '06.12.1931'),
(15, 987321, 1234, 0, '45645678997', 'Ferdi Tayfur', 'Yazılım', '5452298877', 'ferdi@mail.com', '15.10.1945'),
(16, 493571, 1234, 0, '87345678934', 'Yildiz ', 'Danısman', '5529998877', 'yildiz@mail.com', '16.07.1966');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `tbl_basvuru`
--
ALTER TABLE `tbl_basvuru`
  ADD PRIMARY KEY (`basvuruno`);

--
-- Tablo için indeksler `tbl_izin`
--
ALTER TABLE `tbl_izin`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_prim`
--
ALTER TABLE `tbl_prim`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_uyeler`
--
ALTER TABLE `tbl_uyeler`
  ADD PRIMARY KEY (`uyeno`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `tbl_basvuru`
--
ALTER TABLE `tbl_basvuru`
  MODIFY `basvuruno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_izin`
--
ALTER TABLE `tbl_izin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_prim`
--
ALTER TABLE `tbl_prim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_uyeler`
--
ALTER TABLE `tbl_uyeler`
  MODIFY `uyeno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
