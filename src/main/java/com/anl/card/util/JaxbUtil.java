package com.anl.card.util;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/13下午2:57
 */

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @Description:xml和对象相互转换工具类
 * @author:yaolong
 * @data:2017年2月9日 下午10:46:57
 * @version:1.0
 */
public class JaxbUtil {

    /**
     * JavaBean转换成xml 默认编码UTF-8
     *
     */
    public static String convertToXml(Object obj) {
        return convertToXml(obj, "GBK");
    }

    /**
     * JavaBean转换成xml
     *
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息
            // 防止cdata中的特殊字符被转义
            marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
                    new CharacterEscapeHandler(){
                        @Override
                        public void escape(char[] ch, int start,
                                           int length, boolean isAttVal,
                                           Writer writer) throws IOException
                        {
                            writer.write(ch, start, length);
                        }
                    });
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * xml转换成JavaBean
     * @param xml
     * @param c
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c)
            throws JAXBException {
        T t = null;
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        t = (T) unmarshaller.unmarshal(new StringReader(xml));
        return t;
    }
}