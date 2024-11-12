package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jpan.DishManage;
import com.jpan.SeatManage;
import com.jpan.UserDianOrder;
import com.tools.Tools;
import com.util.DBUtilZ;

import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Color;

public class UserWindows {
//在类中定义了一个 JFrame 对象 frame 。
	JFrame frame;

	/**
	 * main 方法中，使用 EventQueue.invokeLater
	 * 在事件分发线程中创建 UserWindows 类的对象并设置窗口可见。
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UserWindows window = new UserWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 构造函数调用 initialize 方法进行窗口的初始化。
	 */
	public UserWindows() {
		initialize();
	}

	/**
	 * initialize 方法中：
	 * 设置窗口的背景颜色、位置、大小、默认关闭操作、布局等属性。
	 * 创建一个 JTabbedPane 选项卡面板，并向其中添加了一个名为 "菜品管理" 的选项卡，对应的面板是 UserDianOrder 。
	 * 设置选项卡面板的位置，并将其添加到窗口的内容面板中。
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.pink);
		frame.getContentPane().setBackground(new Color(239,145,161));
		frame.setBounds(100, 100, 943, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		Tools.setWindowPos(943, 566, frame);//让窗口剧中
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/ct.png"));
		frame.setTitle("订餐管理系统");
		
		
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBackground(new Color(210, 178, 179));
		
		UserDianOrder dishManage = new UserDianOrder();
		dishManage.setBackground(new Color(255, 255, 255));
		tabPane.add("菜品管理",dishManage);
		

		
		
		tabPane.setBounds(20, 10, 899, 499);
		frame.getContentPane().add(tabPane);
		
		
		
		
		
	}
}
