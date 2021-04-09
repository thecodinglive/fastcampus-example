package info.thecodinglive.photoapp.config;

public enum MDCKeys {
    /**
     *  MDC.put("requestId", requestId);
     *         MDC.put("requestUrl", requestUrl);
     *         MDC.put("userAgent", userAgent);
     *         MDC.put("clientIP", clientIP);
     */

    REQUEST_ID("requestId"),
    REQUEST_URL("requestUrl"),
    USER_AGENT("userAgent"),
    CLIENT_IP("clientIP");

    MDCKeys(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    private String propertyKey;
}
