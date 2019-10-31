package ie.gmit.ds;

import java.util.logging.Logger;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;

import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {

	private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

	public PasswordServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void hashPassword(HashPasswordRequest request, StreamObserver<HashPasswordResponse> responseObserver) {
		// TODO Auto-generated method stub
		String password = request.getPassword();
		char[] hashString = password.toCharArray();
		
		byte[] addSalt = Passwords.getNextSalt();
		
		byte[] paswordHashed = Passwords.hash(hashString, addSalt);
		
		responseObserver.onNext(HashPasswordResponse.newBuilder().setId(request.getId()).setPasswordHashed(ByteString.copyFrom(paswordHashed)).setSalt(ByteString.copyFrom(addSalt)).build());
		responseObserver.onCompleted();
	}

	@Override
	public void validateHash(ValidRequest request, StreamObserver<BoolValue> responseObserver) {
		// TODO Auto-generated method stub
		char[] password = request.getPassword().toCharArray();
		byte[] paswordHashed = request.getPasswordHashed().toByteArray();
		byte[] salt = request.getSalt().toByteArray();
		
		responseObserver.equals(Passwords.isExpectedPassword(password, salt, paswordHashed));
		
	
	}

	
}
