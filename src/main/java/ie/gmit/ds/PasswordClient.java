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
	//private final PasswordServiceGrpc.PasswordServiceBlockingStub passwordClientStub;
	private final PasswordServiceGrpc.PasswordServiceStub asyncPasswordService;
	private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;
	
	public PasswordClient(String host, int port) {
       channel = ManagedChannelBuilder
    		   .forAddress(host, port)
    		   .usePlaintext()
    		   .build();
       syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
       asyncPasswordService = PasswordServiceGrpc.newStub(channel);
    }
	
	public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
	
	/*public void tester(String name) {
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
*/
	public void hashPw(int id, String password)
	{
		logger.info("Connected");
		
		HashPasswordRequest req = HashPasswordRequest.newBuilder()
				.setId(id)
				.setPassword(password)
				.build();
	
		HashPasswordResponse res = null;
		
		logger.info("Hash password: "+ res);
	}
	
	public static void main(String[] args) throws Exception {
        PasswordClient client = new PasswordClient("localhost", 50051);
        try {
            client.hashPw(0, "hello");
        } finally {
            client.shutdown();
        }
        
        
    }
	
}
