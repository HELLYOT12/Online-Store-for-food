package inventory;

import java.util.HashMap;
import java.util.Map.Entry;

public class Admin {
    private String userName;
    private String password;
    private static HashMap<String, String> admins = new HashMap<String, String>();
    Admin(){
    	addAdmins();
    }
    Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
        admins.put(userName, password);
    }

    private void addAdmins() {
        admins.put("Mohamed", "1234643M");
        admins.put("Aziz", "GEMSTON12");
        admins.put("Donie", "ILoveMyGF");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static HashMap<String, String> getAdmins() {
        return admins;
    }

    public static Admin searchAdmins(String userName, String password) {
        for (Entry<String, String> admin : admins.entrySet()) {
            String storedUserName = admin.getKey();
            String storedPassword = admin.getValue();
            if (userName.equals(storedUserName) && password.equals(storedPassword)) {
            	return new Admin(storedUserName , storedPassword);
            }
        }
        return null;
    }

    public static HashMap<String, String> getAdminsMap() {
        return admins;
    }
}
