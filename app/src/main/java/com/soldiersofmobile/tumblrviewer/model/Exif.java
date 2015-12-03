
package com.soldiersofmobile.tumblrviewer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Exif {

    @SerializedName("Camera")
    @Expose
    private String Camera;
    @SerializedName("ISO")
    @Expose
    private Integer ISO;
    @SerializedName("Aperture")
    @Expose
    private String Aperture;
    @SerializedName("Exposure")
    @Expose
    private String Exposure;
    @SerializedName("FocalLength")
    @Expose
    private String FocalLength;

    /**
     * 
     * @return
     *     The Camera
     */
    public String getCamera() {
        return Camera;
    }

    /**
     * 
     * @param Camera
     *     The Camera
     */
    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    /**
     * 
     * @return
     *     The ISO
     */
    public Integer getISO() {
        return ISO;
    }

    /**
     * 
     * @param ISO
     *     The ISO
     */
    public void setISO(Integer ISO) {
        this.ISO = ISO;
    }

    /**
     * 
     * @return
     *     The Aperture
     */
    public String getAperture() {
        return Aperture;
    }

    /**
     * 
     * @param Aperture
     *     The Aperture
     */
    public void setAperture(String Aperture) {
        this.Aperture = Aperture;
    }

    /**
     * 
     * @return
     *     The Exposure
     */
    public String getExposure() {
        return Exposure;
    }

    /**
     * 
     * @param Exposure
     *     The Exposure
     */
    public void setExposure(String Exposure) {
        this.Exposure = Exposure;
    }

    /**
     * 
     * @return
     *     The FocalLength
     */
    public String getFocalLength() {
        return FocalLength;
    }

    /**
     * 
     * @param FocalLength
     *     The FocalLength
     */
    public void setFocalLength(String FocalLength) {
        this.FocalLength = FocalLength;
    }

}
