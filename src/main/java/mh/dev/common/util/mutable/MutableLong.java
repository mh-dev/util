package mh.dev.common.util.mutable;

import java.math.BigDecimal;

/**
 * None final {@link Long} wrapper
 * 
 */
public class MutableLong extends MathMutable<Long> {

	/**
	 * Creates a new {@link MutableLong} with base value 0
	 */
	public MutableLong() {
		super(0L);
	}

	/**
	 * Creates a new {@link MutableLong} initialized with the given value
	 * 
	 * @param initialize
	 *            initialization value
	 */
	public MutableLong(Long initialize) {
		super(initialize);
	}

	/**
	 * Creates a new {@link MutableLong} initialized with the value the given {@link MathMutable}. <br>
	 * 
	 * @param mathMutable
	 */
	public <N extends Number> MutableLong(MathMutable<N> mathMutable) {
		super(mathMutable.value.longValue());
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
	public void add(Long value) {
		if (value != null)
			this.value += value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void subtract(Long value) {
		if (value != null)
			this.value -= value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void multiply(Long value) {
		if (value != null)
			this.value *= value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void divide(Long value) {
		if (value != null && !value.equals(0L))
			this.value /= value;
		else
			throw new IllegalArgumentException("value must not be null and not equal 0!");
	}

	@Override
	public BigDecimal convert() {
		return BigDecimal.valueOf(this.value);
	}

}
