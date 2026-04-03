package rodrigo.queiroz.amqp.processor;

import java.util.Random;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.enterprise.context.ApplicationScoped;
import rodrigo.queiroz.model.Quote;

@ApplicationScoped
public class QuoteProcessor {

    private Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    @RunOnVirtualThread
    public Quote process(String quoteRequestString) throws InterruptedException {
        Thread.sleep(200);
        return new Quote(quoteRequestString, random.nextInt(100));

    }
}
