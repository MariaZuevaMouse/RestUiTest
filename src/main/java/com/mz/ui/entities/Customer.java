package com.mz.ui.entities;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String firstName;
    private String secondName;
    private int postalCode;

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
