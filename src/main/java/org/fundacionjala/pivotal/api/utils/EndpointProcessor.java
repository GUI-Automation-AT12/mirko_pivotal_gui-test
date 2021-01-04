package org.fundacionjala.pivotal.api.utils;

public final class EndpointProcessor {

    public static String processEndpoint(final String sourceEndpoint, final String replacedParam) {
        String toReplace = sourceEndpoint.substring(sourceEndpoint.indexOf('{'), sourceEndpoint.indexOf('}') + 1);
        return sourceEndpoint.replace(toReplace, replacedParam);
    }
}
