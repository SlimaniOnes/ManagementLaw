package com.example.managementLaw.controller;



import java.sql.*;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.managementLaw.Entity.User;

import jakarta.servlet.http.HttpServletRequest;




@Controller
public class UserController {

	 @Value("${spring.datasource.url}")
	    private String dbUrl;

	    @Value("${spring.datasource.username}")
	    private String dbUsername;

	    @Value("${spring.datasource.password}")
	    private String dbPassword;
	
	
    @GetMapping("/")
    public String login(Model model) {
    	User user= new User();
        model.addAttribute("user", user);
        return "login";  
        }

    @GetMapping("/home")
    public String home() {
              
        return "home";
    }
    
    
    
    
    
    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user) {
        String username = user.getUsername();
        String password = user.getPassword();

      
        if (isValidCredentials(username, password)) {
            return "home"; // Redirect to the home page
        } else {
            return "erreur"; // Redirect to the error page
        }
    }

    
    
    private boolean isValidCredentials(String username, String password) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String sql = "SELECT COUNT(*) FROM login WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();}
        return false;
    }
    
    
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        
    
        
        return "redirect:/";
    }
    
    
        
    }

