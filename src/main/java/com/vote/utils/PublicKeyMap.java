package com.vote.utils;

import java.io.Serializable;

/**
 * 公钥类
 * @author Wild
 *
 */
public class PublicKeyMap implements Serializable{
	private static final long serialVersionUID = 38912460353805838L;
	
	private String modulus;
	private String exponent;

	public String getModulus() {
		return modulus;
	}

	public void setModulus(String modulus) {
		this.modulus = modulus;
	}

	public String getExponent() {
		return exponent;
	}

	public void setExponent(String exponent) {
		this.exponent = exponent;
	}

	@Override
	public String toString() {
		return "PublicKeyMap [modulus=" + modulus + ", exponent=" + exponent + "]";
	}
}
