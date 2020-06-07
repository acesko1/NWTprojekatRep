import java.io.IOException;

import com.nwt.witcher.paymentapp.AuthorizationServiceApplication;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	 public static void main(String args[]) throws IOException, InterruptedException {
		 
		 System.out.println("Pokretanje GRPC servera");
		 Server server = ServerBuilder.forPort(8085).addService(

				 new UserServiceApplication()).build();
		 server = ServerBuilder.forPort(8084).addService(

				 new SupplyServiceApplication()).build();
		 server = ServerBuilder.forPort(8083).addService(

				 new PaymentServiceApplication()).build();
		 server = ServerBuilder.forPort(8082).addService(

				 new FeedbackServiceApplication()).build();
		 server = ServerBuilder.forPort(8081).addService(

				 new AuthorizationServiceApplication()).build();
		 
		 server.start();
		 System.out.println("Server pokrenut na "+ server.getPort());
	        server.awaitTermination();
	 }
}
