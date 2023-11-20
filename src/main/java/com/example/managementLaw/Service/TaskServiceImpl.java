package com.example.managementLaw.Service;
import com.example.managementLaw.Entity.Task;
import com.example.managementLaw.Repository.*;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private taskRepository tr;


	   
	    @Value("${admin.email}")
	    private static String adminemail;

	public TaskServiceImpl(taskRepository tr) {
		super();
		this.tr = tr;
	}
	
	/**public static void sendEmailToAdmin(Task task) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (task.getDateT().equals(now)) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("ons.slimani99@gmail.com");
            message.setTo(adminemail);
            message.setSubject("Task Alert");
            message.setText("The date of the task is equal to the current time.");

            javaMailSender.send(message);
        }
        
    }**/

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return tr.save(task);
	}

	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return tr.findById(id).get();
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return tr.save(task);
	}

	@Override
	public void deleteTaskById(Long id) {
		tr.deleteById(id);
		
	}

}
