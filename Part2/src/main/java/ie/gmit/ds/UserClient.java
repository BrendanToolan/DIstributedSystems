package ie.gmit.ds;

import java.util.logging.Logger;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class UserClient {
	
	private static final Logger logger = Logger.getLogger(UserClient.class.getName());
	private final ManagedChannel channel;
	private final PasswordServiceGrpc.PasswordServiceStub asyncPasswordService;
	private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

	static Scanner input = new Scanner(System.in);
	
	private int id;
	private String password;
	
	public UserClient(String host, int port)
	{
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
		logger.info("test");
		HashPasswordRequest req = HashPasswordRequest.newBuilder().setId(id).setPassword(password).build();
		HashPasswordResponse res; try {
			res = syncPasswordService.hashPassword(req);
			logger.info(res.toString());
		} catch
			(StatusRuntimeException ex) {
			logger.log(Level.WARNING, "Failed:{0}", ex.getStatus());

		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter Password: ");
		String password = input.nextLine();
		System.out.println("Enter ID: ");
		int id = input.nextInt();
		
		
		
		UserClient client = new UserClient("localhost", 50051);
		try {
			client.hashPassword(id, password);
		} finally {
			client.shutdown();
		}
	}
	
}
