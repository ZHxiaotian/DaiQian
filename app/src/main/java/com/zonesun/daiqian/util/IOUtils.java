package com.zonesun.daiqian.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class IOUtils {


    public  static String   inputStream2String   (InputStream in)   throws IOException {
        StringBuffer   out   =   new   StringBuffer();
        byte[]   b   =   new   byte[4096];
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {
            out.append(new   String(b,   0,   n));
        }
        return   out.toString();
    }


}
