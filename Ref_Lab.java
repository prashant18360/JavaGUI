package newProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Runner {
	String name;
	String time;
	String category;
	Runner next;
	Runner head;
	public Runner(String name,String time,String category) {
		this.name = name;
		this.time = time;
		this.category = category;
		this.next = null;
	}
	public Runner() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void insertadd(String n,String t,String c) {
		Runner newnode = new Runner(n,t,c);
		if(head == null) {
			head = newnode;
			return ;
		}
		Runner current = head;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = newnode;
	}
	
	public void display() {
		if(head == null) {
			return;
		}
		Runner current = head;
		while(current!=null) {
			System.out.println(current.name + " " + current.time + "  " + current.category);
			current = current.next;
		}
		//System.out.print("null");
	}
	public String[] findnames(int wf1,int wf2,int wf3,int ws1,int ws2,int ws3) {
		String[] str = new String[6];
		Runner temp = head;
		while(temp!=null) {
			if(Integer.parseInt(temp.getTime()) == wf1) {
				str[0] = temp.getName();
			}
			else if(Integer.parseInt(temp.getTime()) == ws1) {
				str[1] = temp.getName();
			}
			else if(Integer.parseInt(temp.getTime()) == wf2) {
				str[2] = temp.getName();
			}
			else if(Integer.parseInt(temp.getTime()) == ws2) {
				str[3] = temp.getName();
			}
			else if(Integer.parseInt(temp.getTime()) == wf3) {
				str[4] = temp.getName();
			}
			else if(Integer.parseInt(temp.getTime()) == ws3) {
				str[5] = temp.getName();
			}
			temp = temp.next;
		}
		return str;
	}
	
}



public class Ref_Lab {
	
	
	public static JPanel c_name;
	public static JLabel l_name;
	public static JTextField tf_name;
	public static JPanel c_time;
	public static JLabel l_time;
	public static JTextField tf_time;
	public static int wf1 = Integer.MAX_VALUE;
	public static int wf2 = Integer.MAX_VALUE;
	public static int wf3 = Integer.MAX_VALUE;
	public static int ws1 = Integer.MAX_VALUE;
	public static int ws2 = Integer.MAX_VALUE;
	public static int ws3 = Integer.MAX_VALUE;
	
	public static Runner lobj;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//lobj = new ListNode();
		//LinkedList<> object = new LinkedList<>();	
		//Ref_Lab obj;
		lobj = new Runner();
		JFrame frame = new JFrame("Form");
		
		JPanel c_main = new JPanel();
		c_main.setLayout(new BoxLayout(c_main,BoxLayout.Y_AXIS));
		
		c_name = new JPanel();
		c_name.setLayout(new FlowLayout(FlowLayout.CENTER));
		c_main.add(c_name);
		
		l_name= new JLabel("Name");
		tf_name = new JTextField();
		tf_name.setPreferredSize(new Dimension(150,50));
		c_name.add(l_name);
		c_name.add(tf_name);
		
		////////////////////
		
		c_time = new JPanel();
		c_time.setLayout(new FlowLayout(FlowLayout.CENTER));
		c_main.add(c_time);
		
		l_time = new JLabel("Time");
		tf_time = new JTextField();
		tf_time.setPreferredSize(new Dimension(150,50));
		c_time.add(l_time);
		c_time.add(tf_time);
		
		/////////////////////
		
		JPanel c_cat = new JPanel();
		c_cat.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel l_cat = new JLabel("Category");
		c_cat.add(l_cat);
		c_main.add(c_cat);
		
		ButtonGroup bg_cat = new ButtonGroup();
		
		JRadioButton rb_half = new JRadioButton("Half Marathon");
		JRadioButton rb_open = new JRadioButton("Open 10k Run");
		JRadioButton rb_great = new JRadioButton("Great Delhi Run");
		
		bg_cat.add(rb_half);
		bg_cat.add(rb_open);
		bg_cat.add(rb_great);
		
		c_cat.add(rb_half);
		c_cat.add(rb_open);
		c_cat.add(rb_great);
		
		
		
		////////////////////////
		
		JPanel c_button  = new JPanel();
		c_button.setLayout(new FlowLayout(FlowLayout.CENTER));
		//p_main.add(p_message);
		JButton b_cancel = new JButton("CANCEL");
		JButton b_winner = new JButton("WINNER");
		JButton b_next = new JButton("NEXT");
		
		b_next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = tf_name.getText();
				String t = tf_time.getText();
				//ListNode lobj = new ListNode(r);
				if(rb_half.isSelected()) {
					lobj.insertadd(s, t, "Half Marathon");
					if(wf1 > Integer.parseInt(t)) {
						wf1 = Integer.parseInt(t);
					}
					if(ws1 > Integer.parseInt(t) && wf1 < Integer.parseInt(t)) {
						ws1 = Integer.parseInt(t);
					}
				}
				else if(rb_open.isSelected()) {
					lobj.insertadd(s, t, "Open 10k Run");
					if(wf2 > Integer.parseInt(t)) {
						wf2 = Integer.parseInt(t);
					}
					if(ws2 > Integer.parseInt(t) && wf2 < Integer.parseInt(t)) {
						ws2 = Integer.parseInt(t);
					}
				}
				else if(rb_great.isSelected()) {
					lobj.insertadd(s, t, "Great Delhi Run");
					if(wf3 > Integer.parseInt(t)) {
						wf3 = Integer.parseInt(t);
					}
					if(ws3 > Integer.parseInt(t) && wf3 < Integer.parseInt(t)) {
						ws3 = Integer.parseInt(t);
					}
				}
				//lobj.insertadd(s,t,st);
				tf_name.setText("");
				tf_time.setText("");
				bg_cat.clearSelection();
				
				
			}
			
		} );
		
		b_winner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = tf_name.getText();
				String t = tf_time.getText();
				if(rb_half.isSelected()) {
					lobj.insertadd(s, t, "Half Marathon");
					if(wf1 > Integer.parseInt(t)) {
						wf1 = Integer.parseInt(t);
					}
					if(ws1 > Integer.parseInt(t) && wf1 < Integer.parseInt(t)) {
						ws1 = Integer.parseInt(t);
					}
				}
				else if(rb_open.isSelected()) {
					lobj.insertadd(s, t, "Open 10k Run");
					if(wf2 > Integer.parseInt(t)) {
						wf2 = Integer.parseInt(t);
					}
					if(ws2 > Integer.parseInt(t) && wf2 < Integer.parseInt(t)) {
						ws2 = Integer.parseInt(t);
					}
				}
				else if(rb_great.isSelected()) {
					lobj.insertadd(s, t, "Great Delhi Run");
					if(wf3 > Integer.parseInt(t)) {
						wf3 = Integer.parseInt(t);
					}
					if(ws3 > Integer.parseInt(t) && wf3 < Integer.parseInt(t)) {
						ws3 = Integer.parseInt(t);
					}
				}
				//lobj.insertadd(s,t,c);
				//lobj.display();
				String[] sty = new String[6]; 
				sty = lobj.findnames(wf1, wf2, wf3,ws1,ws2,ws3);
				/*System.out.println(sty[0] + " "+ wf1 + " " + "280k");
				System.out.println(sty[1] + " "+ ws1 + " " + "210k");
				System.out.println(sty[2] + " " + wf2 + " "+ "190k");
				System.out.println(sty[3] + " "+ ws2 + " " + "150k");
				System.out.println(sty[4] + " "+ wf3+ " " + "135k");
				System.out.println(sty[5] + " " + ws3 + " " + "115k");*/
				JFrame f = new JFrame("Winner");
				JLabel hm = new JLabel("HALF MARATHON");
				hm.setLocation(280, 50);
				JLabel l1 = new JLabel(sty[0] + "  -- >First winner : 280000");
				
				JLabel l11 = new JLabel(sty[1] + "  -- >second winner : 210000");
				
				JLabel oR = new JLabel("OPEN 10K RUN");
				oR.setLocation(280,110);
				JLabel oR1 = new JLabel(sty[2] + "  -- >First winner : 190000");
				JLabel oR11 = new JLabel(sty[3] + "  -- >second winner : 150000");
				
				JLabel gdR = new JLabel("GREAT DELHI RUN");
				gdR.setLocation(280, 170);
				JLabel gdR1 = new JLabel(sty[4] + "  -- >First winner : 135000");
				JLabel gdR11 = new JLabel(sty[5] + "  -- >second winner : 115000");
				
				JPanel winName = new JPanel();
				
				winName.add(hm);
				winName.add(l1);
				winName.add(l11);
				
				winName.add(oR);
				winName.add(oR1);
				winName.add(oR11);
				
				winName.add(gdR);
				winName.add(gdR1);
				winName.add(gdR11);
				
				f.add(winName);
				f.setSize(600,600);
				f.setVisible(true);
				
				
				
			}
			
		});
		
		b_cancel.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
			
		});
		
		c_button.add(b_cancel);
		c_button.add(b_winner);
		c_button.add(b_next);
		
		c_main.add(c_button);
		
		///////////////////
		
		frame.add(c_main);
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
