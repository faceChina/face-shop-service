package com.zjlp.face.shop.util.wechat;

import java.security.MessageDigest;

public class MD5 {
	public static void main(String[] args) {
		try {
			System.out.println(getMd5("admin", "utf-8"));
			System.out
					.println(MD52("21232f297a57a5a743894a0e4a801fc3", "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getMd5(String str, String cset) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes(cset));
		byte[] b = md.digest();

		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; ++offset) {
			int i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}

	public static final String MD52(String str, String cset) throws Exception {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		MessageDigest mdInst = MessageDigest.getInstance("MD5");

		mdInst.update(str.getBytes(cset));

		byte[] md = mdInst.digest();

		int j = md.length;
		char[] s = new char[j * 2];
		int k = 0;

		for (int i = 0; i < j; ++i) {
			byte byte0 = md[i];
			s[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
			s[(k++)] = hexDigits[(byte0 & 0xF)];
		}
		return new String(s);
	}
}