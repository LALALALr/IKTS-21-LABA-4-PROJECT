package servlets;

import services.MainService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private final MainService mainService;

    public EditServlet() {
        this.mainService = new MainService();
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int user_id = Integer.parseInt((req.getParameter("user_id")));

            String username = req.getParameter("username");

            String password = req.getParameter("password");

            mainService.editName(user_id, username, password);
            resp.sendRedirect("/ikts_21_app_war/test");
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID/Username/Password");
        }
    }*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int user_id = Integer.parseInt(req.getParameter("user_id"));
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(user_id+"     "+username+"      "+password);
            mainService.editName(user_id, username, password);
            resp.sendRedirect("/ikts_21_app_war/test");
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID/Username/Password");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><head>");
        out.println("<style>");
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
        out.println("h2 { color: #333; text-align: center; }");
        out.println("form { background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 400px; margin: auto; }");
        out.println("label { display: block; margin-bottom: 5px; }");
        out.println("input[type='text'], input[type='number'] { width: 100%; padding: 10px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ddd; }");
        out.println("input[type='submit'] { background-color: #007BFF; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 5px; }");
        out.println("input[type='submit']:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head><body>");
        out.print("<h2>Редактирование</h2>");
        out.print("<form method='post' action='/ikts_21_app_war/edit'>");
        out.print("<input type='hidden' name='user_id' value='" + req.getParameter("id") + "'>");
        out.print("<label for='username'>Username:</label>");
        out.print("<input type='text' id='username' name='username' value='" + req.getParameter("username") + "'>");
        out.print("<label for='password'>Password:</label>");
        out.print("<input type='text' id='password' name='password' value='" + req.getParameter("password") + "'>");
        out.print("<input type='submit' value='Сохранить изменения'>");
        out.print("</form>");
        out.println("</body></html>");
    }
}