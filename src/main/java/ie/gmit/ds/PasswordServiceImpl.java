package ie.gmit.ds;

import java.util.logging.Logger;

import com.google.protobuf.BoolValue;

import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {

	private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

	
	@Override
	public void hashPassword(HashPasswordRequest request, StreamObserver<HashPasswordResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.hashPassword(request, responseObserver);
	}

	@Override
	public void validateHash(ValidRequest request, StreamObserver<BoolValue> responseObserver) {
		// TODO Auto-generated method stub
		super.validateHash(request, responseObserver);
	}

	
}
