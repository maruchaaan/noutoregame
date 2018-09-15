package servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuizLibrary;
import model.Quizz;
import model.count;

/**
 * Servlet implementation class QuizServlet2
 */
@WebServlet("/QuizServlet2")
public class QuizServlet2 extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuizServlet2() {
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

		// System.out.println(list.get(qtimes)); //確認用

		QuizLibrary ql = new QuizLibrary(list);
		count c = new count(list);

		Quizz q = new Quizz(ql.getQst(list.get(c.getQcount())), ql.getQleft(list.get(c.getQcount())),
				ql.getQright(list.get(c.getQcount())), ql.getAnswer(list.get(c.getQcount())));

		System.out.println(q.getqst()); // 確認用

		// セッションスコープにインスタンスを保存
		HttpSession session = request.getSession();

		session.setAttribute("q", q);

		session.setAttribute("c", c);

		System.out.println("むりです");
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quiz2.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		// セッションスコープからクイズ情報を取得
		HttpSession session = request.getSession();
		Quizz q = (Quizz) session.getAttribute("q");
		count c = (count) session.getAttribute("c");

		ArrayList<Integer> list = new ArrayList<Integer>();
		list = c.getRndnumber();
		QuizLibrary ql = new QuizLibrary(list);

		// 答えが正しかったら現在の正解数＋１
		String name = request.getParameter("name"); // 確認用
		System.out.println(name);
		System.out.println(q.getqAnswer());

		if (name.equals(q.getqAnswer())) {
			System.out.println("true!"); // 確認用
			c.setCorrCount();
		}

		c.setQcount(); // 0～9のうち次は何問目か(+1している)

		// qcount++; // 問題数＋１

		// 次がもし10問目なら問題が終了しているため、結果の画面にうつる。
		if (c.getQcount() == 10) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		} else {
			Quizz q2 = new Quizz(ql.getQst(list.get(c.getQcount())), ql.getQleft(list.get(c.getQcount())),
					ql.getQright(list.get(c.getQcount())), ql.getAnswer(list.get(c.getQcount())));

			// セッションスコープにインスタンスを保存
			session.setAttribute("q", q2);
			session.setAttribute("c", c);

			// 0~9問目なら、次の問題
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quiz2.jsp");
			dispatcher.forward(request, response);
		}
	}

}
