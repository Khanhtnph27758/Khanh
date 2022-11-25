
create database handDuAn1
GO

USE handDuAn1
GO


CREATE TABLE LoaiSp
(
	idLoaiSp INT IDENTITY(1,1) PRIMARY KEY,
	tenLoaiSp NVARCHAR(255) NOT NULL
)
GO


CREATE TABLE KichThuoc
(
	idKichThuoc INT IDENTITY(1,1) PRIMARY KEY,
	giaTriKichThuoc VARCHAR(255) NOT NULL,

)
GO


CREATE TABLE Mau
(
	idMau INT IDENTITY(1,1) PRIMARY KEY,
	tenMau NVARCHAR(255) NOT NULL,

)
GO


CREATE TABLE ChatLieu
(
	idChatLieu INT IDENTITY(1,1) PRIMARY KEY,
	tenChatLieu NVARCHAR(255) NOT NULL,
)
GO


CREATE TABLE NguoiDung
(
	idNguoiDung INT IDENTITY(1,1) PRIMARY KEY,
	ten NVARCHAR(255) NOT NULL,
	ngSinh DATE,
	gioiTinh BIT,
	sdt VARCHAR(15),
	email varchar(255),
	diaChi NVARCHAR(255),
	luong MONEY,
	vaiTro BIT,
	trangThai bit,
)
GO


CREATE TABLE KhachHang
(
	idKhachHang INT IDENTITY(1,1) PRIMARY KEY,
	ten NVARCHAR(255) NOT NULL,
	sdt VARCHAR(15) NOT NULL,
	gioiTinh BIT,
	diaChi NVARCHAR(255) NOT NULL,
)
GO
create table LoaiTaiKhoan(
		IdRole int primary key,
		NameRole varchar(100)
	);
insert into LoaiTaiKhoan values (0,'admin')
insert into LoaiTaiKhoan values (1,'nhan vien')
CREATE TABLE TaiKhoan
(
	TK varchar(100) primary key,
		MK varchar(100),
		Email nvarchar(100),
		ROLEACC int DEFAULT 1,
		constraint fk_role foreign key ( ROLEACC ) references LoaiTaiKhoan ( IdRole )
)
insert into TaiKhoan values ('admin','admin','admin@gmail.com',0)
GO


CREATE TABLE KhuyenMai
(
	idKhuyenMai INT IDENTITY(1,1) PRIMARY KEY,
	valueVoucher VARCHAR(255),
	giaTri DOUBLE PRECISION,
	ngayBatDau DATE,
	ngayKetThuc DATE,
	soLuong INT,
)
GO



CREATE TABLE HoaDon
(
	idHoaDon INT IDENTITY(1,1) PRIMARY KEY,
	idKhachHang INT NOT NULL,
	idNhanVien INT NOT NULL,
	idKhuyenMai INT,
	ngayTao DATE,
	trangThaiHoaDon BIT,
	trangThaiThanhToan BIT,
	FOREIGN KEY(idKhachHang) REFERENCES dbo.KhachHang(idKhachHang),
	FOREIGN KEY(idNhanVien) REFERENCES dbo.NguoiDung(idNguoiDung),
	FOREIGN KEY(idKhuyenMai) REFERENCES dbo.KhuyenMai(idKhuyenMai)

)
GO




CREATE TABLE ChiTietSanPham
(
	idCTSP INT IDENTITY(1,1) PRIMARY KEY, 
	idSp INT,
	idKichThuoc INT,
	idMau INT,
	idChatLieu INT,
	gia MONEY,
	sku VARCHAR(255),
	soLuong INT,
	trangThai bit,
	FOREIGN KEY(idKichThuoc) REFERENCES dbo.KichThuoc(idKichThuoc),
	FOREIGN KEY(idMau) REFERENCES dbo.Mau(idMau),
	FOREIGN KEY(idChatLieu) REFERENCES dbo.ChatLieu(idChatLieu)
)
GO


CREATE TABLE NhaCungCap
(
	idNhaCC INT IDENTITY(1,1) PRIMARY KEY,
	tenNhaCC NVARCHAR(255) NOT NULL,
	sdt VARCHAR(15) NOT NULL,
	diaChi NVARCHAR(255)
)
GO


CREATE TABLE chiTietHoaDon
(
	idHoaDon INT,
	idCTSP INT, 
	hoaDon INT,
	soLuong INT, 
	trangThai BIT,
	-- nhà cung cấp
	idNhaCC INT,
	PRIMARY KEY(idHoaDon, idCTSP),
	FOREIGN KEY(idHoaDon) REFERENCES dbo.HoaDon(idHoaDon),
	FOREIGN KEY(idCTSP) REFERENCES dbo.ChiTietSanPham(idCTSP),
	FOREIGN KEY(idNhaCC) REFERENCES dbo.NhaCungCap(idNhaCC),
	--FOREIGN KEY(detailsInvoice) REFERENCES dbo.detailsInvoice()
)
GO

CREATE TABLE SanPham
(
	idSp INT IDENTITY(1,1) PRIMARY KEY,
	idNhaCC INT NOT NULL,
	idLoaiSp INT NOT NULL,
	tenSp NVARCHAR(255) NOT NULL,
	moTa NVARCHAR(255),
	trangThai bit,
	FOREIGN KEY (idNhaCC) REFERENCES dbo.NhaCungCap(idNhaCC),
	FOREIGN KEY (idLoaiSp) REFERENCES dbo.LoaiSp(idLoaiSp)
)
GO

CREATE TABLE HinhAnhSp
(
	idHA INT IDENTITY(1,1) PRIMARY KEY,
	idCTSP INT,
	hinhAnh NVARCHAR(255) NOT NULL,
	FOREIGN KEY(idCTSP) REFERENCES dbo.ChiTietSanPham(idCTSP)
)

insert into Mau values (N'Vàng')
insert into Mau values (N'Đỏ')
insert into Mau values (N'Xanh')


insert into ChatLieu values (N'Vải bông')
insert into ChatLieu values (N'Coton')
insert into ChatLieu values (N'Len')


insert into KichThuoc values('S')
insert into KichThuoc values('32')
insert into KichThuoc values('XXL')

insert into NhaCungCap values('Adidas','','')
insert into NhaCungCap values('Nike','','')
insert into NhaCungCap values('Brand','','')

insert into LoaiSp values(N'Áo')
insert into LoaiSp values(N'Quần')



insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (1,2,N'Áo Khoác')
insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (2,1,N'Quần Jean')
insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (1,3,N'Áo Thun')
insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (1,1,N'Áo Sơ Mi')
insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (2,1,N'Quần Âu')



INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(1,1,1,1,700,21,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(2,3,2,3,2099,3,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(3,2,3,2,2200,5,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(4,3,2,1,209,2,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(4,1,1,1,1000,31,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(1,2,2,2,1000,31,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(5,1,3,3,600,11,0)
INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(5,2,2,2,8000,21,0)

INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong)values(5,2,2,2,8000,21)




select * from ChatLieu
select * from KichThuoc
select * from Mau

select * from LoaiSp
select * from SanPham
select * from ChiTietSanPham
-- insert into LoaiSp values(3,N'Giày')
-- insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (3,1,N'Giày Âu')
select D.*,P.tenSp,S.giaTriKichThuoc,C.tenMau,M.tenChatLieu,tenLoaiSp,gia from ChiTietSanPham D
              INNER JOIN KichThuoc S on D.idKichThuoc = S.idKichThuoc INNER JOIN ChatLieu M on M.idChatLieu = D.idChatLieu
                               INNER JOIN Mau C on C.idMau = D.idMau
                                INNER JOIN SanPham P on P.idSp = D.idSp
                               INNER JOIN LoaiSp L  on L.idLoaiSp = P.idLoaiSp  ORDER BY idCTSP Desc
							   


							  