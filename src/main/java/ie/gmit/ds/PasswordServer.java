package ie.gmit.ds;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

import ie.gmit.ds.PasswordServiceGrpc.PasswordServiceImplBase;

public class PasswordServer {
	
	private Server server;
	private static final Logger logger = Logger.getLogger(PasswordServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
        final PasswordServer server = new PasswordServer();
        server.start();
        server.blockUntilShutdown();
    }
	
	private void start() throws IOException {
		int port = 50051;
		server = ServerBuilder.forPort(port)
				.addService(new PasswordServiceImpl())
				.build()
				.start();
		logger.info("Server started, listening on " + port);
	}
	
	private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
	
	 private void blockUntilShutdown() throws InterruptedException {
	        if (server != null) {
	            server.awaitTermination();
	        }
	    }


	 
}
