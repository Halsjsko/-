package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.dao.AdminDao;
import com.tools.Tools;
import com.util.DBUtilZ;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindows {

	private JFrame frmJava;
	public static JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
		// 在事件分发线程中执行后续的代码
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 创建 DBUtilZ 对象来建立数据库连接，使用给定的账号、密码和数据库名
					DBUtilZ db=new DBUtilZ("root","123456","db_order");//数据库账号  密码 数据库名字
					// 创建 LoginWindows 对象
					LoginWindows window = new LoginWindows();
					// 设置登录窗口可见
					window.frmJava.setVisible(true);
				} catch (Exception e) {
					// 打印异常栈跟踪信息
					e.printStackTrace();
				}
			}
		});
	}

	//创建应用程序
	public LoginWindows() {
		// 初始化窗口
		initialize();
	}
	//初始化窗口的内容
	private void initialize() {
		// 创建 JFrame 对象作为登录窗口
		frmJava = new JFrame();
		frmJava.setTitle("订餐管理系统");
		// 设置窗口图标
		frmJava.setIconImage(Toolkit.getDefaultToolkit().getImage("img/ct.png"));
		frmJava.setBounds(100, 100, 712, 510);
		frmJava.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmJava.getContentPane().setLayout(null);
		frmJava.setResizable(false);
		// 调用工具方法设置窗口居中
		Tools.setWindowPos(612, 410, frmJava);//让窗口剧中
		// 创建并添加账号标签
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(149, 131, 55, 38);
		frmJava.getContentPane().add(lblNewLabel);
		// 创建并添加账号输入文本框
		textField = new JTextField();
		textField.setBounds(214, 142, 229, 21);
		frmJava.getContentPane().add(textField);
		textField.setColumns(10);
		// 创建并添加密码标签
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(149, 190, 55, 30);
		frmJava.getContentPane().add(lblNewLabel_1);
		// 创建并添加安全登录按钮，并为其添加动作监听器
		JButton btnNewButton = new JButton("安全登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//按钮的点击事件
				//获取账号以及密码  进行登录
				String account=textField.getText();//获取账号
				String password=new String(passwordField.getPassword());
				if(account.equals("")) {
					Tools.messageWindows("请输入账号");
				}else  if(password.equals("")) {
					Tools.messageWindows("请输入密码");
				}else {
					AdminDao adminDao = new AdminDao();
					String res = adminDao.LoginAdmin(account, password);//res 0代表失败  1管理员  2普通用户
					// 根据登录结果进行不同的操作
					if(res.equals("1")) {
						ManageWindows window = new ManageWindows();
						window.frame.setVisible(true);
						frmJava.dispose();
					}else if(res.equals("2")) {
						UserWindows window = new UserWindows();
						window.frame.setVisible(true);
						frmJava.dispose();
					}else {
						Tools.messageWindows("账号或密码错误，请输入正确账号密码？");
					}
				}
			}
		});
		// 设置安全登录按钮的背景色、前景色、字体和位置，并添加到窗口的内容面板中
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton.setBounds(149, 256, 145, 38);
		frmJava.getContentPane().add(btnNewButton);
		// 创建并设置密码输入框，添加到窗口的内容面板中
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 197, 229, 21);
		frmJava.getContentPane().add(passwordField);
		// 创建并设置登录标题标签，添加到窗口的内容面板中
		JLabel lblNewLabel_4 = new JLabel("订餐管理系统登录");
		lblNewLabel_4.setForeground(new Color(135, 206, 250));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 37, 578, 69);
		frmJava.getContentPane().add(lblNewLabel_4);
		// 创建并设置注册账号按钮，添加动作监听器，设置相关属性，并添加到窗口的内容面板中
		JButton btnNewButton_1 = new JButton("注册账号");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//打开一个注册窗口
				RegisterWindows window = new RegisterWindows();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.blue);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(304, 256, 157, 38);
		frmJava.getContentPane().add(btnNewButton_1);
		// 创建并设置背景图片标签，添加到窗口的内容面板中
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("img/C.jpg"));
		lblNewLabel_3.setBounds(0, 0, 757, 479);
		frmJava.getContentPane().add(lblNewLabel_3);
	}
}
