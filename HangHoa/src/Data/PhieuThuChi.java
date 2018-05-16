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
public class PhieuThuChi {
    private String MaPC;
    private Date NgayChi;
    private float SoTienChi;
    private int type;
    private String MSKH;

    /**
     * @return the MaPC
     */
    public String getMaPC() {
        return MaPC;
    }

    /**
     * @param MaPC the MaPC to set
     */
    public void setMaPC(String MaPC) {
        this.MaPC = MaPC;
    }

    /**
     * @return the NgayChi
     */
    public Date getNgayChi() {
        return NgayChi;
    }

    /**
     * @param NgayChi the NgayChi to set
     */
    public void setNgayChi(Date NgayChi) {
        this.NgayChi = NgayChi;
    }

    /**
     * @return the SoTienChi
     */
    public float getSoTienChi() {
        return SoTienChi;
    }

    /**
     * @param SoTienChi the SoTienChi to set
     */
    public void setSoTienChi(float SoTienChi) {
        this.SoTienChi = SoTienChi;
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
    
}
