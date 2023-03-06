public class LiftFrame extends JPanel{
	
	//properties
	JMenu themenu = new JMenu("% Efficiency Modules");
	JMenuItem liftmenu = new JMenu("Human lift example");
	JMenuItem electronicmenu = new JMenu("Electronic example");
	//maybe add different electronics
	//one high efficiency one low efficiency and see input comparison
	//high efficiency moves/animates quick, other moves slow
	JMenu helpmenu = new JMenu("Help");
	JMenu aboutmenu = new JMenu("About");
	JMenu testmenu = new JMenu("Test");
	
	//methods
	
	//constructor
	public LiftFrame(){
		themenubar.setSize(275, 30);
		themenubar.setLocation(0, 0);
		themenubar.add(themenu);
		themenu.add(liftmenu);
		themenu.add(electronicmenu);
		themenubar.add(helpmenu);
		themenubar.add(aboutmenu);
		themenubar.add(testmenu);
		helpmenu.addActionListener(this);
		liftmenu.addActionListener(this);
		LiftFrame.add(themenubar);
	}



}
