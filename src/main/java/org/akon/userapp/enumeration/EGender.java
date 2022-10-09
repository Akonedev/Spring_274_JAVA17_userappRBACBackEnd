package org.akon.userapp.enumeration;

import org.akon.userapp.exception.InvalidGenderException;

public enum EGender {

    MALE(1), FEMALE(2);

    private int gender;

    EGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public static EGender getValidGender(String genderName) {
        EGender gender;
        try {
            gender = EGender.valueOf(genderName);
        } catch(IllegalArgumentException ex) {
            throw new InvalidGenderException(String.format("Invalid gender string %s. Are supported only: MALE or FEMALE strings", genderName));
        }
        return gender;
    }

}
