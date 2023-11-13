import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    JFrame window;
    Container container;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNum, weaponLabel, weaponLabelName;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, goblinDef;
    String weapon, position;


    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    Font titleFont = new Font("Book Antiqua", Font.PLAIN, 80);
    Font textFont = new Font("Book Antiqua", Font.PLAIN, 28);

    public static void main(String[] args) {
        new Main();
    }

        public Main(){

            window = new JFrame();
            window.setSize(800, 600);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.BLACK);
            window.setLayout(null);
            window.setVisible(true);

            container = window.getContentPane();

            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100,100,600,150);
            titleNamePanel.setBackground(Color.BLACK);

            titleNameLabel = new JLabel("Weg zu Askalon");
            titleNameLabel.setBounds(0,0,600,150);
            titleNameLabel.setForeground(Color.WHITE);
            titleNameLabel.setFont(titleFont);

            startButtonPanel = new JPanel();
            startButtonPanel.setBounds(300,400,200,100);
            startButtonPanel.setBackground(Color.BLACK);

            startButton = new JButton("START");
            startButton.setBounds(20,20,140,30);
            startButton.setBackground(Color.BLACK);
            startButton.setForeground(Color.WHITE);
            startButton.setFont(textFont);
            startButton.setFocusPainted(false);
            startButton.addActionListener(tsHandler);


            titleNamePanel.add(titleNameLabel);
            startButtonPanel.add(startButton);

            container.add(titleNamePanel);
            container.add(startButtonPanel);

        }

        public void createGameScreen(){

            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);

            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100,100,600,250);
            mainTextPanel.setBackground(Color.BLACK);

            mainTextArea = new JTextArea("Main-text-area");
            mainTextArea.setBounds(100,100,600,250);
            mainTextArea.setBackground(Color.BLACK);
            mainTextArea.setForeground(Color.WHITE);
            mainTextArea.setFont(textFont);
            mainTextArea.setLineWrap(true);
            mainTextArea.setEditable(false);
            mainTextArea.setFocusable(false);
            mainTextPanel.add(mainTextArea);
            container.add(mainTextPanel);

            choiceButtonPanel = new JPanel();
            choiceButtonPanel.setBounds(250,350,300,150);
            choiceButtonPanel.setBackground(Color.BLACK);
            choiceButtonPanel.setLayout(new GridLayout(4,1));
            container.add(choiceButtonPanel);

            choice1 = new JButton("Choice 1");
            choice1.setBounds(0,0,300,30);
            choice1.setBackground(Color.BLACK);
            choice1.setForeground(Color.WHITE);
            choice1.setFont(textFont);
            choice1.setFocusPainted(false);
            choice1.addActionListener(choiceHandler);
            choice1.setActionCommand("c1");
            choiceButtonPanel.add(choice1);

            choice2 = new JButton("Choice 2");
            choice2.setBounds(0,0,300,30);
            choice2.setBackground(Color.BLACK);
            choice2.setForeground(Color.WHITE);
            choice2.setFont(textFont);
            choice2.setFocusPainted(false);
            choice2.addActionListener(choiceHandler);
            choice2.setActionCommand("c2");
            choiceButtonPanel.add(choice2);

            choice3 = new JButton("Choice 3");
            choice3.setBounds(0,0,300,30);
            choice3.setBackground(Color.BLACK);
            choice3.setForeground(Color.WHITE);
            choice3.setFont(textFont);
            choice3.setFocusPainted(false);
            choice3.addActionListener(choiceHandler);
            choice3.setActionCommand("c3");
            choiceButtonPanel.add(choice3);

            choice4 = new JButton("Choice 4");
            choice4.setBounds(0,0,300,30);
            choice4.setBackground(Color.BLACK);
            choice4.setForeground(Color.WHITE);
            choice4.setFont(textFont);
            choice4.setFocusPainted(false);
            choice4.addActionListener(choiceHandler);
            choice4.setActionCommand("c4");
            choiceButtonPanel.add(choice4);

            playerPanel = new JPanel();
            playerPanel.setBounds(100,15,600,50);
            playerPanel.setBackground(Color.BLACK);
            playerPanel.setLayout(new GridLayout(1,4));
            container.add(playerPanel);

            hpLabel = new JLabel("HP:");
            hpLabel.setFont(textFont);
            hpLabel.setForeground(Color.WHITE);
            playerPanel.add(hpLabel);
            hpLabelNum = new JLabel();
            hpLabelNum.setFont(textFont);
            hpLabelNum.setForeground(Color.WHITE);
            playerPanel.add(hpLabelNum);
            weaponLabel = new JLabel("Waffe:");
            weaponLabel.setFont(textFont);
            weaponLabel.setForeground(Color.WHITE);
            playerPanel.add(weaponLabel);
            weaponLabelName = new JLabel();
            weaponLabelName.setFont(textFont);
            weaponLabelName.setForeground(Color.WHITE);
            playerPanel.add(weaponLabelName);

            playerSetup();
        }

    public void playerSetup(){
        playerHP = 15;
        monsterHP = 20;
        weapon = "Messer";
        hpLabelNum.setText(""+playerHP);
        weaponLabelName.setText(weapon);

        townGate();
    }
    public void townGate(){
        position = "heinaGate";
        mainTextArea.setText("Du stehst vor dem Tore der Stadt Askalons. \nVor dem Tor steht eine Wache.");

        choice1.setText("Ansprechen");
        choice2.setText("Angreifen");
        choice3.setText("Verlassen");
        choice4.setText("");
    }
    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Wache: Abend, der Herr! \nSie sind mir ein frisches Gesicht, \nes kommen keine Fremde in unsre Stadt rein!");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void attackGurad(){
        position = "attackGuard";
        mainTextArea.setText("Wache: Bist du verrückt geworden?! \nKapituliere jetzt noch oder du wirsts bereuen! \n\n(Du erhälst 3 Schaden.)");
        playerHP = playerHP - 3;
        hpLabelNum.setText(""+playerHP);
        if(playerHP<1){
            lose();
        }
        choice1.setText("Schlagen");
        choice2.setText("Stechen (" + weapon + ")");
        choice3.setText("Kapitulieren");
        choice4.setText("");
    }
    public void attackGuradAgainBare(){
        position = "attackGuardAgainBare";
        mainTextArea.setText("Wache: Jetzt reichts mir! \n\n(Die Wache ist geschwächt.\nDu erhälst 3 Schaden.)");
        playerHP = playerHP - 3;
        hpLabelNum.setText(""+playerHP);
        if(playerHP<1){
            lose();
        }
        choice1.setText("Erneut Schlagen");
        choice2.setText("Stechen (" + weapon + ")");
        choice3.setText("Kapitulieren");
        choice4.setText("");
    }
    public void attackGuradAgainKnife(){
        position = "attackGuardAgainKnife";
        mainTextArea.setText("Wache: DU MONSTER! \nDU SEIST VERFLUCHT!\n\n(Die Wache hat es nicht erwatet, \ndu stichst ihm in die Kehle \nund rennst in die Stadt.)");
        choice1.setText("In die Stadt");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void placeHolder(){
        position = "placeholder";
        mainTextArea.setText("Dieser Bereich ist noch nicht fertig.");
        choice1.setText("Stadttor");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("Du bist an einer Kreuzung angekommen. \n\n(Du bist von Süden gekommen.");
        choice1.setText("Nach Norden");
        choice2.setText("Nach Osten");
        choice3.setText("Nach Süden");
        choice4.setText("Nach Westen");
    }
    public void north(){
        position = "north";
        mainTextArea.setText("Du kommst an einem Fluss an und ruhistig aus. \n\n(Du heilst dich für 2HP.)");
        playerHP = playerHP + 2;
        hpLabelNum.setText(""+playerHP);
        choice1.setText("Zur Kreuzung");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void east(){
        position = "east";
        mainTextArea.setText("Du läufst in eine Waldhütte rein und findest ein Schwert, das gehört nun dir. \n\n(Du rüstest das Schwert aus.)");
        weapon = "Schwert";
        weaponLabelName.setText(weapon);
        choice1.setText("Zur Kreuzung");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void west(){
        position = "west";
        mainTextArea.setText("Du triffst ein Goblin!");
        choice1.setText("Kämpfen");
        choice2.setText("Flüchten");
        choice3.setText("");
        choice4.setText("");
    }
    public void neumann(){
        position = "east";
        mainTextArea.setText("Du triffst den Sanitätsgefreite Neumann!. \nEin dreifach hoch!\nEin dreifach hoch, Ihm und seinen Erfindungen!\n\n(Er heilt dich und schenkt dir eine seiner \nErfindungen, das ich nicht nennen darf.)");
        weapon = "xxx";
        weaponLabelName.setText(weapon);
        playerHP = playerHP + 8;
        hpLabelNum.setText(""+playerHP);
        choice1.setText("Zur Kreuzung");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void fight(){
        position = "fight";
        mainTextArea.setText("<Goblin>\n\nHP: "+ monsterHP);
        choice1.setText("Angreifen (" + weapon +")");
        choice2.setText("Flüchten");
        choice3.setText("");
        choice4.setText("");
    }
    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if (weapon.equals("Messer")){
            playerDamage = new java.util.Random().nextInt(3) + 2;
        }else if(weapon.equals("Schwert")){
            playerDamage = new java.util.Random().nextInt(3) + 5;
        }

        mainTextArea.setText("Du hast das Monster mit deinem "+ weapon + " \nangegriffen und hast " + playerDamage + " Schaden gemacht.");

        monsterHP = monsterHP - playerDamage;
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(4);


        mainTextArea.setText("Das Monster dich angegriffen und du erleidest " + monsterDamage + " Schaden.");

        playerHP = playerHP - monsterDamage;
        hpLabelNum.setText(""+playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void win(){
        position = "win";

        mainTextArea.setText("Du hast den Goblin getötet, du siegst!");
        goblinDef = 1;
        choice1.setText("Zur Kreuzung");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void lose(){
        position = "lose";

        mainTextArea.setText("Der Goblin hat dich getötet.\n\n<GAME OVER>");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void ending(){
        position = "ending";

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

        if (goblinDef == 1){
            mainTextArea.setText("Wache: Du hast den Goblin getötet? \nDanke dir und wilkommen in Askalon.\n\nGood Ending");
        }else{
            mainTextArea.setText("Du hast es in die Stadt geschafft\naber gab es nicht ein besseren Weg...\n\nBad Ending");
        }
    }
    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event){

            String choice = event.getActionCommand();

            switch (position){
                case "placeholder":
                    switch (choice){
                        case "c1":
                            townGate();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                        default:
                            break;
                    }
                    break;
                case "heinaGate":
                    switch (choice){
                        case "c1":
                            talkGuard();
                            break;
                        case "c2":
                            attackGurad();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                        case "c4":
                            break;
                        default:
                            break;
                    }
                    break;
                case "talkGuard":
                    switch (choice) {
                        case "c1":
                            if (goblinDef == 1){
                                ending();
                            }else {
                                townGate();
                            }
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                        default:
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (choice) {
                        case "c1":
                                attackGuradAgainBare();
                            break;
                        case "c2":
                                attackGuradAgainKnife();
                            break;
                        case "c3":
                            placeHolder();
                            break;
                        case "c4":
                            break;
                        default:
                            break;
                    }
                    break;
                case "attackGuardAgainBare":
                    switch (choice) {
                        case "c1":
                                attackGuradAgainBare();
                            break;
                        case "c2":
                                attackGuradAgainKnife();
                            break;
                        case "c3":
                            placeHolder();
                            break;
                        case "c4":
                            break;
                        default:
                            break;
                    }
                    break;
                case "attackGuardAgainKnife":
                    switch (choice) {
                        case "c1":
                            ending();
                            break;
                        default:
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (choice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            west();
                            break;
                        default:
                            break;
                    }
                    break;
                case "north":
                case "east":
                    switch (choice) {
                        case "c1":
                            crossRoad();
                            break;
                        default:
                            break;
                    }
                    break;
                case "west":
                    switch (choice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                        default:
                            break;
                    }
                    break;
                case "fight":
                    switch (choice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                        default:
                            break;
                    }
                    break;
                case "playerAttack":
                    switch (choice) {
                        case "c1":
                            if (monsterHP<1){
                                win();
                            }else {
                                monsterAttack();
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (choice) {
                        case "c1":
                            if(playerHP<1){
                                lose();
                            }else{
                                fight();
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "win":
                    switch (choice) {
                        case "c1":
                            crossRoad();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}