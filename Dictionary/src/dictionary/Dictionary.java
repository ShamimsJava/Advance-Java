package dictionary;

public class Dictionary extends javax.swing.JFrame {

    public Dictionary() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtWord = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMeaning = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Dictionary");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Dictionary");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Enter A Word");
        jLabel2.setToolTipText("");

        txtWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtWord)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMeaning.setColumns(20);
        txtMeaning.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtMeaning.setRows(5);
        jScrollPane1.setViewportView(txtMeaning);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(386, 415));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWordKeyReleased
        getMeaning();
    }//GEN-LAST:event_txtWordKeyReleased

    private void getMeaning() {
        String word = txtWord.getText();

        switch (word) {
            case "father":
                txtMeaning.setText(" noun\n"
                        + "1.\n"
                        + "a male parent.\n"
                        + "2.\n"
                        + "a father-in-law, stepfather, or adoptive father.\n"
                        + "3.\n"
                        + "any male ancestor, especially the founder of a family or line; progenitor.\n"
                        + "4.\n"
                        + "a man who exercises paternal care over other persons; paternal protector or provider:\n"
                        + "a father to the poor.\n"
                        + "5.\n"
                        + "a person who has originated or established something:\n"
                        + "the father of modern psychology; the founding fathers.\n"
                        + "6.\n"
                        + "a precursor, prototype, or early form:\n"
                        + "The horseless carriage was the father of the modern automobile.\n"
                        + "7.\n"
                        + "one of the leading men in a city, town, etc.:\n"
                        + "a scandal involving several of the city fathers.");
                break;
            case "mother":
                txtMeaning.setText(" noun\n"
                        + "1.\n"
                        + "a female parent.\n"
                        + "2.\n"
                        + "(often initial capital letter) one's female parent.\n"
                        + "3.\n"
                        + "a mother-in-law, stepmother, or adoptive mother. \n"
                        + "Explore Dictionary.com\n"
                        + "11 Insults We Should Bring Back\n"
                        + "The Saddest Words in English\n"
                        + "Avoid These Words. Seriously.\n"
                        + "What's the word for how it smells after it rains?\n"
                        + "4.\n"
                        + "a term of address for a female parent or a woman having or regarded as having the status, function, or authority of a female parent.\n"
                        + "5.\n"
                        + "a term of familiar address for an old or elderly woman.\n"
                        + "6.\n"
                        + "mother superior.\n"
                        + "7.\n"
                        + "a woman exercising control, influence, or authority like that of a mother:\n"
                        + "to be a mother to someone.");
                break;
            case "brother":
                txtMeaning.setText(" noun, plural brothers (Archaic) brethren.\n"
                        + "1.\n"
                        + "a male offspring having both parents in common with another offspring; a male sibling.\n"
                        + "2.\n"
                        + "Also called half brother. a male offspring having only one parent in common with another offspring.\n"
                        + "3.\n"
                        + "a stepbrother.\n"
                        + "4.\n"
                        + "a male numbered among the same kinship group, nationality, ethnicity, profession, etc., as another; an associate; a fellow member, fellow countryman, fellow man, etc.:\n"
                        + "a fraternity brother.\n"
                        + "5.\n"
                        + "Ecclesiastical.\n"
                        + "\n"
                        + "    (often initial capital letter) a male numbered among the lay members of a religious organization that has a priesthood.\n"
                        + "    a man who devotes himself to the duties of a religious order without taking holy orders, or while preparing for holy orders.\n"
                        + "\n"
                        + "6.\n"
                        + "brothers, all members of a particular racial or ethnic group, or of the human race in general:\n"
                        + "All men are brothers.\n"
                        + "7.\n"
                        + "Slang. fellow; buddy:\n"
                        + "Brother, can you spare a dime?");
                break;
            case "sister":
                txtMeaning.setText(" noun\n"
                        + "1.\n"
                        + "a female offspring having both parents in common with another offspring; female sibling.\n"
                        + "2.\n"
                        + "Also called half sister. a female offspring having only one parent in common with another offspring.\n"
                        + "3.\n"
                        + "stepsister.\n"
                        + "4.\n"
                        + "a female friend or protector regarded as a sister.\n"
                        + "5.\n"
                        + "a thing regarded as feminine and associated as if by kinship with something else:\n"
                        + "The ships are sisters.\n"
                        + "6.\n"
                        + "a female fellow member, as of a church.\n"
                        + "7.\n"
                        + "a female member of a religious community that observes the simple vows of poverty, chastity, and obedience.");
                break;
            default:
                txtMeaning.setText("");
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dictionary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMeaning;
    private javax.swing.JTextField txtWord;
    // End of variables declaration//GEN-END:variables
}
