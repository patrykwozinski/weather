package com.example.weather.domain;

public final class Measurement {
    private final Result result;
    private final Temperature temp;

    private Measurement(Result result, Temperature temp) {
        this.result = result;
        this.temp = temp;
    }

    public static Measurement successful(Temperature temp) {
        return new Measurement(Result.successfully, temp);
    }

    public static Measurement failed() {
        return new Measurement(Result.failed, Temperature.unmeasured());
    }

    public boolean isSuccessful() {
        return this.result.equals(Result.successfully);
    }

    enum Result {
        successfully,
        failed,
    }
}
