package jakubfilipiak.BusinessCardWithCMS.utils;

import java.util.Optional;

/**
 * Created by Jakub Filipiak on 17.10.2019
 */
public enum CompanyImageName {

    BRAND_IMAGE("brandImage"),
    STUDIO("studio"),
    LOGO("logo"),
    PORTRAIT("portrait");

    private String name;

    CompanyImageName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Optional<CompanyImageName> fromString(String name) {
        for (CompanyImageName correctName : CompanyImageName.values()) {
            if (correctName.toString().equalsIgnoreCase(name))
                return Optional.of(correctName);
        }
        return Optional.empty();
    }
}
