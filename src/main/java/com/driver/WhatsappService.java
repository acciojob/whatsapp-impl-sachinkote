package com.driver;

import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class WhatsappService {
	
	WhatsappRepository repo=new WhatsappRepository();

	public String createUser(String name, String mobile) throws Exception {
		// TODO Auto-generated method stub
		String output= repo.createUser(name,mobile);
		if(output=="Success")
			return output;
		else
			throw new Exception("User already exists");
	}

	public Group createGroup(List<User> users) {
		// TODO Auto-generated method stub
		return repo.createGroup (users);
	}

	public int createMessage(String content) {
		// TODO Auto-generated method stub
		return repo.createMessage(content);
	}

	public int sendMessage(Message message, User sender, Group group) throws Exception {
		// TODO Auto-generated method stub
		
			return repo.sendMessage(message,sender, group);
		
		
	}

	public String changeAdmin(User approver, User user, Group group) throws Exception {
		// TODO Auto-generated method stub
		return repo.changeAdmin(approver, user,group);
	}
	public int removeUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String findMessage(Date start, Date end, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
