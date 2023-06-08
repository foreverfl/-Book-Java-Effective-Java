package chapter02_CreatingAndDestroyingObjects;

/* - 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않음
 * - 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식
 * */

public class _05_InjectDependentObjects {

	// EmailService Interface에 의존하는 클래스
	public static class UserService {
		private static EmailService emailService;

		public UserService(EmailService emailService) {
			UserService.emailService = emailService;
		}

		public void sendWelcomeEmail(String username) {
			// 사용자에게 환영 이메일 보내기
			String message = "Welcome, " + username + "! Enjoy our services!";
			emailService.sendEmail(username, "Welcome", message);
		}
	}

	public static interface EmailService {
		void sendEmail(String recipient, String subject, String message);
	}

	public static class EmailServiceImpl implements EmailService {
		@Override
		public void sendEmail(String recipient, String subject, String message) {
			// 이메일 보내는 로직 구현
			System.out.println("Sending email to " + recipient + " with subject: " + subject);
			System.out.println("Message: " + message);
		}
	}

	public static void main(String[] args) {
		EmailService emailService = new EmailServiceImpl();
		UserService userService = new UserService(emailService);

		userService.sendWelcomeEmail("John");
	}

}
