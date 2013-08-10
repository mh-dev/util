package mh.dev.common.util.mutable;

import java.math.BigDecimal;

/**
 * None final {@link Double} Wrapper
 * 
 */
public class MutableDouble extends MathMutable<Double> {

	/**
	 * Creates a new {@link MutableDouble} with base value 0
	 */
	public MutableDouble() {
		super(0D);
	}

	/**
	 * Creates a new {@link MutableDouble} initialized with the given value
	 * 
	 * @param initialize
	 *            initialization value
	 */
	public MutableDouble(Double value) {
		super(value);
	}

	/**
	 * Creates a new {@link MutableDouble} initialized with the value the given {@link MathMutable}. <br>
	 * 
	 * @param mathMutable
	 */
	public <N extends Number> MutableDouble(MathMutable<N> mathMutable) {
		super(mathMutable.value.doubleValue());
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
	public void add(Double value) {
		if (value != null)
			this.value += value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void subtract(Double value) {
		if (value != null)
			this.value -= value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void multiply(Double value) {
		if (value != null)
			this.value *= value;
		else
			throw new IllegalArgumentException("value must not be null!");
	}

	@Override
	public void divide(Double value) {
		if (value != null && !value.equals(0D))
			this.value /= value;
		else
			throw new IllegalArgumentException("value must not be null and not equal 0!");
	}

	@Override
	public BigDecimal convert() {
		return BigDecimal.valueOf(this.value);
	}

}
