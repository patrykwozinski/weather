package com.example.weather.domain;

public final class Measurement {
    private final Result result;
    private final Temperature temp;
    private String reason;

    private Measurement(Result result, Temperature temp) {
        this.result = result;
        this.temp = temp;
    }

    private Measurement(Result result, Temperature temp, String reason) {
        this(result, temp);
        this.reason = reason;
    }

    public static Measurement successful(Temperature temp) {
        return new Measurement(Result.successfully, temp);
    }

    public static Measurement failed(String reason) {
        return new Measurement(Result.failed, Temperature.unmeasured(), reason);
    }

    public boolean isSuccessful() {
        return this.result.equals(Result.successfully);
    }

    public String reason() {
        return this.reason;
    }

    private enum Result {
        successfully,
        failed,
    }
}
