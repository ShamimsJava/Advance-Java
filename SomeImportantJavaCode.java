## Showing data in table:

Object[] arr = {var1, var2, var3, .....};
DefaultTableModel varName = (DefaultTableModel)tableName.getModel();
varName.addRow(arr);

## Data retrive from text field:

String varName = textFieldName.getText();

## Data retrive from combo box:

String varName = comboBoxName.getSelectedItem().toString();

## Data retrive from radio button:

String varName;
if(rdName1.isSelected()){
varName = "rdName1Label";
}else if(rdName2.isSelected()){
varName = "rdName2Label";
}else{
varName = "Please enter";
}

##Data retrive from checkbox:

String varName = "";
if(ckVar1.isSelected())
	varName += "ckVar1Label";
if(ckVar2.isSelected())
	varName += "ckVar2Label";
if(ckVar3.isSelected())
	varName += "ckVar3Label";

## Showing dialog box message:

JOptionPane.showMessageDialog(rootPane, "Dialog message");
// Here we have to use keyReleased event

## Go to different frame:

this.setVisible(false);
new DifferentFrameConstructor().setVisible(true);

## Close Frame:

System.exit(0);

## Determine the focus point:

textFieldName.requestFocus();

## Full screening Frame:

this.setExtendedState(JFrame.MAXIMIZE_BOTH); 
// set this statement inside contructor

## Creating common menu bar:

public static JMenuBar displayMenu(JFrame f){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem jframeItem = new JMenuItem("JFrameExample");
        
        jframeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new JFrameExample().setVisible(true);
            }
        });
     
        menuBar.add(fileMenu);
        fileMenu.add(jframeItem); 
        return menuBar;
    }

//////////////////////////////////////////////////////

setJMenuBar(CommonMenuBar.displayMenu(this)); 
// called from constructor

## At a time output in different text box:

qty = Double.parseDouble(txtQuantity.getText());
price = Double.parseDouble(txtPrice.getText());
total = qty * price;
txtTotal.setText(String.valueOf(total));

