package optimization.cp;

import org.testng.annotations.Test;

public class CelsiusFahrenheitConverterTest {

    @Test
    public void converter() {
        Probe<Double> probe = new Probe<Double>();

        Connector<Double> c = new Connector<Double>();
        c.addConstraint(probe);

        Connector<Double> f = new Connector<Double>();
        f.addConstraint(probe);

        CelsiusFahrenheitConverter.converter(c, f);

        c.setValue("user", 10.0);
        System.out.println(f.getValue());

    }
}
