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
	
	public TicketDAO() {
		System.out.println("TicketDAO생성자 호출");
	}
	
	public void buyTicket(final TicketDTO dto) {
		
		System.out.println("buyTicket() 메소드 호출");
		System.out.println(dto.getCustomerId()+"님이 티켓"+dto.getAmount()
				+"장을 구매합니다.");
		
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
	
		try {
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
			System.out.println("카드결제와 티켓구매 모두 정상처리 되었습니다.");
			transactionManager.commit(status);
		}
		catch (Exception e) {
			System.out.println("제약조건을 위배하여 카드결제와 티켓구매"
					+ "모두가 취소 되었습니다.");
			transactionManager.rollback(status);
		}
	}
	
}
