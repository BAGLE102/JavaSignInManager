import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
class User {
	public String account;
	public String password;
	public String signinTime;
	public String fileName;
	public User(){
		this("empty", "empty",null);
	}
	public User(String account, String password, String signinTime) {
		this.account = account;
		this.password = password;
		this.signinTime = signinTime;
    }
}
class UserPanel {
	User user;
	User users[];
	JFrame frame;
	public UserPanel(User user,User users[]){
		this.user = user;
		this.users = users;
		
		//創建用戶視窗
		JFrame frame = new JFrame("用戶介面");
		JPanel panel = new JPanel(new GridLayout(3, 1));
		
		//顯示用戶資訊
		JLabel accountLabel = new JLabel("用戶 :"+user.account);
		panel.add(accountLabel);
		
		//顯示簽到時間
		JLabel signinTimeLabel = new JLabel("最近簽到時間 :"+user.signinTime);
		panel.add(signinTimeLabel);
		
		//建立顯示已簽到的按鈕
		JButton showSinginListButton = new JButton("顯示已簽到的");
		showSinginListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				showSinginList();
			}
		});
		panel.add(showSinginListButton);
		
		//建立更改密碼的按鈕
		JButton changePasswordButton = new JButton("更改密碼");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				changePassword();
			}
		});
		panel.add(changePasswordButton);
		
		//將物件套到視窗上
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	private void showSinginList(){
		for(User user_:users){
			if(user_.account=="empty"){
				break;
				}
			if(user_.signinTime!=null&&!user_.signinTime.isEmpty())
				System.out.println("用戶 : "+user_.account+"最近簽到時間："+user_.signinTime);
		}
	} 
	private void changePassword(){
		String newPassword = JOptionPane.showInputDialog(frame,"請輸入新密碼");
		if(newPassword !=null){
			user.password = newPassword;
			JOptionPane.showMessageDialog(frame,"密碼更新成功!");
		}
	}
}
class Hw{
	static void openFile(String fileName,User users[])throws Exception{
		Scanner sc =new Scanner(new File(fileName));
		int count = 0;
		while(sc.hasNextLine()){
			String data = sc.nextLine();
			System.out.println(data);
			classify(users,data,count);
			count++;
		}
		
	}
	static void classify(User users[],String data,int count)throws Exception{
		String[] data_ = data.split("\\s+"); 
		users[count] = new User(data_[0],data_[1],null);
	}
	static void login(User users[])throws Exception{
		
		//建立視窗
		JFrame frame = new JFrame("簽到登入");
		JPanel panel = new JPanel(new GridLayout(2, 2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		
		//帳號介面:
		JLabel accountLabel = new JLabel("Account:");
		panel.add(accountLabel);
		JTextField accountText = new JTextField(20);//文字輸入框
		panel.add(accountText);
		panel.add(Box.createVerticalStrut(10)); // 空隙高度為 10 pixel
		//密碼介面:
		JLabel passwordLabel = new JLabel("Password:");
		panel.add(passwordLabel);
		JTextField passwordText = new JTextField(20);//文字輸入框
		panel.add(passwordText);
		
		//Button
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = accountText.getText();
				String password = passwordText.getText();
				checkPasswoed(users,account,password,frame);
			}
		});
		panel.add(button);
		
		//將所有物件新增到視窗上
		frame.add(panel);
		frame.setVisible(true);
	}
	static void checkPasswoed(User users[],String account,String password,JFrame frame){

		boolean loginSuccessful = false;
		
		// 在users中尋找對應的使用者
		for (User user : users) {
			if (user != null && user.account.equals(account)) {
			// 如果帳號和密碼都匹配則登入成功
				if (user.password.equals(password)) {
					loginSuccessful = true;
					Date signinTime = new Date();
					DateFormat formatter = DateFormat.getInstance();
					System.out.println(account+"最近簽到時間：" + formatter.format(signinTime));
					JOptionPane.showMessageDialog(frame, account+"最近簽到時間 :"+formatter.format(signinTime));
					user.signinTime = formatter.format(signinTime);
					UserPanel ui = new UserPanel(user,users);
				}
				break;
			}
		}
		
		if (!loginSuccessful){
			JOptionPane.showMessageDialog(frame, "帳號/密碼不符，不要代簽!");
		}
	}
	public static void main(String[] args)throws Exception{
		User[] users = new User[1001];
		String fileName = args[0];
		System.out.println(fileName);
		openFile(fileName,users);
		login(users);
	}
}