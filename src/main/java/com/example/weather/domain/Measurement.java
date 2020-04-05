package com.example.weather.domain;

import io.vavr.control.Either;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

final class Measurement {
    private final Either<Measurement.Failure, Measurement.Success> result;

    private Measurement(Either<Measurement.Failure, Measurement.Success> result) {
        this.result = result;
    }

    public static Measurement successful(Temperature temp) {
        return new Measurement(right(new Measurement.Success(temp)));
    }

    public static Measurement failed(String reason) {
        return new Measurement(left(new Measurement.Failure(reason)));
    }

    public boolean isSuccessful() {
        return result.isRight();
    }

    public Temperature temperature() {
        if (result.isRight()) {
            return result.get().temp;
        }

        return Temperature.unmeasured();
    }

    public String reason() {
        if (result.isLeft()) {
            return result.getLeft().reason;
        }

        return "OK";
    }

    private static class Failure {
        final String reason;

        Failure(String reason) {
            this.reason = reason;
        }
    }

    private static class Success {
        final Temperature temp;

        Success(Temperature temp) {
            this.temp = temp;
        }
    }
}
