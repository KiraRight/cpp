package hiswt;
/**
 * Program for printing
 * GUI was writing on SWT
 * @author ���������
 * @version 1.0
 * @since 23.03.2018
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;


/**
 * We find main method in this class. Class create GUI
 * @author ���������
 *
 */
public class PrtogramForPrintOnPrinter 
{
	public static Shell ConfigureShell(Display display, Human human) 
	{
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setText("Let's print!");
		shell.setSize(300, 100);
		shell.setLayout(new GridLayout(3,false));
		
		GridData gridData = new GridData();
		
		Button putPaperButton = new Button(shell, SWT.PUSH);
		putPaperButton.setText("���������");
		
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		Label putLabel = new Label(shell, SWT.LEFT);
		putLabel.setText("������� �� ���������");
		putLabel.setLayoutData(gridData);
		
		Button printButton = new Button(shell, SWT.PUSH);
		printButton.setText("��������");
		
		Combo kindOfPrint = new Combo(shell, SWT.NULL);
		kindOfPrint.setItems(new String [] {"�����","�����������"});
		
		Button putPrintButton = new Button(shell, SWT.PUSH);
		putPrintButton.setText("�������");
		gridData = new GridData();
		gridData.horizontalSpan = 3;
		
		Label controlLabel = new Label(shell, SWT.LEFT);
		controlLabel.setText("��������");
		controlLabel.setLayoutData(gridData);
		
		putPaperButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if(human.CheckPaperInPrinter() == false)
				{
					human.PutPaper();	
					putLabel.setText("������� ���������");
					putLabel.getParent().layout();
				}
			}
		});
		
		printButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				String text = new String(kindOfPrint.getText());
				if(human.CheckPaperInPrinter() == true)
				{
					if(text.compareTo("")!=0)
					{
						if(human.Print(text))
						{
							controlLabel.setText("�������� " + text);
							controlLabel.getParent().layout();
						}
						else
						{
							controlLabel.setText("��� ����� �����������");
							controlLabel.getParent().layout();
						}
					}
					else
					{
						controlLabel.setText("�������� ������ ������");
						controlLabel.getParent().layout();
					}
				}
				else
				{
					controlLabel.setText("��������� �������");
					controlLabel.getParent().layout();
				}				
			}
		});
		
		putPrintButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if(human.CheckPaperInPrinter() == true)
				{
					human.PickUpPaper();
					putLabel.setText("������� �� ���������");
					putLabel.getParent().layout();
					String text = human.readText();
					if(text!=null)
						controlLabel.setText("�����: " + text);
					else
						controlLabel.setText("������ ���");
					controlLabel.getParent().layout();	
				}
			}
		});
		return shell;
	}

	public static void main(String[] args)
	{
		Display display = new Display();
		Human human = new Human();
		Shell shell = ConfigureShell(display, human);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) 
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
