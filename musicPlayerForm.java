
import javax.sound.sampled.Clip;



/**
 *
 * @author dhruv gautam
 */
public class musicPlayerForm extends javax.swing.JFrame {

    
    public musicPlayerForm() {
        initComponents();
        player.loadMusic(filepath);
    }
    
    static musicPlayer player = musicPlayer.getInstance();
    static String filepath = "";
    static long clipTimePosition;
    
    static boolean isPlaying = true;
    static boolean isLooping = false;
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        fileInputTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        loadButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        loopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("File Path:");

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        loopButton.setText("Loop");
        loopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(fileInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadButton)
                    .addComponent(loopButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(loadButton))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton)
                    .addComponent(pauseButton)
                    .addComponent(loopButton))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        player.clip.setMicrosecondPosition();
        clipTimePosition = 0;
        player.clip.start();
        
    }                                          

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(isPlaying){
            clipTimePosition = player.clip.getMicrosecondPosition();
            player.clip.stop();
            pauseButton.setText("Resume");
            
        }
        else{
            player.clip.setMicrosecondPosition(clipTimePosition);
            player.clip.start();
            pauseButton.setText("Pause");
            
        }
        isPlaying = !isPlaying;
        
    }                                           

    private void loopButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(!isLooping){
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        }
        else{
            player.clip.loop(0);
        }
        isLooping=!isLooping;
    }                                          

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        filepath = fileInputTextField.getText();
        player.clip.stop();
        player.clip.setMicrosecondPosition(0);
        clipTimePosition = 0;
        player.loadMusic(filepath);
    }                                          

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musicPlayerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField fileInputTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton loopButton;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    // End of variables declaration                   
}
