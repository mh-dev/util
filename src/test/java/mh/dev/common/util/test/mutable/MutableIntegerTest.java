package mh.dev.common.util.test.mutable;

import mh.dev.common.util.mutable.MutableInteger;

public class MutableIntegerTest extends MathMutableTest<MutableInteger, Integer> {

	public MutableIntegerTest() {
		super(MutableInteger.class, Integer.class);
	}

	@Override
	protected Integer value(Number number) {
		return new Integer(number.intValue());
	}

}
