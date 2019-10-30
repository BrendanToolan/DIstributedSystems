package ie.gmit.ds;

import java.util.logging.Logger;

import com.google.protobuf.BoolValue;

import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {

	private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

	public PasswordServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void hashPassword(HashPasswordRequest request, StreamObserver<HashPasswordResponse> responseObserver) {
		// TODO Auto-generated method stub
	//	String password = request.getPassword();
		//char[] hashString = password.toCharArray();
		
		//byte[] addSalt = Passwords.getSalt();
	//	byte[] paswordHashed = Passwords.hash(hashString, addSalt);
		
	}

	@Override
	public void validateHash(ValidRequest request, StreamObserver<BoolValue> responseObserver) {
		// TODO Auto-generated method stub
		super.validateHash(request, responseObserver);
	}

	
}
