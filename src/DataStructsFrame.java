import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataStructsFrame extends JFrame {
	public DataStructsFrame(String title, int[] numbers, int[] b) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		final ArrayList<ListItem> list = arrayToList(numbers,b);

		
		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort List");
		JTextField inputText = new JTextField();
		inputText.setToolTipText("Enter Values: ");
		inputText.requestFocus();
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String text = inputText.getText();
				String [] numArr = text.split(" ");
				int[] newNum = new int[numArr.length];
				
				for(int i =0; i< numArr.length;i++) {
					newNum[i] = Integer.parseInt(numArr[i]);
				}
				Arrays.sort(newNum);
				ArrayList<ListItem> newSortList = arrayToList(newNum,b);
				for (int i = 0; i < newSortList.size() / 2; i++) { 
		            ListItem temp = newSortList.get(i); 
		            newSortList.set(i, newSortList.get(newSortList.size() - i - 1)); 
		            newSortList.set(newSortList.size() - i - 1, temp); 
		        } 
				orderedList.addItems(newSortList);
				panel.add(orderedList);
				pack();
				sortButton.setEnabled(false);
			}
		});
		
		panel.add(inputText);
		
		panel.add(sortButton);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}

	private ArrayList<ListItem> arrayToList(int[] numbers,int[]b) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		
		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i], b[i]);
			list.add(item);
		}
		

		return list;
	}
}