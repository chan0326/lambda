package com.erich.api.common;

import com.erich.api.enums.Message;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {
    public abstract Map<String, ?> save(Map<String, ?> paramMap) throws IOException;
}
