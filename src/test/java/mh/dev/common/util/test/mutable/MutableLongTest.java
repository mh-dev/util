package mh.dev.common.util.test.mutable;

import mh.dev.common.util.mutable.MutableLong;

public class MutableLongTest extends MathMutableTest<MutableLong, Long> {

	public MutableLongTest() {
		super(MutableLong.class, Long.class);
	}

	@Override
	protected Long value(Number number) {
		return new Long(number.longValue());
	}

}
