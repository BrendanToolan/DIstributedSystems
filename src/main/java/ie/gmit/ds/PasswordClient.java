package ie.gmit.ds;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PasswordClient {

	private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
	private final ManagedChannel channel;
	private final PasswordServiceGrpc.PasswordServiceBlockingStub passwordClientStub;
	
	public PasswordClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        passwordClientStub = PasswordServiceGrpc.newBlockingStub(channel);
    }
	
	public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
	
	public void tester(String name) {
        logger.info("Will try to greet " + name + " ...");
        HashPasswordRequest request = HashPasswordRequest.newBuilder().build();
        HashPasswordResponse response = null;
        try {
            //response = passwordClientStub;
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Client and Server Connected");
    }

	
	public static void main(String[] args) throws Exception {
        PasswordClient client = new PasswordClient("localhost", 50051);
        try {
            client.tester("hello");
        } finally {
            client.shutdown();
        }
    }
	
}
