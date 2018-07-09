package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import model.QuizLibrary;
import model.Quizz;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// static int qcount = 0;
	static int corcount = 0;
	static int uncorcount = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuizServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) { // 0～9の数字の配列
			list.add(i);
		}
		Collections.shuffle(list); // 配列並び替え
		System.out.println(list); // 確認用


		// qcount=0; //0題目にセット
		// System.out.println(list.get(qtimes)); //確認用

		QuizLibrary ql = new QuizLibrary(list);

		// Quizz q = new
		// Quizz(ql.getQst(qtimes),ql.getQleft(qtimes),ql.getQright(qtimes),ql.getAnswer(qtimes));
		// ql.setQtimes(0);

		// セッションスコープにインスタンスを保存
		HttpSession session = request.getSession();
		// session.setAttribute("q", q);
		session.setAttribute("ql", ql);

		// リクエストスコープにインスタンスを保存?

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		// doGet(request, response);

		// セッションスコープからクイズ情報を取得
		HttpSession session = request.getSession();
		QuizLibrary ql = (QuizLibrary) session.getAttribute("ql");
		
		String name = request.getParameter("name");
		System.out.println(name);
	
		if(ql.getAnswer()==name) {
			corcount++;
		}else {
			uncorcount++;
		}
		
		
		
		ql.setQtimes(); // 0～9のうち次は何問目か(+1している)
		// セッションスコープにインスタンスを保存
		session.setAttribute("ql", ql);

		// 次がもし10問目なら問題が終了しているため、結果の画面にうつる。
		if (ql.getQtimes() == 10) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}

		// Quizz q = (Quizz) session.getAttribute("q");

		// 0~9問目なら、次の問題
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp");
		dispatcher.forward(request, response);

	}

}
