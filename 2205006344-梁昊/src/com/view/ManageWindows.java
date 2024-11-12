package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jpan.DishManage;
import com.jpan.DishManageT;
import com.jpan.SeatManage;
import com.jpan.Statistics;
import com.jpan.Statistics2;
import com.tools.Tools;
import com.util.DBUtilZ;

import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Color;

public class ManageWindows {
//在类中定义了一个 JFrame 对象 frame 。
JFrame frame;
//main 方法中，使用 EventQueue.invokeLater 确保在事件分发线程中创建和操作窗口，
// 创建了 ManageWindows 类的对象 window ，并设置窗口可见。
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWindows window = new ManageWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//这段代码是一个 Java 类的构造函数 public ManageWindows() 。
// 在这个构造函数中，调用了 initialize() 方法。
	public ManageWindows() {
		initialize();
	}
//initialize 方法中：
//创建并设置了窗口的背景颜色、大小、默认关闭操作、布局等属性。
//创建了一个 JTabbedPane 选项卡面板，并向其中添加了多个选项卡，每个选项卡包含相应的面板对象（如 DishManage、SeatManage 等）。
//最后将选项卡面板添加到窗口的内容面板中。

	private void initialize() {
		frame = new JFrame();
		//调用set（），get（）方法设置和获取属性值
		frame.setBackground(new Color(247,217,225));
		frame.getContentPane().setBackground(new Color(247,217,225));
		frame.setBounds(100, 100, 943, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		Tools.setWindowPos(943, 566, frame);//让窗口剧中
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/ct.png"));
		frame.setTitle("订餐管理系统");
		
		
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBackground(new Color(215, 195, 184));
		
		DishManage dishManage = new DishManage();
		dishManage.setBackground(new Color(255, 255, 255));
		tabPane.add("菜品管理",dishManage);
		
		SeatManage set = new SeatManage();
		set.setBackground(new Color(255, 255, 255));
		tabPane.add("厅位管理",set);
		
		
		
		DishManageT dishManage1 = new DishManageT();
		dishManage1.setBackground(new Color(255, 255, 255));
		tabPane.add("上菜管理",dishManage1);
		
		
		Statistics dishManage11 = new Statistics();
		dishManage11.setBackground(new Color(255, 255, 255));
		tabPane.add("厅位统计信息",dishManage11);
		
		
		Statistics2 dishManage112 = new Statistics2();
		dishManage112.setBackground(new Color(255, 255, 255));
		tabPane.add("销量统计",dishManage112);
		
		tabPane.setBounds(20, 10, 899, 499);
		frame.getContentPane().add(tabPane);
		
	}
}
