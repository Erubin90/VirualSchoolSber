package com.zoo.exception.zoo;

import com.zoo.exception.ZooException;

public class EnclosureHasDifferentMasterException extends ZooException {
    public EnclosureHasDifferentMasterException(String message) {
        super(message);
    }
}
