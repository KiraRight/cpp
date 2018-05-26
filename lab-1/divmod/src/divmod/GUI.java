package divmod;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI {
	private JFrame frame;
	private JButton calculateButton;
	private JTextField mass1TextField;
	private JTextField mass2TextField;
	private JTextField speed1TextField;
	private JTextField speed2TextField;
	private JLabel resultLabel;
	/**
	 * method to add components
	 * @param pane
	 */
	public void addComponentsToPane(Container pane) 
	{
		pane.setLayout(new FlowLayout());
        pane.setLayout (new FlowLayout(FlowLayout.LEFT));
        pane.add( new JLabel("�����"));
        mass1TextField = new JTextField("1");
        mass1TextField.setPreferredSize(new Dimension(120, 20));
        pane.add(mass1TextField);
        pane.add( new JLabel("�����"));
        mass2TextField = new JTextField("1");
        mass2TextField.setPreferredSize(new Dimension(120, 20));
        pane.add(mass2TextField);
        pane.add( new JLabel("��������"));
        speed1TextField = new JTextField("50");
        speed1TextField.setPreferredSize(new Dimension(104, 20));
        pane.add(speed1TextField);
        pane.add( new JLabel("��������"));
        speed2TextField = new JTextField("-50");
        speed2TextField.setPreferredSize(new Dimension(104, 20));
        pane.add(speed2TextField);
        resultLabel = new JLabel("�������� ����� ������������: 0");
        resultLabel.setPreferredSize(new Dimension(221, 20));
        pane.add(resultLabel);
        calculateButton = new JButton("���������");
        pane.add( calculateButton);
        
        calculateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Integer mass1 = Integer.parseInt(mass1TextField.getText());
					Integer mass2 = Integer.parseInt(mass2TextField.getText());
					Integer speed1 = Integer.parseInt(speed1TextField.getText());
					Integer speed2 = Integer.parseInt(speed2TextField.getText());
					Integer result = (mass1 * speed1 + mass2 * speed2) / (mass1 + mass2);
					resultLabel.setText("�������� ����� ������������: " + result);
				}
				catch(NumberFormatException exp)
				{
					resultLabel.setText("����������, ������� ����� �����");
				}
			}
		});
	}
	public void createFrame() 
	{
		frame = new JFrame("Speed after collision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(360, 120);
		frame.setResizable(false);

		addComponentsToPane(frame.getContentPane());
		frame.setVisible(true);
		}
	public void createAndShowGUI() 
	{
		createFrame();
		}
}
