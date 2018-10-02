package com.example.android.visitoradea;

/**
 * {@link Attraction} represents a place to visit, such as a landmark, restaurant, park etc.
 * It contains an image, a description, an address, and, if applicable: telephone number, website
 */

public class Attraction {

    private String attractionName;
    private String attractionDescription;
    private String attractionAddress;
    private int attractionImage;
    private static final String NO_TELEPHONE = "";
    private static final String NO_WEBSITE = "";
    private String attractionTelephone = NO_TELEPHONE;
    private String attractionWebsite = NO_WEBSITE;

    /**
     * Create a new Attraction object. (constructor for attractions without tel, website)
     *
     * @param attractionName        is the name of the attraction
     * @param attractionImage       is the photo of the attraction (resource ID)
     * @param attractionDescription is the description of the attraction
     * @param attractionAddress     is the address where the attraction can be found
     */
    public Attraction(String attractionName, int attractionImage, String attractionDescription, String attractionAddress) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.attractionImage = attractionImage;
        this.attractionAddress = attractionAddress;
    }

    /**
     * Create a new Attraction object. (constructor for attractions with all details)
     *
     * @param attractionName        is the name of the attraction
     * @param attractionImage       is the photo of the attraction (resource ID)
     * @param attractionDescription is the description of the attraction
     * @param attractionAddress     is the address where the attraction can be found
     * @param attractionTelephone   is the telephone number of the attraction
     * @param attractionWebsite     is the website of the attraction
     */
    public Attraction(String attractionName, int attractionImage, String attractionDescription, String attractionAddress,
                      String attractionTelephone, String attractionWebsite) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.attractionImage = attractionImage;
        this.attractionAddress = attractionAddress;
        this.attractionTelephone = attractionTelephone;
        this.attractionWebsite = attractionWebsite;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public int getAttractionImage() {
        return attractionImage;
    }

    public String getAttractionDescription() {
        return attractionDescription;
    }

    public String getAttractionAddress() {
        return attractionAddress;
    }

    public String getAttractionTelephone() {
        return attractionTelephone;
    }

    public String getAttractionWebsite() {
        return attractionWebsite;
    }

    public boolean hasTelephone() {
        return !attractionTelephone.equals(NO_TELEPHONE);
    }

    public boolean hasWebsite() {
        return !attractionWebsite.equals(NO_WEBSITE);
    }
}