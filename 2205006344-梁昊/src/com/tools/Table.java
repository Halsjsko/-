package com.tools;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {
	//定义了 JTable 对象 tableL
	// JScrollPane 对象 jscrollpane 和 DefaultTableModel 对象 model 。
	JTable tableL=null;//定义一个表格
	JScrollPane jscrollpane;//滚动条
	DefaultTableModel  model = null;//默认模式
//构造函数 Table(Object[] columns) 调用了同名的 Table 方法来进行初始化操作。
	public Table(Object columns[]) {
		Table(columns);
	}
	//Table 方法中创建了 JTable 对象，设置了不可编辑的模式
	// 为表格设置列名，并对表头的重排序和调整大小进行了限制
	// 最后为表格添加了垂直滚动条。
	void Table(Object columns[]) {
		tableL=getTable(columns);
		jscrollpane=new JScrollPane(tableL);
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);	//设置滚动条放心为竖着的
	}
	//getTable 方法用于获取或创建并配置 JTable 对象。
	//getTables 方法返回 JTable 对象。
	//getJScrollPane 方法返回包含表格的滚动面板。
	//getModel 方法返回表格的数据模型。
	 JTable getTable(Object columns[]) {
		if(tableL==null) {
			tableL=new JTable();//
			model=new DefaultTableModel() {
				public boolean isCellEditable(int row, int column)
				{
				return false;
				}
				
			};
		model.setColumnIdentifiers(columns);
		tableL.setModel(model);
		tableL.getTableHeader().setReorderingAllowed(false);
		tableL.getTableHeader().setResizingAllowed(false);
		}
		
		return tableL;
	}
	 //返回表格
	 public JTable getTables() {
		 return tableL;
	 }
	 public  JScrollPane getJScrollPane() {
		 return jscrollpane;
	 }
	 public DefaultTableModel getModel() {
		 return model;
	 }
}
