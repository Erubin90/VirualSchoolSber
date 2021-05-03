package com.zoo.exception.enclosure;

import com.zoo.exception.ZooException;

public class EnclosureHasMasterException extends ZooException {
    public EnclosureHasMasterException(String message) {
        super(message);
    }
}
