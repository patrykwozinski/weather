package com.example.weather.domain;

final class Measurement {
    private Result result;
    private Temperature temp;

    private Measurement(Result result) {
        this.result = result;
    }

    private Measurement(Result result, Temperature temp) {
        this(result);
        this.temp = temp;
    }

    public static Measurement successful(Temperature temp) {
        return new Measurement(Result.successfully, temp);
    }

    public static Measurement failed() {
        return new Measurement(Result.failed);
    }

    public boolean isSuccessful() {
        return this.result.equals(Result.successfully);
    }

    enum Result {
        successfully,
        failed,
    }
}
