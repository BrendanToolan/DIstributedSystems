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
	
	public void hashPassword(int id, String password) {
		logger.info("User ID: "+id+"\nPassword: "+password);
		HashPasswordRequest req = HashPasswordRequest.newBuilder().setId(id).setPassword(password).build();
		HashPasswordResponse res; try {
			res = syncPasswordService.hashPassword(req);
			logger.info(res.toString());
		} catch
			(StatusRuntimeException ex){
				logger.log(Level.WARNING, "Failed:{0}", ex.getStatus());
				//return
			}
	
	}
	
	public static void main(String[] args) throws Exception {
        PasswordClient client = new PasswordClient("localhost", 50051);
        try {
            client.hashPassword(69, "Password-Test");
        } finally {
            client.shutdown();
        }
        
        
    }
	
}
