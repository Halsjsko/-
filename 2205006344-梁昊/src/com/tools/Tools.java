package com.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.DynamicMBean;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.mysqld.Mysqld;

public class Tools {
	//setWindowPos 方法用于将指定的 JFrame 窗口设置为居中显示。
	// 它通过获取屏幕的尺寸，计算出窗口应该放置的位置，然后设置窗口的边界。
	public static void setWindowPos(int WIDTH,int HEIGHT,JFrame jframe) {
		//传递过来宽和高
		   //设置成静态可以随时随地调用
        //设置窗口的位置以及大小  将窗口传递过来
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;//取宽度和高度
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        jframe.setBounds(x, y, WIDTH, HEIGHT);
	}
	//getPassword 方法用于从 JPasswordField 组件中获取输入的密码
	// 并将其以字符串形式返回。
	public static String getPassword(JPasswordField jp) {
		String password=new String(jp.getPassword());
		return password;
	}
	//messageWindows 方法用于弹出一个包含指定消息的对话框，显示警告信息。
	public static void messageWindows(String msg) {
		JOptionPane.showMessageDialog(null,  msg,"消息",JOptionPane.WARNING_MESSAGE);
	}
	//addDataTable 方法用于将 ResultSet 中的数据添加
	// 到指定的 DefaultTableModel 中，并返回添加的行数。
	public static  int addDataTable(ResultSet rs ,DefaultTableModel  model,int index) {
		int count=0;
		model.setNumRows(0);
		String  data[]=new String [index];
		try {
			while(rs.next()) {
				count++;
				for(int i=0;i<data.length;i++) {
					data[i]=rs.getString(i+1);
				}
				model.addRow(data);
			}
			rs.close();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return count;
		}
	}
}
