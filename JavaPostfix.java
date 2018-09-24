import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;

class Frame extends JFrame implements TreeSelectionListener{
  
    private JTree jt;
    private JTextArea jta;
    
    Frame()
    {
        setTitle("Postfix Expression : Binary Tree Calculator");
        setLayout(new FlowLayout());
        setJTree();
        setJTextArea();
        setAction();
        setSize(700,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setJTree()
    {
          DefaultMutableTreeNode main = new DefaultMutableTreeNode("+");
        createTree(main);
        jt = new JTree(main);
        JScrollPane js = new JScrollPane(jt);
        js.setPreferredSize(new Dimension(300,300));
        add(js);  
    }
    
    private void setJTextArea()
    {
        jta = new JTextArea();
        JScrollPane js = new JScrollPane(jta);
        js.setPreferredSize(new Dimension(300,300));
        add(js); 
    }
    
    private void createTree(DefaultMutableTreeNode main)
    {
        DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode("*");
        sub1.add(new DefaultMutableTreeNode("2"));
        
        DefaultMutableTreeNode sub11 = new DefaultMutableTreeNode("-");
        sub11.add(new DefaultMutableTreeNode("5"));
        sub11.add(new DefaultMutableTreeNode("1"));
        
        
        DefaultMutableTreeNode sub2 = new DefaultMutableTreeNode("*.");
        sub2.add(new DefaultMutableTreeNode("3"));
        sub2.add(new DefaultMutableTreeNode("2"));
   
     
        main.add(sub1);
        main.add(sub2);
        sub1.add(sub11);
    }
    
    
    private void setAction()
    {
        jt.addTreeSelectionListener(this);
    }
    
    public void valueChanged(TreeSelectionEvent eve)
    {
        String getPath = String.valueOf(jt.getSelectionPath());
        if(getPath.equals("[+]"))
        {
            jta.setText("2*(5-1)+(3*2)=14");
        }
        else if(getPath.equals("[+, *]"))
        {
            jta.setText("2*(5-1)=8");
        }
        else if(getPath.equals("[+, *, 2]"))
        {
            jta.setText("2");
        }
        else if(getPath.equals("[+, *, -]"))
        {
            jta.setText("5-1");
        }
        else if(getPath.equals("[+, *, -, 5]"))
        {
            jta.setText("5");
        }
        else if(getPath.equals("[+, *, -, 1]"))
        {
           jta.setText("1");
        }
        else if(getPath.equals("[+, *.]"))
        {
            jta.setText("3*2=6");
        }
         else if(getPath.equals("[+, *, 3]"))
        {
             jta.setText("3");
        }
        else if(getPath.equals("[+, *, 2]"))
        {
            jta.setText("2");
        }
    }
}

public class JavaPostfix {
   
    public static void main(String[] args) {
        
       Frame fr = new Frame();
    }
}