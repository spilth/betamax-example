package spilth.org;

import org.junit.Rule;
import org.junit.Test;
import software.betamax.Configuration;
import software.betamax.TapeMode;
import software.betamax.junit.Betamax;
import software.betamax.junit.RecorderRule;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AddressFinderTest {
    Configuration configuration = Configuration.builder()
            .defaultMode(TapeMode.READ_WRITE)
            .sslEnabled(true)
            .build();

    @Rule
    public RecorderRule recorder = new RecorderRule(configuration);

    @Test
    @Betamax
    public void getIpAddress_returnsIpAddressAsString() {
        AddressFinder addressFinder = new AddressFinder();

        String ipAddress = addressFinder.getIpAddress();

        assertThat(ipAddress, equalTo("42.0.0.42"));
    }
}
