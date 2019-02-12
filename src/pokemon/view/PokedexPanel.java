package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.*;
import java.awt.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhanceField;
	private JTextField healthField;
 	
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JComboBox pokedexDropdown;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		appLayout = new SpringLayout();
		
		changeButton = new JButton("Change pokevalues");
		
		pokedexDropdown = new JComboBox(); //stub
		
		numberLabel = new JLabel("Num");
		nameLabel = new JLabel("Name");
		evolveLabel = new JLabel("Evolve");
		attackLabel = new JLabel("Attack");
		enhanceLabel = new JLabel("Enhance");
		healthLabel = new JLabel("Health");
		imageLabel = new JLabel("Image");
		
		numberField = new JTextField("Num");
		nameField = new JTextField("Name");
		evolveField = new JTextField("Evolve");
		attackField = new JTextField("Attack");
		enhanceField = new JTextField("Enhance");
		healthField = new JTextField("Health");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBackground(Color.CYAN);
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		this.add(imageLabel);
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhanceField);
		this.add(healthField);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
}
