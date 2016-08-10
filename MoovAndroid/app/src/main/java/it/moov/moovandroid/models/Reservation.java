package it.moov.moovandroid.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

@Generated("org.jsonschema2pojo")
public class Reservation {

    @SerializedName("DATE")
    @Expose
    private Long dATE;
    @SerializedName("LONGITUDE")
    @Expose
    private String lONGITUDE;
    @SerializedName("USERNAME")
    @Expose
    private String uSERNAME;
    @SerializedName("CARTYPE")
    @Expose
    private String cARTYPE;
    @SerializedName("LATITUDE")
    @Expose
    private String lATITUDE;

    /**
     * No args constructor for use in serialization
     */
    public Reservation() {
    }

    /**
     * @param cARTYPE
     * @param lATITUDE
     * @param uSERNAME
     * @param lONGITUDE
     * @param dATE
     */
    public Reservation(Long dATE, String lONGITUDE, String uSERNAME, String cARTYPE, String lATITUDE) {
        this.dATE = dATE;
        this.lONGITUDE = lONGITUDE;
        this.uSERNAME = uSERNAME;
        this.cARTYPE = cARTYPE;
        this.lATITUDE = lATITUDE;
    }

    /**
     * @return The dATE
     */
    public Long getDATE() {
        return dATE;
    }

    /**
     * @param dATE The DATE
     */
    public void setDATE(Long dATE) {
        this.dATE = dATE;
    }

    /**
     * @return The lONGITUDE
     */
    public String getLONGITUDE() {
        return lONGITUDE;
    }

    /**
     * @param lONGITUDE The LONGITUDE
     */
    public void setLONGITUDE(String lONGITUDE) {
        this.lONGITUDE = lONGITUDE;
    }

    /**
     * @return The uSERNAME
     */
    public String getUSERNAME() {
        return uSERNAME;
    }

    /**
     * @param uSERNAME The USERNAME
     */
    public void setUSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
    }

    /**
     * @return The cARTYPE
     */
    public String getCARTYPE() {
        return cARTYPE;
    }

    /**
     * @param cARTYPE The CARTYPE
     */
    public void setCARTYPE(String cARTYPE) {
        this.cARTYPE = cARTYPE;
    }

    /**
     * @return The lATITUDE
     */
    public String getLATITUDE() {
        return lATITUDE;
    }

    /**
     * @param lATITUDE The LATITUDE
     */
    public void setLATITUDE(String lATITUDE) {
        this.lATITUDE = lATITUDE;
    }

    @Override
    public String toString() {
        String formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(dATE));
        return uSERNAME+"["+formattedDate+"]"+"{"+lATITUDE+":"+lONGITUDE+"}"+cARTYPE;
    }
}