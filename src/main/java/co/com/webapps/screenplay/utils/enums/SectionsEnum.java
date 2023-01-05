package co.com.webapps.screenplay.utils.enums;

public enum SectionsEnum {

   MOTORSPORTS("Motosports"),
   DEFAULT("default");

   private String section;

    SectionsEnum(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }
}
