package com.jpan;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bean.DishBean;
import com.dao.DishDao;
import com.tools.Table;
import com.tools.Tools;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;

public class DishManage extends JPanel {
	//类中定义了多个文本框 textField 等用于输入菜品的各种信息。
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	//构造函数中：
	//设置了布局和面板的属性。
	//创建并设置了菜品相关信息的标签和文本框。
	//为“增加菜品”、“删除菜品”、“更改菜品”、“查找菜品”等按钮添加了动作监听器
	// 实现了相应的操作逻辑，包括输入校验、与数据库交互等。
	//创建了一个表格，并在“查找菜品”按钮的点击事件中根据输入情况
	// 从数据库获取数据并填充到表格中，同时根据查找结果设置相应的文本框内容。
	public DishManage() {
		// 设置布局为空布局，并设置自身的位置和大小
		setLayout(null);
		this.setBounds(10, 10,899, 499);
		// 创建一个面板
		JPanel panel = new JPanel();
		// 设置面板背景颜色
		panel.setBackground(new Color(244, 180, 185));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u83DC\u54C1\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 153)));
		// 设置面板边框
		panel.setBounds(10, 10, 866, 144);
		add(panel);
		// 将面板添加到当前面板，并设置面板的布局为空布局
		panel.setLayout(null);
		// 创建并设置标签
		JLabel lblNewLabel = new JLabel("菜品名称");
		lblNewLabel.setBounds(5, 24, 59, 15);
		// 将标签添加到面板
		panel.add(lblNewLabel);
		// 创建文本框
		textField = new JTextField();
		textField.setBounds(74, 21, 216, 21);
		panel.add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("菜品口味");
		lblNewLabel_1.setBounds(5, 51, 59, 15);
		panel.add(lblNewLabel_1);
		// 创建对应的文本框
		textField_1 = new JTextField();
		textField_1.setBounds(74, 48, 216, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		// 以下部分类似，创建并设置菜品价格、菜品详情等相关的标签和文本框
		JLabel lblNewLabel_2 = new JLabel("菜品价格");
		lblNewLabel_2.setBounds(5, 76, 59, 15);
		panel.add(lblNewLabel_2);
		textField_2 = new JTextField();
		textField_2.setBounds(74, 73, 216, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("菜品详情");
		lblNewLabel_3.setBounds(5, 101, 59, 15);
		panel.add(lblNewLabel_3);
		textField_3 = new JTextField();
		textField_3.setBounds(74, 98, 216, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblNewLabel_6 = new JLabel("菜品名称（操作）");
		lblNewLabel_6.setBounds(456, 24, 139, 15);
		panel.add(lblNewLabel_6);
		textField_4 = new JTextField();
		textField_4.setBounds(579, 21, 155, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		JButton btnNewButton_1 = new JButton("增加菜品");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 增加菜品按钮的点击事件处理逻辑
				String name=textField.getText();
				String kouwei=textField_1.getText();
				String jaga=textField_2.getText();
				String xiangqing=textField_3.getText();
				// 检查输入是否为空，并给出相应提示
				if(name.equals("")) {
					Tools.messageWindows("请输入菜品名字");
				}else if(kouwei.equals("")) {
					Tools.messageWindows("请输入菜品口味");
				}else if(jaga.equals("")) {
					Tools.messageWindows("菜品价格不能为空");
				}else if(xiangqing.equals("")) {
					Tools.messageWindows("请输入菜品详情");
				}else {
					// 检查价格输入是否为有效的数字
					Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
			        Matcher isNum = pattern.matcher(jaga);
			        if (!isNum.matches()) {
			        	Tools.messageWindows("菜品价格输入有误");
			        }else {
			        	//在这里执行插入语句
			        	DishBean dishBean = new DishBean(name,kouwei,jaga,xiangqing);
			        	int a=new DishDao().saveDish(dishBean);
						// 根据操作结果给出提示
						if(a==0||a==-1) {
			        		Tools.messageWindows("添加失败，菜品名称重复");
			        	}else {
			        		Tools.messageWindows("添加成功");
			        	}
			        }
				}
			}
		});
		btnNewButton_1.setBounds(456, 51, 97, 23);
		panel.add(btnNewButton_1);
		// 创建并设置增加菜品按钮，添加动作监听器，设置位置，添加到面板
		JButton btnNewButton_1_1 = new JButton("删除菜品");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textField_4.getText();
				if(name.equals("")) {
					Tools.messageWindows("请输入菜品名字(操作)");
				}else {
					DishBean dishBean = new DishBean();
					dishBean.setDname(name);
		        	int a=new DishDao().delDish(dishBean);
		        	if(a==0||a==-1) {
		        		Tools.messageWindows("删除失败，菜品不存在");
		        	}else {
		        		Tools.messageWindows("删除成功");
		        	}
				}
			}
		});
		btnNewButton_1_1.setBounds(456, 100, 97, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("更改菜品");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//增加菜品
				String name=textField.getText();
				String kouwei=textField_1.getText();
				String jaga=textField_2.getText();
				String xiangqing=textField_3.getText();
				String name1=textField_4.getText();
			
				if(name.equals("")) {
					Tools.messageWindows("请输入菜品名字");
				}else if(kouwei.equals("")) {
					Tools.messageWindows("请输入菜品口味");
				}else if(jaga.equals("")) {
					Tools.messageWindows("菜品价格不能为空");
				}else if(xiangqing.equals("")) {
					Tools.messageWindows("请输入菜品详情");
				}else 	if(name.equals("")) {
					Tools.messageWindows("请输入菜品名字(操作)"); 
				}else {
					Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
			        Matcher isNum = pattern.matcher(jaga);
			        if (!isNum.matches()) {
			        	Tools.messageWindows("菜品价格输入有误");
			        }else {
			        	DishBean dishBean = new DishBean(name,kouwei,jaga,xiangqing);
			        	int a=new DishDao().upDish(dishBean,name1);
			        	if(a==0||a==-1) {
			        		Tools.messageWindows("更改失败，菜品不存在或者名字重复");
			        	}else {
			        		Tools.messageWindows("更改成功");
			        	}
			        }
				}
			}
		});
		btnNewButton_1_2.setBounds(563, 51, 97, 23);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("查找菜品");
		
		btnNewButton_1_3.setBounds(563, 97, 97, 23);
		panel.add(btnNewButton_1_3);
		//________________________________________________________
		
		Object columns[] ={"菜品名字","菜品口味","菜品价格","菜品简介"};//创建表格	
		Table t1Table=new Table(columns);
		JScrollPane JS = t1Table.getJScrollPane();
		DefaultTableModel model = t1Table.getModel();
		JS.setPreferredSize(new Dimension(800,280));//设置整个滚动条窗口的大小
		JS.setBounds(10, 164, 866, 325);
		add(JS);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField_4.getText();
				if(name.equals("")) {
					//查找全部
					ResultSet rs = new DishDao().showDish();
					int count = Tools.addDataTable(rs, model, 4);//向表格里面添加数据
				}else {
					//查找单个
					ResultSet rs = new DishDao().showDish(name);
					int count = Tools.addDataTable(rs, model, 4);//向表格里面添加数据
					ResultSet rs2 = new DishDao().showDish(name);
					try {
						if(rs2.next()) {
							
							textField.setText(rs2.getString(1));
							textField_1.setText(rs2.getString(2));
							textField_2.setText(rs2.getString(3));
							textField_3.setText(rs2.getString(4));
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
