package br.pit.sd.lab.utils;

import org.apache.commons.lang3.StringUtils;

public class NumberUtils
{

    public static boolean isNumber(String s)
    {
        return StringUtils.isNumeric(s);
    }
}
