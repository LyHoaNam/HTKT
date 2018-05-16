/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Date;

/**
 *
 * @author cuhoa_000
 */
public class HoaDon {
    private String MaHD;
    private String ThueSuat;
    private Date NgayThanhToan;
    private String MSCH;
    private String MSKH;
    private String Soseri;
    private int type;
    private Date NgayTao;

    /**
     * @return the MaHD
     */
    public String getMaHD() {
        return MaHD;
    }

    /**
     * @param MaHD the MaHD to set
     */
    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    /**
     * @return the ThueSuat
     */
    public String getThueSuat() {
        return ThueSuat;
    }

    /**
     * @param ThueSuat the ThueSuat to set
     */
    public void setThueSuat(String ThueSuat) {
        this.ThueSuat = ThueSuat;
    }

    /**
     * @return the NgayThanhToan
     */
    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    /**
     * @param NgayThanhToan the NgayThanhToan to set
     */
    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    /**
     * @return the MSCH
     */
    public String getMSCH() {
        return MSCH;
    }

    /**
     * @param MSCH the MSCH to set
     */
    public void setMSCH(String MSCH) {
        this.MSCH = MSCH;
    }

    /**
     * @return the MSKH
     */
    public String getMSKH() {
        return MSKH;
    }

    /**
     * @param MSKH the MSKH to set
     */
    public void setMSKH(String MSKH) {
        this.MSKH = MSKH;
    }

    /**
     * @return the Soseri
     */
    public String getSoseri() {
        return Soseri;
    }

    /**
     * @param Soseri the Soseri to set
     */
    public void setSoseri(String Soseri) {
        this.Soseri = Soseri;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the NgayTao
     */
    public Date getNgayTao() {
        return NgayTao;
    }

    /**
     * @param NgayTao the NgayTao to set
     */
    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }
    
}
