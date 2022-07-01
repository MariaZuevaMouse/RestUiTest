package com.mz.rest.entities;

import lombok.Getter;

public enum Status {
    AVAILABLE("available"), PENDING("pending"), SOLD("sold");

    @Getter
    private final String status;

    Status(String status) {
        this.status = status;
    }
}
