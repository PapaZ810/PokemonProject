package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.*;
import java.awt.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	private JLabel dragoniteLabel;
	private JLabel articunoLabel;
	private JLabel arcanineLabel;
	private JLabel honedgeLabel;
	private JLabel lampentLabel;
	private JTextField dragoniteText;
	private JTextField articunoText;
	private JTextField arcanineText;
	private JTextField honedgeText;
	private JTextField lampentText;
	private SpringLayout appLayout;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		
		dragoniteLabel = new JLabel("Dragonite");
		articunoLabel = new JLabel("Articuno");
		arcanineLabel = new JLabel("Acanine");
		honedgeLabel = new JLabel("Honedge");
		lampentLabel = new JLabel("Lampent");
		
		dragoniteText = new JTextField("Dra");
		articunoText = new JTextField("Art");
		arcanineText = new JTextField("Arc");
		honedgeText = new JTextField("Hon");
		lampentText = new JTextField("Lam");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBackground(Color.RED);
		this.add(dragoniteLabel);
		this.add(articunoLabel);
		this.add(arcanineLabel);
		this.add(honedgeLabel);
		this.add(lampentLabel);
		this.add(dragoniteText);
		this.add(articunoText);
		this.add(arcanineText);
		this.add(honedgeText);
		this.add(lampentText);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
}
