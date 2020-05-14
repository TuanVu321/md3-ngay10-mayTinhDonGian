import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = Float.parseFloat(request.getParameter("first-operand"));
        float secont = Float.parseFloat(request.getParameter("second-operand"));
        String operator = request.getParameter("operator");
        float result = 0;
        int message = 0;
        PrintWriter printWriter = response.getWriter();

        switch (operator) {
            case "Cong":
                result = first + secont;
                break;
            case "Tru":
                result = first - secont;
                break;
            case "Nhan":
                result = first * secont;
                break;
            case "Chia":
                if (secont != 0)
                    result = first / secont;
                else
                    message = 1;
        }
        if (message == 1) {
            message = 0;
            printWriter.println("<html>");
            printWriter.println("<h2>Khong chia duoc cho so 0</h2>");
            printWriter.println("</html>");
        } else {
            printWriter.println("<html>");
            printWriter.println("<h2> Result </h2>");
            printWriter.println("<h3>" + result + "</h2>");
            printWriter.println("<html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
