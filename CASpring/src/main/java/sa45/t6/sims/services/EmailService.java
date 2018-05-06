package sa45.t6.sims.services;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

	void sendSimpleMail(String id,String ordernumber) throws Exception;

	


}
