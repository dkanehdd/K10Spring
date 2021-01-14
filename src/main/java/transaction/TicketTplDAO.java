package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TicketTplDAO {
	
	JdbcTemplate template;//Spring-JDBC사용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	TransactionTemplate transactionTemplate;//트랜잭션 템플릿사용
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	//생성자
	public TicketTplDAO() {
		System.out.println("TicketTplDAO() 생성자 호출됨");
	}
	
	public boolean buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()메소드 호출");
		System.out.println(dto.getCustomerId()+"님이 티켓"+dto.getAmount()
		+"장을 구매합니다.");
		
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {

					//티켓 결제금액 처리
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
					//티켓 구매갯수에 대한 처리
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
				}
			});
			/*
			모든 업무에 대해 성공처리 되었을때 true를 반환한다.
			별도의 commit() 혹은 rollback()이 필요없다.
			 */
			System.out.println("카드결제와 티켓구매 모두 정상처리 되었습니다.");
			System.out.println("=트랜잭션 템플릿 사용함=");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("제약조건 위반으로 모두 취소되었습니다.");
			return false;
		}
	}
}
