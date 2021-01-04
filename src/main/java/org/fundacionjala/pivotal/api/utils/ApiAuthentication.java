package org.fundacionjala.pivotal.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.config.PivotalProperties;
import org.fundacionjala.pivotal.entities.User;

public final class ApiAuthentication {
    private static final String TOKEN_HEADER = "X-TrackerToken";
    private static RequestSpecification requestSpecification;

    /**
     * Constructor for ApiAuthentication.
     */
    private ApiAuthentication() {
    }

    /**
     * Gets request specification with Token of a defined User and the BaseURI
     * of API which is loaded in Pivotal Properties single instance .
     *
     * @param user to define their Token
     * @return requestSpecification
     */
    public static RequestSpecification getLoggedReqSpec(final User user) throws PropertiesReadingException {
        RestAssured.baseURI = PivotalProperties.getInstance().getBaseApiUrl();
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader(TOKEN_HEADER, user.getToken())
                .addHeader("Content-Type", "application/json")
                .build();
        return requestSpecification;
    }
}
