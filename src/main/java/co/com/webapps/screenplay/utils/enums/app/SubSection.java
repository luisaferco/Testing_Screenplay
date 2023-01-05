package co.com.webapps.screenplay.utils.enums.app;

public enum SubSection {

    TELEPHONY("Telefonía");

    private String subSection;

    SubSection(String subSection) {
        this.subSection = subSection;
    }

    public String getSubSection() {
        return subSection;
    }
}
