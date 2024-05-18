package servlets;
import services.MainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/test")
public class MainServlet extends HttpServlet{

    private final MainService mainService;

    public MainServlet(){
        this.mainService = new MainService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(resp.getOutputStream(), "UTF8"), true);
        out.println("<html><body>");
        out.print("<table border=\"1px\">");
        out.print("<tr>");
        out.print("<th>ID</th>");
        out.print("<th>Username</th>");
        out.print("<th>Password</th>");
        out.print("<th>Email</th>");
        out.print("<th>Create date</th>");
        out.print("<th>Delete</th>");
        out.print("<th>Edit</th>");
        out.print("</tr>");
        try {
            for(Map<String, Object> row: mainService.getNames()){
                out.println("<style>");
                out.println("td {\n" +
                        "  padding: 3px;\n" +
                        "  background-color: #ffffff;\n" +
                        "}");
                out.println("tr {\n" +
                        "  padding: 3px;\n" +
                        "  background-color: #ffffff;\n" +
                        "}");
                out.println("table {\n" +
                        "  table-layout: fixed;\n" +
                        "  width: 100%;\n" +
                        "  border-collapse: collapse;\n" +
                        "  border: 3px solid purple;\n" +
                        "}");
                out.println("body {\n" +
                        "    background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);\n" +
                        "    background-size: 400% 400%;\n" +
                        "    animation: gradient 20s ease infinite;\n" +
                        "    height: 100vh;\n" +
                        "}\n" +
                        "\n" +
                        "@keyframes gradient {\n" +
                        "    0% {\n" +
                        "        background-position: 0% 50%;\n" +
                        "    }\n" +
                        "    50% {\n" +
                        "        background-position: 100% 50%;\n" +
                        "    }\n" +
                        "    100% {\n" +
                        "        background-position: 0% 50%;\n" +
                        "    }\n" +
                        "}");
                out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f9f9f9; }");
                out.printlnt[typ(\"h2 { color: #333; text-align: center; }\");\n" +
                        "                out.println(\"form { background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 400px; margin: auto; }\");\n" +
                        "                out.println(\"label { display: block; margin-bottom: 5px; }\");\n" +
                        "                out.println(\"input[type='text'], inpue='number'] { width: 100%; padding: 10px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ddd; }");
                out.println("input[type='submit'] { background-color: #007BFF; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 5px; }");
                out.println("input[type='submit']:hover { background-color: #0056b3; }");
                out.println("</style>");
                out.print("<tr>");
                out.print("<td>"+row.get("user_id")+"</td>");
                out.print("<td>"+row.get("username")+"</td>");
                out.print("<td>"+row.get("password")+"</td>");
                out.print("<td>"+row.get("email")+"</td>");
                out.print("<td>"+row.get("created_at")+"</td>");
                out.print("<td>");
                out.print("<a href='delete?id="+row.get("user_id")+"'style='color: red;'>Удалить</a>");
                out.print("</td>");
                out.print("<td>");
                out.print("<a href='edit?id="+row.get("user_id")+"&username="+row.get("username")+"&password="+row.get("password")+"'style='color: purple;'>Изменить</a>");
                System.out.println(row.get("user_id"));
                out.print("</td>");
                out.print("</tr>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.print("</table>");
        out.print("<form method='post'>");
        out.print("<p>Введите username</p>");
        out.print("<input name='username' type='text' />");
        out.print("<p>Введите password</p>");
        out.print("<input name='password' type='text' />");
        out.print("<p>Введите email</p>");
        out.print("<input name='email' type='text' />");
        out.print("<p></p>");
        out.print("<input type='submit' value='Отправить'>");
        out.print("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        mainService.addName(username,password,email);
        resp.sendRedirect("/ikts_21_app_war/test");
    }
}
