package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TicketDAO {

	/*
	Spring-JDBC를 사용하기위한 멤버변수와 setter()
	트랜잭션 처리를 위한 매니져클래스의 멤버변수와 setter()
	 */
	JdbcTemplate template;
	PlatformTransactionManager transactionManager;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	/*servlet-context.xml에서 빈을 생성할때 setter를 사용한다.*/
	public TicketDAO() {
		System.out.println("TicketDAO생성자 호출");
	}
	//티켓구매와 결제를 위한 메소드
	public void buyTicket(final TicketDTO dto) {
		
		System.out.println("buyTicket() 메소드 호출");
		System.out.println(dto.getCustomerId()+"님이 티켓"+dto.getAmount()
				+"장을 구매합니다.");
		//DAO에서 트랜잭션 처리를 위한 객체생성
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
	
		/*
		2개의 업무를 하나의 프로세스로 처리하기위해 try~catch로 묶어준다.
		만약 하나라도 업무에 문제(예외)가 생기게된다면 예외가 발생하여
		모든 업무는 rollback되게 될것이다.
		 */
		try {
			//티켓 구매 금액에 대한 DB처리
			template.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

					String query = "INSERT INTO "
							+ " transaction_pay (customerId, amount) "
							+ " VALUES(?,?)";
					PreparedStatement psmt = 
							con.prepareStatement(query);
					psmt.setString(1, dto.getCustomerId());
					//티켓 1장에 10000원이라고 가정
					psmt.setInt(2, dto.getAmount()*10000);
					
					return psmt;
				}
			});
			//티켓구매 갯수에 대한 DB처리
			/*
			check제약조건에 의해 구매갯수가 5장을 초과하는 경우
			제약조건 위배로 예외가 발생한다.
			 */
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					
					String query = "INSERT INTO "
							+ "transaction_ticket (customerId, countNum)"
							+ " VALUES(?,?)";
					PreparedStatement psmt = 
							con.prepareStatement(query);
					psmt.setString(1, dto.getCustomerId());
					psmt.setInt(2, dto.getAmount());
					return psmt;
				}
			});
			/*
			티켓 구매갯수가 5장 이하인경우 정상처리되어 모든 작업이 commit된다.
			 */
			System.out.println("카드결제와 티켓구매 모두 정상처리 되었습니다.");
			transactionManager.commit(status);
		}
		catch (Exception e) {
			/* 
			티켓구매갯수가 5장을 초과하는 경우에는 예외가 발생하여 모든 작업이
			rollback된다.
			 */
			System.out.println("제약조건을 위배하여 카드결제와 티켓구매"
					+ "모두가 취소 되었습니다.");
			transactionManager.rollback(status);
		}
	}
	
}
