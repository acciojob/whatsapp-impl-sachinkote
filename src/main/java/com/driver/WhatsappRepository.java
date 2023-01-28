package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private HashMap<Group, List<User>> groupUserMap;
    private HashMap<Group, List<Message>> groupMessageMap;
    private HashMap<Message, User> senderMap;
    private HashMap<Group, User> adminMap;
    private HashSet<String> userMobile;
    private int customGroupCount;
    private int messageId;

    public WhatsappRepository(){
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<>();
        this.customGroupCount = 0;
        this.messageId = 0;
    }

	public String createUser(String name, String mobile) {
		// TODO Auto-generated method stub
		if(!userMobile.contains(mobile)) {
		    userMobile.add(mobile);
		    return "SUCCESS";
		}
		else
			return("User already exists");
	}

	public Group createGroup(List<User> users) {
		// TODO Auto-generated method stub
		Group group=new Group();
		if(users.size()>2)
		{   customGroupCount++;
			group.setName("Group"+customGroupCount);
			group.setNumberOfParticipants(users.size());
		}
		else
		{
			group.setName(users.get(1).getName());
			group.setNumberOfParticipants(users.size());
		}
		groupUserMap.put(group, users);
		adminMap.put(group, users.get(0));
		return group;
	}

	public int createMessage(String content) {
		// TODO Auto-generated method stub
		messageId++;
		return messageId;
	}

	public int sendMessage(Message message, User sender, Group group) throws Exception {
		// TODO Auto-generated method stub
		if(! groupMessageMap.containsKey(group)) {
			throw new Exception("Group does not exist");
		}
		
		List<User> l=groupUserMap.get(group);
		if(!l.contains(sender))
		{
			throw new Exception("You are not allowed to send message");
		}
		else
			
		{
			 List<Message> l1=groupMessageMap.get(group);
			 l1.add(message);
			 groupMessageMap.put(group, l1);
			 return l1.size();
		}
	}

	public String changeAdmin(User approver, User user, Group group) throws Exception {
		// TODO Auto-generated method stub
		if(! groupMessageMap.containsKey(group)) {
			throw new Exception("Group does not exist");
		}
		if(!adminMap.containsKey(approver))
		{
			throw new Exception("Approver does not have rights");
		}
		if(!groupUserMap.get(group).contains(user))
		{
			throw new Exception("User is not a participant");
		}
		else
		{
			adminMap.put(group, user);
		return "SUCCESS";
		}
	}
}
