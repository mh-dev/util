package mh.dev.common.util.mutable;

import java.math.BigDecimal;

/**
 * Basic helper class for final arithmetic classes ( {@link MutableDouble}, {@link MutableInteger}, {@link MutableLong})
 * 
 * @param <T>
 */
public abstract class MathMutable<T extends Number> {

	protected T value = null;

	/**
	 * Initialization of the start value
	 * 
	 * @param initialize
	 */
	public MathMutable(T initialize) {
		value = initialize;
	}

	/**
	 * Increments the value
	 */
	public abstract void increment();

	/**
	 * Decrements the value
	 */
	public abstract void decrement();

	/**
	 * Adds the parameter to the value
	 * 
	 * @param value
	 *            to add
	 * @throws IllegalArgumentException
	 *             if the value is null
	 */
	public abstract void add(T value);

	/**
	 * Subtracts the parameter from the value
	 * 
	 * @param value
	 *            to subtract
	 * @throws IllegalArgumentException
	 *             if the value is null
	 */
	public abstract void subtract(T value);

	/**
	 * Multiplies the value with a given factor
	 * 
	 * @param value
	 *            to multiply
	 * @throws IllegalArgumentException
	 *             if the value is null
	 */
	public abstract void multiply(T value);

	/**
	 * Divides the value with the given factor. <br>
	 * 
	 * @param value
	 *            to divide
	 * @throws IllegalArgumentException
	 *             if the value is null or 0
	 */
	public abstract void divide(T value);

	/**
	 * Overrides the current value
	 * 
	 * @param value
	 *            to override
	 * @throws IllegalArgumentException
	 *             if the value is null
	 */
	public void set(T value) {
		this.value = value;
	}

	/**
	 * Returns the current value
	 * 
	 * @return
	 */
	public T value() {
		return value;
	}

	public abstract BigDecimal convert();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MathMutable [value=").append(value).append("]");
		return builder.toString();
	}

}
