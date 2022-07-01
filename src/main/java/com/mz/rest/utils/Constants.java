package com.mz.rest.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static String TEST_DATA_PATH = "src/test/resources/testdata.properties";

    //endpoints
    public final static String NEW_PET = "v2/pet";   //"#/pet/addPet";
    public final static String GET_PETS_BY_STATUS = "v2/pet/findByStatus";
    public final static String DELETE_PET = "v2/pet/{petId}";
}
