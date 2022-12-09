create database QUANLYBANGIAY
drop database QUANLYBANGIAY
go
use QUANLYBANGIAY
IF OBJECT_ID('ChucVu') is not null
drop table ChucVu
go
create table ChucVu(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL 
)
IF OBJECT_ID('NhanVien') is not null
drop table NhanVien
go
create table NhanVien(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	HoTen NVARCHAR(30) DEFAULT NULL,
	NgayTao DATE DEFAULT NULL,
	NgaySua DATE DEFAULT NULL,
	Email varchar(50) DEFAULT NULL,
	CCCD VARCHAR(12) DEFAULT NULL,
	Sdt VARCHAR(30) DEFAULT NULL,
	MatKhau VARCHAR(MAX) DEFAULT NULL,
	IdCV UNIQUEIDENTIFIER,
	TrangThai INT DEFAULT 1
)
IF OBJECT_ID('SanPham') is not null
drop table SanPham
go
create table SanPham(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaSP VARCHAR(20) UNIQUE,
	TenSP NVARCHAR(50) DEFAULT NULL ,
	NgayTao DATE DEFAULT NULL,
	NgaySua DATE DEFAULT NULL,
	TrangThai INT DEFAULT 1
)
IF OBJECT_ID('MauSac') is not null
drop table MauSac
go
create table MauSac(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL
)
IF OBJECT_ID('KichThuoc') is not null
drop table KichThuoc
go
create table KichThuoc(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten INT DEFAULT NULL 
)
IF OBJECT_ID('ThuongHieu') is not null
drop table ThuongHieu
go
create table ThuongHieu(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL , 
)
IF OBJECT_ID('DeGiay') is not null
drop table DeGiay
go
create table DeGiay(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL , 
)
IF OBJECT_ID('NhaCungCap') is not null
drop table NhaCungCap
go
create table NhaCungCap(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL
)
IF OBJECT_ID('ChiTietSP') is not null
drop table ChiTietSP
go
create table ChiTietSP(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaChiTietSP VARCHAR(20) UNIQUE,
	IdMauSac UNIQUEIDENTIFIER,
	IdSP UNIQUEIDENTIFIER,
	IdNCC UNIQUEIDENTIFIER,
	IdThuongHieu UNIQUEIDENTIFIER,
	IdKichThuoc UNIQUEIDENTIFIER,
	IdDeGiay UNIQUEIDENTIFIER,
	NgayTao DATE DEFAULT NULL,
	NgaySua DATE DEFAULT NULL,
	Gia decimal(20,0) DEFAULT NULL,
	TrangThai INT DEFAULT 1,
	SoLuongTon INT Check (SoLuongTon>= 0)
)


IF OBJECT_ID('TrangThai') is not null
drop table TrangThai
go
create table TrangThai(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE, 
	TrangThai INT DEFAULT NULL,
	NgayTao DATE DEFAULT NULL,
	NgaySua DATE DEFAULT NULL
)
IF OBJECT_ID('KhachHang') is not null
drop table KhachHang
go
create table KhachHang(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	HoTen NVARCHAR(100) DEFAULT NULL,
	GioiTinh int DEFAULT NULL,
	NgaySinh DATE DEFAULT NULL,
	Sdt VARCHAR(20) DEFAULT NULL,
	DiaChi NVARCHAR(125) DEFAULT NULL,
	CapBac int DEFAULT NULL,
	NgayTao DATE DEFAULT NULL,
	NgaySua DATE DEFAULT NULL
)
IF OBJECT_ID('HoaDon') is not null
drop table HoaDon
go
create table HoaDon(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdKM UNIQUEIDENTIFIER,
	IdNhanVien UNIQUEIDENTIFIER,
	IdKhachHang UNIQUEIDENTIFIER,
	Ma VARCHAR(20) UNIQUE,
	LyDo NVARCHAR(100) DEFAULT NULL,
	NgayTao DATE DEFAULT NULL,
	NgayThanhToan DATE DEFAULT NULL,
	NgaySua DATE DEFAULT NULL,
	IdTrangThai UNIQUEIDENTIFIER,
	TienKhuyenMai decimal(20,0) DEFAULT NULL,
	TongTien decimal(20,0) DEFAULT NULL,
	TienTraLai decimal(20,0) DEFAULT NULL
)
IF OBJECT_ID('HoaDonChiTiet') is not null
drop table HoaDonChiTiet
go
create table HoaDonChiTiet(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdHoaDon UNIQUEIDENTIFIER,
	IdChiTietSP UNIQUEIDENTIFIER,
	MaSP VARCHAR(20) DEFAULT NULL,
	TenSP NVARCHAR(50) DEFAULT NULL,
	KichThuoc INT DEFAULT NULL,
	MauSac VARCHAR(20) DEFAULT NULL,
	SoLuong INT DEFAULT NULL,
	Gia decimal(20,0) DEFAULT NULL,
)

--Tạo quan hệ giữa các bảng
--TaiKhoan
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)

--ChiTietSP 
ALTER TABLE ChiTietSP ADD FOREIGN KEY (IdMauSac) REFERENCES MauSac(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY (IdSP) REFERENCES SanPham(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY (IdNCC) REFERENCES NhaCungCap(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY (IdThuongHieu) REFERENCES ThuongHieu(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY (IdKichThuoc) REFERENCES KichThuoc(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY (IdDeGiay) REFERENCES DeGiay(Id)

--HoaDon
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNhanVien) REFERENCES NhanVien(Id)
ALTER TABLE HoaDon ADD FOREIGN KEY (IdTrangThai) REFERENCES TrangThai(Id)
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKhachHang) REFERENCES KhachHang(Id)

--HoaDonChiTiet
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdHoaDon) REFERENCES HoaDon(Id)
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdChiTietSP) REFERENCES ChiTietSP(Id)

--Select all table
select * from ChucVu
select * from NhanVien
select * from HoaDon
select * from TrangThai
select * from HoaDonChiTiet
select * from ChiTietSP
select * from SanPham
select * from DeGiay
select * from MauSac
select * from KichThuoc
select * from ThuongHieu
select * from NhaCungCap
select * from TrangThai

delete from SanPham where id = 'A632085F-1C50-41C2-99D6-FC31847D6CC1'

update MauSac
set Ten = N'Xám'
where  id = '492F96FF-F4F9-4F56-9434-4843C310BBA1'
delete from MauSac where  id = 'D56AFEAE-911B-4483-B7F4-313B1CD64735'


--Insert Data table ChucVu
insert into ChucVu(Ma, Ten) values ('QL01',N'Quản lí')
insert into ChucVu(Ma, Ten) values ('NV02',N'Nhân viên')
--Insert Data table TaiKhoan
insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK01',N'Nguyen Tuan Anh', 'tuannt', '001203010152', '0987586804', 'ph27418', 'F8B43F90-66D0-4543-ABC3-721EAF3EF276', 1)

insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, NgayTao, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK02',N'Ngo Van Tuan', 'tuannv', GETDATE(), '001203010153', '0987586805', 'ph27467',
'CDB08D54-E194-4597-8D77-7E1B109C0F70', 1)
insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, NgayTao, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK03',N'Nguyen Thi Lan', 'lannt', GETDATE(), '001203010154', '0987586806', 'ph27594',
'D4F97F77-4A80-4B5F-9364-56372BDCF573', 1)
insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, NgayTao, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK04',N'Nguyen Tuan Anh', 'anhnt', GETDATE(), '001203010155', '0987586807', 'ph27418',
'D4F97F77-4A80-4B5F-9364-56372BDCF573', 1)
insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, NgayTao, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK05',N'Duong Quang Hao', 'haodq', GETDATE(), '001203010156', '0987586808', 'ph27423',
'D4F97F77-4A80-4B5F-9364-56372BDCF573', 1)
insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, NgayTao, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK06',N'Khuong Thi Phuong', 'phuongkt', GETDATE(), '001203010157', '0987586809', 'ph26630',
'D4F97F77-4A80-4B5F-9364-56372BDCF573', 1)
insert into TaiKhoan(Ma, HoTen, TenTaiKhoan, NgayTao, CCCD, Sdt, MatKhau, IdCV, TrangThai) 
values ('TK07',N'Do Quang Chien', 'chiendq', GETDATE(), '001203010158', '0987586810', 'ph25320',
'D4F97F77-4A80-4B5F-9364-56372BDCF573', 1)
--insert data table thuonghieu
insert into ThuongHieu(Ma, Ten) values ('TH01', 'Adidas')
insert into ThuongHieu(Ma, Ten) values ('TH02', 'Balenciaga')
insert into ThuongHieu(Ma, Ten) values ('TH03', 'Nike')
insert into ThuongHieu(Ma, Ten) values ('TH04', 'Converse')
--insert data table size
insert into KichThuoc( Ten) values (39)
insert into KichThuoc( Ten) values (40)
insert into KichThuoc( Ten) values (41)
insert into KichThuoc( Ten) values (42)
insert into KichThuoc( Ten) values (43)
--insert data table nhacungcap
insert into NhaCungCap(Ma, Ten, SDT, DiaChi) 
values  ('NCC01', 'Giay Nam Viet', '0987586804', 'Ha Noi')
insert into NhaCungCap(Ma, Ten, SDT, DiaChi) 
values  ('NCC02', 'Giay Pham Hung', '0987586805', 'Ha Noi')
insert into NhaCungCap(Ma, Ten, SDT, DiaChi) 
values  ('NCC03', 'Giay Mira', '0987586806', 'TP HCM')
--insert data table mausac
insert into MauSac(Ma, Ten) values ('MS01', 'Nau')
insert into MauSac(Ma, Ten) values ('MS02', 'Trang')
insert into MauSac(Ma, Ten) values ('MS03', 'Den')
insert into MauSac(Ma, Ten) values ('MS04', 'Xanh duong')
insert into MauSac(Ma, Ten) values ('MS05', 'Do')
--insert data table degiay
insert into DeGiay(Ma, Ten) values ('DG01', 'De cao')
insert into DeGiay(Ma, Ten) values ('DG02', 'De thap')
insert into DeGiay(Ma, Ten) values ('DG03', 'Cao co')
--insert data table sanPham
insert into SanPham(MaSP, TenSP, NgayTao, TrangThai) values ('SP1', 'Nike AF1','Nike AF1.jpg','C:\Users\nguye\Downloads\Nike AF1.jpg', GETDATE(), 1)
insert into SanPham(MaSP, TenSP, NgayTao, TrangThai) values ('SP2', 'Converse Caro','ConverseCaro.jpg','C:\Users\nguye\Downloads\ConverseCaro.jpg', GETDATE(), 1)
insert into SanPham(MaSP, TenSP, NgayTao, TrangThai) values ('SP03', 'Adidas Super Star','Adidas Super Star.jpg','C:\Users\nguye\Downloads\Adidas Super Star.jpg', GETDATE(), 1)
--insert data table chitietSp
insert into ChiTietSP(IdMauSac, IdSP, IdNCC, IdThuongHieu, IdSize, IdDeGiay, NgayTao, Gia, SoLuongTon, TrangThai) 
values ('492F96FF-F4F9-4F56-9434-4843C310BBA1', '95D59CEB-3245-473B-8CF1-3282FDF9507E',
'18D5D861-3AD4-4BCD-8C04-08CC3F7298E6','483CDFDD-185C-402F-970D-22D6DD7A9D9B', 
'EFB218A1-ED28-492E-8D48-AE777800A521', 'CDBCFB1A-1729-426E-85D1-A928FE7419AD', GETDATE(), 2000000, 100, 1) 
insert into ChiTietSP(IdMauSac, IdSP, IdNCC, IdThuongHieu, IdSize, IdDeGiay, NgayTao, Gia, SoLuongTon, TrangThai) 
values ('27FDA91D-CAF5-4A5B-A04B-6A73EEFAEF36', 'BC8F91F7-183B-4E79-BBB8-A364EE4D6D8D',
'6E813634-305E-426D-B21D-C49CB5174EEE','4D4CA4E3-E023-40CE-B3B7-1A7C6CACD08E', 
'3E73F947-AF11-4CEB-89E7-8656EB529A33', '55AEEC3F-060A-4B80-B5C7-F23B85E0BC42', GETDATE(), 2000000, 100, 1)
--insert data table trangthai
insert into TrangThai(Ma,TrangThai) values ('TT01',1)
insert into TrangThai(Ma,TrangThai) values ('TT02',0)
insert into TrangThai(Ma,TrangThai) values ('TT03',2)
--insert data table hoa don chi tiet
insert into HoaDonChiTiet(IdHoaDon, IdChiTietSP) 
values ('8B67E086-8C82-4BDB-8761-AFCB8B720A82','7F5FDB06-82C2-49EF-BF21-142F4D560F57')
delete from ChiTietSP where id = 'D5304142-BC2F-44F3-873F-315450FDFAA9'
select * from HoaDon
select * from HoaDonChiTiet
select * from TaiKhoan
select * from ChiTietSp
select * from MauSac
select * from TrangThai
select * from SanPham


ALTER TABLE hoadonchitiet  
DROP CONSTRAINT [FK__HoaDonChi__IdHoa__2FCF1A8A];   

delete from HoaDonChiTiet where id = 'E379B1E5-CACE-45B4-99D0-FB70A5451CA9'

UPDATE SanPham
SET MaSP = 'SP3'
where Id = '3BE567BA-5BAA-43BD-9D4F-3443D47E51CD'

delete from ChiTietSP where id = 'DB9FD66A-D4D0-4C25-90B6-DE2EF66CB30D'

SELECT Ma, NgayTao, IdTaiKhoan, IdTrangThai from HoaDon where IdTaiKhoan = '589ABB65-09D3-46A7-8256-0515A06EAA95'

insert into HoaDon(IdTaiKhoan,Ma,NgayTao,IdTrangThai) 
values('589ABB65-09D3-46A7-8256-0515A06EAA95','HD02',GETDATE(),'F397189B-D378-4E86-86CD-A6D3D5856790')

delete HoaDonChiTiet where Id = 'D4A619E4-4617-4877-903F-EA9C6CFCA4A9'


update HoaDon set IdTrangThai = 'A5519622-B222-4DD8-A5FE-0B1D19802EF2' where Ma = 'HD01'
select * from HoaDon
delete from HoaDon where Id ='B90A5F52-B94F-4C77-B781-152E28232B0D'

select * from ChiTietSP
update ChiTietSP set IdMauSac = '65D258C1-8756-4F1E-837B-6F0F9C84CFB5' where Id = '0545D187-7B8C-4726-869B-DE78D7EAC2D6'





