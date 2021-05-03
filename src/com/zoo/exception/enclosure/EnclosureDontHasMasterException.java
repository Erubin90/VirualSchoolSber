package com.zoo.exception.enclosure;

import com.zoo.exception.ZooException;

public class EnclosureDontHasMasterException extends ZooException {
    public EnclosureDontHasMasterException(String message) {
        super(message);
    }
}
