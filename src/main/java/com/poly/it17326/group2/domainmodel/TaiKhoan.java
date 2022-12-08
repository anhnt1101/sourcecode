package com.poly.it17326.group2.domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// hocnvph2741
@Entity
@Table(name = "TaiKhoan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class TaiKhoan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "TenTaiKhoan")
    private String tenTaiKhoan;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgaySua")
    private String ngaySua;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private ChucVu chucVu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;
}
