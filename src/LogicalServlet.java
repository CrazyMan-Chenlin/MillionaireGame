import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.Random;

@javax.servlet.annotation.WebServlet(name = "LogicalServlet",urlPatterns = "/LogicalServlet")
public class LogicalServlet extends javax.servlet.http.HttpServlet {

    int num;
    public int getNum() {
        Random random = new Random();
        int num = random.nextInt(31);
        return num;
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         doGet(request,response);
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String status="action";
        String message=null;
        int count=5;
        String guess=request.getParameter("guessNum");
        String time = request.getParameter("count");
        if(time!=null&&!time.equals("")){
            count=Integer.parseInt(time);
            count--;
        }
            if (guess != null && !guess.equals("")) {
                int guessName = Integer.parseInt(request.getParameter("guessNum"));
                if (guessName == num) {
                    message = "��ϲ���н���,��������ѳ���һֻ��";
                    status = "over";
                } else if (guessName > num) {
                    message = "��ϧ��̫����";
                } else if (guessName < num) {
                    message = "��ϧ��̫С��";
                }
            } else {
                message = "��Ϸ��ʼ";
                num = getNum();
                System.out.println(num);
                count = 5;
            }
            if (count == 0) {
                if (!message.equals("��ϲ���н���,��������ѳ���һֻ��")) {
                    message = "��Ϸ����";
                }
                status = "over";
                count = 5;
            }
            request.setAttribute("message", message);
            request.setAttribute("count", count);
            request.setAttribute("status", status);
            request.getRequestDispatcher("/").forward(request, response);
    }
}
