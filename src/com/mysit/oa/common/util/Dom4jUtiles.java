package com.mysit.oa.common.util;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Dom4jUtiles {
    public static Document getDocument(String fileName) {
        SAXReader reader = new SAXReader();
        if (StringUtils.isBlank(fileName)) {
            throw new IllegalArgumentException("文件名都不给我，我读啥子");
        }
        try {
            return reader.read(Dom4jUtiles.class.getClassLoader().getResourceAsStream(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
