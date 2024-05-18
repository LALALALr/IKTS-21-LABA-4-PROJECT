package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainService {

    private final DBService dbService;

    public MainService() {
        dbService = new DBService();
    }

    public void addName(String username,String password,String email){
        String sql = "INSERT INTO accounts(username, password, email, created_at) VALUES ('"+username+"','"+password+"','"+email+"', CURRENT_DATE)";
        //INSERT INTO accounts(username, password, email, created_at) VALUES ('lalalalr', '898989','email@mail.ru', CURRENT_DATE);

        dbService.insert(sql);
    }
    public void editName(int user_id, String username, String password) {
        String sql = "UPDATE accounts SET username =?, password=? WHERE user_id =?";
        dbService.update(sql,username,password,user_id);
    }
    public void deleteName(int id) {
        String sql = "DELETE FROM accounts WHERE user_id ="+id+";";
        dbService.delete(sql);
    }

    public List<Map<String,Object>> getNames() throws SQLException {
        List<Map<String, Object>> result = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        ResultSet rs = dbService.select(sql);
        while (rs.next()){
            Map<String, Object> row = new HashMap<>();
            row.put("user_id", rs.getInt("user_id"));
            row.put("username", rs.getString("username"));
            row.put("password", rs.getString("password"));
            row.put("email", rs.getString("email"));
            row.put("created_at", rs.getString("created_at"));
            result.add(row);
        }
        return result;
    }

}
