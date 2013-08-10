package mh.dev.common.util.test.mutable;

import mh.dev.common.util.mutable.MutableDouble;


public class MutableDoubleTest extends MathMutableTest<MutableDouble, Double> {

	public MutableDoubleTest() {
		super(MutableDouble.class, Double.class);
	}

	@Override
	protected Double value(Number number) {
		return new Double(number.doubleValue());
	}

}
