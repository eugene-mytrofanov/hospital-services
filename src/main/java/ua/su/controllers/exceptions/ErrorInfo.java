package ua.su.controllers.exceptions;

public class ErrorInfo {
    private final String url;
    private final String cause;

    public ErrorInfo(final String url, final Exception ex) {
        this.url = url;
        this.cause = ex.getLocalizedMessage();
    }

    public String getUrl() {
        return url;
    }

    public String getCause() {
        return cause;
    }
}
