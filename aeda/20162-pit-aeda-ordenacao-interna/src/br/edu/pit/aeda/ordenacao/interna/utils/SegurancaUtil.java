package br.edu.pit.aeda.ordenacao.interna.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SegurancaUtil {

  public static String gerarHashMd5(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    MessageDigest m=MessageDigest.getInstance("MD5");
    m.update(s.getBytes(),0,s.length());
    return new BigInteger(1,m.digest()).toString(16);
  }
  
}
