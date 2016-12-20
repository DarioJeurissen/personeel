package be.vdab.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dario.Jeurissen
 *
 */

public final class HelperClass {
	public static String isStringNotEmpty(String s) throws IllegalArgumentException {
		if (s == null || s.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return s;
	}

	public static Date isDateNotNull(Date d) throws IllegalArgumentException {
		if (d == null) {
			throw new IllegalArgumentException();
		}
		return d;
	}

	public static Long isLongStrictlyPositive(Long id) throws IllegalArgumentException {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException();
		}
		return id;
	}

	public static Long isLongStrictlyNegative(Long id) throws IllegalArgumentException {
		if (id == null || id >= 0) {
			throw new IllegalArgumentException();
		}
		return id;
	}

	public static Long isValueNotNegative(Long id) throws IllegalArgumentException {
		if (id == null || id < 0) {
			throw new IllegalArgumentException();
		}
		return id;
	}

	public static Long isValueNotPostive(Long id) throws IllegalArgumentException {
		if (id == null || id > 0) {
			throw new IllegalArgumentException();
		}
		return id;
	}

	public static BigDecimal isBigDecimalNotNegative(BigDecimal bd)
			throws IllegalArgumentException, NullPointerException {
		if (bd != null) {
			if (!(bd.signum() > 0)) {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return bd;
	}
	
	public static BigDecimal isBigDecimalBiggerThan(BigDecimal from, BigDecimal to)
			throws IllegalArgumentException, NullPointerException {
		if (from != null && to != null) {
			if (from.compareTo(to) <= 0) {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return from;
	}

	public static String isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return email;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static String isStringNotEmpty(String s, String error) throws IllegalArgumentException {
		if (s == null || s.isEmpty()) {
			throw new IllegalArgumentException(error);
		}
		return s;
	}

	public static Date isDateNotNull(Date d, String error) throws IllegalArgumentException {
		if (d == null) {
			throw new IllegalArgumentException(error);
		}
		return d;
	}

	public static Long isLongStrictlyPositive(Long id, String error) throws IllegalArgumentException {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException(error);
		}
		return id;
	}

	public static Long isLongStrictlyNegative(Long id, String error) throws IllegalArgumentException {
		if (id == null || id >= 0) {
			throw new IllegalArgumentException(error);
		}
		return id;
	}

	public static Long isValueNotNegative(Long id, String error) throws IllegalArgumentException {
		if (id == null || id < 0) {
			throw new IllegalArgumentException(error);
		}
		return id;
	}

	public static Long isValueNotPostive(Long id, String error) throws IllegalArgumentException {
		if (id == null || id > 0) {
			throw new IllegalArgumentException(error);
		}
		return id;
	}

	public static BigDecimal isBigDecimalNotNegative(BigDecimal bd, String error)
			throws IllegalArgumentException, NullPointerException {
		if (bd != null) {
			if (!(bd.signum() > 0)) {
				throw new IllegalArgumentException(error);
			}
		} else {
			throw new NullPointerException(error);
		}
		return bd;
	}
	
	public static BigDecimal isBigDecimalBiggerThan(BigDecimal from, BigDecimal to, String error)
			throws IllegalArgumentException, NullPointerException {
		if (from != null && to != null) {
			if (from.compareTo(to) <= 0) {
				throw new IllegalArgumentException(error);
			}
		} else {
			throw new NullPointerException(error);
		}
		return from;
	}

	public static String isValidEmail(String email, String error) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return email;
		} else {
			throw new IllegalArgumentException(error);
		}
	}
}