package mh.dev.common.util.test.mutable;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import mh.dev.common.util.mutable.MathMutable;

import org.junit.Test;

public abstract class MathMutableTest<T extends MathMutable<B>, B extends Number> {

	private Class<T> mathMutableClass;
	private Class<B> baseClass;

	public MathMutableTest(Class<T> mathMutableClass, Class<B> baseClass) {
		this.mathMutableClass = mathMutableClass;
		this.baseClass = baseClass;
	}

	@Test
	public void base_set() throws InstantiationException, IllegalAccessException {
		T t = mathMutableClass.newInstance();
		t.set(value(0));
		assertEquals("value should return the same after a set operation", value(0), t.value());
	}

	@Test
	public void base_constructor() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(0));
		assertEquals("value should return the same after initialization with the constructor", value(0), t.value());
	}

	@Test
	public void incremenet() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(0));
		t.increment();
		assertEquals("value should return the same as the default value + 1", value(1), t.value());
	}

	@Test
	public void decrement() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(2));
		t.decrement();
		assertEquals("value should return the same as the default value + 1", value(1), t.value());
	}

	@Test
	public void add() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(1));
		t.add(value(3));
		assertEquals("value should return the result of the addition 1 + 3 = 5", value(4), t.value());
	}

	@Test(expected = IllegalArgumentException.class)
	public void add_null() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance();
		t.add(null);
	}

	@Test
	public void sub() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(5));
		t.subtract(value(3));
		assertEquals("value should return the result of the substraction 5 + 3 = 2", value(2), t.value());
	}

	@Test(expected = IllegalArgumentException.class)
	public void sub_null() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance();
		t.subtract(null);
	}

	@Test
	public void multiply() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(2));
		t.multiply(value(3));
		assertEquals("value should return the result of the multiplication 2 * 3 = 6", value(6), t.value());
	}

	@Test(expected = IllegalArgumentException.class)
	public void multiply_null() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance();
		t.multiply(null);
	}

	@Test
	public void divide() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance(value(6));
		t.divide(value(3));
		assertEquals("value should return the result of the division 6 / 3 = 2", value(2), t.value());
	}

	@Test(expected = IllegalArgumentException.class)
	public void divide_null() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance();
		t.divide(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void divide_zero() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		T t = mathMutableClass.getConstructor(baseClass).newInstance();
		t.divide(value(0));
	}

	protected abstract B value(Number number);

}
