package mh.dev.common.util.mutable;

import java.math.BigDecimal;

/**
 * None final {@link Integer} wrapper
 * 
 */
public class MutableInteger extends MathMutable<Integer> {

	/**
	 * Creates a new {@link MutableInteger} with base value 0
	 */
	public MutableInteger() {
		super(0);
	}

	/**
	 * Creates a new {@link MutableInteger} initialized with the given value
	 * 
	 * @param initialize
	 *            initialization value
	 */
	public MutableInteger(Integer integer) {
		super(integer);
	}

	/**
	 * Creates a new {@link MutableInteger} initialized with the value the given {@link MathMutable}. <br>
	 * 
	 * @param mathMutable
	 */
	public <N extends Number> MutableInteger(MathMutable<N> mathMutable) {
		super(mathMutable.value.intValue());
	}

	@Override
	public void increment() {
		this.value++;
	}

	@Override
	public void decrement() {
		this.value--;
	}

	@Override
	public void add(Integer value) {
		if (value != null)
			this.value += value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void subtract(Integer value) {
		if (value != null)
			this.value -= value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void multiply(Integer value) {
		if (value != null)
			this.value *= value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void divide(Integer value) {
		if (value != null && !value.equals(0))
			this.value /= value;
		else
			throw new IllegalArgumentException("value must not be null and not equal 0!");
	}

	@Override
	public BigDecimal convert() {
		return BigDecimal.valueOf(value);
	}
}
