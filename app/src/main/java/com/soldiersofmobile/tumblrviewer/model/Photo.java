
package com.soldiersofmobile.tumblrviewer.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Photo {

    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("alt_sizes")
    @Expose
    private List<AltSize> altSizes = new ArrayList<AltSize>();
    @SerializedName("original_size")
    @Expose
    private OriginalSize originalSize;
    @SerializedName("exif")
    @Expose
    private Exif exif;

    /**
     * 
     * @return
     *     The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 
     * @param caption
     *     The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 
     * @return
     *     The altSizes
     */
    public List<AltSize> getAltSizes() {
        return altSizes;
    }

    /**
     * 
     * @param altSizes
     *     The alt_sizes
     */
    public void setAltSizes(List<AltSize> altSizes) {
        this.altSizes = altSizes;
    }

    /**
     * 
     * @return
     *     The originalSize
     */
    public OriginalSize getOriginalSize() {
        return originalSize;
    }

    /**
     * 
     * @param originalSize
     *     The original_size
     */
    public void setOriginalSize(OriginalSize originalSize) {
        this.originalSize = originalSize;
    }

    /**
     * 
     * @return
     *     The exif
     */
    public Exif getExif() {
        return exif;
    }

    /**
     * 
     * @param exif
     *     The exif
     */
    public void setExif(Exif exif) {
        this.exif = exif;
    }

}
