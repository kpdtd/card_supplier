package com.sup.pack.logic.jsyd.dto;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/13下午4:19
 */
public class AdapterCDATA extends XmlAdapter<String, String>
{

    @Override
    public String marshal(String arg0) throws Exception
    {
        return "<![CDATA[" + arg0 + "]]>";
    }

    @Override
    public String unmarshal(String arg0) throws Exception
    {
        return arg0;
    }

}